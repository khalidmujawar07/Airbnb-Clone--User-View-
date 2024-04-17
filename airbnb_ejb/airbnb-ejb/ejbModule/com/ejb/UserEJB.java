package com.ejb;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.model.Status;
import com.model.Usersbnb;

import dao.UsersbnbDAO;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
@LocalBean
public class UserEJB implements UserEJBLocal {

    /**
     * Default constructor. 
     */
    public UserEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private UsersbnbDAO userdao;
    
    public Status signUp(Usersbnb user)throws SQLException, Exception{
    	System.out.println("This is Signup ejb");
    	return userdao.signUp(user);
    }
   
    
    public Usersbnb signIn(Usersbnb user)throws SQLException {
    	System.out.println("This is SignIn ejb");
    	return userdao.signIn(user);
    }

}
