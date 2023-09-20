package com.nagarro.searchtshirt;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.customexceptions.CustomException;
import com.nagarro.tshirt.Tshirt;

public class SearchDB {
	List<Tshirt> tshirtlist = new LinkedList<Tshirt>();

	public List<Tshirt> searchTshirts(String colour, String size, String gender, String outputPreference) throws CustomException {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Query query;
         String availability ="Y";
		// if outputpreference is price
		if (outputPreference.equalsIgnoreCase("price")){
			query = session
					.createQuery("from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender AND AVAILABILITY=:availability order by PRICE");
		}

		// if outputpreference is rate
		else if (outputPreference.equalsIgnoreCase("rating")) {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender AND AVALIBILITY=:availability order by RATING DESC");
		}

		// if outputpreference is price and rate both
		else {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender AND AVALIBILITY=:availability order by PRICE,RATING DESC");
		}

		query.setParameter("colour", colour);
		query.setParameter("size", size);
		query.setParameter("gender", gender);
		query.setParameter("availability", availability);
		if(query.list().size()==0) {
			throw new CustomException("Sorry, no t-shirt is available of your required choice");
		}
		
		@SuppressWarnings("unchecked")
		List<Tshirt> findTshirts = (List<Tshirt>) query.list();

		for (Tshirt findTshirt : findTshirts) {
			tshirtlist.add(findTshirt);
		}
		
		
		
		return tshirtlist;
	}

}
