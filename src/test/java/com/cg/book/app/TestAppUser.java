package com.cg.book.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.book.app.exception.AppUserNotFoundException;
import com.cg.book.app.model.AppUser;
import com.cg.book.app.repository.AppUserRepository;
import com.cg.book.app.service.AppUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAppUser {
	@InjectMocks
	private AppUserServiceImpl serviceobj;
	@Mock
	private AppUserRepository appUserRepository;

	// 1. signUpUser() Service Layer Check
	@Test
	public void signUpUserTest() {
		AppUser user = new AppUser();
		user.setUserName("Sai");
		user.setPassword("Sai");
		user.setRole("USER");
		
		Mockito.when(appUserRepository.save(user)).thenReturn(user);
		
		assertEquals(user, serviceobj.signUpUser(user));
	}

//		2. signIn() Service Layer Check for Wrong UserName
	@Test
	public void signInUserTest() throws AppUserNotFoundException {
		AppUser user = new AppUser();
		user.setUserName("Raj");
		user.setPassword("Raj");

		Executable ex = () -> {
			serviceobj.signInUser(user);
		};

		Assertions.assertThrows(AppUserNotFoundException.class, ex);
	}


//	//	3. signIn() Service Layer Check for Wrong Password
//	@Test
//	public void signInUserTest1() throws AppUserNotFoundException {
//		AppUser user=new AppUser();
//		user.setUserName("Priya");
//		user.setPassword("Capgemini");
//		
//		String testReturn="Wrong Password";
//		
//		Mockito.when(appUserRepository.existsById("Priya")).thenReturn(true);
//		Mockito.when(appUserRepository.findById("Priya")).thenReturn(Optional.of(user));
//
//		
//		Assertions.assertEquals(testReturn, serviceobj.signInUser(user));
//	}
//	
// 4. signIn() Service Layer Check for Correct Credentials
//	@Test
//	public void testPositivesignIn() throws AppUserNotFoundException {
//		AppUser user=new AppUser();
//		user.setUserName("Priya");
//		user.setPassword("Priya");
//		
//		String testReturn= "Signed In SuccessFully";
//		
//		Mockito.when(appUserRepository.existsById("Priya")).thenReturn(true);
//		Mockito.when(appUserRepository.findById("Priya")).thenReturn(Optional.of(user));
//
//		
//		Assertions.assertEquals(testReturn, serviceobj.signInUser("Priya", "Priya"));
//	}
}
