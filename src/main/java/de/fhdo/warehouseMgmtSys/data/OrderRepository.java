package de.fhdo.warehouseMgmtSys.data;

import de.fhdo.warehouseMgmtSys.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
