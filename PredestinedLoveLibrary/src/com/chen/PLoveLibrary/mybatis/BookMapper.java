package com.chen.PLoveLibrary.mybatis;

import java.util.List;

import com.chen.PLoveLibrary.domain.Book;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： BookMapper
   * @功能描述： TODO 图书接口
   * @作者信息： 陈强
   * @创建时间： 2018年4月24日下午8:17:00
   * @修改备注：
   */
public interface BookMapper {
	public int insertBook(Book book);
	public List<Book>selectBook(Parameter parameter);
	public int deleteBookByID(String bkID);
	public int updateBookByID(Book book);
	public int getCounts(Parameter parameter);
}
