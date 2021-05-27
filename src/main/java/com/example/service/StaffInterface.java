package com.example.service;

import com.example.entity.Staff;

public interface StaffInterface extends InterfaceService<Staff>{
    Staff findStaffBySpeciality(String speciality);
    Staff findStaffByLastname(String lastname);
}
