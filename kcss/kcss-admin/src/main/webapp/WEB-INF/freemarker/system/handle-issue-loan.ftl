<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "handle.issue.loan"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "common.search"/></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-info"></i>
                            </span>
                            <input type="text" class="form-control" id="loanAppId" placeholder="<@spring.message "review.task.app.id"/>">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <button type="button" class="btn bg-olive margin" id="queryLoan"><@spring.message "common.search"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
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
                    <ul class="pagination pagination-sm no-margin pull-right" id="loan-table-pagination">
                    </ul>
                </div>
            </div>
            <div class="box-body table-responsive no-padding">
                <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="text-align:center">
                    <thead>
                    <tr class="table-head">
                        <th><@spring.message "lpay.adjust.loanid"/></th>
                        <th><@spring.message "report.loan.status"/></th>
                        <th><@spring.message "report.issue.id"/></th>
                        <th><@spring.message "handle.issue.status"/></th>
                        <th><@spring.message "handle.issue.date"/></th>
                        <th><@spring.message "report.issue.amount"/></th>
                        <th><@spring.message "handle.issue.exec"/></th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-loan-data">
                    </tbody>
                </table>
            </div>
            <div id="loanModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                            <h4 class="modal-title"><@spring.message "handle.issue.loan"/></h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label for="modify-loanAppId" class="col-sm-2 control-label"><@spring.message "review.task.app.id"/></label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="modify-loanAppId" placeholder="<@spring.message "review.task.app.id"/>" disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="modify-status" class="col-sm-2 control-label"><@spring.message "report.loan.status"/></label>
                                        <div class="col-sm-10">
                                            <select name="status" id="modify-status" class="form-control">
                                            <#if statusList??>
                                                <#list statusList as item>
                                                    <option value="${item.name()}">${item.name()}</option>
                                                </#list>
                                            </#if>
                                            </select>
                                        </div>
                                    </div>
                                    <#--<div class="form-group">-->
                                        <#--<label for="modify-file" class="col-sm-2 control-label"><@spring.message "fhandle.issue.certificate"/></label>-->
                                        <#--<div class="col-sm-10">-->
                                            <#--<input type="file" class="form-control" id="modify-file" placeholder="<@spring.message "handle.issue.certificate"/>">-->
                                        <#--</div>-->
                                    <#--</div>-->
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default pull-left" data-dismiss="modal"><@spring.message "common.cancel"/></button>
                            <button class="btn btn-primary" id="handleIssueLoanExec"><@spring.message "handle.issue.exec"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/handle-issue-loan.js')}"></script>
