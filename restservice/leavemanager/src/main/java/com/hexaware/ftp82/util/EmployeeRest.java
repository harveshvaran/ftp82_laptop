package com.hexaware.ftp82.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import com.hexaware.ftp82.model.Employee;
//import com.hexaware.ftp82.exceptions.NotFoundException;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
@Api("/Employees")
@SwaggerDefinition(tags={@Tag(name="Employees", description="REST Enpoint")})
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = Employee.listAll();
    return employees;
  }
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("id") final int id) throws NotFoundException {
    final Employee empl = Employee.listById(id);
    if (empl == null) {
     throw new NotFoundException("SORRY..There is NO such Employee ID: " + id);
    }
    return empl;
  }
}
