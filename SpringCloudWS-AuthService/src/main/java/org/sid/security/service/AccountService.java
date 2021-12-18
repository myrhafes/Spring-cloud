package org.sid.security.service;

import java.util.List;

import org.sid.security.entities.AppRole;
import org.sid.security.entities.AppUser;

public interface AccountService {
	AppUser addNewUser(AppUser appUser);
	AppRole addNewRole(AppRole appRolde);
	void addRoleToUser(String username, String Role);
	AppUser loadUserByUsername(String username);
	List<AppUser> listUsers();
}
