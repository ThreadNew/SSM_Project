package com.chen.PLoveLibrary.shiroFilter;



import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
   * @类 名： loginFormAuthenticationFilter
   * @功能描述： TODO 解决shiro 登陆成功不跳转到指定的成功页面
   * @作者信息： 陈强
   * @创建时间： 2018年4月27日下午3:37:27
   * @修改备注：
   */
public class loginFormAuthenticationFilter extends FormAuthenticationFilter {


	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request, response, "/frame/frameSet.jsp");
		return false;
	}
	
}
