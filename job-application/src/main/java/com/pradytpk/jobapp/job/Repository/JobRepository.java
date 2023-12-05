/**
 * @author Pradeep Kumar
 *
 */
package com.pradytpk.jobapp.job.Repository;

import org.springframework.data.repository.CrudRepository;

import com.pradytpk.jobapp.job.model.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

}
