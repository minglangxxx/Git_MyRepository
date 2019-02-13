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
	 * ssm��ѯ
	 * @return
	 */
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemlist() {
	
		//��mysql��ѯ
		List<Items> itemsList = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemsList);
		mav.setViewName("itemList");
		return mav;
	}
	
	/**
	 * 	�󶨼����Ͳ���
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
	 * 	��pojo,�ύ
	 * 	pojo�β�����ҳ��󶨲������޹أ���Ҫ��pojo�����������ҳ��󶨲���һ����
	 * 	�����pictureFile�βα������ͼҳ��󶨵�nameһģһ��
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/updateitem.action")
	public String updateItem(Items items,MultipartFile pictureFile) throws Exception, IOException {
		
		//����ͼƬ����	���ظ��������������
		String picName = UUID.randomUUID().toString().replaceAll("-","");
		//��ȡ�ļ�����׺,��"."��ʼȡֵ
		String extName = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		//��ʼ�ϴ�
		pictureFile.transferTo(new File("C:\\Java\\upload\\"+picName+"."+extName));
		//����ͼƬ��item������
		items.setPic(picName+"."+extName);
		//������Ʒ
		itemService.updateItemById(items);
		
		//�ɹ����ر༭ҳ��
		return "redirect:/itemEdit.action?id="+items.getId();
	}
	
	/**
	 * 	�����
	 */
	@RequestMapping(value="/deletes.action")
	public ModelAndView deleteItems(Integer[] ids) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
}
