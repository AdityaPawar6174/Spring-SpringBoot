package com.infosys.Terminal_Service.service;

import com.infosys.Terminal_Service.model.Terminal;
import com.infosys.Terminal_Service.repository.TerminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalService {

    @Autowired
    TerminalRepo terminalRepo;

    public Terminal addTerminal(Terminal terminal) {
        if (terminalRepo.existsById(terminal.getTerminalId())) {
            throw new IllegalArgumentException("Terminal ID already exists");
        }
        return terminalRepo.save(terminal);
    }

    public Terminal getTerminalById(String terminalId) {
        return terminalRepo.findById(terminalId)
                .orElseThrow(() -> new RuntimeException("Terminal not found"));
    }


    public List<Terminal> getTerminalsByType(String itemType) {
        return terminalRepo.findByItemType(itemType);
    }

    public Terminal updateTerminalStatus(String terminalId, String status) {
        Terminal terminal = getTerminalById(terminalId);
        terminal.setStatus(status);
        return terminalRepo.save(terminal);
    }

    public List<Terminal> getAllTerminals() {
        return terminalRepo.findAll();
    }

    public boolean existsById(String terminalId) {
        return terminalRepo.existsById(terminalId);
    }
}
