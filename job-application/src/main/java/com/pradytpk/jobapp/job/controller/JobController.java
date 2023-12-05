package com.pradytpk.jobapp.job.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradytpk.jobapp.job.model.Job;
import com.pradytpk.jobapp.job.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	private JobService jobService;

	/**
	 * @param jobService
	 */
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<Iterable<Job>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> createJob(@PathVariable Long id) {

		Job job = jobService.getJobById(id);
		if (job != null) {
			return new ResponseEntity<>(job, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id) {

		if (jobService.deleteJobById(id)) {
			return ResponseEntity.ok("job deleted successfully");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {

		boolean updated = jobService.updateJobById(id, updatedJob);
		if (updated) {
			return new ResponseEntity<>("job updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
