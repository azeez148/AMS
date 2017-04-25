package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Role;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.entity.Screen;
import com.experion.ams.mvc.vo.RoleFormVO;

public interface RoleService {

	public List<Role> getAllRoles();

	public List<Screen> getAllScreens();

/*	public boolean addRole(Role role);
*/
	public List<Screen> getIdByScreenName(String str);

	public List<Screen> getScreenDeatails(List<String> st);

	public List<Role> getRoleDetailsById(long id);

	public boolean editRole(Role role);
	public List<Role> getRoleDetailsByName(String roleName);

	public List<RoleToScreenMapping> getRoleToScreenId(Long id);

	public Role getRoleById(long roleId);

	public boolean deleteMappings(long id);

	public boolean editRole(long roleId, RoleFormVO roleFormVO,
			List<Screen> screenList);



	public boolean addRole(RoleFormVO roleFormVO,List<Screen> screenList);

	public Boolean checkRole(String roleName);


}
