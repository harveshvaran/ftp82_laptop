package com.hexaware.ftp82.exceptions;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
//import java.lang.Object.getMessage();
/**
 * This class provides a exception interface for the employee entity.
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
  @Override
  public final Response toResponse(final NotFoundException exception) {
    System.out.println("Custom Exception " + exception.getMessage());
    return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
  }
}
