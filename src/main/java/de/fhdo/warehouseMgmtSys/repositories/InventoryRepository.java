package de.fhdo.warehouseMgmtSys.repositories;

import de.fhdo.warehouseMgmtSys.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
