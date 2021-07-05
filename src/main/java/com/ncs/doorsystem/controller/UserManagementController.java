package com.ncs.doorsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.service.UserManagementService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usermanagemet")
public class UserManagementController 
{
	
	@Autowired
	UserManagementService userService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allusers")
	public @ResponseBody List<CreateUserModal> getAllUsres(@RequestParam("custId") long custId)
	{	
	List<CreateUserModal> list=userService.findAllUsresOfCustomer(custId);
		
		return list;
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createuser")
	public ResponseEntity<CreateUserModal>  createNewUser(@RequestBody CreateUserModal modal,@RequestParam("custId") long custid) throws Exception
	{
		CreateUserModal userModal= userService.createNewUser(modal,custid);
		if(userModal!=null)
		{
			return new ResponseEntity<CreateUserModal>(HttpStatus.OK);
		}
		
		
		return new ResponseEntity<CreateUserModal>(HttpStatus.BAD_REQUEST);
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getuser")
	public @ResponseBody CreateUserModal getUser(@RequestParam("username") String usernname)
	{	
	CreateUserModal list=userService.findUsres(usernname);
		
		return list;
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	
	@PutMapping("/updateUser")
	public CreateUserModal updateUser(@RequestBody CreateUserModal modal,@RequestParam("username") String usernname)
	{
		CreateUserModal userupdate = userService.updateuser(modal,usernname);
		
		if(userupdate!=null)
		{
			return userupdate;
		}
		return modal;
	}
	
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestParam("username") String username) throws Exception
	{
		System.out.println("username "+username);
		int result = userService.deleteUser(username);
		if(result!=0)
		{
			return "user deleted successfully";
		}
		return "unsuccessfull delete";
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/resendPassword")
	public String resndPasswordToEmailID(@RequestParam("username") String userName) throws Exception
	{
		System.out.println("the username "+userName);
		CreateUserModal resendPassUserModal = userService.resendPassword(userName);
		System.out.println(resendPassUserModal.toString());
		if(resendPassUserModal!=null)
		{
			return "Success! Resend password to email!";
		}
		else
		{
			return "Resend Password failed";
		}
		
		
	}
	//@CrossOrigin(origins = "http://localhost:4200")
	
	@RequestMapping("/search")
    public List<CreateUserModal> SearchUser( @RequestParam("keyword") String keyword) {
        List<CreateUserModal> listProducts = userService.searchCreatedUser(keyword);
       
        
        return listProducts;
    }
     
	

}
