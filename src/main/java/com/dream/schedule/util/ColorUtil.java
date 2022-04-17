package com.dream.schedule.util;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class ColorUtil {

    private static Map<Byte, Boolean> colorMap;

    private ColorUtil(){

    }

    @PostConstruct
    public void init(){
        colorMap = new HashMap<>();
        colorMap.put((byte)1, false);
    }

    public static Byte getColor(){
        return (byte) 1;
    }

    public static String getColor(Byte code){
        return "";
    }

}
