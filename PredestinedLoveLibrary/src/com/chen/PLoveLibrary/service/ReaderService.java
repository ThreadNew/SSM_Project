package com.chen.PLoveLibrary.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.PLoveLibrary.domain.Reader;
import com.chen.PLoveLibrary.mybatis.ReaderMapper;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： ReaderService
   * @功能描述： TODO 服务层   读者信息服务层
   * @作者信息： 陈强
   * @创建时间： 2018年4月17日上午9:48:48
   * @修改备注：
   */
@Service
public class ReaderService {
	@Autowired
	private ReaderMapper readerMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertReader(Reader reader)
	{
		return readerMapper.insertReader(reader);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Reader findReaderByrdID(String rdID)
	{
		return readerMapper.findReaderByrdID(rdID);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteReaderByrdID(String rdID)
	{
		return readerMapper.deleteReaderByrdID(rdID);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateReaderByrdID(Reader reader)
	{
		return readerMapper.updateReaderByrdID(reader);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getCounts(Parameter parameter)
	{
		return this.readerMapper.getCounts(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Reader>getReaderInfo(Parameter parameter)
	{
		return this.readerMapper.getReaderInfo(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public String findStatusByrdID(String rdID)
	{
		return this.readerMapper.findStatusByrdID(rdID);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateStatusByrdID(Reader reader)
	{
		return this.readerMapper.updateStatusByrdID(reader);
	}
}
