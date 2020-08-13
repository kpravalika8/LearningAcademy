package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.models.HibernateUtil;
import com.dxc.models.Class;

public class ClassDAO {
	
	public void updateClass(Class user) {
	Transaction transaction = null;
	try {Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
	} catch (Exception ex) {
		if (transaction != null)
			transaction.rollback();
		System.out.println(ex.getMessage());
	}

}

public void deleteClass(int id) {

	Transaction transaction = null;
	try {
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		Class user = session.get(Class.class, id);
		session.remove(user);
		transaction.commit();
	} catch (Exception ex) {
		if (transaction != null)
			transaction.rollback();
		System.out.println(ex.getMessage());
	}
}

public void insertClass(Class user) {

	Transaction transaction = null;
	try {
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	} catch (Exception ex) {
		if (transaction != null)
			transaction.rollback();
		System.out.println(ex.getMessage());
	}
}

public List<Class> selectAllClass() {
    List<Class> users = null;
	Transaction transaction = null;
	try {
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		users = session.createCriteria(Class.class).list();
		transaction.commit();
	} catch (Exception ex) {
		if (transaction != null)
			transaction.rollback();
		System.out.println(ex.getMessage());
	}
	return users;
}

public Class selectClass(int id) {

	Class user = null;
	Transaction transaction = null;
	try {
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		transaction = session.beginTransaction();
		user = session.get(Class.class, id);
		transaction.commit();
	} catch (Exception ex) {
		if (transaction != null)
			transaction.rollback();
		System.out.println(ex.getMessage());
	}
	return user;
}
}

