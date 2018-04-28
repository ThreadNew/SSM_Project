package com.chen.PLoveLibrary.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
   * @类 名： HandleException
   * @功能描述： TODO 全局异常处理
   * @作者信息： 陈强
   * @创建时间： 2018年4月14日下午10:35:48
   * @修改备注：
   */
public class HandleException  implements  HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse reponse, Object object,
			Exception ex) {
		// TODO Auto-generated method stub
		
		ModelAndView mv=new ModelAndView();
		if(ex instanceof UnauthorizedException)
		{
			mv.addObject("message", "对不起你没有该权限，请勿操作");
		}
		else
		{
		mv.addObject("message", ex.getMessage());
		}
		mv.setViewName("error");
		return mv;
	}

}
