package com.aditya.demoMysqlRest.service;

import com.aditya.demoMysqlRest.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);

    public String updateCloudVendor(CloudVendor cloudVendor);

    public String deleteCloudVendor(String vendorId);

    public CloudVendor getCloudVendor(String vendorId);

    public List<CloudVendor> getAllCloudVendors();
}
