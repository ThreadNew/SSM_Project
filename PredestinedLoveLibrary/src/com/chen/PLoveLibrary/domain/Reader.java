package com.chen.PLoveLibrary.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;



/**
   * @类 名： Reader
   * @功能描述： TODO 借书证办理的读者信息
   * @作者信息： 陈强
   * @创建时间： 2018年4月16日下午2:58:01
   * @修改备注：
   */
@SuppressWarnings("serial")
public class Reader implements Serializable{
	private String rdID;//用户名
	private String rdName;//姓名
	private String rdSex;//性别
	private String rdPwd;//密码
	private String rdType;//读者类别
	private String rdDept;//单位名称
	private String rdPhone;//电话号码
	private String rdEmail;//邮箱
	private String rdPhoto;//照片
	private String rdStatus;//证件状态
	private Date rdDateReg;//办证日期
	private int rdBorrowQty;//已借书数量
	private String rdAdminRoles;//读者角色
	@NotBlank(message="{rdID_Message}")
	public String getRdID() {
		return rdID;
	}
	public void setRdID(String rdID) {
		this.rdID = rdID;
	}
	@NotBlank(message="{rdName_Message}")
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	@NotBlank(message="{rdSex_Message}")
	public String getRdSex() {
		return rdSex;
	}
	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}
	@NotBlank(message="{rdPwd_Message}")
	public String getRdPwd() {
		return rdPwd;
	}
	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}
	public String getRdType() {
		return rdType;
	}
	public void setRdType(String rdType) {
		this.rdType = rdType;
	}
	public String getRdDept() {
		return rdDept;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	public String getRdPhone() {
		return rdPhone;
	}
	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}
	@Email(message="{rdEmail_Message")
	public String getRdEmail() {
		return rdEmail;
	}
	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}
	public String getRdPhoto() {
		return rdPhoto;
	}
	public void setRdPhoto(String rdPhoto) {
		this.rdPhoto = rdPhoto;
	}
	public String getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus;
	}
	public Date getRdDateReg() {
		return rdDateReg;
	}
	public void setRdDateReg(Date rdDateReg) {
		this.rdDateReg = rdDateReg;
	}
	public int getRdBorrowQty() {
		return rdBorrowQty;
	}
	public void setRdBorrowQty(int rdBorrowQty) {
		this.rdBorrowQty = rdBorrowQty;
	}
	public String getRdAdminRoles() {
		return rdAdminRoles;
	}
	public void setRdAdminRoles(String rdAdminRoles) {
		this.rdAdminRoles = rdAdminRoles;
	}
	
	
	

}
