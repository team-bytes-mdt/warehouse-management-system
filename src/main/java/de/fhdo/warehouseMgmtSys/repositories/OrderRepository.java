package de.fhdo.warehouseMgmtSys.repositories;

import de.fhdo.warehouseMgmtSys.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
