package controllers;

import controllers.result.ApiResult;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import windy.framework.infrastructure.eventsource.EventStorage;

import javax.inject.Inject;

public class EventStorageController extends Controller{

    @Inject
    private EventStorage eventStorage;

    public Result list(){
        ApiResult apiResult = new ApiResult();
        apiResult.setData(eventStorage.getMapEvents());
        return ok(Json.toJson(apiResult));
    }
}
