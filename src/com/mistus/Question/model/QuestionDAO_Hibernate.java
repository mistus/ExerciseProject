package com.mistus.Question.model;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mistus.Question.model.QuestionVO;

public class QuestionDAO_Hibernate {

	
	//1.Insert
	public void Insert(QuestionVO questionVO){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
		try {
			session.beginTransaction();
			session.saveOrUpdate(questionVO);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("QuestionVO Insert Error");
			throw e;
		}
	
	}
	
	//2.Updata
	public void Updata(QuestionVO questionVO){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
		try {
			session.beginTransaction();
			session.saveOrUpdate(questionVO);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("QuestionVO Updata Error");
			throw e;
		}
	
	}
	
	//3.Delete
	public void delete (Integer questionNumber){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			QuestionVO questionNumberVO = (QuestionVO)session.get(QuestionVO.class, questionNumber);
			session.delete(questionNumberVO);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("QuestionVO Delect Error");
			throw e;
		}
	}
		
	//4.getAll
		private static final String SelectAll="from QuestionVO order by QuestionNumber";
		public List<QuestionVO> getAll(){
			
			List<QuestionVO> list = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			try {
				session.beginTransaction();
				Query sellectAll = session.createQuery(SelectAll);
				list = sellectAll.list();
				session.getTransaction().commit();
				
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("QuestionVO GetAll Error");
				throw e;
			}
			
			return list;
		}
		
	//5.GetOne
		private static final String SellectOne="from QuestionVO where QuestionNumber=?";
		public List<QuestionVO> getOne(Integer questionNumber) {
			
			List<QuestionVO> list = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query sellectOne = session.createQuery(SellectOne);
			sellectOne.setParameter(0, questionNumber);
			list = sellectOne.list(); 
			session.getTransaction().commit();	
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("QuestionVO GetOne Error");
			throw e;
		}
		return list;
	}
		
		
		
		
		//6.取  O < 5 and X < 3
		private static final String SelectAnalytics="from QuestionVO where correct < 5 and wrong < 3";
		public List<QuestionVO> getAnalyticsQuestion(){
			
			List<QuestionVO> list = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			try {
				session.beginTransaction();
				Query sellectAll = session.createQuery(SelectAnalytics);
				list = sellectAll.list();
				session.getTransaction().commit();
				
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("QuestionVO getAnalytics Error");
				throw e;
			}
			
			return list;
		}
		
		
		//7.取  O >= 5
				private static final String SelectCorrectQuestion="from QuestionVO where correct >= 5 ";
				public List<QuestionVO> getCorrectQuestion(){
					
					List<QuestionVO> list = null;
					Session session = HibernateUtil.getSessionFactory().getCurrentSession();
					
					try {
						session.beginTransaction();
						Query sellectAll = session.createQuery(SelectCorrectQuestion);
						list = sellectAll.list();
						session.getTransaction().commit();
						
					} catch (Exception e) {
						session.getTransaction().rollback();
						System.out.println("QuestionVO getCorrectQuestion Error");
						throw e;
					}
					
					return list;
				}

				
				//搜尋／執行指定指令
				public List<QuestionVO> getCommandQuestion(String Command){
					
					List<QuestionVO> list = null;
					Session session = HibernateUtil.getSessionFactory().getCurrentSession();
					
					try {
						
						session.beginTransaction();
						Query sellectAll = session.createQuery(Command);
						
						
						String CmdType = Command.substring(0, 6).toLowerCase();
						if(CmdType.equals("update")||CmdType.equals("delete")){
							
						sellectAll.executeUpdate();
						}else{
							list = sellectAll.list();
						}

						session.getTransaction().commit();
						
					} catch (Exception e) {
						session.getTransaction().rollback();
						System.out.println("QuestionVO getCommandQuestion Error");
						throw e;
					}
					
					return list;
				}	
				
				
				
}
