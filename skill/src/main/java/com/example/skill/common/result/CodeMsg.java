package com.example.skill.common.result;

/**
 * @description:封装错误码以及错误信息
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 11:04
 **/
public class CodeMsg {

    private String innerCode;
    private String message;

    public String getInnerCode() {
        return innerCode;
    }

    public String getMessage() {
        return message;
    }

    private CodeMsg(String innerCode, String message) {
        this.innerCode = innerCode;
        this.message = message;
    }

    public static CodeMsg SUCCESS = new CodeMsg("0", "success");
    public static CodeMsg ERROR = new CodeMsg("500", "server error");

    public static CodeMsg INSERT_USER_FAIL = new CodeMsg("1001", "insert user failed");
    public static CodeMsg DELETE_USER_FAIL = new CodeMsg("1002", "delete user failed");
    public static CodeMsg QUERY_SINGLE_USER_FAIL = new CodeMsg("1003", "query single user failed");
    public static CodeMsg QUERY_USER_LIST_FAIL = new CodeMsg("1004", "query user list failed");
    public static CodeMsg UPDATE_USER_FAIL = new CodeMsg("1005", "update user failed");
}
