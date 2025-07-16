package com.aditya.spring_boot_rest.controller;

import com.aditya.spring_boot_rest.Model.JobPost;
import com.aditya.spring_boot_rest.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    JobService jobService;

    @GetMapping(path="jobPosts", produces = "application/json")
    public List<JobPost> getAllJobs(){
         return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable("id") int id){
        return jobService.getJob(id);
    }

    @PostMapping(path = "jobPost", consumes = {"application/xml"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
        return "Deleted jobSuccessfully";
    }
}
