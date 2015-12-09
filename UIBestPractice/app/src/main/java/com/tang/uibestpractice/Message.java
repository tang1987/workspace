package com.tang.uibestpractice;

/**
 * Created by tangxin on 15/9/7.
 */
public class Message {
    public static int TYPE_SENT = 1;
    public static int TYPE_RECEIVED = 0;
    private String content;
    private int type;

    public Message(String content, int type){
        this.content = content;
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
