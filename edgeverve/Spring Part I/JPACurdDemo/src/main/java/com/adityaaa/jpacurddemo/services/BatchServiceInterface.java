package com.adityaaa.jpacurddemo.services;

import com.adityaaa.jpacurddemo.beans.Batches;

import java.util.List;
import java.util.Optional;

public interface BatchServiceInterface {

    public void addBatch(Batches batch);

    public void addMultipleBatches(List<Batches> batchesList);

    public Optional<Batches> findBatchById(int batchId);

    public void updateBatchesOnbasisOfId(int batchId);

    public List<Batches> showAllBatches();

    public void removeBatchById(int batchId);

    public List<Batches> findOnBasisOfBatchName(String batchName);
}
