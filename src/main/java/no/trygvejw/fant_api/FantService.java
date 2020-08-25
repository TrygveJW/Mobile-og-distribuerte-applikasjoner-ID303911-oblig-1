package no.trygvejw.fant_api;

import no.trygvejw.fant_api.jpa.User;
import no.trygvejw.fant_api.jpa.Users;

import javax.inject.Inject;
import javax.management.Notification;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
public class FantService  {

    @Inject
    Users users;

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(users.getUserById((long)id))
                .build();
    }

    @POST
    @Path("/post/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addElmnt(@PathParam("id") int id) {
        User usr = new User(id);
        users.addUser(usr);
        return Response.ok()
                .entity(new Notification("test notification", "john", id))
                .build();
    }


}
