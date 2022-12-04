package com.example.demo.common;

/**
 * 统一返回结果
 */
public class Result{
    private String code;
    private String msg;
    private Object data;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功状态
     */
   public static  Result success(){
        Result result = new Result();
        result.code= "0";
        result.msg= "成功";
        return result;
    }

    /**
     *成功状态，返回相关信息
     */
    public static  Result success(Object data){
        Result result = new Result();
        result.code= "0";
        result.msg= "成功";
        result.setData(data);
        return result;
    }

    /**
     *失败状态，并返回相关信息
     */
    public static  Result error(String code,String msg){
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

}
