package de.fhdo.warehouseMgmtSys.data;

import de.fhdo.warehouseMgmtSys.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
