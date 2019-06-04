define(ctx + '/js/common/util-service.js', ['main-app'], function (mainApp) {

    var UtilService = {};

    /**
     * 生成盐值
     * @param length
     */
    UtilService.generateSalt = function (length) {
        return randomStr(length);
    };

    function randomStr(length) {
        var charset = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_.';
        var result = '';
        for (var i = length; i > 0; --i) result += charset[Math.round(Math.random() * (charset.length - 1))];
        return result;
    }

    UtilService.goTo = function (url) {
        window.location.href = ctx + url;
    };

    UtilService.timeStamp2Datetime = function (time) {
        if (time == null){
            return '';
        }
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
        var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
    };

    UtilService.timeStamp2Date = function (time) {
        if (time == null){
            return '';
        }
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        return year + "-" + month + "-" + date;
    };

    UtilService.dateAdd  = function (interval, number, date) {
        switch (interval) {
            case "y": {
                date.setFullYear(date.getFullYear() + number);
                return date;
            }
            case "q": {
                date.setMonth(date.getMonth() + number * 3);
                return date;
            }
            case "m": {
                date.setMonth(date.getMonth() + number);
                return date;
            }
            case "w": {
                date.setDate(date.getDate() + number * 7);
                return date;
            }
            case "d": {
                date.setDate(date.getDate() + number);
                return date;
            }
            case "h": {
                date.setHours(date.getHours() + number);
                return date;
            }
            case "mi": {
                date.setMinutes(date.getMinutes() + number);
                return date;
            }
            case "s": {
                date.setSeconds(date.getSeconds() + number);
                return date;
            }
            default: {
                date.setDate(date.getDate() + number);
                return date;
            }
        }
    };

    UtilService.moneyFormat = function (amount, decimal) {
        decimal = decimal > 0 && decimal <= 20 ? decimal : 2;
        amount = parseFloat((amount + "").replace(/[^\d\.-]/g, "")).toFixed(decimal) + "";
        var l = amount.split(".")[0].split("").reverse(),
            r = amount.split(".")[1];
        t = "";
        for (i = 0; i < l.length; i++) {
            t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
        }
        return t.split("").reverse().join("") + "." + r;
    };

    UtilService.moneyToCny = function (n) {
        if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
            return "金额格式错误";
        var unit = "千百十亿千百十万千百十元角分", str = "";
        n += "00";
        var p = n.indexOf('.');
        if (p >= 0)
            n = n.substring(0, p) + n.substr(p + 1, 2);
        unit = unit.substr(unit.length - n.length);
        for (var i = 0; i < n.length; i++)
            str += '零一二三四五六七八九'.charAt(n.charAt(i)) + unit.charAt(i);
        return str.replace(/零(千|百|十|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|一(十)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
    };

    UtilService.formatSecond = function (key) {
        var duration;
        if(key < 60) {
            duration = key + "''";
        }else {
            var minute =  parseInt(key / 60);
            if (key / 60 > 0) {
                var second = key % 60;
                duration = minute + "'" + second + "''";
            }
        }
        return duration;
    };

    UtilService.resolveRunTimeConfig = function (val) {
        var configString = val.toString(2);
        var str = configString.split('').reverse().join('');
        var list = [];
        for(var i=0; i < str.length; i++){
            if (str[i] == '1'){
                list.push(i+':00');
            }
        }
        return list.join(',')
    };

    UtilService.getWeekDate = function (time) {
        var now = new Date(time); //当前日期
        this.nowDayOfWeek = now.getDay(); //今天本周的第几天
        return this.nowDayOfWeek==0?7:this.nowDayOfWeek; // 如果是周日，就变成周七
    };

    UtilService.calculateLastWeekDate = function (time) {
        var days = UtilService.getWeekDate(time);
        var firstDate = new Date(time);
        var lastDate = new Date(time);
        firstDate.setHours(0);
        firstDate.setMinutes(0);
        firstDate.setSeconds(0);
        firstDate.setMilliseconds(0);
        lastDate.setHours(23);
        lastDate.setMinutes(59);
        lastDate.setSeconds(59);
        lastDate.setMilliseconds(999);
        return {firstDay: UtilService.dateAdd('d', -days-6, firstDate), lastDay: UtilService.dateAdd('d', -days, lastDate)}
    };

    /**
     * 将时间转化为YYYY-MM-DD格式
     * @param date_time
     * @returns {string}
     */
    UtilService.formatDate = function (date_time) {
        if (date_time == null || date_time == undefined) {
            return "";
        }
        return date_time.slice(0, 10);
    };

    UtilService.formatDateTime = function (date_time) {
        if (date_time == null || date_time == undefined) {
            return "";
        }
        return date_time.slice(0, 19).replace('T',' ');
    };

    UtilService.formatDateTimeLong = function (date_time) {
        if (date_time == null || date_time == undefined) {
            return "";
        }
        var d = new Date(date_time);
        d.setTime(d.getTime() - d.getTimezoneOffset() * 60 * 1000);
        return d.toISOString().slice(0, 19).replace('T',' ');
    };

    UtilService.dateAdd = function (interval, number, date) {
        switch (interval) {
            case "y": {
                date.setFullYear(date.getFullYear() + number);
                return date;
            }
            case "q": {
                date.setMonth(date.getMonth() + number * 3);
                return date;
            }
            case "m": {
                date.setMonth(date.getMonth() + number);
                return date;
            }
            case "w": {
                date.setDate(date.getDate() + number * 7);
                return date;
            }
            case "d": {
                date.setDate(date.getDate() + number);
                return date;
            }
            case "h": {
                date.setHours(date.getHours() + number);
                return date;
            }
            case "mi": {
                date.setMinutes(date.getMinutes() + number);
                return date;
            }
            case "s": {
                date.setSeconds(date.getSeconds() + number);
                return date;
            }
            default: {
                date.setDate(d.getDate() + number);
                return date;
            }
        }
    }

    /**
     *
     * 格式化带占位符的字符串
     * @param string
     * @param params
     * @returns {*}
     */
    UtilService.formatPlaceholder = function (string, params) {
        if(params.length == 0 || JSON.stringify(params) == "{}") {
            string = string.replace(new RegExp("\\${[a-zA-Z]*\\}", "g"), '______');
            return string;
        }
        if(typeof(params) == 'object') {
            for(var key in params)
                if(params[key]===null || params[key]===undefined || params[key]===''){
                    string = string.replace(new RegExp("\\${" + key + "\\}", "g"), '_____');
                } else {
                    string = string.replace(new RegExp("\\${" + key + "\\}", "g"), params[key]);
                }
            return string;
        } else {
            for(var n = 0; n < params.length; n++)
                string = string.replace(new RegExp("\\${" + n + "\\}", "g"), params[n]);
            return string;
        }
    };

    UtilService.getPlaceHolder = function (string) {
        var arrayList = string.match(/\${[a-zA-Z]*}/g);
        return arrayList || [];
    };

    /**
     * 获取url参数
     * @param variable
     * @returns {*}
     */
    UtilService.getQueryVariable = function (variable) {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){return pair[1];}
        }
        return(false);
    };

    /**
     * 对比手机号
     * @param mobile1
     * @param mobile2
     * @returns {boolean}
     * @Auther
     */
    UtilService.equalsMobile = function (mobile1,mobile2) {
        return UtilService.trimMobile(mobile1) == UtilService.trimMobile(mobile2) ? true : false;
    }

    /**
     * 格式化手机号
     * @param mobile
     * @returns {Node|undefined|void|string|*}
     * @Auther
     */
    UtilService.trimMobile = function (mobile) {
        var _mobile = mobile.toString().trim().replace(/[^0-9]/g, "");

        if (_mobile.indexOf("62") == 0) {
            _mobile = _mobile.substring(2);
        }
        if (_mobile.indexOf("0") != 0) {
            _mobile = "0" + _mobile;
        }
        return _mobile;
    }
    return UtilService;
});
