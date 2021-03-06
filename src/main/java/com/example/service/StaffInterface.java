package com.example.service;

import com.example.entity.Staff;

public interface StaffInterface extends InterfaceService<Staff>{
    Staff findBySpeciality(String speciality);
}
