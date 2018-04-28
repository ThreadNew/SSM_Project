package com.chen.PLoveLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.PLoveLibrary.domain.Borrow;
import com.chen.PLoveLibrary.domain.ReaderType;
import com.chen.PLoveLibrary.mybatis.BorrowMapper;
import com.chen.PLoveLibrary.parameter.Parameter;

@Service
public class BorrowService {
	@Autowired
	private BorrowMapper borrowMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertBorrow(Borrow borrow)
	{
		return this.borrowMapper.insertBorrow(borrow);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ReaderType findReaderTypeByrdID(String rdID)
	{
		return this.borrowMapper.findReaderTypeByrdID(rdID);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBookByID(Parameter parameter)
	{
		return this.borrowMapper.updateBookByID(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Parameter getReaderInfoByID(Parameter parameter)
	{
		return this.borrowMapper.getReaderInfoByID(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateReaderByID(Parameter parameter)
	{
		return this.borrowMapper.updateReaderByID(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Borrow> selectBorrowInfo(Parameter parameter)
	{
		return this.borrowMapper.selectBorrowInfo(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getCounts(Parameter parameter)
	{
		return this.borrowMapper.getCounts(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteBorrowByID(int id)
	{
		return this.borrowMapper.deleteBorrowByID(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateReader(Parameter parameter)
	{
		return this.borrowMapper.updateReader(parameter);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Borrow getBorrow(Borrow borrow)
	{
		return this.borrowMapper.getBorrow(borrow);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateReturn(Borrow borrow)
	{
		return this.borrowMapper.updateReturn(borrow);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateTB(Borrow borrow)
	{
		return this.borrowMapper.updateTB(borrow);
	}

}
