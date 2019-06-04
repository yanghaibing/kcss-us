package com.kcss.core.util.common;

public class MobileUtil {






    public static String trimMobile(String mobile) {
        String _mobile = mobile.trim().replace("+", "");
        _mobile = _mobile.replace(" ", "");
        _mobile = _mobile.replace("-", "");
        if (_mobile.startsWith("628")) {
            _mobile = _mobile.replaceFirst("62", "0");
        }else if (_mobile.startsWith("62")) {
            _mobile = _mobile.replaceFirst("62", "08");
        }else if (!_mobile.startsWith("08")) {
            _mobile = "08" + _mobile;
        }
        return _mobile;
    }

    public static String countryMobile(String mobile) {
        String _mobile = mobile.trim().replace("+", "");
        if (_mobile.startsWith("0")) {
            _mobile = _mobile.replaceFirst("0", "62");
        }
        return _mobile;
    }

    public static boolean isStartWith62(String mobile){
        String _mobile = mobile.trim().replace("+", "");
        if (_mobile.startsWith("62")) {
            return true;
        }
        return false;
    }

    public static boolean checkMobile(String mobile,String support){
        String[] sp = support.trim().split(",");
        String _mobile = mobile.trim().replace("+", "");
        for(String vo: sp) {
            if (_mobile.startsWith(vo.trim())) {
                return true;
            }
        }
        return false;
    }
}
