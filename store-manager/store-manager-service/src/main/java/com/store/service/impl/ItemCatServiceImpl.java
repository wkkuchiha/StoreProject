package com.store.service.impl;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.common.pojo.EasyUITreeNode;
import com.store.mapper.TbItemCatMapper;
import com.store.pojo.TbItemCat;
import com.store.pojo.TbItemCatExample;
import com.store.pojo.TbItemCatExample.Criteria;
import com.store.service.ItemCatService;
 
/*
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemMapper;
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		// 根据父节点的id查询子节点的列表
		TbItemCatExample example = new TbItemCatExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemMapper.selectByExample(example);
		// 节点列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		// 转换成esayuitreenode列表
		for (TbItemCat tbItemCat:list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			// 如果有子节点close，如果没有子节点则是open
			node.setState(tbItemCat.getIsParent()?"close":"open");
			// 添加到节点列表
			resultList.add(node);	
		}
		return resultList;
	}

	 
}
