package com.zqy.utils.messagehandle;

public abstract class BaseRequestMessage {
    public final String  ToUserName;
    public final String  FromUserName;
    public final long  CreateTime;
    public final String  MsgType;
    public final long  MsgId;

    public BaseRequestMessage(String ToUserName,String FromUserName,long CreateTime,String MsgType,long MsgId){
        this.ToUserName = ToUserName;
        this.FromUserName = FromUserName;
        this.CreateTime = CreateTime;
        this.MsgType = MsgType;
        this.MsgId = MsgId;
    }
}
