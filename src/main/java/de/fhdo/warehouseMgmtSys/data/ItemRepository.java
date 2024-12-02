package de.fhdo.warehouseMgmtSys.data;

import de.fhdo.warehouseMgmtSys.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
