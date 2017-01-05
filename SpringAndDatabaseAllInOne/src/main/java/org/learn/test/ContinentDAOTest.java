package org.learn.test;

import java.util.ArrayList;
import java.util.List;

import org.learn.beans.Continent;
import org.learn.beans.User;
import org.learn.dao.ContinentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class ContinentDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("org/learn/beans/beans.xml");

		ContinentDAO continentDAO = (ContinentDAO) context.getBean("continentDAO");

		try {

			System.out.println("======  Query all Continents ============");
			List<Continent> continents = continentDAO.getAllContinents();
			for (Continent continent : continents) {
				System.out.println("ID : " + continent.getId() + " Name : " + continent.getName());
			}
			
			System.out.println("======  Query for single continent =========");
			Continent continent = continentDAO.getContinent(2);
			System.out.println("Result from Single query with ID : " + "ID : " + continent.getId() + " Name : " + continent.getName());
			
			System.out.println("======  Delete single continent =========");
			System.out.println("Number of row affected after delete : " + continentDAO.delete(1));
			
			//=== Insert / create
			System.out.println("======  Insert single continent =========");
			Continent continentDForInsert = new Continent("Asia");
			System.out.println("Number of row affected after Insert : " + continentDAO.create(continentDForInsert));
			
			System.out.println("======  Insert batch continent =========");
			
			List<Continent>  continentList = new ArrayList<>();
			continentList.add(new Continent("Asia1"));
			continentList.add(new Continent("Asi2"));
			System.out.println("Number of row affected batch Insert : " + (continentDAO.createBatch(continentList)).length);
			
			//=====  Update
			System.out.println("======  Update single continent =========");
			Continent continentDForUpdate = new Continent(8,"Asia Updated Va");
			System.out.println("Number of row affected after update : " + continentDAO.update(continentDForUpdate));
			
			
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println(" Can't get Database Conenction on class : " + e.getClass());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage() + " on class : " + e.getClass());
		}

	}

}
