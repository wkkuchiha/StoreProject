package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.common.pojo.EasyUIDataGridResult;
import com.store.common.pojo.StoreResult;
import com.store.pojo.TbItem;
import com.store.service.ItemService;

/**
 * 当前管理Controller
 */
@Controller
public class ItemController {
   
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
		EasyUIDataGridResult itemList = itemService.getItemList(page,rows);
	    return itemList;
	}
	
	@RequestMapping(value = "/item/save",method = RequestMethod.POST)
	@ResponseBody
	public StoreResult addItem(TbItem item , String desc) {
		StoreResult result = itemService.addItem(item, desc);
		return result;
	}
	
	
	
	
	
}
