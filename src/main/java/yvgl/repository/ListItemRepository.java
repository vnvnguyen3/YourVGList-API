package yvgl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yvgl.model.ListItem;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long>{
	
	Optional<ListItem> findById(Long id);
}
