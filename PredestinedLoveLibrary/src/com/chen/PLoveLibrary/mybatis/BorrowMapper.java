package com.chen.PLoveLibrary.mybatis;

import java.util.List;

import com.chen.PLoveLibrary.domain.Borrow;
import com.chen.PLoveLibrary.domain.ReaderType;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： BorrowMapper
   * @功能描述： TODO 借书接口
   * @作者信息： 陈强
   * @创建时间： 2018年4月26日上午10:07:51
   * @修改备注：
   */
public interface BorrowMapper {
	public int insertBorrow(Borrow borrow);
	public int updateBookByID(Parameter parameter);
	public Parameter getReaderInfoByID(Parameter parameter);
	public int updateReaderByID(Parameter parameter);
	public ReaderType findReaderTypeByrdID(String rdID);
	public List<Borrow> selectBorrowInfo(Parameter parameter);
	public int getCounts(Parameter parameter);
	public int deleteBorrowByID(int id);
	public int updateReader(Parameter parameter);
	public Borrow getBorrow(Borrow borrow);
	public int updateReturn(Borrow borrow);
	public int updateTB(Borrow borrow);

}
