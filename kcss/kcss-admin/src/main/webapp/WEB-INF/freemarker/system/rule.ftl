<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.admin.rule.title"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.rule.search"/></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <@spring.message "system.admin.rule.status"/>
                            </span>
                            <select name="status" id="rule-status" class="form-control">
                                <#if reviewEngineStatus??>
                                    <#list reviewEngineStatus as item>
                                        <option value="${item.name()}">${item.name()}</option>
                                    </#list>
                                </#if>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-1">
                            <button type="button" class="btn bg-olive margin" id="query-rule"><@spring.message "system.admin.all.query"/></button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createRuleModal"><@spring.message "system.admin.create.rule"/></button>

                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title"><@spring.message "system.admin.rule.list"/></h3>
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
                        <th><@spring.message "system.admin.rule.id"/></th>
                        <th><@spring.message "system.admin.rule.rulename"/></th>
                        <th><@spring.message "system.admin.rule.status"/></th>
                        <th><@spring.message "system.admin.rule.check_method"/></th>
                        <th><@spring.message "system.admin.rule.description"/></th>
                        <th><@spring.message "system.admin.rule.createtime"/></th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-admin-data">
                    </tbody>
                </table>
            </div>
        </div>


        <div class="box"  hidden id="update-admin-block">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.rule.update"/></h3>
            </div>
            <div class="box-body table-responsive no-padding">
                <form id="modifyAdminInfoForm" novalidate>
                    <div class="form-group col-xs-6">
                        <label for="update-ruleId"><@spring.message "system.admin.rule.id"/></label>
                        <div >
                            <input type="text" disabled class="form-control" id="update-ruleId" name="update-ruleId">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-ruleName"><@spring.message "system.admin.rule.rulename"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-ruleName" name="update-ruleName">
                        </div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-check_method"><@spring.message "system.admin.rule.check_method"/></label>
                        <select name="update-check_method" id="update-check_method" class="form-control">
                        <#if check_method??>
                            <#list check_method as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>
                    <div class="form-group col-xs-6">
                        <label for="update-status"><@spring.message "system.admin.rule.status"/></label>
                        <select name="update-status" id="update-status" class="form-control">
                        <#if reviewEngineStatus??>
                            <#list reviewEngineStatus as item>
                                <option mvalue="${item.name()}" value="${msg.getMessage(item.code())}">${msg.getMessage(item.code())}</option>
                            </#list>
                        </#if>
                        </select>
                    </div>

                    <div class="form-group col-xs-6">
                        <label for="update-description"><@spring.message "system.admin.rule.description"/></label>
                        <div >
                            <input type="text" class="form-control" id="update-description" name="update-description">
                        </div>
                    </div>

                    <div class="form-group col-xs-offset-9 col-xs-3">
                        <button type="button" class="btn btn-primary" id="confirm-update-rule"><@spring.message "common.confirm"/></button>
                    </div>
                </form>
            </div>
        </div>


        <div id="createRuleModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title"> <@spring.message "system.admin.create.rule"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-6 control-label" for="create-ruleName"><@spring.message "system.admin.rule.rulename"/></label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="create-ruleName" name="create-ruleName">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.rule.status"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-status" id="create-status" class="form-control">
                                        <#if reviewEngineStatus??>
                                            <#list reviewEngineStatus as item>
                                                <option value="${item.name()}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="create-group"
                                           class="col-sm-6 control-label"><@spring.message "system.admin.rule.check_method"/></label>
                                    <div class="col-sm-6">
                                        <select name="create-check_method" id="create-check_method" class="form-control">
                                        <#if check_method??>
                                            <#list check_method as item>
                                                <option value="${item.name()}">${msg.getMessage(item.code())}</option>
                                            </#list>
                                        </#if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-6 control-label" for="create-description"><@spring.message "system.admin.rule.description"/></label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="create-description" name="create-description">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default pull-left" data-dismiss="modal"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary" id="createRuleConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/rule.js')}"></script>