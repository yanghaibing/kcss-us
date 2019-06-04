<#include "../common/header.ftl" />
<#include "../common/loading-spinner.ftl" />
<#include "../common/main-menu.ftl" />
<link href="${ctx!}${urls.getForLookupPath('/css/app/review.css')}" rel="stylesheet">
<div class="content-wrapper">
    <section class="content-header">
        Role Management
    </section>
    <section class="content">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">search role</h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </span>
                            <input type="text" class="form-control" id="role_id" placeholder="roleId">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </span>
                            <input type="text" class="form-control" id="role_name" placeholder="role name">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">Role Status</span>
                            <select name="status" id="role_status" class="form-control">
                            <#if roleStatusList??>
                                <option></option>
                                <#list roleStatusList as item>
                                    <option value="${item.name()}">${item.name()}</option>
                                </#list>
                            </#if>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                        <button type="button" class="btn bg-olive margin" id="query-role">Search</button>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary btn-show-create-template" data-toggle="modal">Create role
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Role List</h3>
                <div class="btn-group pagination-page-size">
                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <span id="selectedItem">10</span>rows<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">10</a></li>
                        <li><a href="#">20</a></li>
                        <li><a href="#">40</a></li>
                    </ul>
                </div>
                <div class="box-tools">
                    <ul class="pagination pagination-sm no-margin pull-right" id="rolelist-table-pagination">
                    </ul>
                </div>
            </div>
            <div class="box-body table-responsive no-padding">
                <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%"
                       style="text-align:center">
                    <thead>
                    <tr class="table-head">
                        <th>Role Id</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>Description</th>
                        <th>Create Time</th>
                        <th>Update Time</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody class="table-data table-rolelist-data">
                    </tbody>
                </table>
            </div>
        </div>

        <#--创建/修改角色-->
        <div id="createRoleModal" class="modal fade" tabindex="-1" role="dialog"
             data-backdrop="static">
            <div class="modal-dialog modal-sm role-modal-dialog">
                <div class="modal-content">
                    <div class="modal-header modal-header-create">
                        <button type="button" class="close close-modal-btn" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title">Create Role</h4>
                    </div>

                    <div class="modal-header modal-header-modify">
                        <button type="button" class="close close-modal-btn" aria-label="Close">
                            <span aria-hidden="true"><@spring.message "common.close"/></span></button>
                        <h4 class="modal-title">Update Role</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="create-name"
                                   class="control-label">Role Name</label>
                            <input type="text" class="form-control"
                                   id="create-name"
                                   placeholder="Role Name">
                        </div>
                        <div class="form-group">
                            <label for="create-description"
                                   class="control-label">Description</label>
                            <input type="text" class="form-control"
                                   id="create-description"
                                   placeholder="Description"/>
                        </div>
                        <div class="form-group">
                            <label for="create-status" class="control-label">Role Status</label>
                            <select name="status" id="create-status" class="form-control">
                            <#if roleStatusList??>
                                <option></option>
                                <#list roleStatusList as item>
                                    <option value="${item.name()}">${item.name()}</option>
                                </#list>
                            </#if>
                            </select>
                        </div>
                        <#--todo Get list by call api-->
                        <div class="form-group">
                            <label for="create-type" class="control-label">Role Type</label>
                            <select name="status" id="create-type" class="form-control">
                            <#if roleTypeList??>
                                <option></option>
                                <#list roleTypeList as item>
                                    <option value="${item.name()}">${item.name()}</option>
                                </#list>
                            </#if>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="create-privilege"
                                   class="control-label">Privilege <div class="select-all-privilege-wrap"><input id="selectALLPrivilege" class="select-all-privilege-checkbox" type="checkbox" name="selectAll">select all</div></label>
                            <div class="checkbox" id="privilege-checkbox">
                                <#--<div class="checkbox-label">-->
                                    <#--<input name="privilege" type="checkbox" value="">权限1<i>description</i>-->
                                <#--</div>-->
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer modal-footer-create">
                        <button class="btn btn-default pull-left close-modal-btn"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary"
                                id="createRoleConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                    <div class="modal-footer modal-footer-modify">
                        <button class="btn btn-default pull-left close-modal-btn"><@spring.message "common.cancel"/></button>
                        <button class="btn btn-primary"
                                id="modifyRoleConfirm"><@spring.message "common.confirm"/></button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
<#include "../common/footer.ftl" />
<script src="${ctx!}${urls.getForLookupPath('/js/app/system/role-management.js')}"></script>
