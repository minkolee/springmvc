package cc.conyli.dao;

import cc.conyli.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
