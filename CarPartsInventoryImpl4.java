package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carPartsImpl4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {

	//this time we are injecting EntityManager 
	//object required when using JPA
	//@Autowired doesn't work for injecting the same,
	// instead we use @PersistenceContext annotation for getting entityManager object
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional 
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}
		
	
	public List<CarPart> getAvailableParts() {
		
		Query q = entityManager.createQuery("select c from CarPart as c" );
		List<CarPart> list = q.getResultList();
		return list;

	}
}
