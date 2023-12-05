/**
 * 
 */
package com.pradytpk.jobapp.job.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pradytpk.jobapp.job.Repository.JobRepository;
import com.pradytpk.jobapp.job.model.Job;
import com.pradytpk.jobapp.job.service.JobService;

/**
 * @author Pradeep Kumar
 *
 */

@Service
public class JobServiceImpl implements JobService {
//	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;
	private JobRepository jobRepository;

	/**
	 * @param jobRepository
	 */
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public Iterable<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateJobById(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			return true;
		}
		return false;
	}

}
