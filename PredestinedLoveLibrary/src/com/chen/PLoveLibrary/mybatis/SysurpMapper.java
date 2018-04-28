package com.chen.PLoveLibrary.mybatis;

import java.util.List;

import com.chen.PLoveLibrary.domain.SysPermission;
import com.chen.PLoveLibrary.domain.SysRole;

public interface SysurpMapper {
	public List<SysRole> getRole(String rdID);
	public List<SysPermission>getPermission(String roleName);

}
