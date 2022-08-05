package com.cg.book.app.service;

import java.util.List;
import com.cg.book.app.model.AppUser;

public interface AppUserService {

	List<AppUser> getAllUsers();

	AppUser signUpUser(AppUser appUser);

	AppUser signInUser(AppUser appUser);

	AppUser updateUser(AppUser appUser);

	String signOutUser(String userName);

//	String logoutUser(String userName);


	
}
