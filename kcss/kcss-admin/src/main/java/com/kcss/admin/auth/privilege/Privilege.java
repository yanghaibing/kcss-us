package com.kcss.admin.auth.privilege;

import com.kcss.core.util.jackson.I18NEnum;

public enum Privilege implements I18NEnum {
// customer 5
    VIEW_CUSTOMER("enum.privilege.customer.management.tab"),
    VIEW_CUSTOMER_MGT("enum.privilege.all.customers.info"),
    VIEW_CUSTOMER_SMS("enum.privilege.all.customers.sms"),
    CUSTOMER_CONTACT("enum.privilege.view.contact.detail"),
    MODIFY_CUSTOMER_MGT("enum.privilege.update.customer.info"),

    //finance 4
    FINANCE_MANAGEMENT("enum.privilege.finance.management"),
    FINANCE_DEPOSITS("enum.privilege.finance.deposits"),
    FINANCE_LOAN_ISSUES("enum.privilege.finance.loan.issues"),
    FINANCE_BALANCE("enum.privilege.finance.balance"),

    // application 12
    VIEW_REVIEW("enum.privilege.application.management.tab"),
    VIEW_REVIEW_CASES("enum.privilege.all.review.cases"),
    VIEW_REVIEW_TASKS("enum.privilege.all.review.tasks"),
    VIEW_REVIEW_DETAIL("enum.privilege.review.detail"),
    REVIEW_CASE_ASSIGN("enum.privilege.case.assignment"),
    FIRST_REVIEW("enum.privilege.first.review"),
    SECOND_REVIEW("enum.privilege.second.review"),
    FINAL_REVIEW("enum.privilege.final.review"),
    VIEW_REVIEW_TASK_ASSIGNED("enum.privilege.my.review.task"),
    MODIFY_REVIEW_TASK("enum.privilege.process.review.task"),
    FORCE_APPROVE_REVIEW("enum.privilege.review.first.final.force.approve"),
    APPROVAL_CONCLUSION("enum.privilege.review.approval.conclusion"),


    // collection 4
    VIEW_COLLECTION("enum.privilege.view.collection"),
    COLLECTION_CASE_ASSIGN("enum.privilege.collection.case.assign"),
    COLLECTION_CASE_ASSIGNED("enum.privilege.my.collection.case.assigned"),
    COLLECTION_CASE("enum.privilege.all.collection.case"),

// report 4
    VIEW_REPORT("enum.privilege.system.report.tab"),
    FINANCE_REPORT("enum.privilege.finance.report"),
    OPERATION_REPORT("enum.privilege.operation.report"),
    RISK_REPORT("enum.privilege.risk.report"),

// system admin 11
    VIEW_SYSTEM_MGT("enum.privilege.system.admin.management.tab"),
    SYSTEM_ADMIN("enum.privilege.system.admin.management"),
    SYSTEM_ROLE("enum.privilege.system.role.management"),
    SYSTEM_BLACKLIST("enum.privilege.system.blacklist.management"),
    SYSTEM_SETTING("enum.privilege.system.setting.management"),
    SYSTEM_AMOUNT_CONTROL("enum.privilege.system.amount.control.management"),
    SYSTEM_STEP("enum.privilege.system.step.management"),
    SYSTEM_TASK("enum.privilege.system.task.management"),
    DEFAULT_INTEREST("enum.privilege.system.default.interest.management"),
    HANDLE_ISSUE_LOAN("enum.privilege.system.handle.issue.loan.management"),
    CONTRACT_TEMPLATE("enum.privilege.system.contract.template"),

    VIEW_SYSTEM_GROUP("enum.privilege.system.group.management"),
    OPERATE_SYSTEM_ADMIN("enum.privilege.system.operate.admin.info");
    //setting

//    private String label;
//
//    Privilege(String label) {
//        this.label = label;
//    }
//
//    public String label() {
//        return label;
//    }
    private String code;

    Privilege(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

}
