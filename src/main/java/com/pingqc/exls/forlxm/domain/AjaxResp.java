package com.pingqc.exls.forlxm.domain;

/**
 * Created by pingqc on 16/4/5.
 */
public class AjaxResp {

    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";

    private String result = SUCCESS;
    private int code;
    private String msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
