package com.example.demo.service.impl;

import com.example.demo.model.facility.Facility;
import com.example.demo.repository.IFacilityRepository;
import com.example.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> showList() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<Facility> findName(Pageable pageable, String name) {
        return facilityRepository.findByNameContaining(pageable,name);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);

    }

    @Override
    public void remove(int id) {
       facilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }
}
