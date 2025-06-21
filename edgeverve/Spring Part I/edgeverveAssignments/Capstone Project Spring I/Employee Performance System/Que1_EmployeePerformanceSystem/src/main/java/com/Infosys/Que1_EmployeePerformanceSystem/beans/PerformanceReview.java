package com.Infosys.Que1_EmployeePerformanceSystem.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "performance_review")
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotBlank(message = "Rating should be provided")
    private int rating;
    @Column(name = "review_date")
//    @NotBlank(message = "Review date should be provided in the Format (yyyy-mm-dd)")
    private Date reviewDate;
//    @NotBlank(message = "Remarks should be provided")
    private String remarks;

    // Foreign key to Employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PerformanceReview{" +
                "id=" + id +
                ", rating=" + rating +
                ", reviewDate='" + reviewDate + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
