package com.adityaaa.jpacurddemo.services;

import com.adityaaa.jpacurddemo.beans.Batches;
import com.adityaaa.jpacurddemo.repos.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BatchServices implements BatchServiceInterface{
    @Autowired
    BatchRepo batchRepo;

    @Override
    public void addBatch(Batches batch) {
        batchRepo.save(batch);
    }

    @Override
    public void addMultipleBatches(List<Batches> batchesList) {
        Iterable<Batches> batchInfo = batchRepo.saveAll(batchesList);
    }

    @Override
    public Optional<Batches> findBatchById(int batchId) {
        return batchRepo.findById(batchId);
    }

    @Override
    public void updateBatchesOnbasisOfId(int batchId) {

        try {
            Optional<Batches> optional = batchRepo.findById(batchId);
            Batches batch = optional.get();

            if (batch != null) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter New Start Date");
                String newStartDate = sc.next();
                System.out.println("Enter New End Date");
                String newEndDate = sc.next();
                batch.setBatchStartDate(newStartDate);
                batch.setBatchEndDate(newEndDate);
                batchRepo.save(batch);
            }
        }
        catch (Exception e){
            System.err.println("Batch Id not Found...! In the Update Batch In Service"+e);
        }
    }

    @Override
    public List<Batches> showAllBatches() {
        List<Batches> batchesList =  batchRepo.findAll();
        return batchesList;
    }

    @Override
    public void removeBatchById(int batchId) {
        try{
            batchRepo.deleteById(batchId);
        }
        catch (Exception e){
            System.err.println("Id is invalid..."+e);
        }
    }

    @Override
    public List<Batches> findOnBasisOfBatchName(String batchName) {
        return batchRepo.findByBatchName(batchName);
    }


}
