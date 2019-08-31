package com.risyst.hibernate;

import java.util.List;

import com.risyst.hibernate.dbservice.DbService;
import com.risyst.hibernate.model.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       DbService dbService = new DbService();
       Users user = new Users();
       user.setUserId(1);
       user.setUserName("abc");
       user.setAddress("abcd2");
       user.setPhone("1234562");
       user.setGender('M');
       //dbService.updateUser(user);
       List<Users> list = dbService.getUsers();
       list.forEach(usr -> {
    	   System.out.println(usr.toString());
       });
    }
}
