package controllers;

import entities.Author;
import entities.Publisher;
import services.interfaces.IPublisherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("publishers")
public class PublisherController {
    @Inject
    private IPublisherService publisherService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPublishers() {
        List<Publisher> publishers;
        try {
            publishers = publisherService.getAllPublishers();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (publishers == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No publishers was found")
                    .build();
        }

        return Response
                .ok(publishers)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getPublisherById(@PathParam("id") int id) {
        Publisher publisher;
        try {
            publisher = publisherService.getPublisherById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (publisher == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Publisher does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(publisher)
                .build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createPublisher(Publisher publisher) {
        boolean created;
        try {
            created = publisherService.create(publisher);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Publisher cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Publisher created successfully!")
                .build();
    }
}