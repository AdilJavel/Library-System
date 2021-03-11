package controllers;

import entities.Book;
import services.interfaces.IBookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("books")
public class BookController {
    @Inject
    private IBookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        List<Book> books;
        try {
            books = bookService.getAllBooks();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (books == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No books was found")
                    .build();
        }

        return Response
                .ok(books)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id) {
        Book book;
        try {
            book = bookService.getBookById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (book == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Book does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(book)
                .build();
    }

    @GET
    @Path("/name/{name}")
    public Response getBookByName(@PathParam("name") String name) {
        List<Book> books;
        try {
            books = bookService.getBookByName(name);
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

    @GET
    @Path("/jenre/{jenre}")
    public Response getBookByJenre(@PathParam("jenre") String jenre) {
        List<Book> books;
        try {
            books = bookService.getBookByJenre(jenre);
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gender/{gender}")
    public Response getAllBooksByGender(@PathParam("gender")int gender) {
        List<Book> books;
        try {
            books = bookService.getAllBooksByGender(gender);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (books == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No books was found")
                    .build();
        }

        return Response
                .ok(books)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createBook(Book book) {
        boolean created;
        try {
            created = bookService.create(book);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Book cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Book created successfully!")
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/year/{year}")
    public Response getAllBooksByYear(@PathParam("year")int year) {
        List<Book> books;
        try {
            books = bookService.getAllBooksByYear(year);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (books == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No books was found")
                    .build();
        }

        return Response
                .ok(books)
                .build();
    }
    @GET
    @Path("/price/{price}")
    public Response getBookByPrice(@PathParam("price") int price) {
        List<Book> books;
        try {
            books = bookService.getBookByPrice(price);
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

    @GET
    @Path("/publisher/{publisher}")
    public Response getBookByPublisher(@PathParam("publisher") String publisher) {
        List<Book> books;
        try {
            books = bookService.getBookByPublisher(publisher);
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