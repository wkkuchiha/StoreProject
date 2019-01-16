package com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.mapper.TbItemMapper;
import com.store.pojo.TbItem;
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

}
