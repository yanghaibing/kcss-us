
define(ctx + '/js/common/table-service.js', ['main-app'], function (mainApp) {

    var TableService = {};

    TableService.reloadData = function (target, config, data) {
        $(target).empty();
        var content = $(target);
        if (!data || data.length === 0) {
            var row = $('<tr><td word-wrap:break-word class="no-data-row" colspan=' + config.length + '>no record</td></tr>');
            content.append(row);
        }
        else {
            for (var i = 0; i < data.length; i++) {
                var row = $('<tr></tr>');
                var item = data[i];
                for (var j = 0; j < config.length; j++) {
                    var rowData = $('<td></td>');
                    if (config[j].name) {
                        if (config[j].render) {
                            if ($.isArray(config[j].name)) {
                                var renderData = {};
                                $.each(config[j].name, function (index, value) {
                                    renderData[value] = item[value];
                                });
                                rowData.append(config[j].render(renderData, item));
                            }
                            else {
                                rowData.append(config[j].render(item[config[j].name], item));
                            }
                        }
                        else {
                            rowData.text(item[config[j].name]);
                        }
                        if (config[j].class) {
                            rowData.addClass(config[j].class);
                        }
                        if (config[j].events && config[j].events.length > 0) {
                            $.each(config[j].events, function (index, value) {
                                rowData.find(value.target).on(value.name, value.action);
                            });
                        }
                    }
                    row.append(rowData);
                }
                content.append(row);
            }
        }
    };
    TableService.loadReportData = function (target, data) {
        $(target).empty();
        var content = $(target);
        if (!data || data.length === 0 || data == '[]') {
            var row = $('<tr><td word-wrap:break-word class="no-data-row">no record</td></tr>');
            content.append(row);
        } else {
            for (var i = 0; i < data.length; i++) {
                var row = $('<tr></tr>');
                var item = data[i];
                $.each(item, function (key, values) {
                    var rowData = $('<td class="text-center"></td>');
                    rowData.text(values);
                    row.append(rowData);
                });
                content.append(row);
            }
        }
    };
    TableService.loadReportHeader = function (target, data) {
        $(target).empty();
        var tr = $(target);
        if (!data || data.length === 0) {
            //TODO
        } else {
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                var row = $('<th class="text-center"></th>');
                row.text(item);
                tr.append(row);
            }
        }
    };

    TableService.createPagination = function (target, config, index, length, cb) {
        $(target).empty();
        var content = $(target);
        if (length > 0) {
            var low, high, nextDot, preDot;
            low = (index > 1) ? (index - 1) : 1;
            // preDot = (low > 1) ? true : false;
            preDot = index > 1;
            if (length <= config.size) {
                high = index;
                nextDot = false;
            } else if (length == config.size * config.window) {
                high = index + config.window - 1;
                nextDot = true;
            } else {
                high = index + Math.ceil(length / config.size) - 1;
                nextDot = false;
            }
            if (preDot) {
                var dot = $('<li page-number="' + (index - 1) + '"><a href="#">«</a></li>');
                dot.addClass('pre-item');
                dot.click(function (event) {
                    event.preventDefault();
                    var selectPage = parseInt($(this).attr('page-number'));
                    cb(selectPage);
                });
                content.append(dot);
            } else {
                var dot = $('<li page-number="' + (index - 1) + '"><a href="javascript:void(0)">«</a></li>');
                dot.addClass('pre-item disabled');
                // dot.click(function (event) {
                //     event.preventDefault();
                //     var selectPage = parseInt($(this).attr('page-number'));
                //     cb(selectPage);
                // });
                content.append(dot);
            }
            for (var i = low; i <= high; i++) {
                var item = $('<li page-number="' + i + '"><a href="#">' + i + '</a></li>');
                item.addClass('number-item');
                if (i == index) {
                    item.addClass('active');
                }
                item.click(function (event) {
                    event.preventDefault();
                    var selectPage = parseInt($(this).attr('page-number'));
                    cb(selectPage);
                });
                content.append(item);
            }
            if (nextDot) {
                var dot = $('<li page-number="' + (high + 1) + '"><a href="#">»</a></li>');
                dot.addClass('next-item');
                dot.click(function (event) {
                    event.preventDefault();
                    var selectPage = parseInt($(this).attr('page-number'));
                    cb(selectPage);
                });
                content.append(dot);
            } else {
                var dot = $('<li page-number="' + (high + 1) + '"><a href="javascript:void(0)">»</a></li>');
                dot.addClass('next-item disabled');
                // dot.click(function (event) {
                //     event.preventDefault();
                //     var selectPage = parseInt($(this).attr('page-number'));
                //     cb(selectPage);
                // });
                content.append(dot);
            }
            content.append('<input type="text" style="width:40px" id="inputT" />');
            var aa = $('<a href="javascript:void(0)">go</a>');
            aa.click(function (event) {
                event.preventDefault();
                var selectPage = parseInt($('#inputT').val());
                cb(selectPage);
            });
            content.append(aa);
        }
    };

    jQuery.fn.removeAttributes = function () {
        return this.each(function () {
            var attributes = $.map(this.attributes, function (item) {
                return item.name;
            });
            var img = $(this);
            $.each(attributes, function (i, item) {
                img.removeAttr(item);
            });
        });
    };


    TableService.handleHtmlTableText = function (htmlText) {
        var object = $($.parseHTML(htmlText)[5]);
        object.removeAttributes();
        object.find('tr:lt(1), tr:lt(2), tr:last-child').remove();
        object.find("td:first-child").remove();
        object.find('tr').removeAttributes();
        object.find('td').removeAttributes();
        object.find('span').removeAttributes();
        object.addClass('table table-striped table-bordered table-hover');
        object.attr({
            cellspacing: "0"
        });
        object.find("tr:first-child").addClass('table-header');
        return object;
    };


    return TableService;

});
