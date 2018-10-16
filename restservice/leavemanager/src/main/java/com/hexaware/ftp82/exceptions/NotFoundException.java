package com.hexaware.ftp82.exceptions;
 
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
@Provider
public class NotFoundException implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build(); 
    }
}
