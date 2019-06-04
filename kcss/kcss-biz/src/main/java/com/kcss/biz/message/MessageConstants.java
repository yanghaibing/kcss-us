package com.kcss.biz.message;

public class MessageConstants {

    public enum MsgSender {
        ZENZIVA,
        GOSMS,
        RAJA,
        FAKE,
        NEXMO,
        TWILIO,
        UNKNOWN_YET,
        CHUANG_LAN,
        NEXELE
    }

    public enum MsgTrigger {
        REGISTER,
        REPAYMENT_REMINDER,
        DUE_DAY_REMINDER,
        OVERDUE_REMINDER,
        OVERDUE_REMINDER_1_day,
        OVERDUE_REMINDER_7_day,
        OVERDUE_REMINDER_15_day,
        OVERDUE_M1_REMINDER,
        FAKE,
        COLLECTION,
        ISSUE_SUCCEED_REMINDER,
        ISSUE_FAILED_REMINDER,
        ISSUE_FAILED_BANKCARD_ERROR_REMINDER,
        DEPOSIT_SUCCEED_REMINDER,
        REJECT,
        APPROVED,
        SUBMITTED,
        BROADCAST,
        BIND_PHONE
    }

    public enum MsgType {
        NOTIFICATION,//通知
        ALERT,//警告
        MESSAGE//信息
    }

    public enum MsgTemplate {

        WELCOME("inbox.msg.template.welcome", 0),

        LOGIN_CODE("sms.template.auth.login.code", 1),

        CUSTOMER_HOLD("sms.template.customer.hold", 1),

        LOAN_APP_SUBMIT("sms.template.loan.app.submit", 0),
        LOAN_APP_APPROVED("sms.template.loan.app.approved", 1),
        LOAN_APP_REJECTED("sms.template.loan.app.rejected", 0),
        LOAN_APP_ISSUED_FAILED("sms.template.loan.app.issue.failed", 1),
        LOAN_APP_CURRENT("sms.template.loan.app.current", 4),
        LOAN_APP_PAYOFF("sms.template.loan.app.payoff", 0),
        LOAN_APP_REPAYMENT_REMINDER("sms.template.loan.app.repayment.reminder", 2),
        LOAN_APP_DUE_DAY_REMINDER("sms.template.loan.app.due.day.reminder", 2),
        LOAN_APP_OVERDUE_REMINDER("sms.template.loan.app.overdue.reminder", 3),
        LOAN_APP_OVERDUE_REMINDER_M1("sms.template.loan.app.overdue.reminder.m1", 1);

        private String code;
        private int paramSize;

        MsgTemplate(String code, int paramSize) {
            this.code = code;
            this.paramSize = paramSize;
        }

        public String code() {
            return this.code;
        }

        public int paramSize() {
            return this.paramSize;
        }
    }

    public enum  MsgTemplateType {
        SMS,
        ;
    }

    public enum  MsgTemplateApplication {
        LOGIN_CODE,
        LOAN_APP_SUBMIT,
        LOAN_APP_APPROVED,
        LOAN_APP_REJECTED,
        LOAN_APP_ISSUE_FAILED,
        LOAN_APP_ISSUE_FAILED_BANKCARD_ERROR,
        LOAN_APP_CURRENT,
        LOAN_APP_PAYOFF,
        LOAN_APP_REPAYMENT_REMINDER,
        LOAN_APP_DUE_DAY_REMINDER,
        LOAN_APP_OVERDUE_REMINDER,
        LOAN_APP_OVERDUE_REMINDER_M1,
        CUSTOMER_HOLD,
        WELCOME,
        BIND_PHONE
        ;
    }

}
