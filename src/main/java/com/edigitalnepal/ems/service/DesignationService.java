package com.edigitalnepal.ems.service;

import com.edigitalnepal.ems.exception.DesignationNotFoundException;
import com.edigitalnepal.ems.message.ResponseMessage;
import com.edigitalnepal.ems.model.Designation;
import com.edigitalnepal.ems.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DesignationService {
    @Autowired
    DesignationRepository designationRepository;

    public ResponseMessage<?> get(Long id) {
        return ResponseMessage.withResponseData(getDesignation(id), "success");
    }

    public ResponseMessage<?> get(Pageable pageable) {
        Page<Designation> savedDesignation = designationRepository.findAll(pageable);
        return ResponseMessage.withResponseData(savedDesignation, "success");
    }

    public ResponseMessage<?> save(Designation designation) {
        Designation savedDesignation = designationRepository.save(designation);
        return ResponseMessage.withResponseData(savedDesignation, "success");
    }

    public ResponseMessage<?> update(Long id, Designation designation) {
        getDesignation(id);
        designation.setId(id);
        return save(designation);
    }

    public ResponseMessage<?> delete(Long id) {
        Designation designation = getDesignation(id);
        designationRepository.delete(designation);
        return ResponseMessage.withResponseData(null, "success");
    }

    private Designation getDesignation(Long id) {
        return designationRepository.findById(id).orElseThrow(
                () -> new DesignationNotFoundException(id)
        );
    }
}
