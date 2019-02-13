package com.springmvc_mybatis.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc_mybatis.pojo.Items;
import com.springmvc_mybatis.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * ssm查询
	 * @return
	 */
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemlist() {
	
		//从mysql查询
		List<Items> itemsList = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemsList);
		mav.setViewName("itemList");
		return mav;
	}
	
	/**
	 * 	绑定简单类型参数
	 */	 
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toedit(Integer id,HttpServletRequest request,HttpServletResponse response,
			HttpSession session) {
		Items item = itemService.queryItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	/**
	 * 	绑定pojo,提交
	 * 	pojo形参名和页面绑定参数名无关，但要求pojo类的属性名和页面绑定参数一样！
	 * 	这里的pictureFile形参必须和试图页面绑定的name一模一样
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/updateitem.action")
	public String updateItem(Items items,MultipartFile pictureFile) throws Exception, IOException {
		
		//设置图片名称	不重复的随机数字名称
		String picName = UUID.randomUUID().toString().replaceAll("-","");
		//获取文件名后缀,从"."开始取值
		String extName = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		//开始上传
		pictureFile.transferTo(new File("C:\\Java\\upload\\"+picName+"."+extName));
		//设置图片到item属性中
		items.setPic(picName+"."+extName);
		//更新商品
		itemService.updateItemById(items);
		
		//成功返回编辑页面
		return "redirect:/itemEdit.action?id="+items.getId();
	}
	
	/**
	 * 	数组绑定
	 */
	@RequestMapping(value="/deletes.action")
	public ModelAndView deleteItems(Integer[] ids) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
}
