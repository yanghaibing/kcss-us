require(['main-app',
    ctx + '/js/service/demo-service.js',
    ctx + '/js/common/alert-service.js',
    ctx + '/js/service/account-service.js',
    ctx + '/js/common/util-service.js'],
    function (mainApp,demoService,alertService,accountService,utilService) {
        $(function(){
            demoService.demo();
        });

        var t = null;
        var time = function(){
            clearTimeout(t);
            var dt = new Date();
            var h=dt.getHours();
            var m=dt.getMinutes();
            var s=dt.getSeconds();
            $("#clock").html("Time:"+ h +':'+m+':'+s);
            t = setTimeout(time,1000);
            if (s%5 == 0 ){
                alertService.success('alert');
            } else {
                $(".close").click();
            }
        };

        t = setTimeout(time,1000);


        $('.logout').on('click',function(){
            accountService.logout().success(function(){
                utilService.goTo('/auth/login');
            });

        });

    });