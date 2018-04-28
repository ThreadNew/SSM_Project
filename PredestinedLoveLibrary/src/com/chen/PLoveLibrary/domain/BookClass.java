package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
   * @类 名： BookClass
   * @功能描述： TODO  图书的编目工作
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日下午12:40:16
   * @修改备注：
   */
@SuppressWarnings("serial")
public class BookClass implements Serializable{
	private String bkCatalog;//分类号
	private String bkClassName;//分类名
	@NotBlank(message="不能为空")
	public String getBkCatalog() {
		return bkCatalog;
	}
	public void setBkCatalog(String bkCatalog) {
		this.bkCatalog = bkCatalog;
	}
	@NotBlank(message="不能为空")
	public String getBkClassName() {
		return bkClassName;
	}
	public void setBkClassName(String bkClassName) {
		this.bkClassName = bkClassName;
	}
	
	

}
