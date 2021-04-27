package yvgl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yvgl.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	Optional<Game> findByID(Long id);
	
	List<Game> findByPlatform(String platform);

}
