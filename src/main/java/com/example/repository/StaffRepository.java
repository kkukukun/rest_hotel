package com.example.repository;

import com.example.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "staff", path = "staff")
public interface StaffRepository extends JpaRepository<Staff,Long> {
    Staff findStaffBySpeciality (String speciality);
}
