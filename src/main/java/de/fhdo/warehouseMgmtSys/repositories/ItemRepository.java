package de.fhdo.warehouseMgmtSys.repositories;

import de.fhdo.warehouseMgmtSys.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
