package com.store.service;

import com.store.common.pojo.EasyUIDataGridResult;
import com.store.common.pojo.StoreResult;
import com.store.pojo.TbItem;

public interface ItemService {
   
	TbItem getItemById(long itemId); // 根据商品id查询商品信息
	EasyUIDataGridResult getItemList(int page,int rows);
	StoreResult addItem(TbItem item,String desc);
}
