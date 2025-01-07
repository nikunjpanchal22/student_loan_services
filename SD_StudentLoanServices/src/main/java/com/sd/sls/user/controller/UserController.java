package com.sd.sls.user.controller;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.sls.user.constants.UserConstants;
import com.sd.sls.user.model.User;
import com.sd.sls.user.service.IUserBusinessService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private IUserBusinessService userBusinessService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Map<String, Object> userValues) {
		Map<String, Boolean> resultMap = userBusinessService.registerUser(userValues);
		if (resultMap.containsKey(UserConstants.USER_REGISTERED)) {
			return resultMap.get(UserConstants.USER_REGISTERED) == true
					? new ResponseEntity<>(UserConstants.USER_REGISTERED_SUCCESSFULLY, HttpStatus.OK)
					: new ResponseEntity<>(UserConstants.USER_ALREADY_REGISTERED, HttpStatus.NOT_FOUND);
		} else if (resultMap.containsKey(UserConstants.USER_ALREADY_REGISTERED)) {
			return new ResponseEntity<>(UserConstants.USER_ALREADY_REGISTERED, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(UserConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Map<String, Object> userValues) {
		String userName = Objects.toString(userValues.get(UserConstants.EMAIL));
		String password = Objects.toString(userValues.get(UserConstants.PASSWORD));
		return userBusinessService.loginUser(userName, password) == true
				? new ResponseEntity<>(UserConstants.USER_LOGGED_IN_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(UserConstants.INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<Integer> getUserId(@RequestParam String email)
	{
		User user = userBusinessService.findUserByEmail(email);
		if (user == null)
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(user.getUserId());
	}
	
	@PutMapping("/updateprofile/{userId}")
	public ResponseEntity<String> updateprofile(@PathVariable("userId") Long userId, @RequestBody Map<String, Object> userValues)
	{
		userValues.put(UserConstants.USER_ID, userId);
		Map<String, Boolean> resultMap = userBusinessService.updateprofile(userValues);
		if (resultMap.containsKey(UserConstants.USER_UPDATED_SUCCESSFULLY))
		{
			return ResponseEntity.ok(UserConstants.USER_UPDATED_SUCCESSFULLY);
		}
		return new ResponseEntity<>(UserConstants.USER_UPDATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@GetMapping("/test")
	public void test() 
	{
		System.out.println("Running");
	}
}
