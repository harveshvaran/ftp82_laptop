package com.hexaware.ftp82.model;

import com.hexaware.ftp82.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
      String sDate1 = "2018-11-09";
      Date date1 = dateFormat.parse(sDate1);
      Employee e100 = new Employee(100);
      Employee e101 = new Employee();
      Employee e102 = new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1);
      Employee e103 = new Employee();
      assertNotEquals(e100, null);
      assertNotEquals(e101, null);
      assertNotEquals(e102, null);
      assertNotEquals(e103, null);
      assertNotEquals(e103, new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1));
      assertEquals(new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1).equals(e102), true);
      assertEquals(e100.hashCode(), new Employee(100).hashCode());
      assertEquals(e101.hashCode(), new Employee().hashCode());
      assertEquals(e102.hashCode(), new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1).hashCode());
      assertNotEquals(e103.hashCode(), new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1).hashCode());
      assertNotEquals(e100, new Integer(100));
      assertNotEquals(e101, new Integer(100));
      assertNotEquals(e102, new Integer(100));
      assertNotEquals(e103, new Integer(100));
      assertEquals(e100, new Employee(100));
      assertEquals(e102, new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1));
      assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
      assertEquals(e102.getEmpId(), 100);
      assertEquals(e102.getEmpName(), "harvesh");
      assertEquals(e102.getEmpPh(), 8220645161L);
      assertEquals(e102.getEmpEmail(), "harveshvaran@gmail.com");
      assertEquals(e102.getEmpDept(), "cse");
      assertEquals(e102.getEmpManagerId(), 2000);
      assertEquals(e102.getEmpLeaveBalance(), 3);
      assertEquals(e102.getEmpDoj(), "2018-11-09");
      e103.setEmpId(100);
      e103.setEmpName("harvesh");
      e103.setEmpPh(8220645161L);
      e103.setEmpEmail("harveshvaran@gmail.com");
      e103.setEmpDept("cse");
      e103.setEmpManagerId(2000);
      e103.setEmpLeaveBalance(3);
      e103.setEmpDoj("2018-11-09");
      assertEquals(e103.getEmpId(), 100);
      assertEquals(e103.getEmpName(), "harvesh");
      assertEquals(e103.getEmpPh(), 8220645161L);
      assertEquals(e103.getEmpEmail(), "harveshvaran@gmail.com");
      assertEquals(e103.getEmpDept(), "cse");
      assertEquals(e103.getEmpManagerId(), 2000);
      assertEquals(e103.getEmpLeaveBalance(), 3);
      assertEquals(e103.getEmpDoj(), "2018-11-09");
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
<<<<<<< HEAD
  @Test
=======
  //@Test
>>>>>>> 1ae0273fcaaf9178086823d92cfce6bcdaf8857f
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        try {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
          String sDate1 = "2018-11-09";
          Date date1 = dateFormat.parse(sDate1);
          ArrayList<Employee> es = new ArrayList<Employee>();
          es.add(new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1));
          es.add(new Employee(10));
          es.add(new Employee(100));
          dao.list(); result = es;
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
      String sDate1 = "2018-11-09";
      Date date1 = dateFormat.parse(sDate1);
      Employee[] es = Employee.listAll();
      assertEquals(3, es.length);
      assertEquals(new Employee(100, "harvesh", 8220645161L, "harveshvaran@gmail.com", "cse", 2000, 3, date1), es[0]);
      assertEquals(new Employee(10), es[1]);
      assertEquals(new Employee(100), es[2]);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);
    e = Employee.listById(-1);
    assertNull(e);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testSend(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee();
    new Expectations() {
      {
        dao.check(100);
        result = e100;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.send(100);
    assertEquals(e100, e);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testGetLeaveBalance(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.getBalance(100);
        e100.setEmpLeaveBalance(3);
        result = e100;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.getLeaveBalance(100);
    int res = e.getEmpLeaveBalance();
    assertEquals(res, 3);
  }
}
