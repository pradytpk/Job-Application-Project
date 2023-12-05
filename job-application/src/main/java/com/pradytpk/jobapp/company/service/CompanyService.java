package com.pradytpk.jobapp.company.service;

import java.util.List;

import com.pradytpk.jobapp.company.model.Company;

public interface CompanyService {
	List<Company> getAllComponaies();

	boolean updateCompany(Company company, Long id);

	void createCompany(Company company);

}
