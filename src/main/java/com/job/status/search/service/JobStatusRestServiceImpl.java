package com.job.status.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("jobStatusRestService")
public class JobStatusRestServiceImpl implements JobStatusRestService {

	public JobStatusResponse getStatus(JobStatusRequest request) {
		List<Job> jobs = request.getJobs();
		JobStatusResponse response = new JobStatusResponse();
		if (jobs.toString().contains("Not Ok")) {
			response.setFlag(false);
			response.setInaccessibility(findRepeatStatus(request)
					+ "(status is other than OK)");
		} else {
			response.setFlag(true);
		}
		return response;
	}

	private int findRepeatStatus(JobStatusRequest request) {
		int count = 0;
		for (Job job : request.getJobs()) {
			if (job.getStatus().equalsIgnoreCase("Not Ok")) {
				count++;
			}
		}
		return count;
	}
}
