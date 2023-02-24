package com.vkakarla.springboot.soap.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import javax.persistence.*;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;
    String name;
    String department;
    String phone;
    String address;
}