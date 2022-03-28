create schema '3AT_21';

create table '3AT_21'.'student' (
                                    'id_student' INT NOT NULL,
                                    'name' VARCHAR(45) NULL,
                                    'bd' DATE NULL,
                                    'course' INT NULL,
                                    PRIMARY KEY ('id_student'));

create table '3AT_21'.'address' (
                                    'id_address' INT NOT NULL,
                                    'country' VARCHAR(45) NULL,
                                    'city' VARCHAR(45) NULL,
                                    PRIMARY KEY ('id_address'));

create table '3AT_21'.'student_address' (
                                    'id_address_student' INT NOT NULL,
                                    'id_address' VARCHAR(45) NULL,
                                    'id_student' VARCHAR(45) NULL,
                                    PRIMARY KEY ('id_address_student'));