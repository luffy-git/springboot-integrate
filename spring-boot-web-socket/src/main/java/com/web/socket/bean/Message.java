package com.web.socket.bean;

import java.io.Serializable;

/**
 * @Description  消息
 * @Fiel com.web.socket.bean.Message
 * @Author jaood
 * @Date 2017/8/10 14:52
 * @Blog http://blog.csdn.net/jaood
 */
public class Message implements Serializable{

    /** 消息内容 */
    private String content;

    private String name;

    public String getContent(){
        return content;
    }

    public String getName(){
        return name;
    }
}
