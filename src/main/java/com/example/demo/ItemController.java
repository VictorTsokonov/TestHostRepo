package com.example.demo;

import com.example.demo.Entities.Item;
import com.example.demo.Repositories.ItemRepository;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PostMapping
	public Item createItem(@RequestBody String name) {
		Item item = new Item(name);
		return itemRepository.save(item);
	}

	@GetMapping("/all")
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Item not found: " + id));
	}

	@PutMapping("/{id}")
	public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
		return itemRepository.findById(id).map(existingItem -> {
			existingItem.setName(item.getName());
			return itemRepository.save(existingItem);
		}).orElseThrow(() -> new RuntimeException("Item not found: " + id));
	}

	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id) {
		if (!itemRepository.existsById(id)) {
			throw new RuntimeException("Item not found: " + id);
		}
		itemRepository.deleteById(id);
	}

}
