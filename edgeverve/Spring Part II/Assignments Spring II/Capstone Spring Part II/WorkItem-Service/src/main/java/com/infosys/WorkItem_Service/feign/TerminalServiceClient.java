package com.infosys.WorkItem_Service.feign;

import com.infosys.WorkItem_Service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "terminal-service",
    configuration = FeignConfig.class,
    fallback = TerminalServiceFallback.class
)
public interface TerminalServiceClient {
    @GetMapping("/api/terminals/{terminalId}/validate")
    boolean validateTerminal(@PathVariable String terminalId);
}

// Fallback
@Component
class TerminalServiceFallback implements TerminalServiceClient {
    @Override
    public boolean validateTerminal(String terminalId) {
        return true;
    }
}