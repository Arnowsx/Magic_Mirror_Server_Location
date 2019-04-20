-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE magic_mirror_database;
-- 使用数据库
use magic_mirror_database;
-- 创建数据库

-- 设备信息表
CREATE TABLE device_info_table(
                                  `device_id` int NOT NULL AUTO_INCREMENT COMMENT '设备ID',
                                  `name` varchar(20) NOT NULL COMMENT '设备名称',
                                  `device_mac` varchar(20) NOT NULL COMMENT '设备MAC地址',
                                  `device_type` int NOT NULL COMMENT '设备类型',
                                  PRIMARY KEY (`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO device_info_table(device_id, name, device_mac, device_type)
VALUES (1, "MagicMirror", "00-01-6C-06-A6-29", 1);

INSERT INTO device_info_table(device_id, name, device_mac, device_type)
VALUES (2, "MagicDoorbell", "11-02-6C-01-A3-22",2);

-- 设备类型表
CREATE TABLE device_type_table(
                                  `type_id` int NOT NULL AUTO_INCREMENT COMMENT '类型ID',
                                  `type` varchar(20) NOT NULL COMMENT  '设备类型',
                                  PRIMARY KEY (`type_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO device_type_table(type_id, type) VALUES (1, "mirror");
INSERT INTO device_type_table(type_id, type) VALUES (2, "doorbell");
INSERT INTO device_type_table(type_id, type) VALUES (3, "alarmclock");

-- 设备认证信息表
CREATE TABLE device_login_info_table(
                                        `device_login_id` varchar(20) NOT NULL COMMENT '设备ID',
                                        `device_pwd_key` varchar(30) COMMENT '设备密钥',
                                        `device_id` int NOT NULL,
                                        PRIMARY KEY (`device_login_id`),
                                        FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 设备认证事件表
CREATE TABLE device_login_log_table(
                                       `event_id` int NOT NULL AUTO_INCREMENT COMMENT '登录事件ID',
                                       `device_id` int NOT NULL,
                                       `device_login_ip` varchar(20),
                                       `device_login_last_time` varchar(20),
                                       PRIMARY KEY (`event_id`),
                                       FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- *唤醒词表
CREATE TABLE wake_up_word_table(
                                   `word_id` int NOT NULL AUTO_INCREMENT COMMENT '唤醒词ID',
                                   `word_content` varchar(20) COMMENT '唤醒词文字内容',
                                   `word_blob` longblob COMMENT '唤醒词二进制',
                                   `device_id` int NOT NULL ,
                                   PRIMARY KEY (`word_id`),
                                   FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 闹钟表
CREATE TABLE clock_table(
                            `clock_id` int NOT NULL AUTO_INCREMENT COMMENT '闹钟ID',
                            `time` varchar(25) COMMENT '闹钟设置时间',
                            `status` int,
                            `device_id` int NOT NULL COMMENT '设备ID',
                            PRIMARY KEY (`clock_id`),
                            FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 备注表
CREATE TABLE  note_table(
                            `note_id` int NOT NULL AUTO_INCREMENT COMMENT '日志ID',
                            `save_time` varchar(25),
                            `text` varchar(1000),
                            `device_id` int NOT NULL,
                            PRIMARY KEY (`note_id`),
                            FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 火情警报表
CREATE TABLE fire_warn_table(
                                `event_id` int NOT NULL AUTO_INCREMENT COMMENT '火警ID',
                                `time` varchar(25),
                                `data` float,
                                `device_id` int NOT NULL ,
                                PRIMARY KEY (`event_id`),
                                FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 烟雾警报表
CREATE TABLE smoke_warn_table(
                                 `event_id` int NOT NULL AUTO_INCREMENT COMMENT '烟雾警报ID',
                                 `time` varchar(25),
                                 `data` float,
                                 `device_id` int NOT NULL ,
                                 PRIMARY KEY (`event_id`),
                                 FOREIGN KEY (`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 新闻表
CREATE TABLE news_table(
                           `news_id` int NOT NULL AUTO_INCREMENT COMMENT '新闻ID',
                           `time` varchar(25),
                           `text` varchar(1000),
                           `device_id` int NOT NULL,
                           PRIMARY KEY (`news_id`),
                           FOREIGN KEY(`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 联系人表
CREATE TABLE contacts_table(
                               `contact_id` int NOT NULL AUTO_INCREMENT COMMENT '联系人ID',
                               `contact_name` varchar(20),
                               `telephone` varchar(20),
                               `weixin` varchar(25),
                               `qq` varchar(15),
                               PRIMARY KEY (`contact_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 声音类型表
CREATE TABLE voice_type_table(
                                 `type_id` int NOT NULL AUTO_INCREMENT COMMENT '声音类型ID',
                                 `type` varchar(20) NOT NULL,
                                 PRIMARY KEY (`type_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO voice_type_table(type_id, type) VALUES (1, "news");
INSERT INTO voice_type_table(type_id, type) VALUES (2, "weather");
INSERT INTO voice_type_table(type_id, type) VALUES (3, "clock");
INSERT INTO voice_type_table(type_id, type) VALUES (4, "warning");
INSERT INTO voice_type_table(type_id, type) VALUES (5, "dialog");
INSERT INTO voice_type_table(type_id, type) VALUES (6, "log");

-- *声音记录表
CREATE TABLE voice_record_table(
                                   `record_id` int NOT NULL AUTO_INCREMENT,
                                   `voice_type` int NOT NULL,
                                   `voice_file_blob` longblob,
                                   `voice_text` varchar(1000),
                                   `device_id` int NOT NULL,
                                   PRIMARY KEY (`record_id`),
                                   FOREIGN KEY (`device_id`) REFERENCES `device_info_table`(`device_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
