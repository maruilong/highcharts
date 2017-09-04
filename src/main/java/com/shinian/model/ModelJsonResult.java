package com.shinian.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.shinian.util.JsonBinder;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ModelJsonResult implements Serializable {

    //
    public static final int CODE_SUCCESS = 1;

    //
    public static final int CODE_ERROR = 0;

    //
    public static final int CODE_ERROR_APP_DENY = -1;

    //the attributes of the result object.
    private int code = ModelJsonResult.CODE_ERROR;

    //static Json Result
    public static final ModelJsonResult RESULT_ERROR_APP_DENY = new ModelJsonResult(CODE_ERROR_APP_DENY, 0, "Application is denied.");

    //
    private int ID = 0;
    private String desc = null;

    //
    private int messageNoticeAmount = 0;
    private int circleNoticeAmount = 0;

    //the object.
    private Object result = null;

    //
    public ModelJsonResult() {
        this(CODE_SUCCESS, 0, "success", null);
    }

    public ModelJsonResult(int code) {
        this(code, 0, null, null);
    }

    public ModelJsonResult(int code, int ID, String desc) {
        this(code, ID, desc, null);
    }

    public ModelJsonResult(int code, int ID, String desc, Object result) {
        this.code = code;

        this.ID = ID;
        this.desc = desc;

        this.result = result;

        //
    }

    //
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getMessageNoticeAmount() {
        return messageNoticeAmount;
    }

    public void setMessageNoticeAmount(int messageNoticeAmount) {
        this.messageNoticeAmount = messageNoticeAmount;
    }

    public int getCircleNoticeAmount() {
        return circleNoticeAmount;
    }

    public void setCircleNoticeAmount(int circleNoticeAmount) {
        this.circleNoticeAmount = circleNoticeAmount;
    }

    public Object getResult() {
        return result;
    }

    public <T> T getResult(Class<T> clazz) {
        if (result != null) {
            return JsonBinder.buildNonEmptyBinder().fromJson(JsonBinder.buildNonEmptyBinder().toJson(result), clazz);
        }

        return null;
    }


    public void setResult(Object result) {
        this.result = result;
    }

    //
    public static ModelJsonResult fromJson(String jsonValue) throws JsonParseException, JsonMappingException {
        return JsonBinder.buildNonEmptyBinder().fromJson(jsonValue, ModelJsonResult.class);
    }

    public String toJson() {
        return JsonBinder.buildNonNullBinder().toJson(this);
    }


}
