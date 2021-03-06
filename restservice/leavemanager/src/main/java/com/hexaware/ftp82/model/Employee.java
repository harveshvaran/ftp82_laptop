package com.hexaware.ftp82.model;

import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.EmployeeDAO;
import java.util.Objects;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;

// import java.util.Properties;
// import javax.mail.Transport;
// import javax.mail.Session;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeMessage;
// import javax.mail.Message;
// import javax.mail.MessagingException;
// import javax.mail.PasswordAuthentication;
/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empPh to store employee phone number.
   * empEmail to store employee Email.
   * empDept to store employee Dept.
   * empManagerId to store employee managerid.
   * empLeaveBalance to store employee leavebalance.
   * empDoj to store employee doj.
   */
  private int empId;
  private String empName;
  private long empPh;
  private String empEmail;
  private String empDept;
  private int empManagerId;
  private int empLeaveBalance;
  private String empDoj;
  private String empImage;
  // private String empMailUser;
  // private String empMailPass;
  /**
   * Equals class to check employee details.
   * @return true or false.
   */
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empPh, emp.empPh) && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empDept, emp.empDept) && Objects.equals(empManagerId, emp.empManagerId)
        && Objects.equals(empLeaveBalance, emp.empLeaveBalance) && Objects.equals(empDoj, emp.empDoj)
        && Objects.equals(empImage, emp.empImage)
        // && Objects.equals(empMailUser, emp.empMailUser)&& Objects.equals(empMailPass, emp.empMailPass)
        ) {
      return true;
    }
    return false;
  }
  /**
   * @return empId employee id.
   * @return empName employee name.
   * @return empPh employee phone number.
   * @return empEmail employee email id.
   * @return empDept department of employee.
   * @return empManagerId employee id of the manager.
   * @return empLeaveBalance leave balance of the employee.
   * @return empDoj date of joining of the employee.
   * @return empMailUser date of joining of the employee.
   * @return empMailPass date of joining of the employee.
   */
  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empPh, empEmail, empDept, empManagerId, empLeaveBalance, empDoj, empImage);
  }
  /**
   *
   */
  public Employee() { }
  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argEmpId to initialize employee table details.
   * @param argEmpName to initialize employee table details.
   * @param argEmpPh to initialize employee table details.
   * @param argEmpEmail to initialize employee table details.
   * @param argEmpDept to initialize employee table details.
   * @param argEmpManagerId to initialize employee table details.
   * @param argEmpLeaveBalance to initialize employee table details.
   * @param argEmpDoj to initialize employee table details.
   * @param argEmpImage to initialize employee table details.
  //  * @param argEmpMailUser to initialize employee table details.
  //  * @param argEmpMailPass to initialize employee table details.
   */
  public Employee(final int argEmpId, final String argEmpName, final long argEmpPh, final String argEmpEmail, final String argEmpDept, final int argEmpManagerId, final int argEmpLeaveBalance, final Date argEmpDoj
    , final String argEmpImage) {
      // , final String argEmpMailUser, final String argEmpMailPass
      this.empId = argEmpId;
      this.empName = argEmpName;
      this.empPh = argEmpPh;
      this.empEmail = argEmpEmail;
      this.empDept = argEmpDept;
      this.empManagerId = argEmpManagerId;
      this.empLeaveBalance = argEmpLeaveBalance;
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
      String empDojj = dateFormat.format(argEmpDoj);
      this.empDoj = empDojj;
      this.empImage = argEmpImage;
      // this.empMailUser = argEmpMailUser;
      // this.empMailPass = argEmpMailPass;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
 /**
   * Gets the Employeename.
   * @return this Employee's name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   * Gets the EmployeePhoneNumber.
   * @return this Employee's PhoneNumber.
   */
  public final long getEmpPh() {
    return empPh;
  }

  /**
   *
   * @param argEmpPh to set employee PhoneNumber.
   */
  public final void setEmpPh(final long argEmpPh) {
    this.empPh = argEmpPh;
  }
  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
   * Gets the Employeedepartment.
   * @return this Employee's department.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
   *
   * @param argEmpDept to set employee department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's ManagerID.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }
  /**
   *
   * @param argEmpManagerId to set employee ManagerId.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }
  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's LeaveBalance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }
/**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final String getEmpDoj() {
    return empDoj;
  }
  /**
   *
   * @param argEmpDoj to set employee Doj.
   */
  public final void setEmpDoj(final String argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
  /**
   * Gets the EmployeeImage.
   * @return this Employee's Image.
   */
  public final String getEmpImage() {
    return empImage;
  }
  /**
   *
   * @param argEmpImage to set employee Doj.
   */
  public final void setEmpImage(final String argEmpImage) {
    this.empImage = argEmpImage;
  }
  // /**
  //  * Gets the EmployeeImage.
  //  * @return this Employee's Image.
  //  */
  // public final String getMailUser() {
  //   return empMailUser;
  // }
  // /**
  //  * Gets the EmployeeImage.
  //  * @return this Employee's Image.
  //  */
  // public final String getMailPass() {
  //   return empMailPass;
  // }
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    Employee e = dao().find(empID);
    if (e == null) {
      e = null;
      return e;
    }
    return e;
  }
   /**
   * list employee details by id.
   * @param id to get employee details.
   * @return Employee
   */
  public static Employee send(final int id) {
    return dao().check(id);
  }
  /**
   * list employee details by id.
   * @param id to get employee details.
   * @return Employee
   */
  public static int getLeaveBalance(final int id) {
    Employee e = dao().getBalance(id);
    int noOfday = 0;
    noOfday = e.getEmpLeaveBalance();
    return noOfday;
  }
  /**
   * list employee details by id.
   * @param id to get employee details.
   * @return Employee
   */
  public static String displayEmpImage(final int id) {
    Employee e = dao().getImage(id);
    return e.getEmpImage();
  }
  /*
   * @param argsEmpID to get employee details.
    public static void sendMail(final int argsFromId, final int argsToId, final String argsMessage) {
    final String from = getMailId(argsFromId);
    final String to = getMailId(argsToId);
    Employee e = dao().getCredentials(argsFromId);
    final String username = e.getMailUser();
    final String password = e.getMailPass();
    String host = "smtp.gmail.com";
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
        }
      });
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(to));
      message.setSubject("Applied for Leave!");
      message.setText(argsMessage);
      Transport.send(message);
      System.out.println("Sent message successfully....");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
  */
  /*
  /**
   * @param empId to get employee details.
   * @return dfs
  public static String getMailId(final int empId) {
    Employee e = dao().getMail(empId);
    return e.getEmpEmail();
  }
  */
}
