package com.chen.PLoveLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.PLoveLibrary.domain.BookClass;
import com.chen.PLoveLibrary.mybatis.BookClassMapper;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： BookClassService
   * @功能描述： TODO 图书编目服务层
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日下午2:27:28
   * @修改备注：
   */
@Service
public class BookClassService {
	@Autowired
	private BookClassMapper bookClassMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertBookClass(BookClass bookClass)
	{
		return this.bookClassMapper.insertBookClass(bookClass);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteBookClassByID(BookClass bookClass)
	{
		return this.bookClassMapper.deleteBookClassByID(bookClass);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBookClass(BookClass bookClass)
	{
		return this.bookClassMapper.updateBookClass(bookClass);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<BookClass> selectBookClassByID(Parameter parameter)
	{
		return this.bookClassMapper.selectBookClassByID(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getCount(Parameter parameter)
	{
		return this.bookClassMapper.getCount(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public BookClass findBookClassByID(Parameter parameter)
	{
		return this.bookClassMapper.findBookClassByID(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<BookClass> selectAllBkCatalog()
	{
		return this.bookClassMapper.selectAllBkCatalog();
	}

}
