package com.dxc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.models.HibernateUtil;
import com.dxc.models.Teacher;

public class TeacherDAO {
	public void updateUser(Teacher user) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.buildSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}

	}

	public void deleteTeacher(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.buildSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Teacher user = session.get(Teacher.class, id);
			session.remove(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

	public void insertTeacher(Teacher user) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.buildSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Teacher> selectAllUser() {

		List<Teacher> users = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.buildSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			users = session.createCriteria(Teacher.class).list();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		return users;
	}

	public Teacher selectUser(int id) {

		Teacher user = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.buildSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			user = session.get(Teacher.class, id);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		return user;
	}

}

