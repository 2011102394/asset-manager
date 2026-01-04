CREATE TABLE sys_user (
    user_id bigint NOT NULL,
    dept_id bigint DEFAULT NULL,
    user_name varchar(30) NOT NULL,
    nick_name varchar(30) NOT NULL,
    epc varchar(100) DEFAULT NULL,
    user_type varchar(2) DEFAULT '0',
    email varchar(50) DEFAULT '',
    phonenumber varchar(11) DEFAULT '',
    sex char(1) DEFAULT '0',
    avatar varchar(100) DEFAULT '',
    password varchar(100) DEFAULT '',
    status char(1) DEFAULT '0',
    del_flag char(1) DEFAULT '0',
    login_ip varchar(128) DEFAULT '',
    login_date timestamp without time zone DEFAULT NULL,
    pwd_update_date timestamp without time zone DEFAULT NULL,
    create_by varchar(64) DEFAULT '',
    create_time timestamp without time zone DEFAULT NULL,
    update_by varchar(64) DEFAULT '',
    update_time timestamp without time zone DEFAULT NULL,
    remark varchar(500) DEFAULT NULL,
    PRIMARY KEY (user_id)
);

-- ========== 单独添加【表注释】+【所有字段注释】（PG标准语法） ==========
COMMENT ON TABLE sys_user IS '用户信息表';
COMMENT ON COLUMN sys_user.user_id IS '用户ID';
COMMENT ON COLUMN sys_user.dept_id IS '部门ID';
COMMENT ON COLUMN sys_user.user_name IS '用户账号';
COMMENT ON COLUMN sys_user.nick_name IS '用户昵称';
COMMENT ON COLUMN sys_user.epc IS 'EPC编码';
COMMENT ON COLUMN sys_user.user_type IS '用户类型（00系统用户）';
COMMENT ON COLUMN sys_user.email IS '用户邮箱';
COMMENT ON COLUMN sys_user.phonenumber IS '手机号码';
COMMENT ON COLUMN sys_user.sex IS '用户性别（0男 1女 2未知）';
COMMENT ON COLUMN sys_user.avatar IS '头像地址';
COMMENT ON COLUMN sys_user.password IS '密码';
COMMENT ON COLUMN sys_user.status IS '账号状态（0正常 1停用）';
COMMENT ON COLUMN sys_user.del_flag IS '删除标志（0代表存在 2代表删除）';
COMMENT ON COLUMN sys_user.login_ip IS '最后登录IP';
COMMENT ON COLUMN sys_user.login_date IS '最后登录时间';
COMMENT ON COLUMN sys_user.pwd_update_date IS '密码最后更新时间';
COMMENT ON COLUMN sys_user.create_by IS '创建者';
COMMENT ON COLUMN sys_user.create_time IS '创建时间';
COMMENT ON COLUMN sys_user.update_by IS '更新者';
COMMENT ON COLUMN sys_user.update_time IS '更新时间';
COMMENT ON COLUMN sys_user.remark IS '备注';