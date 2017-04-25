package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Role;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.entity.Screen;

public interface RoleDAO {

	public List<Role>  getAllRoles();

	public List<Screen> getAllScreens();

	public boolean addRole(Role role);

	public List<Screen> getIdByScreenName(String string);

	public List<Screen> getScreenDeatails(List<String> st);

	public List<Role> getRoleDetailsById(long roleId);

	public boolean editRole(Role role);

	public List<Role> getRoleDetailsByName(String roleName);

	public List<RoleToScreenMapping> getRoleToScreenId(Long id);

	public Role getroleById(long roleId);

	public boolean deleteMappings(long toScreenMappings);

	public Boolean checkRole(String roleName);


	
}
