package com.kcss.core.util.regularexpression;

import org.springframework.util.StringUtils;

/**
 * @author X
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 正在表达式
 * @date 2018/4/26 16:08
 */
public class RegExp {

    public static boolean emailCheck(String email){
        if(StringUtils.isEmpty(email)){
            return  false;
        }else{
            return email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+[\\\\.][a-zA-Z0-9_-]+$");
        }
    }



    //去除非数字字母字符
    public static String cleanNotNumberAndLetter(String str){
        if(!StringUtils.isEmpty(str)){
            return str.replaceAll("[^A-Za-z0-9]", "");
        }else {
            return "";
        }
    }

    //判断两个字符串相同？(不区分大小写)
    public static boolean checkTwoString(String str1,String str2){
        if(str1!=null&&str2!=null){
            return str1.equalsIgnoreCase(str2);
        }
        return false;
    }

    //格式化手机号去除非数字字符并以0开头
    public static String trimMobile(String mobile) {
        if(StringUtils.isEmpty(mobile)){
            return "";
        }
        String _mobile = cleanNotNumber(mobile);
        if (_mobile.startsWith("62")) {
            _mobile = _mobile.replaceFirst("62", "");
        }
        if (!_mobile.startsWith("0")) {
            _mobile = "0" + _mobile;
        }
        return _mobile;
    }
    //去除非数字字符
    public static String cleanNotNumber(String str){
        if(!StringUtils.isEmpty(str)){
            return str.replaceAll("[^0-9]", "");
        }else {
            return "";
        }
    }

    //去除非数字字符
    public static String formatDistance(String str){
        if(!StringUtils.isEmpty(str)){
            return str.replaceAll(",", ".").replaceAll("[^0-9.]", "");
        }else {
            return "0";
        }
    }
}
