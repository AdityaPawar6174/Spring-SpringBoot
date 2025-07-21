package com.infosys.Terminal_Service.repository;

import com.infosys.Terminal_Service.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepo extends JpaRepository<Terminal, String> {
    List<Terminal> findByItemType(String itemType);
    boolean existsByTerminalId(String terminalId);
}
