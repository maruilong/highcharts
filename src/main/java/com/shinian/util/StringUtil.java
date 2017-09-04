/**
 * CopyRight ShellColr.com 2013.
 */

package com.shinian.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    //
    public static final String EMPTY = "";

    /**
     * The check APIs.
     */
    public static boolean isNullOrEmpty(String src) {
        return src == null || EMPTY.equals(src);
    }

    /**
     * the operating APIs.
     */
    public static String appendZeroes(String src, int length) {
        String appendStr = multiStrings("0", length) + src;

        return appendStr.substring(appendStr.length() - length);
    }

    public static String multiStrings(String src, int times) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            stringBuilder.append(src);
        }

        return stringBuilder.toString();
    }

    //
    public static String nullToEmpty(String src) {
        return src == null ? "" : src;
    }

    public static String cutStringFrontPart(String src, int length) {
        String returnValue = src;

        if (length > 0 && !isNullOrEmpty(src) && src.length() > length) {
            returnValue = src.substring(0, length);
        }

        return returnValue;
    }

    public static String cutStringEndPart(String src, int length) {
        String returnValue = src;

        if (length > 0 && !isNullOrEmpty(src) && src.length() > length) {
            returnValue = src.substring(src.length() - length);
        }

        return returnValue;
    }

    public static String escapeJsonChars(String src) {
        String returnValue = src;

        if (!StringUtil.isNullOrEmpty(src)) {
            returnValue = src.replace("\\", "\\\\").replace("'", "\'").replace("\"", "\\\"");
        }

        return returnValue;
    }

    public static boolean nullEquals(String src, String target) {
        boolean returnValue = false;

        if (src == null && target == null) {
            returnValue = true;
        } else if (src != null && target != null) {
            returnValue = src.equals(target);
        }

        return returnValue;
    }

    public static String capitalize(String src) {
        int strLen;

        return src != null && (strLen = src.length()) != 0 ? (new StringBuilder(strLen)).append(Character.toTitleCase(src.charAt(0))).append(src.substring(1)).toString() : src;
    }

    public static String uncapitalize(String src) {
        int strLen;

        return src != null && (strLen = src.length()) != 0 ? (new StringBuilder(strLen)).append(Character.toLowerCase(src.charAt(0))).append(src.substring(1)).toString() : src;
    }

    public static int getStringUnicodeNum(String targetValue) {
        int returnValue = 0;
        //
        for (int i = 0; i < targetValue.length(); i++) {
            int c = targetValue.charAt(i);

            //单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                returnValue++;
            } else {
                returnValue += 2;
            }
        }

        return returnValue;
    }

    public static boolean equals(String str1, String str2) {
        boolean returnValue = false;

        if (str1 == null) {
            returnValue = (str2 == null);
        } else {
            returnValue = str1.equals(str2);
        }

        return returnValue;
    }


    public static String subStringForUnicode(String targetValue, int number) {
        int returnValue = 0;
        int subStrValue = 0;
        //
        for (int i = 0; i < targetValue.length(); i++) {
            int c = targetValue.charAt(i);

            //单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                returnValue++;
            } else {
                returnValue += 2;
            }

            if (returnValue > number) {
                break;
            }
            subStrValue++;
        }

        return targetValue.substring(0, subStrValue);
    }

    public static List<String> subStringsForUnicode(String targetValue, int number) {
        List<String> returnValue = new ArrayList<String>();
        int subIntValue = 0;
        int subStrValue = 0;

        int lastStrValue = 0;
        //
        for (int i = 0; i < targetValue.length(); i++) {
            int c = targetValue.charAt(i);

            //单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                subIntValue++;
            } else {
                subIntValue += 2;
            }

            subStrValue++;

            if (subIntValue >= number || i == targetValue.length() - 1) {
                returnValue.add(targetValue.substring(lastStrValue, subStrValue));
                lastStrValue = subStrValue;
                subIntValue = 0;
            }
        }

        return returnValue;
    }


    public static String getFirstNotEmptyValue(String... values) {
        String returnValue = null;

        for (String value : values) {
            if (!isNullOrEmpty(value)) {
                returnValue = value;

                break;
            }
        }

        return returnValue;
    }

    public static Object castToBaseObject(String value, Class clazz) {
        Object returnValue = null;

        if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
            returnValue = Integer.valueOf(value);
        } else if (clazz.equals(Long.class) || clazz.equals(long.class)) {
            returnValue = Long.valueOf(value);
        } else if (clazz.equals(Double.class) || clazz.equals(double.class)) {
            returnValue = Double.valueOf(value);
        } else if (clazz.equals(Float.class) || clazz.equals(float.class)) {
            returnValue = Float.valueOf(value);
        } else if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
            returnValue = Boolean.valueOf(value);
        } else if (clazz.equals(String.class)) {
            returnValue = value;
        }

        return returnValue;
    }

    //
    public static String decodeHtml(String htmlText) {
        String returnValue = "";
        if (StringUtil.isNullOrEmpty(htmlText)) return returnValue;

        returnValue = htmlText.replace("&#60;", "<");
        returnValue = returnValue.replace("&#62;", ">");
        return returnValue;
    }

    public static String encodeHtml(String htmlText) {
        String returnValue = "";

        if (StringUtil.isNullOrEmpty(htmlText)) return returnValue;
        returnValue = htmlText.replace("<", "&#60;");
        returnValue = returnValue.replace(">", "&#62;");
        return returnValue;
    }

    public static boolean isInList(String src, String[] list) {
        boolean returnValue = false;

        //
        if (src != null && list != null && list.length > 0) {
            for (String value : list) {
                returnValue = value.equalsIgnoreCase(src);

                if (returnValue) {
                    break;
                }
            }
        }

        return returnValue;
    }

    //
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
