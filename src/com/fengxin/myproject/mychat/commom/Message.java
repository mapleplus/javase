package com.fengxin.myproject.mychat.commom;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author FENGXIN
 * 客户端消息类
 **/
public class Message implements Serializable, MessageType {
    
    @Serial
    private static final long serialVersionUID = 1L;
    private String sender;
    private String receiver;
    private String content;
    private String time;
    private String messageType;
    
    public String getSender () {
        return sender;
    }
    
    public void setSender (String sender) {
        this.sender = sender;
    }
    
    public String getReceiver () {
        return receiver;
    }
    
    public void setReceiver (String receiver) {
        this.receiver = receiver;
    }
    
    public String getTime () {
        return time;
    }
    
    public void setTime (String time) {
        this.time = time;
    }
    
    public String getContent () {
        return content;
    }
    
    public void setContent (String content) {
        this.content = content;
    }
    
    public String getMessageType () {
        return messageType;
    }
    
    public void setMessageType (String messageType) {
        this.messageType = messageType;
    }
    
    public Message () {
    }
    
    public Message (String sender , String receiver , String content , String time , String messageType) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.time = time;
        this.messageType = messageType;
    }
}
