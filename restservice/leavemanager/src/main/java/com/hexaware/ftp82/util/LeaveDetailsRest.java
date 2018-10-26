package com.hexaware.ftp82.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
//import javax.ws.rs.NotFoundException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import com.hexaware.ftp82.model.LeaveDetails;
//import com.hexaware.ftp82.exceptions.NotFoundException;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/LeaveDetails")
@Api("/LeaveDetails")
@SwaggerDefinition(tags={@Tag(name="LeaveDetails", description="REST Enpoint")})
public class LeaveDetailsRest {
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   * @throws NotFoundException
   */
  @GET
  @Path("/history/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeeLeaveHistory(@PathParam("id") final int id)  {
    final LeaveDetails[] ls1 = LeaveDetails.history(id);
    if (ls1 == null) {
      throw new NotFoundException("SORRY..There is NO such Employee ID: " + id);
    }
    return ls1;
  }
  /**
   * Returns a list of all the employees.
   * @param empId as parameter
   * @return a list of all the employees.
   * @throws NotAuthorizedException
   */
  @GET
  @Path("/pending/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsList(@PathParam("empId") final int empId)  {
    System.out.println("Pending Applications List");
    final LeaveDetails[] ls = LeaveDetails.listAll(empId);
    if (ls == null) {
      throw new NotAuthorizedException("No such Employee ID: " + empId);
    }
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
  @Produces(MediaType.TEXT_PLAIN)
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
  @Produces(MediaType.TEXT_PLAIN)
  public final String postApproveOrDeny(@PathParam("eid")final int eid, @PathParam("lid")final int lid, @PathParam("comments")final String comments, @PathParam("status")final String status) {
    if (LeaveDetails.checkIds(eid, lid) == 0) {
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
  /**
   * Returns a specific employee's details.
   * @param iD the id of the employee
   * @param leaveType the id of the employee
   * @param startDate the id of the employee
   * @param endDate the id of the employee
   * @param leaveReason the id of the employee
    * @param leaveId the id of the employee
   * @return the employee details
   */
  @PUT
  @Path("/updateleave/{iD}/{leaveType}/{startDate}/{endDate}/{leaveReason}/{leaveId}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String updateLeaveRest(@PathParam("iD") final int iD, @PathParam("leaveType") final String leaveType, @PathParam("startDate") final String startDate, @PathParam("endDate") final String endDate, @PathParam("leaveReason") final String leaveReason, @PathParam("leaveId") final int leaveId) {
    int res = LeaveDetails.dateExpiryOfsdate(startDate);
    if (res == 0) {
      int res1 = LeaveDetails.dateExpiryOfedate(endDate, startDate);
      if (res1 == 1) {
        int status = LeaveDetails.editLeave(iD, leaveType, startDate, endDate, leaveReason, leaveId);
        if (status > 0) {
          return "updated sucessfully";
        } else {
          return "failed during updation try again";
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
   * @param lId the id of the employee
   * @param empId the id of the employee
   * @return the status
   */
  @DELETE
  @Path("/delete/{lId}/{empId}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String deleteLeaveRest(@PathParam("lId") final int lId, @PathParam("empId") final int empId) {
    int res1 = LeaveDetails.removeLeaveRequest(lId, empId);
    if (res1 > 0) {
      return "leave request deleted";
    } else {
      return "error occured during deletion";
    }
  }
  /**
   * Returns a specific employee's details.
   * @param eid the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/reedit/{eid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] reeditPermission(@PathParam("eid") final int eid) {
    LeaveDetails[] leave = LeaveDetails.listAl(eid);
    if (leave == null) {
      throw new NotFoundException("SORRY..There are no records..!!");
    }
    return leave;
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
  @Path("/reedit/re/{eid}/{lid}/{comments}/{status}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String reEditing(@PathParam("eid")final int eid, @PathParam("lid")final int lid, @PathParam("comments")final String comments, @PathParam("status")final String status) {
    int editStatus = LeaveDetails.editPermis(eid, lid, comments, status);
    switch (editStatus) {
      case 1:
        return "Leave has been Re-Edited";
      case -1:
        return "Enter correct Status to update !";
      default:
        return "Re-Editing is not processed enter valid id!";
    }
  }
}
