package org.sid.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.security.entities.AppRole;
import org.sid.security.entities.AppUser;
import org.sid.security.repositories.AppRoleRepository;
import org.sid.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public AppUser addNewUser(AppUser appUser) {
		String pw = appUser.getPassword();
		appUser.setPassword(passwordEncoder.encode(pw));
		return appUserRepository.save(appUser);
	}

	@Override
	public AppRole addNewRole(AppRole appRolde) {
		return appRoleRepository.save(appRolde);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByRoleName(rolename);
		appUser.getAppRoles().add(appRole);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> listUsers() {
		return appUserRepository.findAll();
	}

}
