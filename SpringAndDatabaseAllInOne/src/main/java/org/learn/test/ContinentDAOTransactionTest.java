package org.learn.test;

import java.util.ArrayList;
import java.util.List;

import org.learn.beans.Continent;
import org.learn.dao.ContinentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class ContinentDAOTransactionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("org/learn/beans/beans.xml");

		ContinentDAO continentDAO = (ContinentDAO) context.getBean("continentDAO");

		try {

			System.out.println("======  Insert batch continent ( nothing will be inserted to Db for transaction) =========");

			List<Continent> continentList = new ArrayList<>();
			continentList.add(new Continent(19,"Asia1"));  //  valid Data
			continentList.add(new Continent(10,"Asi2"));  //  invalid data, dupe PK
			System.out.println(
					"Number of row affected batch Insert : " + (continentDAO.createBatchWithTransaction(continentList)).length);

		} catch (CannotGetJdbcConnectionException e) {
			System.out.println(" Can't get Database Conenction on class : " + e.getClass());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage() + " on class : " + e.getClass());
		}

	}

}
