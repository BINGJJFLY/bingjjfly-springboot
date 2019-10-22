package com.wjz.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebDataBinderController {

    @ResponseBody
    @RequestMapping("/binder")
    public Date binder(Date birth) {
        return birth;
    }

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false));
        binder.registerCustomEditor(int.class, new PropertyEditorSupport() {
            @Override
            public String getAsText() {
                return getValue().toString();
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(Integer.parseInt(text));
            }
        });
    }*/
}
