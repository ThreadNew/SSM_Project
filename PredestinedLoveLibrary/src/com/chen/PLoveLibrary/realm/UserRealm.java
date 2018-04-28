package com.chen.PLoveLibrary.realm;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.PLoveLibrary.domain.SysPermission;
import com.chen.PLoveLibrary.domain.SysRole;
import com.chen.PLoveLibrary.mybatis.SysurpMapper;
import com.chen.PLoveLibrary.mybatis.UserLoginMapper;

/**
 * @类 名： UserRealm @功能描述： TODO 自定义realm，权限和登录校验，继承AuthorizingRealm @作者信息：
 *    陈强 @创建时间： 2018年4月14日下午7:45:05 @修改备注：
 */
/**
   * @类 名： UserRealm
   * @功能描述： TODO
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日上午11:04:24
   * @修改备注：
   */
/**
   * @类 名： UserRealm
   * @功能描述： TODO
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日上午11:04:27
   * @修改备注：
   */
public class UserRealm extends AuthorizingRealm {

	/**
	 * @Fields userLoginMapper : TODO bean自动注入
	 */
	@Autowired
	private UserLoginMapper userLoginMapper;
	@Autowired
	private SysurpMapper sysurpMapper;

	/*
	 * (非 Javadoc) <p>Title: doGetAuthorizationInfo</p> <p>Description: shiro授权
	 * ：角色和权限</p>
	 * 
	 * @param principals
	 * 
	 * @return
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		Object username=principals.getPrimaryPrincipal();
		List<SysRole> roleList=sysurpMapper.getRole((String)username);
		List<SysPermission> permissionList=null;
		List<String> permission=new ArrayList<String>();
		List<String> role=new ArrayList<String>();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
		for (SysRole sysRole : roleList) {
			
			permissionList=sysurpMapper.getPermission(sysRole.getRoleName());
			for (SysPermission p : permissionList) {
				permission.add(p.getPerName());
				
			}
			role.add(sysRole.getRoleName());
			System.out.println(sysRole.getRoleName());
			
			
		}
		System.out.println(role.get(0));
		info.addRoles(role);
		info.addStringPermissions(permission);
		return info;
	}

	/*
	 * (非 Javadoc) <p>Title: doGetAuthenticationInfo</p> <p>Description:
	 * shiro的身份验证</p>
	 * 
	 * @param token
	 * 
	 * @return
	 * 
	 * @throws AuthenticationException
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
	 * apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		Object username = token.getPrincipal();
		if (username != null) {
			Object password = (Object) userLoginMapper.findpwdByName((String) username);
			System.out.println(password);
			if (password == null) {
				throw new IncorrectCredentialsException("密码错误");
			} else {

				AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, "realm1");
				return info;
			}
		} else {
			throw new UnknownAccountException("无用户");
		}

	}
	 /** 
	   * @Title : clearCached 
	   * @功能描述: TODO 清除缓存
	   * @开发者：陈强  
	   * @参数：  
	   * @返回类型：void 
	   * @throws ：
	   */
	public void clearCached() {
	      PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
	      super.clearCache(principals);
	 }
	  
}
