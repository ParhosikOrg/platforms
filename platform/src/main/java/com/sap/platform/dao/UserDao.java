package com.sap.platform.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.sap.platform.model.User;

@Repository
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;		
	
	public static final String hqlAllUsers = "FROM User as usr ORDER BY usr.id";
	
	public List<User> getAllUsers() {
		String hql = "FROM User as usr ORDER BY usr.id";
		List<User> users = (List<User>) entityManager.createQuery(hql).getResultList();
		return users;
	}

	public User verify(User user) {
		
		List<User> users = (List<User>) entityManager.createQuery(hqlAllUsers).getResultList();
		
		User u = null;
		boolean exists = false;
		
		if( !exists ) {
			for (User usr : users) {
				
				if( user.getUserName().equals(usr.getUserName()) && user.getPassword().equals(usr.getPassword()) ) {
					u = usr;
					exists = true;
					break;
				} 
					
			}	
		}
		
		
/*		User u = entityManager.find(User.class, 2);
		System.out.println("Input in DAO: " + user.getUserName() + "-> " + u.getUserName() );
*/		
/*		if( exists ) 
			return new ResponseEntity<User>(HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
*/
		
		return u;


		
	}

}
