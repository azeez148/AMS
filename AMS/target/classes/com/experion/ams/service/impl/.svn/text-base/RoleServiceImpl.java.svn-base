package com.experion.ams.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.RoleDAO;
import com.experion.ams.entity.Role;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.entity.Screen;
import com.experion.ams.mvc.vo.RoleFormVO;
import com.experion.ams.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private static final String STATUS_ACTIVE = "Active";
	private static final String STATUS_INACTIVE = "InActive";
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}

	@Override
	public List<Screen> getAllScreens() {
		// TODO Auto-generated method stub
		return roleDAO.getAllScreens();
	}

	@Override
	public boolean addRole(RoleFormVO roleFormVO,List<Screen> screenList) {
		Role role = new Role();
		role.setRoleName(roleFormVO.getName());
		role.setDescription(roleFormVO.getDescription());
		role.setStatus(roleFormVO.getStatus());
		List<RoleToScreenMapping> roleScreenMapList = new ArrayList<RoleToScreenMapping>();

		for (Screen screen : screenList) {

			RoleToScreenMapping roletoscreenmap = new RoleToScreenMapping();
			 roletoscreenmap.setScreen(screen);
			 roletoscreenmap.setRole(role);
			
		 roletoscreenmap.setScreenId(screen.getId());
			roleScreenMapList.add(roletoscreenmap);
		}
		 role.setRoleScreenMap(roleScreenMapList);

		return roleDAO.addRole(role);
	}

	@Override
	public List<Screen> getIdByScreenName(String string) {
		// TODO Auto-generated method stub
		return roleDAO.getIdByScreenName(string);
	}

	@Override
	public List<Screen> getScreenDeatails(List<String> st) {
		return roleDAO.getScreenDeatails(st);
	}

	// @Override
	// public List<Role> getRoleDetailsById(long roleId) {
	// // TODO Auto-generated method stub
	// return roleDAO.getRoleDetailsById(roleId);
	// }

	@Override
	public boolean editRole(Role role) {
		// TODO Auto-generated method stub
		return roleDAO.editRole(role);
	}

	@Override
	public List<Role> getRoleDetailsByName(String roleName) {
		// TODO Auto-generated method stub public List<Role>
		return roleDAO.getRoleDetailsByName(roleName);
	}

	@Override
	public List<RoleToScreenMapping> getRoleToScreenId(Long id) {
		return roleDAO.getRoleToScreenId(id);
	}

	@Override
	public Role getRoleById(long roleId) {
		return roleDAO.getroleById(roleId);
	}

	@Override
	public boolean deleteMappings(long toScreenMappings) {
		// TODO Auto-generated method stub
		return roleDAO.deleteMappings(toScreenMappings);
	}

	@Override
	public List<Role> getRoleDetailsById(long id) {
		// TODO Auto-generated method stub
		return roleDAO.getRoleDetailsById(id);
	}

	@Override
	@Transactional
	public boolean editRole(long roleId, RoleFormVO roleFormVO,
			List<Screen> screenList) {

		List<Role> roleList = roleDAO.getRoleDetailsById(roleId);
		Role role = roleList.get(0);
		System.out.println("ID in Role......." + role);

		role.setRoleName(roleFormVO.getName());
		role.setDescription(roleFormVO.getDescription());

/*		if (roleFormVO.getStatus().equals(STATUS_ACTIVE)) {
*/			role.setStatus(roleFormVO.getStatus());
		/*} else {
			role.setStatus("no");
		}*/

		List<RoleToScreenMapping> roleScreenMapList = role.getRoleScreenMap();
		for (RoleToScreenMapping mapping : roleScreenMapList) {
			roleDAO.deleteMappings(mapping.getId());
		}
		roleScreenMapList.clear();
		System.out.println(roleScreenMapList.size());

		for (Screen screen : screenList) {
			RoleToScreenMapping roletoscreenmap = new RoleToScreenMapping();
			roletoscreenmap.setRole(role);
			roletoscreenmap.setScreen(screen);

			roletoscreenmap.setScreenId(screen.getId());
//			roletoscreenmap.setRoleId(role.getId());

			roleScreenMapList.add(roletoscreenmap);
		}

		System.out.println("list....." + roleScreenMapList.size());

		System.out.println("Role to Screen Mapping List ...... "
				+ roleScreenMapList);
		role.setRoleScreenMap(roleScreenMapList);
		System.out.println("ID in Role......." + role);

		return roleDAO.editRole(role);
	}

	@Override
	public Boolean checkRole(String roleName) {
		return roleDAO.checkRole(roleName);

	}



	
	

	

	
}
