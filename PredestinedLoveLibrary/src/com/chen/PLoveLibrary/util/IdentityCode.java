package com.chen.PLoveLibrary.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
   * @类 名： IdentityCode（工具类）
   * @功能描述： 登陆界面的验证码功能
   * @作者信息： 陈强
   * @创建时间： 2018年4月14日下午3:34:22
   * @修改备注：
   */
/**
 * @类 名： IdentityCode @功能描述： TODO @作者信息： 陈强 @创建时间： 2018年4月14日下午3:46:04 @修改备注：
 */
@SuppressWarnings("restriction")
public class IdentityCode {
	/**
	 * @Fields CHARS : 验证码的随机数 TODO
	 */
	public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'D' };
	/**
	 * @Fields random : 声明随机数的对象 TODO
	 */
	public static Random random = new Random();

	/**
	 * @Title : getRandomString
	 * @功能描述: TODO 获取验证码在页面显示的六个数
	 * @开发者：陈强 @参数： @return
	 * @返回类型：String
	 * @throws ：
	 */
	public static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	/**
	 * @Title : getRandomColor
	 * @功能描述: TODO 得到背景色
	 * @开发者：陈强 @参数： @return
	 * @返回类型：Color
	 * @throws ：
	 */
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	/** 
	   * @Title : getReverseColor 
	   * @功能描述: TODO 得到验证码的前景色
	   * @开发者：陈强  
	   * @参数： @param c
	   * @参数： @return 
	   * @返回类型：Color 
	   * @throws ：
	   */
	public static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	/** 
	   * @Title : outputIdentity 
	   * @功能描述: TODO 生成验证码的图片，并在session中存储验证码的值
	   * @开发者：陈强  
	   * @参数： @param request
	   * @参数： @param response
	   * @参数： @throws ServletException
	   * @参数： @throws IOException 
	   * @返回类型：void 
	   * @throws ：
	   */
	public static void outputIdentity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置图片的格式
		response.setContentType("image/jpeg");
		String randomString = getRandomString();
		//将验证码的值绑到session中
		request.getSession().setAttribute("randomString", randomString);
		int width = 100;
		int height = 30;
		Color color = getRandomColor();
		Color reverse = getReverseColor(color);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		//转化成jpg的格式
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);
		out.flush();
	}
}
