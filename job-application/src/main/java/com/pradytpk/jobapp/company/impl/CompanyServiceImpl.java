/**
 * 
 */
package com.pradytpk.jobapp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pradytpk.jobapp.company.Repository.CompanyRepository;
import com.pradytpk.jobapp.company.model.Company;
import com.pradytpk.jobapp.company.service.CompanyService;

/**
 * @author Pradeep Kumar
 *
 */

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	/**
	 * @param companyRepository
	 */
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllComponaies() {
		return (List<Company>) companyRepository.findAll();
	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get();

			companyToUpdate.setName(company.getName());
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setJobs(company.getJobs());

			companyRepository.save(companyToUpdate);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}
}
