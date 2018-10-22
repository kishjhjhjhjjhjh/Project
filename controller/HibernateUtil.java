package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL5Dialect;

import com.model.Student;


public class HibernateUtil 
{
	private static StandardServiceRegistry registry;
	
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getsessionfactory()
	{
		StandardServiceRegistryBuilder registerbuilder=new StandardServiceRegistryBuilder();
		
		Map<String,Object> map=new HashMap<>();
		
		map.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		map.put(Environment.USER,"root");
		map.put(Environment.PASS,"root");
		map.put(Environment.URL,"jdbc:mysql://localhost:3306/hibcrud8");
		map.put(Environment.SHOW_SQL,true);
		map.put(Environment.HBM2DDL_AUTO,"update");
		
		//map.put(Environment.DIALECT, "mysql");
		registerbuilder.applySettings(map);
		
		registry=registerbuilder.build();
		
		MetadataSources mds=new MetadataSources(registry)
				.addAnnotatedClass(Student.class);
		
		Metadata md=mds.getMetadataBuilder().build();
		
		SessionFactory sessionfactory=md.buildSessionFactory();
		return sessionfactory;
	}

}
