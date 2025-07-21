package com.infosys.WorkItem_Service.feign;

import com.infosys.WorkItem_Service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "user-service",
    configuration = FeignConfig.class,
    fallback = UserServiceFallback.class
)
public interface UserServiceClient {
    @GetMapping("/api/users/{userId}/validate")
    boolean validateUser(@PathVariable Long userId);
}

@Component
class UserServiceFallback implements UserServiceClient {
    @Override
    public boolean validateUser(Long userId) {
        return true; // Fallback logic
    }
}