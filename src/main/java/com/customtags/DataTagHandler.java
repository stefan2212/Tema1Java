package com.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class DataTagHandler  extends SimpleTagSupport {
    private String record;

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.print(record);

    }

}
