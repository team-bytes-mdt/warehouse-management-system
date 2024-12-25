package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.repositories.InventoryRepository;
import de.fhdo.warehouseMgmtSys.repositories.ItemRepository;
import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     *Inventory Service
     */
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public boolean deleteInventoryById(Long id) {
        if(inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<Inventory> updateInventoryById(long id, Inventory inventory) {

        return inventoryRepository.findById(id).map(existing -> {
            existing.setLocation(inventory.getLocation());
            existing.setLast_updated_date(inventory.getLast_updated_date());
            return inventoryRepository.save(existing);
        });
    }




}
