package com.adityaaa.jpacurddemo.services;

import com.adityaaa.jpacurddemo.beans.Batches;

import java.util.List;

public interface BatchServiceInterface {

    public void addBatch(Batches batch);

    public void addMultipleBatches(List<Batches> batchesList);


//     public List<Batches> showAllBatches();
}
