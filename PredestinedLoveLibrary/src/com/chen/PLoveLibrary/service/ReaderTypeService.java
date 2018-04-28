package com.chen.PLoveLibrary.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.PLoveLibrary.domain.ReaderType;
import com.chen.PLoveLibrary.mybatis.ReaderTypeMapper;

/**
   * @类 名： ReaderTypeService
   * @功能描述： TODO 读者类别服务层
   * @作者信息： 陈强
   * @创建时间： 2018年4月18日上午11:17:03
   * @修改备注：
   */
@Service
public class ReaderTypeService {
	@Autowired
	private ReaderTypeMapper readerTypeMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertReaderType(ReaderType readerType)
	{
		return this.readerTypeMapper.insertReaderType(readerType);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true )
	public ReaderType findReaderTypeByID(int id)
	{
		return this.readerTypeMapper.findReaderTypeByID(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteReaderTypeByID(int id)
	{
		return this.readerTypeMapper.deleteReaderTypeByID(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateReaderType(ReaderType readerType)
	{
		return this.readerTypeMapper.updateReaderType(readerType);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@SuppressWarnings("rawtypes")
	public List<ReaderType>searchReaderType(Map map)
	{
		return this.readerTypeMapper.searchReaderType(map);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int findCountsReaderType(int rdType)
	{
		return this.readerTypeMapper.findCountsReaderType(rdType);
	}
}
