package com.hexaware.ftpxx.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hexaware.ftpxx.persistence.EmployeeFactory;

import com.hexaware.ftpxx.model.Employee;

import com.hexaware.ftpxx.persistence.DbConnection;

import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class EmployeeFactoryTest {

	@Before
	public void initInput() {

	}

	@Test
	public void test(@Mocked final DbConnection db) {
		Employee[] es = EmployeeFactory.listAll();
		assertEquals(0, es.length);
	}
}

