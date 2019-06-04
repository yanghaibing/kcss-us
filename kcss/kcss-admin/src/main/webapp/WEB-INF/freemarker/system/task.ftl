<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.admin.task.title"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.task.search"/></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <#--<div class="col-md-3">-->
                        <#--<div class="input-group">-->
                            <#--<span class="input-group-addon">-->
                                <#--<i class="fa fa-phone"></i>-->
                            <#--</span>-->
                            <#--<input type="text" class="form-control" id="admin-mobile" placeholder="<@spring.message "system.admin.mobile"/>">-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="col-md-3">-->
                        <#--<div class="input-group">-->
                            <#--<span class="input-group-addon">-->
                                <#--<i class="fa fa-user"></i>-->
                            <#--</span>-->
                            <#--<input type="text" class="form-control" id="admin-name" placeholder="<@spring.message "system.admin.name"/>">-->
                        <#--</div>-->
                    <#--</div>-->
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <@spring.message "system.admin.task.status"/>
                            </span>
                            <select name="status" id="task-status" class="form-control">
                                <#if reviewEngineStatus??>
                                    <#list reviewEngineStatus as item>
                                        <option value="${item.name()}">${item.name()}</option>
                                    </#list>
                                </#if>
                            </select>
                        </div>
                    </div>
                    <#--<div class="col-md-4">-->
                        <#--<div class="input-group col-md-12">-->
                            <#--<span class="input-group-addon"><@spring.message "system.admin.register.from"/></span>-->
                            <#--<input type="text" class="datepicker form-control" data-date-format="yyyy-mm-dd" data-date-language="zh-CN" data-provide="datepicker" aria-describedby="basic-addon3"-->
                                   <#--title="registerStartTime" id="registerStartTime">-->
                            <#--<span class="input-group-addon">&nbsp;&nbsp; <@spring.message "system.admin.register.to"/> &nbsp;&nbsp;</span>-->
                            <#--<input type="text" class="datepicker form-control" data-date-format="yyyy-mm-dd" data-date-language="zh-CN" data-provide="datepicker" aria-describedby="basic-addon4"-->
                                   <#--title="registerEndTime" id="registerEndTime">-->
                        <#--</div>-->
                    <#--</div>-->
                    <div class="col-md-1">
                            <button type="button" class="btn bg-olive margin" id="query-task"><@spring.message "system.admin.all.query"/></button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createTaskModal"><@spring.message "system.admin.create.task"/></button>

                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title"><@spring.message "system.admin.task.list"/></h3>
                <div class="btn-group pagination-page-size">
                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <span id="selectedItem">10</span>
                        rows
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">10</a></li>
                        <li><a href="#">20</a></li>
                        <li><a href="#">40</a></li>
                    </ul>
                </div>
                <div class="box-tools">
                    <ul class="pagination pagination-sm no-margin pull-right" id="admin-table-pagination">
                    </ul>
                </div>
            </div>
            <div class="box-body table-responsive no-padding">
                <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="text-align:center">
                    <thead>
                    <tr class="table-head">
                        <th><@spring.message "system.admin.task.id"/></th>
                        <th><@spring.message "system.admin.task.taskname"/></th>
                        <th><@spring.message "system.admin.task.status"/></th>
                        <th><@spring.message "system.admin.task.type"/></th>
                        <th><@spring.message "system.admin.task.description"/></th>
                        <th><@spring.message "system.admin.task.createtime"/></th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-admin-data">
                    </tbody>
                </table>
            </div>
        </div>


        <div class="box"  hidden id="update-admin-block">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.task.update"/></h3>
            </div>
            <div class="box-body table-responsive no-padding">
                <form id="modifyAdminInfoForm" novalidate>
                    <div class="form-group col-xs-6">
                        <label for="update-taskId"><@spring.message "system.admin.task.id"/></label>
                        <div >
                            <input type="text" disabled class="form-control" id="update-taskId" name="update-taskId">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-taskName"><@spring.message "system.admin.task.taskname"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-taskName" name="update-taskName">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-status"><@spring.message "system.admin.task.status"/></label>
                        <select name="update-status" id="update-status" class="form-control">
                        <#if reviewEngineStatus??>
                            <#list reviewEngineStatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-type"><@spring.message "system.admin.task.type"/></label>
                        <select name="update-type" id="update-type" class="form-control">
                        <#if type??>
                            <#list type as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-description"><@spring.message "system.admin.task.description"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-description" name="update-description">
                        </div>
                    </div>

                    <div class="form-group col-xs-offset-9 col-xs-3">
                        <button type="button" class="btn btn-primary" id="confirm-update-task"><@spring.message "common.confirm"/></button>
                    </div>
                </form>
            </div>
        </div>


        <div id="createTaskModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title"> <@spring.message "system.admin.create.task"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-6 control-label" for="create-taskName"><@spring.message "system.admin.task.taskname"/></label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="create-taskName" name="create-taskName">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.task.status"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-status" id="create-status" class="form-control">
                                        <#if reviewEngineStatus??>
                                            <#list reviewEngineStatus as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.task.type"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-type" id="create-type" class="form-control">
                                        <#if type??>
                                            <#list type as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-6 control-label" for="create-description"><@spring.message "system.admin.task.description"/></label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="create-description" name="create-description">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default pull-left" data-dismiss="modal"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary" id="createTaskConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/task.js')}"></script>