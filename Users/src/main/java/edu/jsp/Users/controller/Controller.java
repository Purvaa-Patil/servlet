package edu.jsp.Users.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.jsp.Users.entity.Udetail;

public class Controller {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("User_servlet");
	EntityManager entityManager =factory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
public Udetail register(Udetail user) {
		
		if(user!=null) {
			try {

				entityTransaction.begin();
				entityManager.persist(user);
				entityTransaction.commit();
				return user;
			}
			catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public Udetail login(String email, String password) {
		
		String query= "select u from Udetail u where u.email= :email";
		TypedQuery<Udetail> typedQuery=entityManager.createQuery(query, Udetail.class);
		typedQuery.setParameter("email", email);
	
		Udetail user=typedQuery.getSingleResult();
		
		if(user!=null) {
			return user;
		}
		return null;
		
	}
}


