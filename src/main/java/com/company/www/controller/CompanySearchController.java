package com.company.www.controller;

import com.company.www.model.Company;
import com.company.www.model.CompanySearch;
import com.company.www.model.CompanySearchResult;
import com.company.www.model.OfficerSearchResult;
import com.company.www.service.CompanySearchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/www.company.com")
public class CompanySearchController {

    @Autowired
    private CompanySearchService companySearchService;

    @PostMapping("/search")
    public ResponseEntity<List<Company>> searchCompanies(@Valid @RequestBody CompanySearch companySearch) {
        CompanySearchResult companySearchResult = companySearchService.searchCompanies(companySearch);
        if (companySearchResult != null && companySearchResult.getTotalResults() > 0) {
            for (Company company : companySearchResult.getCompanies()) {
                OfficerSearchResult officerSearchResult = companySearchService.searchOfficersByCompany(company.getCompanyNumber());
                if (officerSearchResult != null && officerSearchResult.getTotalResults() > 0) {
                    company.setOfficers(officerSearchResult.getOfficers());
                }
            }
            return new ResponseEntity(companySearchResult, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
