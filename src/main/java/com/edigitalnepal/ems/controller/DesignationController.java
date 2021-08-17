package com.edigitalnepal.ems.controller;

import com.edigitalnepal.ems.message.ResponseMessage;
import com.edigitalnepal.ems.model.Designation;
import com.edigitalnepal.ems.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/designations")
public class DesignationController {

    @Autowired
    DesignationService designationService;

    @GetMapping
    public ResponseEntity<?> get(Pageable pageable) {
        ResponseMessage<?> responseMessage = designationService.get(pageable);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        ResponseMessage<?> responseMessage = designationService.get(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Designation designation) {
        ResponseMessage<?> responseMessage = designationService.save(designation);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Designation designation) {
        ResponseMessage<?> responseMessage = designationService.update(id, designation);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ResponseMessage<?> responseMessage = designationService.delete(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

}
