package com.springmvc_mybatis.service;

import java.util.List;

import com.springmvc_mybatis.pojo.Items;

public interface ItemService {
	public List<Items> selectItemsList();
	public Items queryItemById(Integer id);
	public void updateItemById(Items items);
}
