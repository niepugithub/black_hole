package com.example.skill.common.result;

/**
 * @description:封装返回结果
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 11:03
 **/
public class AjaxResult {

    private String innerCode;
    private String message;
    private Object data;
    private long total;

    // 成功，不返回数据
    public static AjaxResult SUCCESS() {
        return new AjaxResult();
    }

    // 成功，返回无分页数据
    public static AjaxResult SUCCESS(Object data) {
        return new AjaxResult(data);
    }

    // 成功，返回有分页数据
    public static AjaxResult SUCCESS(Object data, long total) {
        return new AjaxResult(data, total);
    }

    //失败，返回返回码和错误提示信息
    public static AjaxResult ERROR(CodeMsg codeMsg) {
        return new AjaxResult(codeMsg);
    }

    // 出现异常时候，返回的结果
    public static AjaxResult ERROR(String message) {
        return new AjaxResult(message);
    }

    private AjaxResult() {
        this.innerCode = CodeMsg.SUCCESS.getInnerCode();
        this.message = CodeMsg.SUCCESS.getMessage();
    }

    private AjaxResult(Object data) {
        this();
        this.data = data;
    }

    private AjaxResult(Object data, long total) {
        this(data);
        this.total = total;
    }

    private AjaxResult(CodeMsg codeMsg) {
        if (null == codeMsg) {
            return;
        }
        this.innerCode = codeMsg.getInnerCode();
        this.message = codeMsg.getMessage();
    }

    private AjaxResult(String message) {
        this.innerCode = "exception";
        this.message = message;
    }


    public String getInnerCode() {
        return innerCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }
}
