<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<div class="content-wrapper">
    <section class="content-header">
        <h1><@spring.message "system.admin.management.title"/></h1>
    </section>

    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title"><@spring.message "system.admin.management.amount.control.management"/></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                               Total Amount
                            </span>
                            <input id="total-amount-input" type="text" class="form-control" value="${amountControl.totalAmount}">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                               Used Amount
                            </span>
                            <input type="text" disabled class="form-control" value="${amountControl.usedAmount}">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                               Control Type
                            </span>
                            <input type="text" disabled class="form-control" value="${amountControl.controlType}">
                        </div>
                    </div>

                    <div class="col-md-1">
                        <button type="button" class="btn bg-olive margin" id="modify"><@spring.message "common.modify"/></button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>


<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/amount-control-management.js')}"></script>