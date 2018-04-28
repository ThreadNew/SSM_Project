package com.chen.PLoveLibrary.controller;



import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chen.PLoveLibrary.domain.Reader;
import com.chen.PLoveLibrary.domain.SysUR;
import com.chen.PLoveLibrary.mybatis.UserLoginMapper;
import com.chen.PLoveLibrary.parameter.Parameter;
import com.chen.PLoveLibrary.service.ReaderService;
import com.chen.PLoveLibrary.util.ExportExcelUtil;


/**
   * @类 名： ReaderController
   * @功能描述： TODO 读者管理的控制器
   * @作者信息： 陈强
   * @创建时间： 2018年4月16日下午3:07:18
   * @修改备注：
   */
@Controller
@RequestMapping("/reader")
@RequiresRoles(value={"BookManager","SysManager","Manager"},logical=Logical.OR)
public class ReaderController {
	@Autowired
	private ReaderService readerService;
	@Autowired
	private UserLoginMapper userLoginMapper;
	
	/** 
	   * @Title : comeReader 
	   * @功能描述: TODO 进入读者信息录入界面
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */

	@RequestMapping("/toReader")
	@RequiresPermissions(value={"reader:toReader","iterm:all"},logical=Logical.OR)
	public String comeReader()
	{
		return "WEB-INF/readerJsp/readerLoad";
	}
	/** 
	   * @Title : ReaderLoad 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @param reader
	   * @参数： @param br
	   * @参数： @param file
	   * @参数： @param model
	   * @参数： @param request
	   * @参数： @return
	   * @参数： @throws Exception 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/readerLoad",method={RequestMethod.POST,RequestMethod.POST})
	@RequiresPermissions(value={"reader:readerLoad","iterm:all"},logical=Logical.OR)
	@SuppressWarnings("unused")
	public String ReaderLoad(@Validated Reader reader,BindingResult br,
			@RequestParam(value="filePhoto",required=false)MultipartFile file,
			Model model,HttpServletRequest request) throws Exception
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
		String path=request.getSession().getServletContext().getRealPath("upload");
		String fileName=file.getOriginalFilename();
		String fileType=file.getContentType();
		File targetFile = new File(path, fileName);   
		if(file==null)
		{
			reader.setRdPhoto("upload/empty.jpg");
		}
		else
		{
			if(fileType.equals("image/jpeg")  ||fileType.equals("image/pjpeg")||fileType.equals("image/gif"))
			{
				reader.setRdPhoto("upload/"+fileName);
				 file.transferTo(targetFile);  
			}
			else
			{
				reader.setRdPhoto("upload/empty.jpg");
			}
			
		}
		reader.setRdDateReg(new Date());
		i=readerService.insertReader(reader);
		
		if(i==0)
		{
			throw new Exception("业务办理失败");
		}
		userLoginMapper.insertSysUser(reader);
		model.addAttribute("reader",reader);
		return "WEB-INF/readerJsp/readerLoad";
	}

	/** 
	   * @Title : FindReader 
	   * @功能描述: TODO 查找reader信息实现数据库的分页。
	   * @开发者：陈强  
	   * @参数： @param start
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/findReader")
	@RequiresPermissions(value={"reader:findReader","iterm:all"},logical=Logical.OR)
	public String FindReader(Model model,Parameter parameter)
	{
		int count=readerService.getCounts(parameter);
		int start=parameter.getStart();
		if(start<0) start=0;
		if(start>count)start-=10;
		int end=start+10;
		parameter.setStart(start);
		parameter.setEnd(end);
		List<Reader> readerList=readerService.getReaderInfo(parameter);
		model.addAttribute("readerList",readerList);
		model.addAttribute("start", start);
		model.addAttribute("rdID", parameter.getRdID());
		
		return "WEB-INF/readerJsp/readerPage";
	}
	/** 
	   * @Title : DeleteReader 
	   * @功能描述: TODO 删除用户的信息，在重定向页面
	   * @开发者：陈强  
	   * @参数： @param rdID
	   * @参数： @param start
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("deleteReader")
	@RequiresPermissions(value={"reader:deleteReader","iterm:all"},logical=Logical.OR)
	public String DeleteReader(@RequestParam("rdID")String rdID,@RequestParam(value="start")Integer start,Model model,RedirectAttributes rab)
	{
		readerService.deleteReaderByrdID(rdID);
		userLoginMapper.deleteSysUser(rdID);
		SysUR sysUR=new SysUR();
		sysUR.setUserName(rdID);
		userLoginMapper.deletePermission(sysUR);
		System.out.println(rdID);
		rab.addAttribute("start", start);
		return "redirect:/reader/findReader";
	}
	/** 
	   * @Title : EditReader 
	   * @功能描述: TODO 读者信息编辑  跳转到读者信息注册界面
	   * @开发者：陈强  
	   * @参数： @param model
	   * @参数： @param rdID  用户名
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/editReader/{rdID}")
	@RequiresPermissions(value={"reader:editReader","iterm:all"},logical=Logical.OR)
	public String EditReader(Model model,@PathVariable String rdID,@RequestParam(value="start")Integer start)
	{
		Reader reader=readerService.findReaderByrdID(rdID);
		model.addAttribute("editReader", reader);
		model.addAttribute("start", start);
		return "WEB-INF/readerJsp/readerPage";
	}
	/** 
	   * @Title : UpdateReader 
	   * @功能描述: TODO 编辑读者信息
	   * @开发者：陈强  
	   * @参数： @param reader 读者类
	   * @参数： @param file 文件上传
	   * @参数： @param ra 重定向
	   * @参数： @param start 页码
	   * @参数： @param request
	   * @参数： @return
	   * @参数： @throws IllegalStateException
	   * @参数： @throws IOException 
	   * @返回类型：String 
	   * @throws ：
	   */
	@SuppressWarnings("unused")
	@RequiresPermissions(value={"reader:updateReader","iterm:all"},logical=Logical.OR)
	@RequestMapping(value="/updateReader/{start}",method={RequestMethod.POST,RequestMethod.GET})
	public String UpdateReader(@Validated Reader reader,BindingResult br,
			@RequestParam(value="filePhoto",required=false)MultipartFile file,
			RedirectAttributes ra,
			@PathVariable Integer start,
			HttpServletRequest request,Model model) throws IllegalStateException, IOException
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
		String path=request.getSession().getServletContext().getRealPath("upload");
		String fileName=file.getOriginalFilename();
		String fileType=file.getContentType();
		File targetFile = new File(path, fileName);   
		if(file==null)
		{
			reader.setRdPhoto("upload/empty.jpg");
		}
		else
		{
			if(fileType.equals("image/jpeg")  ||fileType.equals("image/pjpeg")||fileType.equals("image/gif"))
			{
				reader.setRdPhoto("upload/"+fileName);
				 file.transferTo(targetFile);  
			}
			else
			{
				reader.setRdPhoto("upload/empty.jpg");
			}
			
		}
		reader.setRdDateReg(new Date());
		System.out.println(reader.getRdID());
		i=readerService.updateReaderByrdID(reader);
		userLoginMapper.updateSysUser(reader);
		ra.addAttribute("start", start);
		return "redirect:/reader/findReader";
	}
	/** 
	   * @Title : SearchReader 
	   * @功能描述: TODO 查找指定的用户
	   * @开发者：陈强  
	   * @参数： @param rdID
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/searchReader", method={RequestMethod.POST,RequestMethod.GET})
	@RequiresPermissions(value={"reader:searchReader","iterm:all"},logical=Logical.OR)
	public String SearchReader(@RequestParam("rdID")String rdID,RedirectAttributes ra)
	{
		
		ra.addAttribute("rdID",rdID);
		ra.addAttribute("start", 0);
		return "redirect:/reader/findReader";
	}
	/** 
	   * @Title : ExportExcel 
	   * @功能描述: TODO 将数据导出
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @param request
	   * @参数： @param response
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/exportExcel")
	public String ExportExcel(Parameter parameter,HttpServletRequest request,HttpServletResponse response)
	{
		
		int start=parameter.getStart();
		int end=start+10;
		parameter.setStart(start);
		parameter.setEnd(end);
		List<Reader> readerList=readerService.getReaderInfo(parameter);
		
		ExportExcelUtil ex = new ExportExcelUtil();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	    String title = "Reader信息记录"; 
	    String[] headers = { "用户名","姓名","性别","读者类型","单位名称","电话号码","邮箱","证件状态","办证日期","已借书数量","读者角色","照片"};
	    List<String[]> dataset = new ArrayList<String[]>(); 
	    for(int i=0;i<readerList.size();i++)
	      {
	        Reader reader=readerList.get(i);
	        String borrowQty=Integer.toString(reader.getRdBorrowQty());
	        String date=format.format(reader.getRdDateReg());
	        dataset.add(new String[]{reader.getRdID(),reader.getRdName(),reader.getRdSex(),reader.getRdType(),
	        		reader.getRdDept(),reader.getRdPhone(),reader.getRdEmail(),reader.getRdStatus(),
	        		date,borrowQty,reader.getRdAdminRoles(),reader.getRdPhoto()});
	       System.out.println(reader.getRdID());
	      }
	    
		OutputStream out = null;//创建一个输出流对象 
		try { 
			
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"Reader.xls");//filename是下载的xls的名，建议最好用英文 
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
	/** 
	   * @Title : findStatusByrdID 
	   * @功能描述: TODO 找到证件当前的状态
	   * @开发者：陈强  
	   * @参数： @param rdID
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/findStatusByrdID")
	@RequiresPermissions(value={"reader:findStatusByrdID","iterm:all"},logical=Logical.OR)
	 public String findStatusByrdID(@RequestParam("rdID")String rdID,Model model)
	 {
		 String status= readerService.findStatusByrdID(rdID);
		 model.addAttribute("status", status);
		 model.addAttribute("rdID", rdID);
		 return "WEB-INF/readerJsp/readerStatus";
	 }
	
	/** 
	   * @Title : updateStatus 
	   * @功能描述: TODO 更改证件的状态
	   * @开发者：陈强  
	   * @参数： @param reader
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/updateStatus",method={RequestMethod.POST,RequestMethod.GET})
	@RequiresPermissions(value={"reader:updateStatus","iterm:all"},logical=Logical.OR)
	public String updateStatus(Reader reader)
	{
		readerService.updateStatusByrdID(reader);
		return "WEB-INF/readerJsp/readerStatus";
	}
	@RequestMapping("/toReaderStatus")
	public String readerStatus()
	{
		return "WEB-INF/readerJsp/readerStatus";
	}
}
