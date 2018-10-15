package com.hexaware.ftp82.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp82.model.LeaveDetails;
//import com.hexaware.ftp82.exceptions.NotFoundException;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/LeaveDetails")
public class LeaveDetailsRest {
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/history/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeeLeaveHistory(@PathParam("id") final int id) throws NotFoundException {
    final LeaveDetails[] ls1 = LeaveDetails.history(id);
    //if (ls1 == null) {
    //throw new NotFoundException("SORRY..There is NO such Employee ID: " + id);
    //}
    //return ls1;
  }
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
   * @param iD the id of the employee
   * @param leaveType the id of the employee
   * @param startDate the id of the employee
   * @param endDate the id of the employee
   * @param leaveReason the id of the employee
   * @return the employee details
   */
  @POST
  @Path("/applyleave/{iD}/{leaveType}/{startDate}/{endDate}/{leaveReason}")
 // @Produces(MediaType.APPLICATION_JSON)
  public final String applyLeaveRest(@PathParam("iD") final int iD, @PathParam("leaveType") final String leaveType, @PathParam("startDate") final String startDate, @PathParam("endDate") final String endDate, @PathParam("leaveReason") final String leaveReason) {
    int res = LeaveDetails.dateExpiryOfsdate(startDate);
    if (res == 0) {
      int res1 = LeaveDetails.dateExpiryOfedate(endDate, startDate);
      if (res1 == 1) {
        int status = LeaveDetails.applyLeave(iD, leaveType, startDate, endDate, leaveReason);
        if (status > 0) {
          return "inserted sucessfully";
        } else {
          return "failed during insertion try again";
        }
      } else {
        return "enter the endDate properly";
      }
    } else {
      return "enter the Start Date properly";
    }
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
  //@Produces(MediaType.APPLICATION_JSON)
  public final String postApproveOrDeny(@PathParam("eid")final int eid, @PathParam("lid")final int lid, @PathParam("comments")final String comments, @PathParam("status")final String status) {
    if (LeaveDetails.checkIds(eid, lid) == 1) {
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
    } else {
      return "Enter corresponding Employee ID and Leave ID !";
    }
  }
}
