package com.chen.PLoveLibrary.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chen.PLoveLibrary.domain.Reader;
import com.chen.PLoveLibrary.domain.SysUR;
import com.chen.PLoveLibrary.domain.SysUser;
import com.chen.PLoveLibrary.mybatis.UserLoginMapper;
import com.chen.PLoveLibrary.parameter.Parameter;
import com.chen.PLoveLibrary.realm.UserRealm;
import com.chen.PLoveLibrary.util.IdentityCode;


/**
   * @类 名： UserLoginController
   * @功能描述： TODO 该类的作用主要是处理用户登陆，密码修改，信息维护，登陆验证等功能的一个controller的类
   * @作者信息： 陈强
   * @创建时间： 2018年4月14日下午3:55:37
   * @修改备注：
   */
@Controller
@RequestMapping("/Userlogin")
public class UserLoginController {
	@Autowired
	private UserLoginMapper userLoginMapper;
	@Autowired
	private UserRealm userRealm;
	/** 
	   * @throws IOException 
	   * @throws ServletException 
	   * @Title : createIdentity 
	   * @功能描述: TODO 产生验证码
	   * @开发者：陈强  
	   * @参数：  
	   * @返回类型：void 
	   */
	@RequestMapping("/identity")
	public void createIdentity(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		IdentityCode.outputIdentity(request, response);
	}
	
	/** 
	   * @Title : Login 
	   * @功能描述: TODO 登陆验证
	   * @开发者：陈强  
	   * @参数： @param request
	   * @参数： @param response
	   * @参数： @param user
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */

	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpServletResponse response,SysUser user)
	{
		if(user.getIdentity().equals(request.getSession().getAttribute("randomString")))
		{
			
			org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
			UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
			if(!subject.isAuthenticated())
			{
				
				subject.login(token);
				
				
			}
		}
		else
		{
			return "login";
		}
		request.getSession().setAttribute("admin",user.getUsername());
		//将登陆的用户信息存储在session中
		Reader reader=userLoginMapper.selectSysUser(user.getUsername());
		request.getSession().setAttribute("SysReader",reader);
		//model.addAttribute("admin",user.getUsername());
		return "frame/frameSet";
	}
	/** 
	   * @Title : logOut 
	   * @功能描述: TODO 用户注销登陆
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/logout")
	public String logOut()
	{
		userRealm.clearCached();
		return "login";
	}
	/** 
	   * @Title : login 
	   * @功能描述: TODO 返回后台登陆界面
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("/index")
	public String login()
	{
		return "login";
	}
	/** 
	   * @throws Exception 
	 * @Title : passwordEdit 
	   * @功能描述: TODO 用户修改密码
	   * @开发者：陈强  
	   * @参数： @param user
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="/pwdEdit",method=RequestMethod.POST)
	public String passwordEdit(SysUser user) throws Exception
	{
		int i=0;
		user.setDate(new Date());
		i=userLoginMapper.updatepwdByName(user);
		userLoginMapper.updatePwd(user);
		if(i==0)
		{
			throw  new Exception("密码修改失败");
		}
		return "frame/mainFrame";
	}
	//*********************************************************
	// *    权限设置
	// * 
	// * 
	// * 
	// * 
	// ********************************************************
	/** 
	   * @Title : comePermission 
	   * @功能描述: TODO 进入权限注册界面
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping("toReaderPermission")
	@RequiresPermissions(value={"permission:toReaderPermission","iterm:all"},logical=Logical.OR)
	public String comePermission()
	{
		return "WEB-INF/readerJsp/readerPermission";
	}
	/** 
	   * @Title : InsertPermission 
	   * @功能描述: TODO 插入权限
	   * @开发者：陈强  
	   * @参数： @param sysUR
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="insertPermission",method={RequestMethod.GET,RequestMethod.POST})
	@RequiresPermissions(value={"permission:insertPermission","iterm:all"},logical=Logical.OR)
	public String InsertPermission(SysUR sysUR)
	{
		userLoginMapper.insertPermission(sysUR);
		return "index";
	}
	/** 
	   * @Title : selectPermission 
	   * @功能描述: TODO 遍历信息
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @param model
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	@RequestMapping(value="selectPermission")
	@RequiresPermissions(value={"permission:selectPermission","iterm:all"},logical=Logical.OR)
	public String selectPermission(Parameter parameter,Model model)
	{
		int count=userLoginMapper.getCountsPermission();
		int start=parameter.getStart();
		if(start<0)start=0;
		if(start>count)start-=10;
		int end=start+10;
		parameter.setEnd(end);
		parameter.setStart(start);
		List<SysUR> permission=userLoginMapper.selectPermission(parameter);
		model.addAttribute("permission", permission);
		model.addAttribute("parameter", parameter);
		return "WEB-INF/readerJsp/permissionPage";
	}
	@RequestMapping(value="deletePermission")
	@RequiresPermissions(value={"permission:deletePermission","iterm:all"},logical=Logical.OR)
	public String DeletePermission(Parameter parameter,RedirectAttributes ra,SysUR sysUR)
	{
		userLoginMapper.deletePermission(sysUR);
		ra.addAttribute("start", parameter.getStart());
		return "redirect:/Userlogin/selectPermission";
	}
	
}
