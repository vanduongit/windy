package controllers;

import controllers.result.ApiResult;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import windy.framework.infrastructure.messaging.CommandBus;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.repositories.BookRepository;

import javax.inject.Inject;

public class BookController extends Controller{
    private CommandBus commandBus;
    private BookRepository bookRepository;

    @Inject
    public BookController(CommandBus commandBus, BookRepository bookRepository) {
        this.commandBus = commandBus;
        this.bookRepository = bookRepository;
    }

    public Result create(){

        Book book = Json.fromJson(request().body().asJson(),Book.class);
        CreateBookCommand createBookCommand = new CreateBookCommand(book);
        commandBus.send(createBookCommand,CreateBookCommand.class);

        ApiResult apiResult = new ApiResult();
        return ok(Json.toJson(apiResult));
    }

    public Result getAll(){
        ApiResult apiResult = new ApiResult();
        apiResult.setData(bookRepository.getAll());

        System.out.println(Json.toJson(bookRepository.getAll()));
        return ok(Json.toJson(bookRepository.getAll()));
    }
}
