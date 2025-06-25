package com.aditya.demoMysqlRest.Repository;

import com.aditya.demoMysqlRest.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudVendorRepo extends JpaRepository<CloudVendor, String> {
}
