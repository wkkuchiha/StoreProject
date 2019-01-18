package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.common.pojo.EasyUITreeNode;
import com.store.service.ItemCatService;

/**
 * 商品分类管理controller
 */
@Controller
public class ItemCatController {
   
   @Autowired
   private ItemCatService itemCatService;
	
   @RequestMapping("/item/cat/list")
   @ResponseBody
   public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0") Long parentId) {
	  List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
      return list;
   }
}