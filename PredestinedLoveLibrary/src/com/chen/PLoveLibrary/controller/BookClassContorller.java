package com.chen.PLoveLibrary.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chen.PLoveLibrary.domain.BookClass;
import com.chen.PLoveLibrary.parameter.Parameter;
import com.chen.PLoveLibrary.service.BookClassService;

/**
 * @类 名： BookClassContorller @功能描述： TODO 图书编目控制器 @作者信息： 陈强 @创建时间：
 *    2018年4月22日下午2:30:29 @修改备注：
 */
@Controller
@RequestMapping("/bookClass")
@RequiresRoles(value={"BookManager","SysManager","Manager"},logical=Logical.OR)
public class BookClassContorller {
	@Autowired
	private BookClassService bookClassService;

	/**
	 * @Title : comeBookClassJSp
	 * @功能描述: TODO 进入到图书编目的页面
	 * @开发者：陈强 @参数： @return
	 * @返回类型：String
	 * @throws ：
	 */
	@RequestMapping("/toBookClass")
	@RequiresPermissions(value={"bookClass:toBookClass","iterm:all"},logical=Logical.OR)
	public String comeBookClassJSp() {
		return "WEB-INF/bookJsp/bookClass";
	}

	/** 
	   * @Title : InsertBookClass 
	   * @功能描述: TODO 插入数据
	   * @开发者：陈强  
	   * @参数： @param bookClass
	   * @参数： @param br
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value ="/insertBookClass", method = { RequestMethod.POST, RequestMethod.GET })
	@RequiresPermissions(value={"bookClass:insertBookClass","iterm:all"},logical=Logical.OR)
	public String InsertBookClass(@Validated BookClass bookClass, BindingResult br, Model model) {

		if (br.hasErrors()) {
			String Message = null;
			List<ObjectError> errors = br.getAllErrors();
			for (ObjectError objectError : errors) {

				model.addAttribute("message", Message + objectError.getDefaultMessage());
			}
			return "error";
		}
		bookClassService.insertBookClass(bookClass);
		model.addAttribute("bkCatalog",bookClass.getBkCatalog());
		model.addAttribute("bkClassName", bookClass.getBkClassName());
		return "WEB-INF/bookJsp/bookClass";
	}
	/** 
	   * @Title : BookClassInfo 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/selectBookClass")
	@RequiresPermissions(value={"bookClass:selectBookClass","iterm:all"},logical=Logical.OR)
	public String BookClassInfo(Parameter parameter,Model model)
	{
		int count=bookClassService.getCount(parameter);
		int start=parameter.getStart();
		if(start<0) start=0;
		if(start>count)start-=10;
		int end= start+10;
		parameter.setStart(start);
		parameter.setEnd(end);
		List<BookClass> bookClassList= bookClassService.selectBookClassByID(parameter);
		model.addAttribute("bookClassList", bookClassList);
		model.addAttribute("start", start);
		
		
		return "WEB-INF/bookJsp/bookClassInfo";
	}
	/** 
	   * @Title : DeleteBookClass 
	   * @功能描述: TODO 删除信息
	   * @开发者：陈强  
	   * @参数： @param bookClass
	   * @参数： @param ra
	   * @参数： @param parameter
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/deleteBookClass")
	@RequiresPermissions(value={"bookClass:deleteBookClass","iterm:all"},logical=Logical.OR)
	public String DeleteBookClass(BookClass bookClass ,RedirectAttributes ra,Parameter parameter)
	{
		bookClassService.deleteBookClassByID(bookClass);
		ra.addAttribute("start",parameter.getStart());
		return "redirect:/bookClass/selectBookClass";
	}
	/** 
	   * @Title : EditBookClass 
	   * @功能描述: TODO 编辑信息
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @param ra
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/editBookClass")
	@RequiresPermissions(value={"bookClass:editBookClass","iterm:all"},logical=Logical.OR)
	public String EditBookClass(Parameter parameter,Model model)
	{
		BookClass bookClass=bookClassService.findBookClassByID(parameter);
		model.addAttribute("BookClass", bookClass);
		model.addAttribute("start", parameter.getStart());
		return "WEB-INF/bookJsp/bookClassInfo";
	}
	
	/** 
	   * @Title : UpdateBookClass 
	   * @功能描述: TODO 更新信息
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @param ra
	   * @参数： @param bookClass
	   * @参数： @param br
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping( value="/updateBookClass",method={ RequestMethod.POST, RequestMethod.GET } )
	@RequiresPermissions(value={"bookClass:updateBookClass","iterm:all"},logical=Logical.OR)
	public String UpdateBookClass(Parameter parameter,RedirectAttributes ra,@Validated BookClass bookClass,BindingResult br,Model model)
	{

		if (br.hasErrors()) {
			String Message = null;
			List<ObjectError> errors = br.getAllErrors();
			for (ObjectError objectError : errors) {

				model.addAttribute("message", Message + objectError.getDefaultMessage());
			}
			return "error";
		}
		bookClassService.updateBookClass(bookClass);
		ra.addAttribute("start", parameter.getStart());
		return "redirect:/bookClass/selectBookClass";
		
	}

}
