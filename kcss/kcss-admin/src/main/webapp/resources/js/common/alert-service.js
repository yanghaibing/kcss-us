define(ctx + '/js/common/alert-service.js', ['main-app'], function(mainApp) {

        var AlertService = {};

        function clear () {
            $(".alert.alert-dismissable").remove();
        }

        AlertService.success = function(message) {
            clear ();
            var ele =
                '<div class="alert alert-success alert-dismissable">'+
                '<button type="button" class="close" ' +
                'data-dismiss="alert" aria-hidden="true">' +
                '&times;' +
                '</button>' +
                 message +
                '</div>';
            $('body').append(ele);
        };

        AlertService.error = function(message) {
            clear ();
            var ele =
                '<div class="alert alert-danger alert-dismissable">'+
                '<button type="button" class="close" ' +
                'data-dismiss="alert" aria-hidden="true">' +
                '&times;' +
                '</button>' +
                message +
                '</div>';
            $('body').append(ele);
        };

        AlertService.warning = function(message) {
            clear ();
            var ele =
                '<div class="alert alert-warning alert-dismissable">'+
                '<button type="button" class="close" ' +
                'data-dismiss="alert" aria-hidden="true">' +
                '&times;' +
                '</button>' +
                message +
                '</div>';
            $('body').append(ele);
        };

        return AlertService;
    }
);
