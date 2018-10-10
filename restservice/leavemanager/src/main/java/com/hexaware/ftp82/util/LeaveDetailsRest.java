package com.hexaware.ftp82.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp82.model.LeaveDetails;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/LeaveDetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @param empId as parameter
   * @return a list of all the employees
   */
  @GET
  @Path("/pending/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsList(@PathParam("empId") final int empId) {
    System.out.println("Pending Applications List");
    final LeaveDetails[] ls = LeaveDetails.listAll(empId);
    return ls;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/history/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeeLeaveHistory(@PathParam("id") final int id) {
    final LeaveDetails[] ls1 = LeaveDetails.history(id);
    if (ls1 == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return ls1;
  }
  /**
   * Returns a specific employee's details.
   * @param eid the id of the employee
   * @param lid the id of the employee
   * @param comments the id of the employee
   * @param status the id of the employee
   * @return the employee details
   */
  @POST
  @Path("/approve/{eid}/{lid}/{comments}/{status}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String postApproveOrDeny(@PathParam("eid")final int eid, @PathParam("lid")final int lid, @PathParam("comments")final String comments, @PathParam("status")final String status) {
    LeaveDetails ls = new LeaveDetails();
    int flag = ls.applyForLeave(eid, lid, comments, status);
    switch (flag) {
      case 1:
        return "Leave approved !";
      case 100:
        return "Leave approval Denied !";
      case 102:
        return "Leave process completed !";
      default:
        return "process unsuccessful !";
    }
  }
}
