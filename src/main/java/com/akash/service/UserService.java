package com.akash.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

import com.akash.controller.AddResponce;
import com.akash.entity.User;

@Component
public class UserService {

	static HashMap<Integer, User>UserDetails;

	UserService(){
		UserDetails=new HashMap<Integer, User>();
		User u1=new User(121, "Akash", "Sarwade", "Pune", "BE-Comp", "DXC Technology", 32909.2, "Chennai");
		User u2=new User(122, "Sham", "Sarwade", "Pune", "BE-Comp", "DXC Technology", 89765.2, "Pune");
		User u3=new User(123, "Sentener", "John", "Pune", "BE-Comp", "DXC Technology", 7865.2, "Banglore");
		User u4=new User(124, "Asmita", "Singh", "Pune", "BE-Comp", "DXC Technology", 7865.2, "Chennai");
		
		UserDetails.put(1, u1);
		UserDetails.put(2, u2);
		UserDetails.put(3, u3);
		UserDetails.put(4, u4);
	}
	
//	get All UsersDetails
	public List getAllUsers() {
		List users=new ArrayList<>(UserDetails.values());
		return users;
	}
	
	//get user By Id
	public User getUserById(int id) {
		User user=UserDetails.get(id);
		return user;
	}
	
	//get user by name
//	public User getUserByName(String userName) {
//		User user=null;
//		for(int i:UserDetails.keySet())
//		{
//			if(UserDetails.get(i).getFirstName().equals(userName))
//				user.UserDetails.get(i);
//		}
//		return user;
//	}
	
	//add new Users
	public User addUser(User user) {
		user.setEmpId(getMaxId());
		UserDetails.put(user.getEmpId(), user);
		return user;
		
	}
	//utility method to get max id
	public static int getMaxId() {
		int max=0;
		for(int id:UserDetails.keySet())
			if(max<=id)
				max=id;
		return max+1;
	}
	
	//update Existing User
	public User updateUser(User user) {
		if(user.getEmpId()>0)
			UserDetails.put(user.getEmpId(), user);
		return user;
	}
	
	//delete User
	public AddResponce deleteUser(int id) {
		UserDetails.remove(id);
		AddResponce resp=new AddResponce();
		resp.setMsg("User Deleted Successfully.......!!!");
		resp.setId(id);
		return resp;
	}
}

