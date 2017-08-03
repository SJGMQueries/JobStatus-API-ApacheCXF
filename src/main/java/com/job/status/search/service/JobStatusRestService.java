package com.job.status.search.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jobStatusRestService")
public interface JobStatusRestService {
	@Path("/getStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public JobStatusResponse getStatus(JobStatusRequest request);
}
