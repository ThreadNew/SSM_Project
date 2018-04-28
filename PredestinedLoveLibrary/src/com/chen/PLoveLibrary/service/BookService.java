package com.chen.PLoveLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.PLoveLibrary.domain.Book;
import com.chen.PLoveLibrary.mybatis.BookMapper;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： BookService
   * @功能描述： TODO 图书管理服务层
   * @作者信息： 陈强
   * @创建时间： 2018年4月24日下午8:26:03
   * @修改备注：
   */
@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertBook(Book book)
	{
		return this.bookMapper.insertBook(book);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Book>selectBook(Parameter parameter)
	{
		return this.bookMapper.selectBook(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteBookByID(String bkID)
	{
		return this.bookMapper.deleteBookByID(bkID);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBookByID(Book book)
	{
		return this.bookMapper.updateBookByID(book);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getCounts(Parameter parameter)
	{
		return this.bookMapper.getCounts(parameter);
	}
}
