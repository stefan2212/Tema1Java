package com.content;

public class Content implements IContent {

    private String key;
    private String value;
    private String method;
    private String header;

    @Override
    public String getMethod() {
        return method;
    }
    @Override
    public void setMethod(String method) {
        this.method = method;
    }
    @Override
    public String getHeader() {
        return header;
    }
    @Override
    public void setHeader(String header) {
        this.header = header;
    }
    @Override
    public String getKey() {
        return key;
    }
    @Override
    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String getValue() {
        return value;
    }
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.key + " " + this.value + " " + this.method + " " + this.header + "\r\n";
    }



}
