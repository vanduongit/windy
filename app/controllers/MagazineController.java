package controllers;

import controllers.result.ApiResult;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import windy.framework.core.messaging.ICommandBus;
import windy.framework.infrastructure.messaging.CommandBus;

import windy.infrastructure.contracts.commands.magazine.DeleteMagazineCommand;
import windy.infrastructure.domains.Magazine;
import windy.infrastructure.repositories.MagazineRepository;

import javax.inject.Inject;

public class MagazineController extends Controller{

    private ICommandBus commandBus;
    private MagazineRepository magazineRepository;

    @Inject
    public MagazineController(CommandBus commandBus, MagazineRepository magazineRepository) {
        this.commandBus = commandBus;
        this.magazineRepository = magazineRepository;
    }

    public Result create(){

        Magazine Magazine = Json.fromJson(request().body().asJson(),Magazine.class);
        //CreateMagazineCommand createMagazineCommand = new CreateMagazineCommand(Magazine);
        //commandBus.send(createMagazineCommand,CreateMagazineCommand.class);
        ApiResult apiResult = new ApiResult();
        return ok(Json.toJson(apiResult));
    }

    public Result getAll(){
        ApiResult apiResult = new ApiResult();
        apiResult.setData(magazineRepository.getAll());
        return ok(Json.toJson(magazineRepository.getAll()));
    }

    public Result get(String uuid){
        Magazine magazine = magazineRepository.getById(uuid);
        ApiResult apiResult = new ApiResult();
        apiResult.setData(magazine);
        return ok(Json.toJson(apiResult));
    }

    public Result update(){
        Magazine magazine = Json.fromJson(request().body().asJson(),Magazine.class);
        ApiResult apiResult = new ApiResult();
        //UpdateMagazineCommand updateMagazineCommand = new UpdateMagazineCommand(magazine);
        //commandBus.send(updateMagazineCommand,UpdateMagazineCommand.class);
        return ok(Json.toJson(apiResult));
    }

    public Result delete(String uuid){
        ApiResult apiResult = new ApiResult();
        DeleteMagazineCommand deleteMagazineCommand = new DeleteMagazineCommand(uuid);
        commandBus.send(deleteMagazineCommand);
        return ok(Json.toJson(apiResult));
    }

}
