package com.chen.PLoveLibrary.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chen.PLoveLibrary.domain.ReaderType;
import com.chen.PLoveLibrary.service.ReaderTypeService;
import com.chen.PLoveLibrary.util.ExportExcelUtil;

/**
   * @类 名： ReaderTypeController
   * @功能描述： TODO 读者类别控制器
   * @作者信息： 陈强
   * @创建时间： 2018年4月18日上午10:35:00
   * @修改备注：
   */
/**
   * @类 名： ReaderTypeController
   * @功能描述： TODO
   * @作者信息： 陈强
   * @创建时间： 2018年4月18日下午5:07:15
   * @修改备注：
   */
@Controller
@RequestMapping("/readerType")
@RequiresRoles(value={"BookManager","SysManager","Manager"},logical=Logical.OR)
public class ReaderTypeController {
	@Autowired
	private ReaderTypeService readerTypeService;
	/** 
	   * @Title : InsertReaderType 
	   * @功能描述: TODO 添加用户类别信息
	   * @开发者：陈强  
	   * @参数： @param model
	   * @参数： @param readerType
	   * @参数： @param br
	   * @参数： @param ra
	   * @参数： @return
	   * @参数： @throws Exception 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/insertReaderType" ,method={RequestMethod.POST,RequestMethod.GET})
	@RequiresPermissions(value={"readerType:insertReaderType","iterm:all"},logical=Logical.OR)
	public String InsertReaderType(Model model,@Validated ReaderType readerType,BindingResult br,RedirectAttributes ra) throws Exception
	{
		if(br.hasErrors())
		{
			List<ObjectError> errors=br.getAllErrors();
			for(ObjectError error:errors)
			{
				model.addAttribute("message",error.getDefaultMessage());
			}
			return "error";
		}
		int i=0;
		i=readerTypeService.insertReaderType(readerType);
		if(i==0)
		{
			throw new Exception("插入失败");
		}
		ra.addAttribute("rdType", readerType.getRdType());
		ra.addAttribute("start",0);
		return "redirect:/readerType/searchReaderType";
	}
	/** 
	   * @Title : SearchReaderType 
	   * @功能描述: TODO 查询所有的读者类型的信息
	   * @开发者：陈强  
	   * @参数： @param start
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/searchReaderType")
	@RequiresPermissions(value={"readerType:searchReaderType","iterm:all"},logical=Logical.OR)
	public String SearchReaderType(@RequestParam(value="start")int start,Model model,@RequestParam("rdType")int rdType)
	{
		
		int count=readerTypeService.findCountsReaderType(rdType);
		if(start<0)start=0;
		if(start>=count)start-=10;
		int end=start+10;
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("rdType",rdType);
		List<ReaderType> typeList=readerTypeService.searchReaderType(map);
		model.addAttribute("TypeList", typeList);
		model.addAttribute("start", start);
		model.addAttribute("rdType",rdType);
		return "WEB-INF/readerJsp/readerType";
	}
	/** 
	   * @Title : EditReaderType 
	   * @功能描述: TODO  编辑读者类型信息
	   * @开发者：陈强  
	   * @参数： @param rdType
	   * @参数： @param start
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/editReaderType")
	@RequiresPermissions(value={"readerType:editReaderType","iterm:all"},logical=Logical.OR)
	public String EditReaderType(@RequestParam("rdType")int rdType,@RequestParam("start")int start,Model model)
	{
		ReaderType readerType=readerTypeService.findReaderTypeByID(rdType);
		model.addAttribute("readerType",readerType);
		model.addAttribute("start", start);
		return "WEB-INF/readerJsp/readerType";
	}
	/** 
	   * @Title : UpdateReaderType 
	   * @功能描述: TODO 更新读者类型信息
	   * @开发者：陈强  
	   * @参数： @param readerType
	   * @参数： @param br
	   * @参数： @param model
	   * @参数： @param ra  用于重定向之后还能带参数跳转的的工具类
	   * @参数： @param start 开始页数
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/updateReaderType",method={RequestMethod.POST,RequestMethod.GET})
	@RequiresPermissions(value={"readerType:updateReaderType","iterm:all"},logical=Logical.OR)
	public String UpdateReaderType(@Validated ReaderType readerType,BindingResult br,
			Model model,RedirectAttributes ra,@RequestParam("start")int start)
	{
		if(br.hasErrors())
		{
			List<ObjectError> errors=br.getAllErrors();
			for(ObjectError error:errors)
			{
				model.addAttribute("message",error.getDefaultMessage());
			}
			return "error";
		}
		readerTypeService.updateReaderType(readerType);
		ra.addAttribute("start", start);
		ra.addAttribute("rdType", -1);
		return "redirect:/readerType/searchReaderType";
	}
	/** 
	   * @Title : DeleteReaderType 
	   * @功能描述: TODO 删除信息
	   * @开发者：陈强  
	   * @参数： @param rdType
	   * @参数： @param ra
	   * @参数： @param start
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/deleteReaderType")
	@RequiresPermissions(value={"readerType:deleteReaderType","iterm:all"},logical=Logical.OR)
	public String DeleteReaderType(@RequestParam("rdType")int rdType,RedirectAttributes ra,@RequestParam("start")int start)
	{
		readerTypeService.deleteReaderTypeByID(rdType);
		ra.addAttribute("start", start);
		ra.addAttribute("rdType", -1);
		return "redirect:/readerType/searchReaderType";
	}
	/** 
	   * @Title : ExportExcel 
	   * @功能描述: TODO 将读者类型信息导出
	   * @开发者：陈强  
	   * @参数： @param rdType
	   * @参数： @param start
	   * @参数： @param request
	   * @参数： @param response
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/exportExcel")
	public String ExportExcel(@RequestParam("rdType")int rdType,@RequestParam("start")int start,HttpServletRequest request,HttpServletResponse response)
	{
		
		int end=start+10;
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("rdType",rdType);
		List<ReaderType> typeList=readerTypeService.searchReaderType(map);
		ExportExcelUtil ex = new ExportExcelUtil();
		String title="读者类型表";
		String[] headers ={"读者类别","读者名称","可借书的天数","可续借的次数","罚款率","证件的有效期","可借书的数量"};
		List<String[]> dataset=new ArrayList<String[]>();
		for(int i=0;i<typeList.size();i++)
		{
			ReaderType type=typeList.get(i);
			dataset.add(new String[]{Integer.toString(type.getRdType()),type.getRdTypeName(),Integer.toString(type.getCanLendDay())+"天",Integer.toString(type.getCanContinueTimes())+"次"
					,Float.toString(type.getPunishRate()),Integer.toString(type.getDateValid())+"天",Integer.toString(type.getCanLendQty())+"本"});
		}
		OutputStream out = null;//创建一个输出流对象 
		try { 
			
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"ReaderType.xls");//filename是下载的xls的名，建议最好用英文 
			response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
			response.setHeader("Pragma","No-cache");//设置头 
			response.setHeader("Cache-Control","no-cache");//设置头 
			response.setDateHeader("Expires", 0);//设置日期头  
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			ex.exportExcel(rootPath,title,headers, dataset, out);
			out.flush();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}finally{
			try{
				if(out!=null){ 
					out.close(); 
				}
			}catch(IOException e){ 
				e.printStackTrace(); 
			} 
		}
		return null;
	}
}
