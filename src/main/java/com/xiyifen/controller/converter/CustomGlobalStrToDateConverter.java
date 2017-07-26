package com.xiyifen.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomGlobalStrToDateConverter implements Converter<String,Date> {
    public Date convert(String source) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

//        @Override
//        public Date convert(String source) {
//            try {
//                Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
//                return date;
//            } catch (ParseException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return null;
//        }

    }


