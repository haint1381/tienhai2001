package com.furama.bo.common;

public class Validate {
    public static String REGEX_ID_KH="^KH-\\d{4}$";
    public static String REGEX_ID_DV="^DV-\\d{4}$";
    public static final String REGEX_PHONE_NUMBER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
    public static final String REGEX_EMAIL= "^(\\w{3,}@\\w+\\.\\w+)$";
    public static final String REGEX_ID_CARD = "^\\d{9}$";
    public static final String REGEX_INTEGER= "^[-]*\\d+$";
    public static final String REGEX_DOUBLE= "^[-]*\\d+([.]\\d+)?$";
    public static final String REGEX_20= "^[2-9]\\d(\\.?(\\d*))|([1-9][0-9]\\d+(\\.?(\\d*)))$";
    public static final String REGEX_ID= "^(\\d{3}-\\d{2}-\\d{2})|([A-Z]{3}-[A-Z]{2}-[A-Z]{2})$";
}
