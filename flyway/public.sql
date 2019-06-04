/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : PostgreSQL
 Source Server Version : 100005
 Source Host           : localhost:5432
 Source Catalog        : cjt
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100005
 File Encoding         : 65001

 Date: 04/06/2019 14:45:13
*/


-- ----------------------------
-- Sequence structure for t_admin_audit_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_admin_audit_id_seq";
CREATE SEQUENCE "public"."t_admin_audit_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_admin_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_admin_id_seq";
CREATE SEQUENCE "public"."t_admin_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_app_push_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_app_push_id_seq";
CREATE SEQUENCE "public"."t_app_push_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_catalogue_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_catalogue_id_seq";
CREATE SEQUENCE "public"."t_catalogue_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_catalogue_test_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_catalogue_test_id_seq";
CREATE SEQUENCE "public"."t_catalogue_test_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_college_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_college_id_seq";
CREATE SEQUENCE "public"."t_college_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_college_picture_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_college_picture_id_seq";
CREATE SEQUENCE "public"."t_college_picture_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_file_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_file_id_seq";
CREATE SEQUENCE "public"."t_file_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_group_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_group_id_seq";
CREATE SEQUENCE "public"."t_group_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_info_kind_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_info_kind_id_seq";
CREATE SEQUENCE "public"."t_info_kind_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_info_type_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_info_type_id_seq";
CREATE SEQUENCE "public"."t_info_type_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_information_file_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_information_file_id_seq";
CREATE SEQUENCE "public"."t_information_file_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_information_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_information_id_seq";
CREATE SEQUENCE "public"."t_information_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_job_metric_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_job_metric_id_seq";
CREATE SEQUENCE "public"."t_job_metric_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_lesson_assess_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_lesson_assess_id_seq";
CREATE SEQUENCE "public"."t_lesson_assess_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_lesson_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_lesson_id_seq";
CREATE SEQUENCE "public"."t_lesson_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_lesson_section_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_lesson_section_id_seq";
CREATE SEQUENCE "public"."t_lesson_section_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_lesson_tag_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_lesson_tag_id_seq";
CREATE SEQUENCE "public"."t_lesson_tag_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_meet_lesson_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_meet_lesson_id_seq";
CREATE SEQUENCE "public"."t_meet_lesson_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_message_template_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_message_template_id_seq";
CREATE SEQUENCE "public"."t_message_template_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_privilege_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_privilege_id_seq";
CREATE SEQUENCE "public"."t_privilege_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_questions_and_answers_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_questions_and_answers_id_seq";
CREATE SEQUENCE "public"."t_questions_and_answers_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_questions_and_answers_like_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_questions_and_answers_like_id_seq";
CREATE SEQUENCE "public"."t_questions_and_answers_like_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_role_id_seq";
CREATE SEQUENCE "public"."t_role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_setting_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_setting_id_seq";
CREATE SEQUENCE "public"."t_setting_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sms_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sms_id_seq";
CREATE SEQUENCE "public"."t_sms_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_student_like_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_student_like_id_seq";
CREATE SEQUENCE "public"."t_student_like_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_student_message_inbox_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_student_message_inbox_id_seq";
CREATE SEQUENCE "public"."t_student_message_inbox_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_student_teacher_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_student_teacher_id_seq";
CREATE SEQUENCE "public"."t_student_teacher_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_study_group_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_study_group_id_seq";
CREATE SEQUENCE "public"."t_study_group_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_study_group_student_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_study_group_student_id_seq";
CREATE SEQUENCE "public"."t_study_group_student_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_suggest_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_suggest_id_seq";
CREATE SEQUENCE "public"."t_suggest_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_token_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_token_id_seq";
CREATE SEQUENCE "public"."t_token_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_admin";
CREATE TABLE "public"."t_admin" (
  "id" int8 NOT NULL DEFAULT nextval('t_admin_id_seq'::regclass),
  "mobile" varchar(32) COLLATE "pg_catalog"."default",
  "password" varchar(256) COLLATE "pg_catalog"."default",
  "full_name" varchar(32) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "failed_login_count" int4,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_admin"."id" IS '管理员';
COMMENT ON COLUMN "public"."t_admin"."mobile" IS '手机号';
COMMENT ON COLUMN "public"."t_admin"."password" IS '密码';
COMMENT ON COLUMN "public"."t_admin"."full_name" IS '全名';
COMMENT ON COLUMN "public"."t_admin"."type" IS '类别';
COMMENT ON COLUMN "public"."t_admin"."status" IS '状态';
COMMENT ON COLUMN "public"."t_admin"."failed_login_count" IS '错误登录次数';
COMMENT ON COLUMN "public"."t_admin"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_admin"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_admin" IS '管理员';

-- ----------------------------
-- Table structure for t_admin_audit
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_admin_audit";
CREATE TABLE "public"."t_admin_audit" (
  "id" int8 NOT NULL DEFAULT nextval('t_admin_audit_id_seq'::regclass),
  "admin_id" int8,
  "access_mode" varchar(32) COLLATE "pg_catalog"."default",
  "topic" varchar(32) COLLATE "pg_catalog"."default",
  "subject" varchar(32) COLLATE "pg_catalog"."default",
  "param_l" text COLLATE "pg_catalog"."default",
  "param_h" text COLLATE "pg_catalog"."default",
  "comment" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_admin_audit"."id" IS '编号';
COMMENT ON COLUMN "public"."t_admin_audit"."admin_id" IS '管理员编号';
COMMENT ON COLUMN "public"."t_admin_audit"."access_mode" IS '操作方式(PRIVATE:私有的/PUBLIC:共有的)';
COMMENT ON COLUMN "public"."t_admin_audit"."topic" IS '主题';
COMMENT ON COLUMN "public"."t_admin_audit"."subject" IS '操作类目(INSERT:插入/UPTIMESTAMPTZ:修改/QUERY:查询)';
COMMENT ON COLUMN "public"."t_admin_audit"."param_l" IS '参数_I';
COMMENT ON COLUMN "public"."t_admin_audit"."param_h" IS '参数_h';
COMMENT ON COLUMN "public"."t_admin_audit"."comment" IS '描述';
COMMENT ON COLUMN "public"."t_admin_audit"."create_time" IS '创建时间';
COMMENT ON TABLE "public"."t_admin_audit" IS '管理员操作记录';

-- ----------------------------
-- Table structure for t_admin_group_rel
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_admin_group_rel";
CREATE TABLE "public"."t_admin_group_rel" (
  "admin_id" int8,
  "group_id" int8
)
;
COMMENT ON COLUMN "public"."t_admin_group_rel"."admin_id" IS '管理员编号';
COMMENT ON COLUMN "public"."t_admin_group_rel"."group_id" IS '组编号';
COMMENT ON TABLE "public"."t_admin_group_rel" IS '管理员组关联';

-- ----------------------------
-- Table structure for t_admin_role_rel
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_admin_role_rel";
CREATE TABLE "public"."t_admin_role_rel" (
  "admin_id" int8,
  "role_id" int8
)
;
COMMENT ON COLUMN "public"."t_admin_role_rel"."admin_id" IS '管理员编号';
COMMENT ON COLUMN "public"."t_admin_role_rel"."role_id" IS '角色编号';
COMMENT ON TABLE "public"."t_admin_role_rel" IS '管理员角色关联';

-- ----------------------------
-- Table structure for t_app_push
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_app_push";
CREATE TABLE "public"."t_app_push" (
  "id" int8 NOT NULL DEFAULT nextval('t_app_push_id_seq'::regclass),
  "push_to" varchar(32) COLLATE "pg_catalog"."default",
  "push_trigger" varchar(64) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "title" varchar(64) COLLATE "pg_catalog"."default",
  "body" varchar(512) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_app_push"."id" IS '编号';
COMMENT ON COLUMN "public"."t_app_push"."push_to" IS '接收对象';
COMMENT ON COLUMN "public"."t_app_push"."push_trigger" IS '推送触发器';
COMMENT ON COLUMN "public"."t_app_push"."type" IS '推送类型(MESSAGE:消息/NOTIFICATION:通知)';
COMMENT ON COLUMN "public"."t_app_push"."title" IS '标题';
COMMENT ON COLUMN "public"."t_app_push"."body" IS '主体';
COMMENT ON COLUMN "public"."t_app_push"."status" IS '状态(NEW:新建/PUSH_FAILED:推送失败/PUSHED:已推送)';
COMMENT ON COLUMN "public"."t_app_push"."create_time" IS '创建时间';
COMMENT ON TABLE "public"."t_app_push" IS 'app推送记录';

-- ----------------------------
-- Table structure for t_catalogue
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_catalogue";
CREATE TABLE "public"."t_catalogue" (
  "id" int8 NOT NULL DEFAULT nextval('t_catalogue_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "suggest_learn_time" varchar(64) COLLATE "pg_catalog"."default",
  "lesson_id" int8,
  "sort" int4,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_catalogue"."id" IS '编号';
COMMENT ON COLUMN "public"."t_catalogue"."name" IS '名称';
COMMENT ON COLUMN "public"."t_catalogue"."suggest_learn_time" IS '建议学习时长';
COMMENT ON COLUMN "public"."t_catalogue"."lesson_id" IS '课程编号';
COMMENT ON COLUMN "public"."t_catalogue"."sort" IS '排序';
COMMENT ON COLUMN "public"."t_catalogue"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_catalogue"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_catalogue" IS '课程章节';

-- ----------------------------
-- Table structure for t_catalogue_test
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_catalogue_test";
CREATE TABLE "public"."t_catalogue_test" (
  "id" int8 NOT NULL DEFAULT nextval('t_catalogue_test_id_seq'::regclass),
  "name" varchar(32) COLLATE "pg_catalog"."default",
  "catalogue_id" int8,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_catalogue_test"."id" IS '编号';
COMMENT ON COLUMN "public"."t_catalogue_test"."name" IS '名称';
COMMENT ON COLUMN "public"."t_catalogue_test"."catalogue_id" IS '章节编号';
COMMENT ON COLUMN "public"."t_catalogue_test"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_catalogue_test"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_catalogue_test" IS '章节测试';

-- ----------------------------
-- Table structure for t_college
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_college";
CREATE TABLE "public"."t_college" (
  "id" int8 NOT NULL DEFAULT nextval('t_college_id_seq'::regclass),
  "name" varchar(512) COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "url" varchar(512) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_college"."id" IS '编号';
COMMENT ON COLUMN "public"."t_college"."name" IS '名称';
COMMENT ON COLUMN "public"."t_college"."description" IS '描述';
COMMENT ON COLUMN "public"."t_college"."url" IS '官网';
COMMENT ON COLUMN "public"."t_college"."type" IS '类型企业或院校';
COMMENT ON COLUMN "public"."t_college"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_college"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_college" IS '学院\企业';

-- ----------------------------
-- Table structure for t_college_picture
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_college_picture";
CREATE TABLE "public"."t_college_picture" (
  "id" int8 NOT NULL DEFAULT nextval('t_college_picture_id_seq'::regclass),
  "college_id" varchar(512) COLLATE "pg_catalog"."default",
  "background_img_url" varchar(512) COLLATE "pg_catalog"."default",
  "logo_img_url" varchar(512) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_college_picture"."college_id" IS '学院编号';
COMMENT ON TABLE "public"."t_college_picture" IS '背景LOGO';

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_file";
CREATE TABLE "public"."t_file" (
  "id" int8 NOT NULL DEFAULT nextval('t_file_id_seq'::regclass),
  "file_type" varchar(32) COLLATE "pg_catalog"."default",
  "file_kind" varchar(128) COLLATE "pg_catalog"."default",
  "path" varchar(256) COLLATE "pg_catalog"."default",
  "metadata" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now(),
  "upload_id" int8,
  "upload_type" varchar(32) COLLATE "pg_catalog"."default",
  "name" varchar(256) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_file"."id" IS '编号';
COMMENT ON COLUMN "public"."t_file"."file_type" IS '文件类型';
COMMENT ON COLUMN "public"."t_file"."file_kind" IS '文件性质(mime)';
COMMENT ON COLUMN "public"."t_file"."path" IS '文件路径';
COMMENT ON COLUMN "public"."t_file"."metadata" IS '元数据';
COMMENT ON COLUMN "public"."t_file"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_file"."update_time" IS '修改时间';
COMMENT ON COLUMN "public"."t_file"."upload_id" IS '上传者编号';
COMMENT ON COLUMN "public"."t_file"."upload_type" IS '上传者类型';
COMMENT ON COLUMN "public"."t_file"."name" IS '文件名称';
COMMENT ON TABLE "public"."t_file" IS '文件';

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_group";
CREATE TABLE "public"."t_group" (
  "id" int8 NOT NULL DEFAULT nextval('t_group_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "description" varchar(512) COLLATE "pg_catalog"."default",
  "parent_id" int8,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_group"."id" IS '编号';
COMMENT ON COLUMN "public"."t_group"."name" IS '组名';
COMMENT ON COLUMN "public"."t_group"."type" IS '分组类型 ADMIN';
COMMENT ON COLUMN "public"."t_group"."status" IS '状态：ACTIVE / INACTIVE';
COMMENT ON COLUMN "public"."t_group"."description" IS '描述';
COMMENT ON COLUMN "public"."t_group"."parent_id" IS '父组编号';
COMMENT ON COLUMN "public"."t_group"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_group"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_group" IS '组';

-- ----------------------------
-- Table structure for t_info_kind
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_info_kind";
CREATE TABLE "public"."t_info_kind" (
  "id" int8 NOT NULL DEFAULT nextval('t_info_kind_id_seq'::regclass),
  "info_type_id" int8,
  "name" varchar(512) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_info_kind"."id" IS '编号';
COMMENT ON COLUMN "public"."t_info_kind"."info_type_id" IS '咨询类别编号';
COMMENT ON COLUMN "public"."t_info_kind"."name" IS '咨询类目名';
COMMENT ON COLUMN "public"."t_info_kind"."type" IS '类别(////)';
COMMENT ON COLUMN "public"."t_info_kind"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_info_kind"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_info_kind" IS '资讯类目';

-- ----------------------------
-- Table structure for t_info_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_info_type";
CREATE TABLE "public"."t_info_type" (
  "id" int8 NOT NULL DEFAULT nextval('t_info_type_id_seq'::regclass),
  "name" varchar(512) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_info_type"."id" IS '编号';
COMMENT ON COLUMN "public"."t_info_type"."name" IS '资讯类名';
COMMENT ON COLUMN "public"."t_info_type"."type" IS '类别(SCHOOL/COMPANY)';
COMMENT ON COLUMN "public"."t_info_type"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_info_type"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_info_type" IS '咨询类别';

-- ----------------------------
-- Table structure for t_information
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_information";
CREATE TABLE "public"."t_information" (
  "id" int8 NOT NULL DEFAULT nextval('t_information_id_seq'::regclass),
  "title" varchar(256) COLLATE "pg_catalog"."default",
  "sub_title" varchar(256) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "roundup" varchar(512) COLLATE "pg_catalog"."default",
  "source_from" varchar(512) COLLATE "pg_catalog"."default",
  "author" varchar(64) COLLATE "pg_catalog"."default",
  "info_auth" varchar(32) COLLATE "pg_catalog"."default",
  "jump_url" varchar(512) COLLATE "pg_catalog"."default",
  "published_time" varchar(32) COLLATE "pg_catalog"."default",
  "sort" int4,
  "publish_admin_id" int8,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "click_num" int4,
  "show_type" varchar(32) COLLATE "pg_catalog"."default",
  "media_type" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_information"."id" IS '编号';
COMMENT ON COLUMN "public"."t_information"."title" IS '标题';
COMMENT ON COLUMN "public"."t_information"."sub_title" IS '子标题:专题';
COMMENT ON COLUMN "public"."t_information"."content" IS '内容';
COMMENT ON COLUMN "public"."t_information"."roundup" IS '摘要';
COMMENT ON COLUMN "public"."t_information"."source_from" IS '资讯来源';
COMMENT ON COLUMN "public"."t_information"."author" IS '作者';
COMMENT ON COLUMN "public"."t_information"."info_auth" IS '资讯权限';
COMMENT ON COLUMN "public"."t_information"."jump_url" IS '跳转地址';
COMMENT ON COLUMN "public"."t_information"."published_time" IS '原文发布时间';
COMMENT ON COLUMN "public"."t_information"."sort" IS '排序';
COMMENT ON COLUMN "public"."t_information"."publish_admin_id" IS '发布者编号';
COMMENT ON COLUMN "public"."t_information"."status" IS '状态ACTIVE / INACTIVE';
COMMENT ON COLUMN "public"."t_information"."click_num" IS '浏览数';
COMMENT ON COLUMN "public"."t_information"."show_type" IS '资讯app列表页模版形式：SHOW_LEFT,SHOW_RIGHT,SHOW_TOP,SHOW_DOWN';
COMMENT ON COLUMN "public"."t_information"."media_type" IS '多媒体类型';
COMMENT ON COLUMN "public"."t_information"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_information"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_information" IS '资讯';

-- ----------------------------
-- Table structure for t_information_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_information_file";
CREATE TABLE "public"."t_information_file" (
  "id" int8 NOT NULL DEFAULT nextval('t_information_file_id_seq'::regclass),
  "info_id" int8,
  "file_id" varchar(1) COLLATE "pg_catalog"."default",
  "file_type" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_information_file"."id" IS '编号';
COMMENT ON COLUMN "public"."t_information_file"."info_id" IS '资讯编号';
COMMENT ON COLUMN "public"."t_information_file"."file_id" IS '文件编号';
COMMENT ON COLUMN "public"."t_information_file"."file_type" IS '文件类型';
COMMENT ON COLUMN "public"."t_information_file"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_information_file"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_information_file" IS '资讯文件关联';

-- ----------------------------
-- Table structure for t_job_metric
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_job_metric";
CREATE TABLE "public"."t_job_metric" (
  "id" int8 NOT NULL DEFAULT nextval('t_job_metric_id_seq'::regclass),
  "job_name" varchar(256) COLLATE "pg_catalog"."default" NOT NULL,
  "uuid" int8,
  "duration" int8,
  "start_time" timestamptz(6),
  "end_time" timestamptz(6),
  "status" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "message" text COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_job_metric"."id" IS 'job执行记录ID';
COMMENT ON COLUMN "public"."t_job_metric"."job_name" IS 'job名称';
COMMENT ON COLUMN "public"."t_job_metric"."uuid" IS 'UUID';
COMMENT ON COLUMN "public"."t_job_metric"."duration" IS '持续时间';
COMMENT ON COLUMN "public"."t_job_metric"."start_time" IS '开始时间';
COMMENT ON COLUMN "public"."t_job_metric"."end_time" IS '结束时间';
COMMENT ON COLUMN "public"."t_job_metric"."status" IS '状态(SUCCESS:成功)';
COMMENT ON COLUMN "public"."t_job_metric"."message" IS '消息';

-- ----------------------------
-- Table structure for t_lesson
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_lesson";
CREATE TABLE "public"."t_lesson" (
  "id" int8 NOT NULL DEFAULT nextval('t_lesson_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "start_learn_time" timestamptz(6),
  "end_learn_time" timestamptz(6),
  "credit" float8,
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "teacher_id" int8,
  "intro" text COLLATE "pg_catalog"."default",
  "background" text COLLATE "pg_catalog"."default",
  "target" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now(),
  "status" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_lesson"."id" IS '编号';
COMMENT ON COLUMN "public"."t_lesson"."name" IS '课程名';
COMMENT ON COLUMN "public"."t_lesson"."start_learn_time" IS '课程开始学习时间';
COMMENT ON COLUMN "public"."t_lesson"."end_learn_time" IS '课程结束学习时间';
COMMENT ON COLUMN "public"."t_lesson"."credit" IS '学分';
COMMENT ON COLUMN "public"."t_lesson"."type" IS '课程性质';
COMMENT ON COLUMN "public"."t_lesson"."teacher_id" IS '授课老师编号';
COMMENT ON COLUMN "public"."t_lesson"."intro" IS '简介';
COMMENT ON COLUMN "public"."t_lesson"."background" IS '课程背景';
COMMENT ON COLUMN "public"."t_lesson"."target" IS '课程目标';
COMMENT ON COLUMN "public"."t_lesson"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_lesson"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_lesson"."status" IS '是否启用';
COMMENT ON TABLE "public"."t_lesson" IS '课程';

-- ----------------------------
-- Table structure for t_lesson_assess
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_lesson_assess";
CREATE TABLE "public"."t_lesson_assess" (
  "id" int8 NOT NULL DEFAULT nextval('t_lesson_assess_id_seq'::regclass),
  "lesson_id" int8,
  "name" varchar(64) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "rule" text COLLATE "pg_catalog"."default",
  "point" int4,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_lesson_assess"."id" IS '编号';
COMMENT ON COLUMN "public"."t_lesson_assess"."lesson_id" IS '课程编号';
COMMENT ON COLUMN "public"."t_lesson_assess"."name" IS '名称';
COMMENT ON COLUMN "public"."t_lesson_assess"."type" IS '类目(ALL\PIECE)';
COMMENT ON COLUMN "public"."t_lesson_assess"."rule" IS '规则详情';
COMMENT ON COLUMN "public"."t_lesson_assess"."point" IS '分数';
COMMENT ON COLUMN "public"."t_lesson_assess"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_lesson_assess"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_lesson_assess" IS '考核标准';

-- ----------------------------
-- Table structure for t_lesson_section
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_lesson_section";
CREATE TABLE "public"."t_lesson_section" (
  "id" int8 NOT NULL DEFAULT nextval('t_lesson_section_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "duration" varchar(32) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "sort" int4,
  "url" varchar(512) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_lesson_section"."id" IS '编号';
COMMENT ON COLUMN "public"."t_lesson_section"."name" IS '名称';
COMMENT ON COLUMN "public"."t_lesson_section"."duration" IS '时长';
COMMENT ON COLUMN "public"."t_lesson_section"."type" IS '类型(资料\视频\活动\直播\音频)';
COMMENT ON COLUMN "public"."t_lesson_section"."sort" IS '排序';
COMMENT ON COLUMN "public"."t_lesson_section"."url" IS '资源URL';
COMMENT ON COLUMN "public"."t_lesson_section"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_lesson_section"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_lesson_section" IS '课时';

-- ----------------------------
-- Table structure for t_lesson_tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_lesson_tag";
CREATE TABLE "public"."t_lesson_tag" (
  "id" int8 NOT NULL DEFAULT nextval('t_lesson_tag_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now(),
  "lesson_id" int8
)
;
COMMENT ON COLUMN "public"."t_lesson_tag"."id" IS '编号';
COMMENT ON COLUMN "public"."t_lesson_tag"."name" IS '名称';
COMMENT ON COLUMN "public"."t_lesson_tag"."description" IS '描述';
COMMENT ON COLUMN "public"."t_lesson_tag"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_lesson_tag"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_lesson_tag" IS '课程标签';

-- ----------------------------
-- Table structure for t_meet_lesson
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_meet_lesson";
CREATE TABLE "public"."t_meet_lesson" (
  "id" int8 NOT NULL DEFAULT nextval('t_meet_lesson_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "url" varchar(512) COLLATE "pg_catalog"."default",
  "lesson_id" int8,
  "start_time" timestamptz(6),
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "credit" float8,
  "teach_body" text COLLATE "pg_catalog"."default",
  "teach_target" text COLLATE "pg_catalog"."default",
  "teach_flow" text COLLATE "pg_catalog"."default",
  "teach_duty" text COLLATE "pg_catalog"."default",
  "grade_rule" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_meet_lesson"."id" IS '编号';
COMMENT ON COLUMN "public"."t_meet_lesson"."name" IS '名称';
COMMENT ON COLUMN "public"."t_meet_lesson"."url" IS '资源url';
COMMENT ON COLUMN "public"."t_meet_lesson"."lesson_id" IS '课程编号';
COMMENT ON COLUMN "public"."t_meet_lesson"."start_time" IS '开始时间';
COMMENT ON COLUMN "public"."t_meet_lesson"."status" IS '状态';
COMMENT ON COLUMN "public"."t_meet_lesson"."credit" IS '学分';
COMMENT ON COLUMN "public"."t_meet_lesson"."teach_body" IS '教学内容';
COMMENT ON COLUMN "public"."t_meet_lesson"."teach_target" IS '教学目标';
COMMENT ON COLUMN "public"."t_meet_lesson"."teach_flow" IS '教学流程';
COMMENT ON COLUMN "public"."t_meet_lesson"."teach_duty" IS '教学职责';
COMMENT ON COLUMN "public"."t_meet_lesson"."grade_rule" IS '评分要求';
COMMENT ON COLUMN "public"."t_meet_lesson"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_meet_lesson"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_meet_lesson" IS '见面课';

-- ----------------------------
-- Table structure for t_message_template
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_message_template";
CREATE TABLE "public"."t_message_template" (
  "id" int8 NOT NULL DEFAULT nextval('t_message_template_id_seq'::regclass),
  "type" varchar(64) COLLATE "pg_catalog"."default",
  "application" varchar(64) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_message_template"."id" IS '编号';
COMMENT ON COLUMN "public"."t_message_template"."type" IS '模板类型';
COMMENT ON COLUMN "public"."t_message_template"."application" IS '应用节点';
COMMENT ON COLUMN "public"."t_message_template"."content" IS '内容';
COMMENT ON COLUMN "public"."t_message_template"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_message_template"."update_time" IS '修改时间';
COMMENT ON TABLE "public"."t_message_template" IS '消息模板';

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_privilege";
CREATE TABLE "public"."t_privilege" (
  "id" int8 NOT NULL DEFAULT nextval('t_privilege_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "param" varchar(512) COLLATE "pg_catalog"."default",
  "description" varchar(512) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_privilege"."id" IS '编号';
COMMENT ON COLUMN "public"."t_privilege"."name" IS '权限名';
COMMENT ON COLUMN "public"."t_privilege"."type" IS '权限分类: BUSINESS / SYSTEM';
COMMENT ON COLUMN "public"."t_privilege"."status" IS '状态：ACTIVE / INACTIVE';
COMMENT ON COLUMN "public"."t_privilege"."param" IS '扩展数据';
COMMENT ON COLUMN "public"."t_privilege"."description" IS '描述';
COMMENT ON COLUMN "public"."t_privilege"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_privilege"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_privilege" IS '权限';

-- ----------------------------
-- Table structure for t_privilege_role_rel
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_privilege_role_rel";
CREATE TABLE "public"."t_privilege_role_rel" (
  "role_id" int8,
  "privilege_id" int8
)
;
COMMENT ON COLUMN "public"."t_privilege_role_rel"."role_id" IS '角色编号';
COMMENT ON COLUMN "public"."t_privilege_role_rel"."privilege_id" IS '权限编号';
COMMENT ON TABLE "public"."t_privilege_role_rel" IS '角色权限管理';

-- ----------------------------
-- Table structure for t_questions_and_answers
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_questions_and_answers";
CREATE TABLE "public"."t_questions_and_answers" (
  "id" int8 NOT NULL DEFAULT nextval('t_questions_and_answers_id_seq'::regclass),
  "student_id" int8,
  "catalogue_id" int8,
  "questions_and_answers_id" int8,
  "body" text COLLATE "pg_catalog"."default",
  "like_num" int4,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_questions_and_answers"."id" IS '编号';
COMMENT ON COLUMN "public"."t_questions_and_answers"."student_id" IS '学生编号';
COMMENT ON COLUMN "public"."t_questions_and_answers"."catalogue_id" IS '章节编号';
COMMENT ON COLUMN "public"."t_questions_and_answers"."questions_and_answers_id" IS '回复编号';
COMMENT ON COLUMN "public"."t_questions_and_answers"."body" IS '问答主体';
COMMENT ON COLUMN "public"."t_questions_and_answers"."like_num" IS '点赞数量';
COMMENT ON COLUMN "public"."t_questions_and_answers"."status" IS '状态';
COMMENT ON COLUMN "public"."t_questions_and_answers"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_questions_and_answers"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_questions_and_answers" IS '问答';

-- ----------------------------
-- Table structure for t_questions_and_answers_like
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_questions_and_answers_like";
CREATE TABLE "public"."t_questions_and_answers_like" (
  "id" int8 NOT NULL DEFAULT nextval('t_questions_and_answers_like_id_seq'::regclass),
  "questions_and_answers_id" int8,
  "student_id" int8,
  "create_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_questions_and_answers_like"."id" IS '编号';
COMMENT ON COLUMN "public"."t_questions_and_answers_like"."questions_and_answers_id" IS '问答编号';
COMMENT ON COLUMN "public"."t_questions_and_answers_like"."student_id" IS '学生编号';
COMMENT ON COLUMN "public"."t_questions_and_answers_like"."create_time" IS '创建时间';
COMMENT ON TABLE "public"."t_questions_and_answers_like" IS '问答点赞';

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_role";
CREATE TABLE "public"."t_role" (
  "id" int8 NOT NULL DEFAULT nextval('t_role_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default",
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "description" varchar(512) COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_role"."id" IS '编号';
COMMENT ON COLUMN "public"."t_role"."name" IS '角色名';
COMMENT ON COLUMN "public"."t_role"."type" IS '角色分类';
COMMENT ON COLUMN "public"."t_role"."status" IS '状态：ACTIVE / INACTIVE';
COMMENT ON COLUMN "public"."t_role"."description" IS '描述';
COMMENT ON COLUMN "public"."t_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_role"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_role" IS '角色';

-- ----------------------------
-- Table structure for t_setting
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_setting";
CREATE TABLE "public"."t_setting" (
  "id" int8 NOT NULL DEFAULT nextval('t_setting_id_seq'::regclass),
  "namespace" varchar(64) COLLATE "pg_catalog"."default",
  "key" varchar(64) COLLATE "pg_catalog"."default",
  "value" varchar(512) COLLATE "pg_catalog"."default",
  "comments" varchar(512) COLLATE "pg_catalog"."default",
  "flag" bool DEFAULT false,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_setting"."id" IS '编号';
COMMENT ON COLUMN "public"."t_setting"."namespace" IS '作用域';
COMMENT ON COLUMN "public"."t_setting"."key" IS '键';
COMMENT ON COLUMN "public"."t_setting"."value" IS '值';
COMMENT ON COLUMN "public"."t_setting"."comments" IS '备注';
COMMENT ON COLUMN "public"."t_setting"."flag" IS '是否启用';
COMMENT ON COLUMN "public"."t_setting"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_setting"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_setting" IS '设置';

-- ----------------------------
-- Table structure for t_sms
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sms";
CREATE TABLE "public"."t_sms" (
  "id" int8 NOT NULL DEFAULT nextval('t_sms_id_seq'::regclass),
  "sender" varchar(32) COLLATE "pg_catalog"."default",
  "send_trigger" varchar(32) COLLATE "pg_catalog"."default",
  "sendto" varchar(32) COLLATE "pg_catalog"."default",
  "code" varchar(16) COLLATE "pg_catalog"."default",
  "content" varchar(512) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "response" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_sms"."id" IS '编号';
COMMENT ON COLUMN "public"."t_sms"."sender" IS '发送人';
COMMENT ON COLUMN "public"."t_sms"."send_trigger" IS '发送触发器';
COMMENT ON COLUMN "public"."t_sms"."sendto" IS '发送至';
COMMENT ON COLUMN "public"."t_sms"."code" IS '编码';
COMMENT ON COLUMN "public"."t_sms"."content" IS '内容';
COMMENT ON COLUMN "public"."t_sms"."status" IS '状态';
COMMENT ON COLUMN "public"."t_sms"."response" IS '反馈';
COMMENT ON COLUMN "public"."t_sms"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_sms"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_sms" IS '短信记录';

-- ----------------------------
-- Table structure for t_student_like
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_student_like";
CREATE TABLE "public"."t_student_like" (
  "id" int8 NOT NULL DEFAULT nextval('t_student_like_id_seq'::regclass),
  "student_id" int8,
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "like_id" int8,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_student_like"."id" IS '编号';
COMMENT ON COLUMN "public"."t_student_like"."student_id" IS '学生编号';
COMMENT ON COLUMN "public"."t_student_like"."type" IS '关注类型(老师\课程\企业)';
COMMENT ON COLUMN "public"."t_student_like"."like_id" IS '关注的编号';
COMMENT ON COLUMN "public"."t_student_like"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_student_like"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_student_like" IS '学生的关注';

-- ----------------------------
-- Table structure for t_student_message_inbox
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_student_message_inbox";
CREATE TABLE "public"."t_student_message_inbox" (
  "id" int8 NOT NULL DEFAULT nextval('t_student_message_inbox_id_seq'::regclass),
  "student_id" int8,
  "send_trigger" varchar(64) COLLATE "pg_catalog"."default",
  "msg_type" varchar(32) COLLATE "pg_catalog"."default",
  "msg_title" varchar(64) COLLATE "pg_catalog"."default",
  "msg_body" varchar(512) COLLATE "pg_catalog"."default",
  "is_read" bool,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_student_message_inbox"."id" IS '编号';
COMMENT ON COLUMN "public"."t_student_message_inbox"."student_id" IS '学生编号';
COMMENT ON COLUMN "public"."t_student_message_inbox"."send_trigger" IS '发送触发器';
COMMENT ON COLUMN "public"."t_student_message_inbox"."msg_type" IS '消息类型(NOTIFICATION:通知/ALERT:警告/MESSAGE:信息)';
COMMENT ON COLUMN "public"."t_student_message_inbox"."msg_title" IS '消息标题';
COMMENT ON COLUMN "public"."t_student_message_inbox"."msg_body" IS '消息内容';
COMMENT ON COLUMN "public"."t_student_message_inbox"."is_read" IS '已读(f:false/t:true)';
COMMENT ON COLUMN "public"."t_student_message_inbox"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_student_message_inbox"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_student_message_inbox" IS '学生站内信';

-- ----------------------------
-- Table structure for t_student_teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_student_teacher";
CREATE TABLE "public"."t_student_teacher" (
  "id" int8 NOT NULL DEFAULT nextval('t_student_teacher_id_seq'::regclass),
  "college_id" int8,
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "mark_no" varchar(128) COLLATE "pg_catalog"."default",
  "password" varchar(256) COLLATE "pg_catalog"."default",
  "name" varchar(32) COLLATE "pg_catalog"."default",
  "nick_name" varchar(32) COLLATE "pg_catalog"."default",
  "mobile" varchar(32) COLLATE "pg_catalog"."default",
  "email" varchar(64) COLLATE "pg_catalog"."default",
  "head_file_id" int8,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "status_expired_time" timestamptz(6),
  "last_login_time" timestamptz(6),
  "failed_login_count" int4 DEFAULT 0,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now(),
  "gender" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_student_teacher"."id" IS '编号';
COMMENT ON COLUMN "public"."t_student_teacher"."college_id" IS '学院或企业编号';
COMMENT ON COLUMN "public"."t_student_teacher"."type" IS '类型(学生\老师)';
COMMENT ON COLUMN "public"."t_student_teacher"."mark_no" IS '学号/工号';
COMMENT ON COLUMN "public"."t_student_teacher"."password" IS '密码';
COMMENT ON COLUMN "public"."t_student_teacher"."name" IS '姓名';
COMMENT ON COLUMN "public"."t_student_teacher"."nick_name" IS '昵称';
COMMENT ON COLUMN "public"."t_student_teacher"."mobile" IS '手机号';
COMMENT ON COLUMN "public"."t_student_teacher"."email" IS '邮箱';
COMMENT ON COLUMN "public"."t_student_teacher"."head_file_id" IS '头像文件编号';
COMMENT ON COLUMN "public"."t_student_teacher"."status" IS '状态(ACTIVE:活跃/HOLD:保留/DISABLED:禁用)';
COMMENT ON COLUMN "public"."t_student_teacher"."status_expired_time" IS '状态失效时间';
COMMENT ON COLUMN "public"."t_student_teacher"."last_login_time" IS '最后一次登录时间';
COMMENT ON COLUMN "public"."t_student_teacher"."failed_login_count" IS '登录失败次数';
COMMENT ON COLUMN "public"."t_student_teacher"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_student_teacher"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_student_teacher"."gender" IS '性别';
COMMENT ON TABLE "public"."t_student_teacher" IS '学生/老师';

-- ----------------------------
-- Table structure for t_study_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_study_group";
CREATE TABLE "public"."t_study_group" (
  "id" int8 NOT NULL DEFAULT nextval('t_study_group_id_seq'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default",
  "group_num" int4,
  "create_teacher" int8,
  "update_teacher" int8,
  "comment" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_study_group"."id" IS '编号';
COMMENT ON COLUMN "public"."t_study_group"."name" IS '组名';
COMMENT ON COLUMN "public"."t_study_group"."group_num" IS '组人员数';
COMMENT ON COLUMN "public"."t_study_group"."create_teacher" IS '创建老师';
COMMENT ON COLUMN "public"."t_study_group"."update_teacher" IS '修改老师';
COMMENT ON COLUMN "public"."t_study_group"."comment" IS '备注';
COMMENT ON COLUMN "public"."t_study_group"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_study_group"."update_time" IS '更新时间';
COMMENT ON TABLE "public"."t_study_group" IS '学习组';

-- ----------------------------
-- Table structure for t_study_group_student
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_study_group_student";
CREATE TABLE "public"."t_study_group_student" (
  "id" int8 NOT NULL DEFAULT nextval('t_study_group_student_id_seq'::regclass),
  "study_group_id" int8,
  "student_id" int8,
  "create_time" timestamptz(6) DEFAULT now(),
  "update_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON TABLE "public"."t_study_group_student" IS '学习组与学生管理';

-- ----------------------------
-- Table structure for t_suggest
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_suggest";
CREATE TABLE "public"."t_suggest" (
  "id" int8 NOT NULL DEFAULT nextval('t_suggest_id_seq'::regclass),
  "student_teacher_id" int8,
  "platform" varchar(32) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."t_suggest"."id" IS '编号';
COMMENT ON COLUMN "public"."t_suggest"."student_teacher_id" IS '提议者编号';
COMMENT ON COLUMN "public"."t_suggest"."platform" IS '平台';
COMMENT ON COLUMN "public"."t_suggest"."content" IS '内容';
COMMENT ON COLUMN "public"."t_suggest"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for t_token
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_token";
CREATE TABLE "public"."t_token" (
  "id" int8 NOT NULL DEFAULT nextval('t_token_id_seq'::regclass),
  "subject" varchar(32) COLLATE "pg_catalog"."default",
  "token" varchar(256) COLLATE "pg_catalog"."default",
  "expired_time" timestamptz(6),
  "refresh_token" varchar(256) COLLATE "pg_catalog"."default",
  "refresh_expired_time" timestamptz(6),
  "metadata" text COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_token"."id" IS '编号';
COMMENT ON COLUMN "public"."t_token"."subject" IS '标识';
COMMENT ON COLUMN "public"."t_token"."token" IS 'token';
COMMENT ON COLUMN "public"."t_token"."expired_time" IS '过期时间';
COMMENT ON COLUMN "public"."t_token"."refresh_token" IS '更新token';
COMMENT ON COLUMN "public"."t_token"."refresh_expired_time" IS '更新过期时间';
COMMENT ON COLUMN "public"."t_token"."metadata" IS '数据';
COMMENT ON TABLE "public"."t_token" IS 'Token令牌';

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_admin_audit_id_seq"
OWNED BY "public"."t_admin_audit"."id";
SELECT setval('"public"."t_admin_audit_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_admin_id_seq"
OWNED BY "public"."t_admin"."id";
SELECT setval('"public"."t_admin_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_app_push_id_seq"
OWNED BY "public"."t_app_push"."id";
SELECT setval('"public"."t_app_push_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_catalogue_id_seq"
OWNED BY "public"."t_catalogue"."id";
SELECT setval('"public"."t_catalogue_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_catalogue_test_id_seq"
OWNED BY "public"."t_catalogue_test"."id";
SELECT setval('"public"."t_catalogue_test_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_college_id_seq"
OWNED BY "public"."t_college"."id";
SELECT setval('"public"."t_college_id_seq"', 2, true);
ALTER SEQUENCE "public"."t_college_picture_id_seq"
OWNED BY "public"."t_college_picture"."id";
SELECT setval('"public"."t_college_picture_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_file_id_seq"
OWNED BY "public"."t_file"."id";
SELECT setval('"public"."t_file_id_seq"', 20, true);
ALTER SEQUENCE "public"."t_group_id_seq"
OWNED BY "public"."t_group"."id";
SELECT setval('"public"."t_group_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_info_kind_id_seq"
OWNED BY "public"."t_info_kind"."id";
SELECT setval('"public"."t_info_kind_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_info_type_id_seq"
OWNED BY "public"."t_info_type"."id";
SELECT setval('"public"."t_info_type_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_information_file_id_seq"
OWNED BY "public"."t_information_file"."id";
SELECT setval('"public"."t_information_file_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_information_id_seq"
OWNED BY "public"."t_information"."id";
SELECT setval('"public"."t_information_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_job_metric_id_seq"
OWNED BY "public"."t_job_metric"."id";
SELECT setval('"public"."t_job_metric_id_seq"', 17, true);
ALTER SEQUENCE "public"."t_lesson_assess_id_seq"
OWNED BY "public"."t_lesson_assess"."id";
SELECT setval('"public"."t_lesson_assess_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_lesson_id_seq"
OWNED BY "public"."t_lesson"."id";
SELECT setval('"public"."t_lesson_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_lesson_section_id_seq"
OWNED BY "public"."t_lesson_section"."id";
SELECT setval('"public"."t_lesson_section_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_lesson_tag_id_seq"
OWNED BY "public"."t_lesson_tag"."id";
SELECT setval('"public"."t_lesson_tag_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_meet_lesson_id_seq"
OWNED BY "public"."t_meet_lesson"."id";
SELECT setval('"public"."t_meet_lesson_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_message_template_id_seq"
OWNED BY "public"."t_message_template"."id";
SELECT setval('"public"."t_message_template_id_seq"', 2, true);
ALTER SEQUENCE "public"."t_privilege_id_seq"
OWNED BY "public"."t_privilege"."id";
SELECT setval('"public"."t_privilege_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_questions_and_answers_id_seq"
OWNED BY "public"."t_questions_and_answers"."id";
SELECT setval('"public"."t_questions_and_answers_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_questions_and_answers_like_id_seq"
OWNED BY "public"."t_questions_and_answers_like"."id";
SELECT setval('"public"."t_questions_and_answers_like_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_role_id_seq"
OWNED BY "public"."t_role"."id";
SELECT setval('"public"."t_role_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_setting_id_seq"
OWNED BY "public"."t_setting"."id";
SELECT setval('"public"."t_setting_id_seq"', 4, true);
ALTER SEQUENCE "public"."t_sms_id_seq"
OWNED BY "public"."t_sms"."id";
SELECT setval('"public"."t_sms_id_seq"', 5, true);
ALTER SEQUENCE "public"."t_student_like_id_seq"
OWNED BY "public"."t_student_like"."id";
SELECT setval('"public"."t_student_like_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_student_message_inbox_id_seq"
OWNED BY "public"."t_student_message_inbox"."id";
SELECT setval('"public"."t_student_message_inbox_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_student_teacher_id_seq"
OWNED BY "public"."t_student_teacher"."id";
SELECT setval('"public"."t_student_teacher_id_seq"', 4, true);
ALTER SEQUENCE "public"."t_study_group_id_seq"
OWNED BY "public"."t_study_group"."id";
SELECT setval('"public"."t_study_group_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_study_group_student_id_seq"
OWNED BY "public"."t_study_group_student"."id";
SELECT setval('"public"."t_study_group_student_id_seq"', 2, false);
ALTER SEQUENCE "public"."t_suggest_id_seq"
OWNED BY "public"."t_suggest"."id";
SELECT setval('"public"."t_suggest_id_seq"', 3, true);
ALTER SEQUENCE "public"."t_token_id_seq"
OWNED BY "public"."t_token"."id";
SELECT setval('"public"."t_token_id_seq"', 18, true);

-- ----------------------------
-- Indexes structure for table t_admin
-- ----------------------------
CREATE UNIQUE INDEX "t_admin_pk" ON "public"."t_admin" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_admin
-- ----------------------------
ALTER TABLE "public"."t_admin" ADD CONSTRAINT "pk_t_admin" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_admin_audit
-- ----------------------------
CREATE UNIQUE INDEX "t_admin_audit_pk" ON "public"."t_admin_audit" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_admin_audit
-- ----------------------------
ALTER TABLE "public"."t_admin_audit" ADD CONSTRAINT "pk_t_admin_audit" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_app_push
-- ----------------------------
CREATE UNIQUE INDEX "t_app_push_pk" ON "public"."t_app_push" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_app_push
-- ----------------------------
ALTER TABLE "public"."t_app_push" ADD CONSTRAINT "pk_t_app_push" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_catalogue
-- ----------------------------
CREATE UNIQUE INDEX "t_catalogue_pk" ON "public"."t_catalogue" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_catalogue
-- ----------------------------
ALTER TABLE "public"."t_catalogue" ADD CONSTRAINT "pk_t_catalogue" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_catalogue_test
-- ----------------------------
CREATE UNIQUE INDEX "t_catalogue_test_pk" ON "public"."t_catalogue_test" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_catalogue_test
-- ----------------------------
ALTER TABLE "public"."t_catalogue_test" ADD CONSTRAINT "pk_t_catalogue_test" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_college
-- ----------------------------
CREATE UNIQUE INDEX "t_college_pk" ON "public"."t_college" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_college
-- ----------------------------
ALTER TABLE "public"."t_college" ADD CONSTRAINT "pk_t_college" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_college_picture
-- ----------------------------
CREATE UNIQUE INDEX "t_college_picture_pk" ON "public"."t_college_picture" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_college_picture
-- ----------------------------
ALTER TABLE "public"."t_college_picture" ADD CONSTRAINT "pk_t_college_picture" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_file
-- ----------------------------
CREATE UNIQUE INDEX "t_file_pk" ON "public"."t_file" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_file
-- ----------------------------
ALTER TABLE "public"."t_file" ADD CONSTRAINT "pk_t_file" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_group
-- ----------------------------
CREATE UNIQUE INDEX "t_group_pk" ON "public"."t_group" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_group
-- ----------------------------
ALTER TABLE "public"."t_group" ADD CONSTRAINT "pk_t_group" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_info_kind
-- ----------------------------
CREATE UNIQUE INDEX "t_info_kind_pk" ON "public"."t_info_kind" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_info_kind
-- ----------------------------
ALTER TABLE "public"."t_info_kind" ADD CONSTRAINT "pk_t_info_kind" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_info_type
-- ----------------------------
CREATE UNIQUE INDEX "t_info_type_pk" ON "public"."t_info_type" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_info_type
-- ----------------------------
ALTER TABLE "public"."t_info_type" ADD CONSTRAINT "pk_t_info_type" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_information
-- ----------------------------
CREATE UNIQUE INDEX "t_information_pk" ON "public"."t_information" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_information
-- ----------------------------
ALTER TABLE "public"."t_information" ADD CONSTRAINT "pk_t_information" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_information_file
-- ----------------------------
CREATE UNIQUE INDEX "t_information_file_pk" ON "public"."t_information_file" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_information_file
-- ----------------------------
ALTER TABLE "public"."t_information_file" ADD CONSTRAINT "pk_t_information_file" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_lesson
-- ----------------------------
CREATE UNIQUE INDEX "t_lesson_pk" ON "public"."t_lesson" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_lesson
-- ----------------------------
ALTER TABLE "public"."t_lesson" ADD CONSTRAINT "pk_t_lesson" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_lesson_assess
-- ----------------------------
CREATE UNIQUE INDEX "t_lesson_assess_pk" ON "public"."t_lesson_assess" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_lesson_assess
-- ----------------------------
ALTER TABLE "public"."t_lesson_assess" ADD CONSTRAINT "pk_t_lesson_assess" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_lesson_section
-- ----------------------------
CREATE UNIQUE INDEX "t_lesson_section_pk" ON "public"."t_lesson_section" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_lesson_section
-- ----------------------------
ALTER TABLE "public"."t_lesson_section" ADD CONSTRAINT "pk_t_lesson_section" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_lesson_tag
-- ----------------------------
CREATE UNIQUE INDEX "t_lesson_tag_pk" ON "public"."t_lesson_tag" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_lesson_tag
-- ----------------------------
ALTER TABLE "public"."t_lesson_tag" ADD CONSTRAINT "pk_t_lesson_tag" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_meet_lesson
-- ----------------------------
CREATE UNIQUE INDEX "t_meet_lesson_pk" ON "public"."t_meet_lesson" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_meet_lesson
-- ----------------------------
ALTER TABLE "public"."t_meet_lesson" ADD CONSTRAINT "pk_t_meet_lesson" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_message_template
-- ----------------------------
CREATE UNIQUE INDEX "t_message_template_pk" ON "public"."t_message_template" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_message_template
-- ----------------------------
ALTER TABLE "public"."t_message_template" ADD CONSTRAINT "pk_t_message_template" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_privilege
-- ----------------------------
CREATE UNIQUE INDEX "t_privilege_pk" ON "public"."t_privilege" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_privilege
-- ----------------------------
ALTER TABLE "public"."t_privilege" ADD CONSTRAINT "pk_t_privilege" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_questions_and_answers
-- ----------------------------
CREATE UNIQUE INDEX "t_questions_and_answers_pk" ON "public"."t_questions_and_answers" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_questions_and_answers
-- ----------------------------
ALTER TABLE "public"."t_questions_and_answers" ADD CONSTRAINT "pk_t_questions_and_answers" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_questions_and_answers_like
-- ----------------------------
CREATE UNIQUE INDEX "t_questions_and_answers_like_pk" ON "public"."t_questions_and_answers_like" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_questions_and_answers_like
-- ----------------------------
ALTER TABLE "public"."t_questions_and_answers_like" ADD CONSTRAINT "pk_t_questions_and_answers_lik" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_role
-- ----------------------------
CREATE UNIQUE INDEX "t_role_pk" ON "public"."t_role" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_role
-- ----------------------------
ALTER TABLE "public"."t_role" ADD CONSTRAINT "pk_t_role" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_setting
-- ----------------------------
CREATE UNIQUE INDEX "t_setting_pk" ON "public"."t_setting" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_setting
-- ----------------------------
ALTER TABLE "public"."t_setting" ADD CONSTRAINT "pk_t_setting" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_sms
-- ----------------------------
CREATE UNIQUE INDEX "t_sms_pk" ON "public"."t_sms" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_sms
-- ----------------------------
ALTER TABLE "public"."t_sms" ADD CONSTRAINT "pk_t_sms" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_student_like
-- ----------------------------
CREATE UNIQUE INDEX "t_student_like_pk" ON "public"."t_student_like" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_student_like
-- ----------------------------
ALTER TABLE "public"."t_student_like" ADD CONSTRAINT "pk_t_student_like" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_student_message_inbox
-- ----------------------------
CREATE UNIQUE INDEX "t_student_message_inbox_pk" ON "public"."t_student_message_inbox" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_student_message_inbox
-- ----------------------------
ALTER TABLE "public"."t_student_message_inbox" ADD CONSTRAINT "pk_t_student_message_inbox" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_student_teacher
-- ----------------------------
CREATE UNIQUE INDEX "t_student_teacher_mobile_unique" ON "public"."t_student_teacher" USING btree (
  "mobile" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "t_student_teacher_pk" ON "public"."t_student_teacher" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_student_teacher
-- ----------------------------
ALTER TABLE "public"."t_student_teacher" ADD CONSTRAINT "pk_t_student_teacher" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_study_group
-- ----------------------------
CREATE UNIQUE INDEX "t_study_group_pk" ON "public"."t_study_group" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_study_group
-- ----------------------------
ALTER TABLE "public"."t_study_group" ADD CONSTRAINT "pk_t_study_group" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_study_group_student
-- ----------------------------
CREATE UNIQUE INDEX "t_study_group_student_pk" ON "public"."t_study_group_student" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_study_group_student
-- ----------------------------
ALTER TABLE "public"."t_study_group_student" ADD CONSTRAINT "pk_t_study_group_student" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_token
-- ----------------------------
CREATE UNIQUE INDEX "t_token_pk" ON "public"."t_token" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_token
-- ----------------------------
ALTER TABLE "public"."t_token" ADD CONSTRAINT "pk_t_token" PRIMARY KEY ("id");
