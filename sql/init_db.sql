use mzat;

create table student (
                                    id_student INT NOT NULL,
                                    name VARCHAR(45) NULL,
                                    bd DATE NULL,
                                    course INT NULL,
                                    PRIMARY KEY (id_student));

create table address (
                                    id_address INT NOT NULL,
                                    country VARCHAR(45) NULL,
                                    city VARCHAR(45) NULL,
                                    PRIMARY KEY (id_address));

create table student_address (
                                    id_address_student INT NOT NULL,
                                    id_address VARCHAR(45) NULL,
                                    id_student VARCHAR(45) NULL,
                                    PRIMARY KEY (id_address_student));