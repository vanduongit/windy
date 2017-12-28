package controllers;

import controllers.result.ApiResult;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import windy.framework.infrastructure.messaging.CommandBus;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.contracts.commands.book.DeleteBookCommand;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
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
        book.setPublishedDate(System.currentTimeMillis());
        book.setCreatedAt(System.currentTimeMillis());
        CreateBookCommand createBookCommand = new CreateBookCommand(book);
        commandBus.send(createBookCommand,CreateBookCommand.class);

        ApiResult apiResult = new ApiResult();
        return ok(Json.toJson(apiResult));
    }

    public Result getAll(){
        ApiResult apiResult = new ApiResult();
        apiResult.setData(bookRepository.getAll());
        return ok(Json.toJson(bookRepository.getAll()));
    }

    public Result get(String uuid){
        Book book = bookRepository.getById(uuid);
        ApiResult apiResult = new ApiResult();
        apiResult.setData(book);
        return ok(Json.toJson(apiResult));
    }

    public Result update(){
        Book book = Json.fromJson(request().body().asJson(),Book.class);
        ApiResult apiResult = new ApiResult();
        UpdateBookCommand updateBookCommand = new UpdateBookCommand(book);
        commandBus.send(updateBookCommand,UpdateBookCommand.class);
        return ok(Json.toJson(apiResult));
    }

    public Result delete(String uuid){
        ApiResult apiResult = new ApiResult();
        DeleteBookCommand deleteBookCommand = new DeleteBookCommand(uuid);
        commandBus.send(deleteBookCommand,DeleteBookCommand.class);
        return ok(Json.toJson(apiResult));
    }


}
