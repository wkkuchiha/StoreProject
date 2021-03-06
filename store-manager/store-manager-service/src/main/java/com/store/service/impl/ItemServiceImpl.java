package com.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.common.pojo.EasyUIDataGridResult;
import com.store.common.pojo.StoreResult;
import com.store.common.utils.IDUtils;
import com.store.mapper.TbItemDescMapper;
import com.store.mapper.TbItemMapper;
import com.store.pojo.TbItem;
import com.store.pojo.TbItemDesc;
import com.store.pojo.TbItemExample;
import com.store.service.ItemService;

/**
 * 商品管理服务 
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Override
	public TbItem getItemById(long itemId) {
		
	    TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		 
		// 设置分页信息
		PageHelper.startPage(page,rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		// 返回结果
		return result;
	}

	/**
	 * 商品添加的方法
	  */
	@Override
	public StoreResult addItem(TbItem item, String desc) {
		// 生成商品id
		long itemId = IDUtils.genItemId();
		// 补全item的属性
		item.setId(itemId);
		// 商品状态 1 正常 2 下架 3 删除
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		// 向商品表中插入数据
		itemMapper.insert(item);
		// 创建一个商品描述表对应的pojo
		TbItemDesc itemDesc = new TbItemDesc();
		// 补全pojo的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setUpdated(new Date());
		itemDesc.setCreated(new Date());
		// 向商品描述表中插入数据
		itemDescMapper.insert(itemDesc);
		// 返回结果
		return null;
	}
}
