package com.aditya.spring_boot_rest.Repo;

import com.aditya.spring_boot_rest.Model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")),
            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")),
            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost jobPost){
        jobs.add(jobPost);
    }

    public JobPost getJob(int i) {

        for (JobPost job : jobs){
            if (job.getPostId() == i)
                return job;
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobs){
            if (jobPost1.getPostId() == jobPost.getPostId()){
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }


    public void deleteJob(int id) {
        for (JobPost jobPost : jobs){
            if (jobPost.getPostId() == id){
                jobs.remove(id);
            }
        }
    }
}
