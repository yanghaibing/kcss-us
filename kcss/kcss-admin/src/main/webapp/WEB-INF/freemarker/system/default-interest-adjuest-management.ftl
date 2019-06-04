<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.default.interest.adjuest"/></h1>
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.default.interest.adjuest.search"/></h3>
            </div>
            <div class="box-body">
                <div class="col-md-3">
                    <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-phone">Mobile</i>
                            </span>
                        <input type="text" class="form-control" id="mobile-input" >
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="input-group">
                            <span class="input-group-addon">
                            <@spring.message "system.default.interest.adjuest.loanappid"/>
                            </span>
                        <input type="text" class="form-control" id="loanAppId-input" />
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="input-group">
                        <button type="button" class="btn bg-olive margin" id="query-button"><@spring.message "common.search"/></button>
                    </div>
                </div>

            </div>
        </div>

        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Query Result<#--<@spring.message "customer.customer.list"/>--></h3>
                <#--<div class="btn-group pagination-page-size">-->
                    <#--<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">-->
                        <#--<span id="selectedItem">10</span>-->
                        <#--rows-->
                        <#--<span class="caret"></span>-->
                    <#--</button>-->
                    <#--<ul class="dropdown-menu" role="menu">-->
                        <#--<li><a href="#">10</a></li>-->
                        <#--<li><a href="#">20</a></li>-->
                        <#--<li><a href="#">40</a></li>-->
                    <#--</ul>-->
                <#--</div>-->
                <#--<div class="box-tools">-->
                    <#--<ul class="pagination pagination-sm no-margin pull-right" id="customer-table-pagination">-->
                    <#--</ul>-->
                <#--</div>-->
            </div>

            <div class="box-body table-responsive no-padding">
                <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="text-align:center">
                    <thead>
                    <tr class="table-head">
                        <th><@spring.message "lpay.adjust.loanid"/></th>
                        <th><@spring.message "lpay.adjust.mobile"/></th>
                        <th><@spring.message "lpay.adjust.dueDate"/></th>
                        <th><@spring.message "lpay.adjust.total.topay"/></th>
                        <th><@spring.message "lpay.adjust.principal.topay"/></th>
                        <th><@spring.message "lpay.adjust.interest.topay"/></th>
                        <th><@spring.message "lpay.adjust.serviceFee.topay"/></th>
                        <th><@spring.message "lpay.adjust.default.topay"/></th>
                        <th><@spring.message "lpay.adjust.interest"/></th>
                        <th><@spring.message "lpay.adjust.adjust.amount"/>
                        <th><@spring.message "lpay.adjust.adjust.discharge"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-customer-data">
                    </tbody>
                </table>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/lpay-adjust-amount-management.js')}"></script>