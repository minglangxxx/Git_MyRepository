package com.springmvc_mybatis.service;
/**
 * 	查询商品信息
 * @author 33452
 *
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc_mybatis.mapper.ItemsMapper;
import com.springmvc_mybatis.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);	
	}
	
	public Items queryItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	
	public void updateItemById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeySelective(items);
	}
}
