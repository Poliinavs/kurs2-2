package com.iris.glass;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.Tag;
import jakarta.servlet.jsp.tagext.TagSupport;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspTag;
@SuppressWarnings("serial")
public class Avsubmit extends TagSupport  implements Tag {
    @Override
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<input type=\"submit\" required value=\"Вход\" name=\"input\">\n" +
                    " <input type=\"submit\" required value=\"Регистрация\" name=\"registration\">");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return SKIP_BODY;
    }


    public int doEndTag() throws JspException {
        // Код для обработки закрывающего тега
        return EVAL_PAGE;
    }
}