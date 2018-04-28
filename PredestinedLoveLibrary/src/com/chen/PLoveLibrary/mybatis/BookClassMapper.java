package com.chen.PLoveLibrary.mybatis;

import java.util.List;

import com.chen.PLoveLibrary.domain.BookClass;
import com.chen.PLoveLibrary.parameter.Parameter;

/**
   * @类 名： BookClassMapper
   * @功能描述： TODO 图书编目
   * @作者信息： 陈强
   * @创建时间： 2018年4月22日下午2:24:12
   * @修改备注：
   */
public interface BookClassMapper {
	public int insertBookClass(BookClass bookClass);
	public int deleteBookClassByID(BookClass bookClass);
	public int updateBookClass(BookClass bookClass);
	public List<BookClass> selectBookClassByID(Parameter parameter);
	public int getCount(Parameter parameter);
	public BookClass findBookClassByID(Parameter parameter);
	public List<BookClass>selectAllBkCatalog();

}
