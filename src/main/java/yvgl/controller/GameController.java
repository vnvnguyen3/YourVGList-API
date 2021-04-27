package yvgl.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import yvgl.model.Game;
import yvgl.repository.GameRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

	@Autowired
	GameRepository repo;
	
	@PostMapping("/add/game")
	public Game createGame(@RequestBody Game game) {
		repo.save(game);
		return game;
	}

	@GetMapping("games")
	public List<Game> getAllGames(){
		return repo.findAll();
	}
	
	@GetMapping("games/{id}")
	public Game getGame(@PathVariable long id) {
		Optional<Game> optGame = repo.findById(id);
		
		if(optGame.isPresent()) {
			return optGame.get();
		}
		
		return new Game();
	}
	
	@GetMapping("games/platform/{platform}")
	public List<Game> getGameByPlatform(@PathVariable String platform) {
		return repo.findByPlatform(platform);
	}
	
	@PutMapping("update/game/{id}")
	public String updateGame(@RequestBody Game game) {
		Optional<Game> found = repo.findByID(game.getId());
		
		if(found.isPresent()) {
			repo.save(game);
			return "Saved: = " + game.toString();
		}else {
			return "Could not update game with id = " + game.getId();
		}
	}
	
	@PatchMapping("update/game/{title}")
	public String updateTitle(@RequestBody Map<String, String> titleUpdate) {
		long id = Long.parseLong(titleUpdate.get("id"));
		String title = titleUpdate.get("title");
		
		Optional<Game> found = repo.findByID(id);
		
		if(found.isPresent()) {
			Game toUpdate = found.get();
			toUpdate.setTitle(title);
			repo.save(toUpdate);
			return title;
		} else {
			return "Could not find game with id = " + id;
		}
	}
	
	@DeleteMapping("/delete/game/{id}")
	public ResponseEntity<String> deleteGame(@PathVariable long id) {
		Optional<Game> found = repo.findByID(id);
		
		if(found.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(200).body("Deleted game with id = " + id);
		} else {
			return ResponseEntity.status(404).body("Game with id = " + id + " not found.");
		}
	}
	
}
