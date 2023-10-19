package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.GenericActionFailedException;
import org.kainos.ea.client.InvalidEmployeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Runtime Terrors API")
@Path("/api")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeService();

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(employeeService.getAllEmployees())
                    .build();
        } catch (GenericActionFailedException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/employees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(@PathParam("id") int id, EmployeeRequest employee) {
        try{
            employeeService.updateEmployee(id, employee);

            return Response.ok().build();
        } catch (InvalidEmployeeException | EmployeeDoesNotExistException e ) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
