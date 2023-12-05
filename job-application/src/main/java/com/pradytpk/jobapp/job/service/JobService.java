package com.pradytpk.jobapp.job.service;

import com.pradytpk.jobapp.job.model.Job;

public interface JobService {
	Iterable<Job> findAll();

	void createJob(Job job);

	/**
	 * @param id
	 * @return
	 */
	Job getJobById(Long id);

	/**
	 * @param id
	 * @return
	 */
	boolean deleteJobById(Long id);

	/**
	 * @param id
	 * @param updatedJob
	 * @return
	 */
	boolean updateJobById(Long id, Job updatedJob);

}
