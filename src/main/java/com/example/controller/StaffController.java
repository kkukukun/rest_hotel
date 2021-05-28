package com.example.controller;

import com.example.entity.Room;
import com.example.entity.Staff;
import com.example.service.RoomInterface;
import com.example.service.StaffInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StaffController {

    @Qualifier("staffServiceImpl")
    @Autowired
    StaffInterface staffRepo;

    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Staff staff = this.staffRepo.findById(id);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @RequestMapping(value = "/staff", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        HttpHeaders headers = new HttpHeaders();
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.staffRepo.save(staff);
        return new ResponseEntity<>(staff, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> deleteStaff(@PathVariable("id") Long id) {
        Staff staff = this.staffRepo.findById(id);

        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.staffRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffs = this.staffRepo.findAll();

        if (staffs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @RequestMapping(value = "/staff/{speciality}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> findStaffBySpeciality(@PathVariable("speciality") String speciality) {
        if (speciality == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Staff staff = this.staffRepo.findBySpeciality(speciality);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
