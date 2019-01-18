package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.common.pojo.EasyUIDataGridResult;
import com.store.mapper.TbItemMapper;
import com.store.pojo.TbItem;
import com.store.pojo.TbItemExample;
import com.store.service.ItemService;

/**
 * 商品管理服务 
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
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
}
