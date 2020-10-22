package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Formation;
import com.example.demo.repository.companyRepository;
import com.example.demo.repository.formationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class companyservice {

    @Autowired
    private companyRepository companyRepository;

    /* ---------------------------------get all------------------*/
    public List<Company> findAll() {
        return companyRepository.findAll();


    }
    /*--------------------------save one ------------------*/
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    /* ------------------------update formationills----------------- */
    public Company update(Company company) throws ResourceNotFoundException {

        Company inBase = companyRepository.findById(company.getId())
                .orElseThrow(() -> new ResourceNotFoundException("company not found for this id :: " + company.getId()));
        inBase.setName(company.getName());
        inBase.setAdress(company.getAdress());
        inBase.setDescription(company.getDescription());
        inBase.setCity(company.getCity());

        inBase = companyRepository.save(inBase);
        return inBase;
    }
    /* ---------------find one---------*/
    public Company findOne(String id) throws ResourceNotFoundException {

        Company inBase = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("COMPANY not found for this id :: " + id));

        return inBase;
    }
    /* -------------------delete by id -------------------*/
    public void delete(String id) {

        companyRepository.deleteById(id);
    }
}
