package com.chen.PLoveLibrary.mybatis;

import java.util.List;

import com.chen.PLoveLibrary.domain.Reader;
import com.chen.PLoveLibrary.domain.SysUR;
import com.chen.PLoveLibrary.domain.SysUser;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： UserLoginMapper
   * @功能描述： TODO  用户登陆的接口
   * @作者信息： 陈强
   * @创建时间： 2018年4月14日下午8:48:13
   * @修改备注：
   */
public interface UserLoginMapper {
	
	/** 
	   * @Title : findpwdByName 
	   * @功能描述: TODO 查找密码
	   * @开发者：陈强  
	   * @参数： @param name 用户名
	   * @参数： @return 
	   * @返回类型：String 
	   * @throws ：
	   */
	public String findpwdByName(String name);
	
	/** 
	   * @Title : updatepwdByName 
	   * @功能描述: TODO 更新密码
	   * @开发者：陈强  
	   * @参数： @param sysUser 
	   * @返回类型：void 
	   * @throws ：
	   */
	public int updatepwdByName(SysUser sysUser);
	/** 
	   * @Title : insertSysUser 
	   * @功能描述: TODO  读者表插入一条信息，则在系统用户表中也要插入一条信息
	   * @开发者：陈强  
	   * @参数： @param reader
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int insertSysUser(Reader reader);
	/** 
	   * @Title : updateSysUser 
	   * @功能描述: TODO 读者表更新，系统表也要更新
	   * @开发者：陈强  
	   * @参数： @param reader
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int updateSysUser(Reader reader);
	/** 
	   * @Title : deleteSysUser 
	   * @功能描述: TODO 读者表删除，系统表也要删除
	   * @开发者：陈强  
	   * @参数： @param id
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int deleteSysUser(String id);
	/** 
	   * @Title : selectSysUser 
	   * @功能描述: TODO 查询自己的而用户信息
	   * @开发者：陈强  
	   * @参数： @param reader
	   * @参数： @return 
	   * @返回类型：Reader 
	   * @throws ：
	   */
	public Reader selectSysUser(String id);
	/** 
	   * @Title : updatePwd 
	   * @功能描述: TODO 更新密码
	   * @开发者：陈强  
	   * @参数： @param user
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int updatePwd(SysUser user);
	/** 
	   * @Title : insertPermission 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @param sysUR
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int insertPermission(SysUR sysUR);
	/** 
	   * @Title : selectPermission 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @param parameter
	   * @参数： @return 
	   * @返回类型：List<SysUR> 
	   * @throws ：
	   */
	public List<SysUR>selectPermission(Parameter parameter);
	/** 
	   * @Title : deletePermission 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @param username
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public  int deletePermission(SysUR sysUR);
	/** 
	   * @Title : getCountsPermission 
	   * @功能描述: TODO
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int getCountsPermission();
}
