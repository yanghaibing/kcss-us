requirejs.config({
    paths: {
        jquery: ctx+'/js/libs/jquery-2.2.0.min',
        bootstrap: ctx+'/js/libs/bootstrap.min',
        theme: ctx+'/js/theme/app.min',
        slimscroll: ctx+'/js/theme/jquery.slimscroll.min',
        datepicker: ctx+'/js/libs/bootstrap-datepicker.min',
        datetimepicker: ctx+'/js/libs/bootstrap-datetimepicker',
        highlight: ctx+'/js/libs/jquery.highlight',
        three: ctx+'/js/libs/three',
        canvasRenderer: ctx+'/js/libs/canvasRenderer',
        projector: ctx+'/js/libs/projector',
        summernote: ctx + '/js/libs/summernote',
        jqueryform: ctx+'/js/libs/jquery.form.min',
        zoom:ctx+'/js/libs/zoom'
    },
    shim: {
        'bootstrap': ['jquery'],
        'slimscroll':['jquery'],
        'theme': ['jquery', 'bootstrap','slimscroll'],
        'datepicker': ['jquery', 'bootstrap'],
        'datetimepicker': ['jquery', 'bootstrap'],
        'highlight': ['jquery'],
        'canvasRenderer' : ['three'],
        'projector' : ['three'],
        'summernote': ['jquery','bootstrap'],
        'jqueryform': ['jquery'],
        'zoom':['jquery','bootstrap']
    },
    waitSeconds: 0
});

define('main-app', ['jquery', 'bootstrap', 'slimscroll', 'theme', 'datepicker', 'datetimepicker', 'highlight','zoom'], function(){});
