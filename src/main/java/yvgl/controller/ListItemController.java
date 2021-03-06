package yvgl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import yvgl.exception.ResourceNotFoundException;
import yvgl.model.ListItem;
import yvgl.repository.ListItemRepository;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class ListItemController {
	
	@Autowired
	ListItemRepository repo;
	
	@PostMapping("/add/listItem")
	public ListItem createListItem(@RequestBody ListItem listItem) {
		repo.save(listItem);
		return listItem;
	}
	
	@GetMapping("listItems")
	public List<ListItem> getAllListItems() {
		return repo.findAll();
	}
	
	@GetMapping("listItems/{id}")
	public ListItem getListItem(@PathVariable long id) throws ResourceNotFoundException {
		Optional<ListItem> optListItem = repo.findById(id);

		if(optListItem.isPresent()) {
			return optListItem.get();
		}
		
		return new ListItem();
	}
	
	@PutMapping("update/listItem/{id}")
	public String updateListItem(@RequestBody ListItem listItem) throws ResourceNotFoundException {
		Optional<ListItem> found = repo.findById(listItem.getId());
		
		if(found.isPresent()) {
			repo.save(listItem);
			return "Saved: " + listItem.toString();
 		} else {
 			return "Could not update list item with id = " +listItem.getId();
 		}
	}
	
	@DeleteMapping("delete/listItems/{id}")
	public long deleteRating(@PathVariable long id) throws ResourceNotFoundException {
		repo.deleteById(id);
		return id;
	}

}
