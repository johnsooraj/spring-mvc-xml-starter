package com.spring.starter.user.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.starter.models.Users;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Users> fetchAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<Users> criteriaQuery = session.getCriteriaBuilder().createQuery(Users.class);
		criteriaQuery.from(Users.class);
		return session.createQuery(criteriaQuery).getResultList();
	}

}
