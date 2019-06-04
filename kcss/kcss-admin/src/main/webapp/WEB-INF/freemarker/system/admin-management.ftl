<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.admin.management.title"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.management.search"/></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-phone"></i>
                            </span>
                            <input type="text" class="form-control" id="admin-mobile" placeholder="<@spring.message "system.admin.mobile"/>">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </span>
                            <input type="text" class="form-control" id="admin-name" placeholder="<@spring.message "system.admin.name"/>">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <@spring.message "system.admin.status"/>
                            </span>
                            <select name="status" id="admin-status" class="form-control">
                                <#if adminStatusList??>
                                    <#list adminStatusList as item>
                                        <option value="${item.name()}">${item.name()}</option>
                                    </#list>
                                </#if>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="input-group col-md-12">
                            <span class="input-group-addon"><@spring.message "system.admin.register.from"/></span>
                            <input type="text" class="datepicker form-control" data-date-format="yyyy-mm-dd" data-date-language="zh-CN" data-provide="datepicker" aria-describedby="basic-addon3"
                                   title="registerStartTime" id="registerStartTime">
                            <span class="input-group-addon">&nbsp;&nbsp; <@spring.message "system.admin.register.to"/> &nbsp;&nbsp;</span>
                            <input type="text" class="datepicker form-control" data-date-format="yyyy-mm-dd" data-date-language="zh-CN" data-provide="datepicker" aria-describedby="basic-addon4"
                                   title="registerEndTime" id="registerEndTime">
                        </div>
                    </div>
                    <div class="col-md-1">
                            <button type="button" class="btn bg-olive margin" id="query-admin"><@spring.message "system.admin.all.query"/></button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createAdminModal"><@spring.message "system.admin.create.admin"/></button>

                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title"><@spring.message "system.admin.list"/></h3>
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
                        <th><@spring.message "system.admin.id"/></th>
                        <th><@spring.message "system.admin.mobile"/></th>
                        <th><@spring.message "system.admin.name"/></th>
                        <th><@spring.message "system.admin.status"/></th>
                        <th><@spring.message "system.admin.register.time"/></th>
                        <th><@spring.message "system.admin.group.id"/></th>
                        <th><@spring.message "system.admin.role.id.list"/></th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-admin-data">
                    </tbody>
                </table>
            </div>
        </div>

        <div class="box"  hidden id="update-admin-block">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.management.search"/></h3>
            </div>
            <div class="box-body table-responsive no-padding">
                <form id="modifyAdminInfoForm" novalidate>
                    <div class="form-group col-xs-6">
                        <label for="update-adminId"><@spring.message "system.admin.id"/></label>
                        <div >
                            <input type="text" disabled class="form-control" id="update-adminId" name="update-adminId">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-mobile"><@spring.message "system.admin.mobile"/></label>
                        <div >
                            <input type="text" disabled class="form-control" id="update-mobile" name="update-mobile">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-name"><@spring.message "system.admin.name"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-name" name="update-name">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-status"><@spring.message "system.admin.status"/></label>
                        <select name="update-status" id="update-status" class="form-control">
                            <#if adminStatusList??>
                                <#list adminStatusList as item>
                                    <option value="${item.name()}">${msg.getMessage(item.code())}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-group"><@spring.message "system.admin.group"/></label>
                        <select name="update-group" id="update-group" class="form-control">
                        <#if groupList??>
                            <#list groupList as item>
                                <option value="${item.getId()?c}">${item.getName()}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-role"><@spring.message "system.admin.role"/></label>
                        <select name="update-role" id="update-role" class="form-control select2" multiple="multiple">
                        <#if roleList??>
                            <#list roleList as item>
                                <option value="${item.getId()?c}">${item.getName()}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>

                    <div class="form-group col-xs-offset-9 col-xs-3">
                        <button type="button" class="btn btn-primary" id="confirm-update-admin"><@spring.message "common.confirm"/></button>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#resetPasswordModal"><@spring.message "system.admin.reset.password"/></button>
                    </div>
                </form>
            </div>
        </div>

        <div id="resetPasswordModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title"> <@spring.message "system.admin.reset.password"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label for="modify-force-approve-comments"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.new.password"/></label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control"
                                               id="modify-new-password"
                                               placeholder="<@spring.message "system.admin.new.password"/>">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default pull-left" data-dismiss="modal"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary" id="resetPasswordConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

        <div id="createAdminModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title"> <@spring.message "system.admin.create.admin"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label for="create-mobile"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.mobile"/></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control"
                                               id="create-mobile"
                                               placeholder="<@spring.message "system.admin.mobile"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-name"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.name"/></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control"
                                               id="create-name"
                                               placeholder="<@spring.message "system.admin.name"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-password"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.password"/></label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control"
                                               id="create-password"
                                               placeholder="<@spring.message "system.admin.password"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.group"/></label>
                                    <div class="col-sm-10">
                                        <select name="create-group" id="create-group" class="form-control">
                                            <option value=""></option>
                                        <#if groupList??>
                                            <#list groupList as item>
                                                <option value="${item.getId()?c}">${item.getName()}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-role"
                                           class="col-sm-2 control-label"><@spring.message "system.admin.role"/></label>
                                    <div class="col-sm-10">
                                        <select name="create-role" id="create-role" class="form-control">
                                            <option value=""></option>
                                        <#if roleList??>
                                            <#list roleList as item>
                                                <option value="${item.getId()?c}">${item.getName()}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default pull-left" data-dismiss="modal"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary" id="createAdminConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/admin-management.js')}"></script>