package com.hexaware.ftp82.exceptions;
import java.lang.NotFoundException;
import com.hexaware.ftp82.util.LeaveDetailsRest;
import com.hexaware.ftp82.util.EmployeeRest;

//import com.hexaware.ftp82.util.CliMain;
/**
  * Returns a specific employee's details.
  * @return the exceptions.
  */
class NotFoundException extends Exception {
/**
  * Returns a specific employee's details.
  * @param s the String variable.
  */
  NotFoundException(final String s) {
  super(s);
  }
}
