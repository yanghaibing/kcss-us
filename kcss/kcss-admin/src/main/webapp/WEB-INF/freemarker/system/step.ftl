<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.admin.step.title"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.step.search"/></h3>
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
                                <@spring.message "system.admin.step.status"/>
                            </span>
                            <select name="status" id="step-status" class="form-control">
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
                            <button type="button" class="btn bg-olive margin" id="query-step"><@spring.message "system.admin.all.query"/></button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createStepModal"><@spring.message "system.admin.create.step"/></button>

                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title"><@spring.message "system.admin.step.list"/></h3>
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
                        <th><@spring.message "system.admin.step.id"/></th>
                        <th><@spring.message "system.admin.step.name"/></th>
                        <th><@spring.message "system.admin.step.status"/></th>
                        <th><@spring.message "system.admin.step.loantype"/></th>
                        <th><@spring.message "system.admin.step.triggerstatus"/></th>
                        <th><@spring.message "system.admin.step.approvedtargetstatus"/></th>
                        <th><@spring.message "system.admin.step.rejecttargetstatus"/></th>
                        <th><@spring.message "system.admin.step.reapplystatus"/></th>
                        <th><@spring.message "system.admin.step.runmode"/></th>
                        <th><@spring.message "system.admin.step.createtime"/></th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-admin-data">
                    </tbody>
                </table>
            </div>
        </div>


        <div class="box"  hidden id="update-admin-block">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.step.update"/></h3>
            </div>
            <div class="box-body table-responsive no-padding">
                <form id="modifyAdminInfoForm" novalidate>
                    <div class="form-group col-xs-6">
                        <label for="update-stepId"><@spring.message "system.admin.step.id"/></label>
                        <div >
                            <input type="text" disabled class="form-control" id="update-stepId" name="update-stepId">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-stepName"><@spring.message "system.admin.step.name"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-stepName" name="update-stepName">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-status"><@spring.message "system.admin.step.status"/></label>
                        <select name="update-status" id="update-status" class="form-control">
                        <#if reviewEngineStatus??>
                            <#list reviewEngineStatus as item>
                                <option  mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-loantype"><@spring.message "system.admin.step.loantype"/></label>
                        <select name="update-loanType" id="update-loanType" class="form-control">
                        <#if loanType??>
                            <#list loanType as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-triggerstatus"><@spring.message "system.admin.step.triggerstatus"/></label>
                        <select name="update-triggerstatus" id="update-triggerstatus" class="form-control">
                        <#if triggerstatus??>
                            <#list triggerstatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>

                    <div class="form-group col-xs-6">
                        <label for="update-approvedtargetstatus"><@spring.message "system.admin.step.approvedtargetstatus"/></label>
                        <select name="update-approvedtargetstatus" id="update-approvedtargetstatus" class="form-control">
                        <#if approvedtargetstatus??>
                            <#list approvedtargetstatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-rejecttargetstatus"><@spring.message "system.admin.step.rejecttargetstatus"/></label>
                        <select name="update-rejecttargetstatus" id="update-rejecttargetstatus" class="form-control">
                        <#if rejecttargetstatus??>
                            <#list rejecttargetstatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-reapplystatus"><@spring.message "system.admin.step.reapplystatus"/></label>
                        <select name="update-reapplystatus" id="update-reapplystatus" class="form-control">
                        <#if reapplystatus??>
                            <#list reapplystatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-runmode"><@spring.message "system.admin.step.runmode"/></label>
                        <select name="update-runmode" id="update-runmode" class="form-control">
                        <#if runmode??>
                            <#list runmode as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>

                    <div class="form-group col-xs-offset-9 col-xs-3">
                        <button type="button" class="btn btn-primary" id="confirm-update-step"><@spring.message "common.confirm"/></button>
                    </div>
                </form>
            </div>
        </div>


        <div id="createStepModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title"> <@spring.message "system.admin.create.step"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-6 control-label" for="create-stepName"><@spring.message "system.admin.step.name"/></label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="create-stepName" name="create-stepName">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.status"/></label>
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
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.loantype"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-loanType" id="create-loanType" class="form-control">
                                        <#if loanType??>
                                            <#list loanType as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.triggerstatus"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-triggerstatus" id="create-triggerstatus" class="form-control">
                                        <#if triggerstatus??>
                                            <#list triggerstatus as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.approvedtargetstatus"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-approvedtargetstatus" id="create-approvedtargetstatus" class="form-control">
                                        <#if approvedtargetstatus??>
                                            <#list approvedtargetstatus as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.rejecttargetstatus"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-rejecttargetstatus" id="create-rejecttargetstatus" class="form-control">
                                        <#if rejecttargetstatus??>
                                            <#list rejecttargetstatus as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.reapplystatus"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-reapplystatus" id="create-reapplystatus" class="form-control">
                                        <#if reapplystatus??>
                                            <#list reapplystatus as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.step.runmode"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-runmode" id="create-runmode" class="form-control">
                                        <#if runmode??>
                                            <#list runmode as item>
                                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
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
                        <button class="btn btn-primary" id="createStepConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/step.js')}"></script>