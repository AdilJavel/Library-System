package controllers;

import entities.Author;
import entities.Book;
import entities.User;
import services.interfaces.IUserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
public class UserController {
    @Inject
    private IUserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> users;
        try {
            users = userService.getAllUsers();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (users == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No users was found")
                    .build();
        }

        return Response
                .ok(users.toString())
                .build();
    }


    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {
        User user;
        try {
            user = userService.getUserById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (user == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(user.toString())
                .build();
    }
    @GET
    @Path("favs/{id}")
    public Response getUserByIdWithBooks(@PathParam("id") int id) {
        User user;
        try {
            user = userService.getUserByIdWithBooks(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (user == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(user.withFavs())
                .build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createUser(User user) {
        boolean created;
        try {
            created = userService.create(user);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("User cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("User created successfully!")
                .build();
    }

    @GET
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeUserByID(@PathParam("id") int id) {
        boolean deleted;
        try {
            deleted = userService.removeUserById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (deleted == false) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User does not exist")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(deleted ? "User was Removed" : "User deletion been failed.")
                .build();
    }

    @GET
    @Path("/samefavs/{id}")
    public Response getUsersWithSame(@PathParam("id") int id) {
        List<User> users;
        try {
            users = userService.getUsersWithSame(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (users == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Users does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(users.toString())
                .build();
    }
}