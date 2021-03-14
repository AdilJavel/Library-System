package controllers;

import entities.Author;
import entities.Book;
import services.interfaces.IAuthorService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("authors")
public class AuthorController {
    @Inject
    private IAuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuthors() {
        List<Author> authors;
        try {
            authors = authorService.getAllAuthors();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (authors == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No authors was found")
                    .build();
        }

        return Response
                .ok(authors)
                .build();
    }


    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        Author author;
        try {
            author = authorService.getAuthorById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (author == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Author does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(author)
                .build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createAuthor(Author author) {
        boolean created;
        try {
            created = authorService.create(author);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Author cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Author created successfully!")
                .build();
    }

    @GET
    @Path("/books/{name}")
    public Response getAuthorBook(@PathParam("name") String name) {
        List<Book> books;
        try {
            books = authorService.getAuthorBook(name);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (books == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Book does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(books)
                .build();
    }
}