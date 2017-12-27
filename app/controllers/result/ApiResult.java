package controllers.result;

import java.util.HashMap;
import java.util.Map;

public class ApiResult {
    public int status;
    public String message;
    private Map<String, Object> body;


    public ApiResult() {
        this.status = 200;
        body = new HashMap<String,Object>();
        message = "";
    }

    public void setData(Object data){
        body.put("data",data);
    }

    public Map<String, Object> getBody(){
        return this.body;
    }

}
