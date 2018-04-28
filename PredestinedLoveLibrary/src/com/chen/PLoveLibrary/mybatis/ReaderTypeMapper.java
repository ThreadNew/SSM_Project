package com.chen.PLoveLibrary.mybatis;

import java.util.List;
import java.util.Map;

import com.chen.PLoveLibrary.domain.ReaderType;

public interface ReaderTypeMapper {
	/** 
	   * @Title : insertReaderType 
	   * @功能描述: TODO 读者类别注册
	   * @开发者：陈强  
	   * @参数： @param id
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int insertReaderType(ReaderType readerType);
	/** 
	   * @Title : findReaderTypeByID 
	   * @功能描述: TODO 根据id查找信息
	   * @开发者：陈强  
	   * @参数： @param id
	   * @参数： @return 
	   * @返回类型：ReaderType 
	   * @throws ：
	   */
	public ReaderType findReaderTypeByID(int id);
	/** 
	   * @Title : deleteReaderTypeByID 
	   * @功能描述: TODO 根据id删除信息
	   * @开发者：陈强  
	   * @参数： @param id
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int deleteReaderTypeByID(int id);
	/** 
	   * @Title : updateReaderType 
	   * @功能描述: TODO 更新数据
	   * @开发者：陈强  
	   * @参数： @param readerType
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int updateReaderType(ReaderType readerType);
	/** 
	   * @Title : searchReaderType 
	   * @功能描述: TODO 分页查找
	   * @开发者：陈强  
	   * @参数： @param map
	   * @参数： @return 
	   * @返回类型：List<ReaderType> 
	   * @throws ：
	   */
	@SuppressWarnings("rawtypes")
	public List<ReaderType>searchReaderType(Map map);
	/** 
	   * @Title : findCountsReaderType 
	   * @功能描述: TODO 得到总记录的个数
	   * @开发者：陈强  
	   * @参数： @return 
	   * @返回类型：int 
	   * @throws ：
	   */
	public int findCountsReaderType(int rdType);
}
