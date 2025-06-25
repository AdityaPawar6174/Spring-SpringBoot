package com.aditya.demoMysqlRest.service.implementation;

import com.aditya.demoMysqlRest.Repository.CloudVendorRepo;
import com.aditya.demoMysqlRest.exception.CloudVendorNotFoundException;
import com.aditya.demoMysqlRest.model.CloudVendor;
import com.aditya.demoMysqlRest.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepo cloudVendorRepo;

    public CloudVendorServiceImpl(CloudVendorRepo cloudVendorRepo){
        this.cloudVendorRepo = cloudVendorRepo;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepo.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepo.deleteById(vendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if (cloudVendorRepo.findById(vendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Cloud vendor not found with id: " + vendorId);
        }
        return cloudVendorRepo.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepo.findAll();
    }
}
