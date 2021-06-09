package com.wust.spring.boot.standard.demo.constant.page;

public class StringUtils extends org.springframework.util.StringUtils {

    public static boolean notEmpty(String str) {
        return (str != null && !"" .equals(str));
    }

    public static String camelCaseToSnakeCase(String str) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return str.replaceAll(regex, replacement).toLowerCase();
    }
}
