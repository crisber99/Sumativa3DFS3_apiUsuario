package com.example.api_control_usuario.Exception;

public class ErrorResponse {
    private final String msg;

    public ErrorResponse(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
