package com.example.service.impl;

import com.example.entity.Staff;
import com.example.repository.StaffRepository;
import com.example.service.InterfaceService;
import com.example.service.StaffInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffInterface {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findById(Long id) {
        return null;
    }

    public Staff findBySpeciality(String speciality) {
        return staffRepository.findStaffBySpeciality(speciality);
    }

    @Override
    public void delete(Long id){staffRepository.deleteById(id);}

}
