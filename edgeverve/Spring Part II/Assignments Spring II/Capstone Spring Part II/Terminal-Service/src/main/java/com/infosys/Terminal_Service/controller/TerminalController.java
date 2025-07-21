package com.infosys.Terminal_Service.controller;

import com.infosys.Terminal_Service.model.Terminal;
import com.infosys.Terminal_Service.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terminals")
public class TerminalController {
    @Autowired
    TerminalService terminalService;

    @PostMapping
    public ResponseEntity<Terminal> createTerminal(@RequestBody Terminal terminal) {
        return ResponseEntity.ok(terminalService.addTerminal(terminal));
    }

    @GetMapping("/{terminalId}")
    public ResponseEntity<Terminal> getTerminalById(@PathVariable String terminalId) {
        return ResponseEntity.ok(terminalService.getTerminalById(terminalId));
    }

    @GetMapping
    public ResponseEntity<List<Terminal>> getTerminalsByType(@RequestParam String itemType) {
        return ResponseEntity.ok(terminalService.getTerminalsByType(itemType));
    }

    @PutMapping("/{terminalId}/status")
    public ResponseEntity<Terminal> updateTerminalStatus(
            @PathVariable String terminalId,
            @RequestParam String status) {
        return ResponseEntity.ok(terminalService.updateTerminalStatus(terminalId, status));
    }

    @GetMapping("/{terminalId}/validate")
    public ResponseEntity<Boolean> validateTerminal(@PathVariable String terminalId) {
        boolean exists = terminalService.existsById(terminalId);
        return ResponseEntity.ok(exists);
    }


    @GetMapping("/all")
    public List<Terminal> getAllTerminal(){
        return terminalService.getAllTerminals();
    }
}
