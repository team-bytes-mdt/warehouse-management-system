package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.domain.InventoryRoom;
import de.fhdo.warehouseMgmtSys.repositories.InventoryRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryRoomService {

    private final InventoryRoomRepository inventoryRoomRepository;

    public InventoryRoomService(InventoryRoomRepository inventoryRoomRepository) {
        this.inventoryRoomRepository = inventoryRoomRepository;
    }

    /**
     *InventoryRoom Service
     */
    public List<InventoryRoom> getAllInventories() {
        return inventoryRoomRepository.findAll();
    }

    public Optional<InventoryRoom> getInventoryById(Long id) {
        return inventoryRoomRepository.findById(id);
    }

    public InventoryRoom createInventory(InventoryRoom inventory) {
        return inventoryRoomRepository.save(inventory);
    }

    public boolean deleteInventoryById(Long id) {
        if(inventoryRoomRepository.existsById(id)) {
            inventoryRoomRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<InventoryRoom> updateInventoryById(long id, InventoryRoom inventory) {

        return inventoryRoomRepository.findById(id).map(existing -> {
            existing.setLocation(inventory.getLocation());
            existing.setLastUpdatedDate(inventory.getLastUpdatedDate());
            return inventoryRoomRepository.save(existing);
        });
    }




}
