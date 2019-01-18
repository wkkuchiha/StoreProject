package com.store.service;

import java.util.List;

import com.store.common.pojo.EasyUITreeNode;
public interface ItemCatService {
   List<EasyUITreeNode> getItemCatList(long parentId);
   
}
