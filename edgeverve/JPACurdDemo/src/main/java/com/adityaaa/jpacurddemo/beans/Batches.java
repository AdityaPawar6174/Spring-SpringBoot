package com.adityaaa.jpacurddemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_batches")
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Size(min = 1, message = "Batch id must have 3 characters")
    private @Getter @Setter int batchId;
    /*
    @NotNull --> it will allow 0 and empty values

    @NotEmpty --> check if it's not null and size greater than 0

    @NotBlank --> check if it's not null and trimmed length greater than 0
    **/

    @NotBlank(message = "Batch Name cannot be empty")
    private @Getter @Setter String batchName;
    @NotBlank(message = "Batch Start Date cannot be empty")
    private @Getter @Setter String batchStartDate;
    private @Getter @Setter String batchEndDate;

    public Batches(String batchStartDate, String batchName, String batchEndDate) {
        this.batchStartDate = batchStartDate;
        this.batchName = batchName;
        this.batchEndDate = batchEndDate;
    }

    @Override
    public String toString() {
        return "Batches{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", batchEndDate='" + batchEndDate + '\'' +
                '}';
    }
}
