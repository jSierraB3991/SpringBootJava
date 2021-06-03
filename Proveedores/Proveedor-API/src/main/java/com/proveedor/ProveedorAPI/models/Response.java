package com.proveedor.ProveedorAPI.models;

public class Response <T> { T obj;
    
    private Boolean  _isSuccess;
    private String _message;
    private T _result;
    
    public Response()
    {
    }
    
    public Response(String msg)
    {
        this._isSuccess = false;
        this._message = msg;
        this._result = null;
    }
    
    public Response(T result, String msg)
    {
        this._isSuccess = true;
        this._message = msg;
        this._result = result;
    }

    public Boolean getIsSuccess() { return _isSuccess; }
    
    public void setIsSuccess(Boolean isSuccess) { this._isSuccess = isSuccess; }

    public String getMessage() { return _message; }
    
    public void setMessage(String message) {  this._message = message; }

    public T getResult() { return _result; }
    
    public void setRsult(T result) { this._result = result; }
}
