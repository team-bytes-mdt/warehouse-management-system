package de.fhdo.warehouseMgmtSys.data;

import de.fhdo.warehouseMgmtSys.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
