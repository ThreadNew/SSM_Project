package com.chen.PLoveLibrary.mybatis;

import java.util.List;


import com.chen.PLoveLibrary.domain.Reader;
import com.chen.PLoveLibrary.parameter.Parameter;

public interface ReaderMapper {
	public int insertReader(Reader reader);
	public Reader findReaderByrdID(String rdID);
	public int deleteReaderByrdID(String rdID);
	public int updateReaderByrdID(Reader reader);
	public int getCounts(Parameter parameter);
	public List<Reader>getReaderInfo(Parameter parameter);
	public String findStatusByrdID(String rdID);
	public int updateStatusByrdID(Reader reader);
}
