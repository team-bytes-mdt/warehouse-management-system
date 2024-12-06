package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.repositories.InventoryRepository;
import de.fhdo.warehouseMgmtSys.repositories.ItemRepository;
import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    public InventoryService(InventoryRepository inventoryRepository, ItemRepository itemRepository) {
        this.inventoryRepository = inventoryRepository;
        this.itemRepository = itemRepository;
    }

    /**
     *Inventory Service
     */
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventoryById(Long id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory updateInventoryById(Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(inventory.getId()).orElse(null);
        if (existingInventory != null) {
            Inventory updatedInventory = new Inventory();
            updatedInventory.setId(inventory.getId());
            updatedInventory.setLocation(inventory.getLocation());
            updatedInventory.setLast_updated_date(inventory.getLast_updated_date());
            return inventoryRepository.save(updatedInventory);
        }
        return null;
    }

    /**
     * Item Service methods (Functional Requirements)
     */
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).orElse(null);
        if (existingItem != null) {

        }
        return itemRepository.save(item);
    }

    public Item updateItem(Item item) {
        Item itemToUpdate = itemRepository.findById(item.getId()).orElse(null);
        if (itemToUpdate != null) {
            Item newItem = new Item();
            newItem.setId(itemToUpdate.getId());
            newItem.setName(item.getName());
            newItem.setDescription(item.getDescription());
            newItem.setPrice(item.getPrice());
            return itemRepository.save(newItem);
        }
        return null;
    }

    public void removeItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public Object getStockLevels(long id) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            return String.format("Stock level for item ID %d is %d.", id, existingItem.getQuantity());
        }
        return String.format("Item with ID %d not found.", id);
    }

    public String trackStockLevels(long id, int quantity) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            int newQuantity = existingItem.getQuantity() + quantity;
            existingItem.setQuantity(newQuantity);
            itemRepository.save(existingItem);
            return String.format("Stock level for item ID %d increased by %d. New stock: %d", id, quantity, newQuantity);
        }
        return String.format("Item with ID %d not found.", id);
    }


}
