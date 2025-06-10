package com.aditya.JobApp.Controller;

import com.aditya.JobApp.Model.JobPost;
import com.aditya.JobApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/", "home"})
    public String home(){
        System.out.println("Home() called");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        System.out.println("addJob() called");
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPost", jobs);
        return "viewalljobs";
    }
}
