package com.wby.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wby on 2018/3/9.
 */

/**
 * 用户Bean
 */
public class User {
    private String username;
    private String password;
    private String email;
    private String age;
    private Map<String,String> errors=null;//保存错误信息
    public User() {
        this.username="";
        this.password="";
        this.email="";
        this.age="";
        this.errors=new HashMap <String,String>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Map <String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map <String, String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", errors=" + errors +
                '}';
    }

    /**
     * 验证是否用户合法
     * @return
     */
    public boolean isValidate(){
        boolean flag=true;
        if(!this.username.matches("\\w{6,15}")){
           flag=false;
           this.username="";
           errors.put("errname","用户名是5-16的字母或者数字");
        }
        if(!this.email.matches("\\w+@\\w+\\.\\w+\\.?\\w*")){
           flag=false;
           this.email="";
           errors.put("erremail","输入的email不合法");
        }
        if(!this.age.matches("\\d+")){
            flag=false;
            this.age="";
            errors.put("errage","年龄只能是数字");
        }
        return flag;
    }

    /**
     * 打印出错误信息
     * @param key
     * @return
     */
    public String getErrorMsg(String key){
        String value=this.errors.get(key);
        return value==null?"":value;
    }
}
