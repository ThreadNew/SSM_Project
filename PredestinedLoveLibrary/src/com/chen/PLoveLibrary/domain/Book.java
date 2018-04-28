package com.chen.PLoveLibrary.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
   * @类 名： Book
   * @功能描述： TODO  图书信息
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日下午9:04:15
   * @修改备注：
   */
@SuppressWarnings("serial")
public class Book implements Serializable {
	@NotBlank(message="不能为空")
	private String bkID;//图书序号
	@NotBlank(message="不能为空")
	private String bkCode;//图书编号
	@NotBlank(message="不能为空")
	private String bkName;//书名
	private String bkAuthor;//作者
	private String bkPress;//出版社
	private Date bkDatePress;//出版日期
	@NotBlank(message="不能为空")
	private String bkISBN;//ISBN书号
	@NotBlank(message="不能为空")
	private String bkCatalog;//分类号
	private String bkLanguage;//语言
	private int bkPages;//页数
	private String bkPrice;//价格
	private Date bkDateIn;//入馆日期
	@NotBlank(message="不能为空")
	@Size(min=0,max=100,message="字数超了100个")
	private String bkBrief;//内容简介
	private String bkCover;//图书封面
	private String bkStatus;//图书状态
	public String getBkID() {
		return bkID;
	}
	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
	public String getBkCode() {
		return bkCode;
	}
	public void setBkCode(String bkCode) {
		this.bkCode = bkCode;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public String getBkPress() {
		return bkPress;
	}
	public void setBkPress(String bkPress) {
		this.bkPress = bkPress;
	}
	public Date getBkDatePress() {
		return bkDatePress;
	}
	public void setBkDatePress(Date bkDatePress) {
		this.bkDatePress = bkDatePress;
	}
	public String getBkISBN() {
		return bkISBN;
	}
	public void setBkISBN(String bkISBN) {
		this.bkISBN = bkISBN;
	}
	public String getBkCatalog() {
		return bkCatalog;
	}
	public void setBkCatalog(String bkCatalog) {
		this.bkCatalog = bkCatalog;
	}
	public String getBkLanguage() {
		return bkLanguage;
	}
	public void setBkLanguage(String bkLanguage) {
		this.bkLanguage = bkLanguage;
	}
	public int getBkPages() {
		return bkPages;
	}
	public void setBkPages(int bkPages) {
		this.bkPages = bkPages;
	}
	public String getBkPrice() {
		return bkPrice;
	}
	public void setBkPrice(String bkPrice) {
		this.bkPrice = bkPrice;
	}
	public Date getBkDateIn() {
		return bkDateIn;
	}
	public void setBkDateIn(Date bkDateIn) {
		this.bkDateIn = bkDateIn;
	}
	public String getBkBrief() {
		return bkBrief;
	}
	public void setBkBrief(String bkBrief) {
		this.bkBrief = bkBrief;
	}
	public String getBkCover() {
		return bkCover;
	}
	public void setBkCover(String bkCover) {
		this.bkCover = bkCover;
	}
	public String getBkStatus() {
		return bkStatus;
	}
	public void setBkStatus(String bkStatus) {
		this.bkStatus = bkStatus;
	}
	
	

}
