package com.artcreation.group.stock.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: duke
 * @Date: 2019-08-06 15:53
 */
public class ResponseObject {
    public static int ResponseCode_Success = 200;//请求
    public static int ResponseCode_NOT_FOUNDED = 102;//对象没找到
    public static int ResponseCode_PARAM_ERROR = 103;//参数格式错误
    public static int ResponseCode_DATA_FORMAT = 104;//数据类型转换错误
    public static int ResponseCode_COMMON_ERROE = 105;
    public static int ResponseCode_CHECK_ERROE = 205;
    public static int ResponseCode_AUTH_ERROR = 401;//用户验证失败
    public static int ResponseCode_SYS_ERROR= 500;//系统错误，请联系系统管理员


    private Object data;


    public static ResponseEntity success() {
        ResponseObject object = new ResponseObject(ResponseCode_Success, "success");
        return ResponseEntity.status(ResponseCode_Success).body(object);

    }

    public static ResponseEntity successNonePage() {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("list", new ArrayList<>());
        m.put("current", 0);
        m.put("pages", 0);
        m.put("size", 0);
        m.put("total", 0);
        return ResponseEntity.status(ResponseCode_Success).body(m);
    }

    public static ResponseEntity error() {
        ResponseObject object = new ResponseObject(ResponseCode_COMMON_ERROE, "默认出错信息");
        return ResponseEntity.status(ResponseCode_Success).body(object);
    }


    public static ResponseObject successWithPage(Object data, PageObject pageObject) {
        ResponseObject object = new ResponseObject(ResponseCode_Success, "success");
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("list", data);
        m.put("page", pageObject);
//        object.setData(m);
        return object;
    }

    public static ResponseEntity successWithIpage(IPage iPageObject) {
        //ResponseObject object = new ResponseObject(ResponseCode_Success, "success");
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("list", iPageObject.getRecords());
        m.put("current", iPageObject.getCurrent());
        m.put("pages", iPageObject.getPages());
        m.put("size", iPageObject.getSize());
        m.put("total", iPageObject.getTotal());
        return ResponseEntity.status(ResponseCode_Success).body(m);
    }

    public static ResponseEntity successWithIpageObject(IPage iPageObject,Object object) {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("list", object);
        m.put("current", iPageObject.getCurrent());
        m.put("pages", iPageObject.getPages());
        m.put("size", iPageObject.getSize());
        m.put("total", iPageObject.getTotal());
        return ResponseEntity.status(ResponseCode_Success).body(m);
    }

    public static ResponseEntity successIpageDate(IPage iPageObject,Object object,String key,Object value) {
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put(key,value);
        m.put("list", object);
        m.put("current", iPageObject.getCurrent());
        m.put("pages", iPageObject.getPages());
        m.put("size", iPageObject.getSize());
        m.put("total", iPageObject.getTotal());
        return ResponseEntity.status(ResponseCode_Success).body(m);
    }


    public static ResponseEntity success(Object data) {
        return ResponseEntity.status(ResponseCode_Success).body(data);
    }



    public static ResponseEntity error(int code, String message) {
        ResponseObject object = new ResponseObject(code, message);
        return ResponseEntity.status(code).body(object);

    }


    public static ResponseObject error(int code, String message, Exception e) {

        ResponseObject object = new ResponseObject(code, message);


        return object;

    }

    public static ResponseEntity success(String key, Object value) {

        ResponseObject object = new ResponseObject(ResponseCode_Success, "success");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put(key, value);
//        object.setData(data);
        return ResponseEntity.status(ResponseCode_Success).body(object);

    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseObject(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = new HashMap<String, Object>();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;
}
