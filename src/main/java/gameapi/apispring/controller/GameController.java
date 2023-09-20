package gameapi.apispring.controller;


import gameapi.apispring.dto.GameRequestDto;
import gameapi.apispring.model.Game;
import gameapi.apispring.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

  public final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Game> createGame(@RequestBody GameRequestDto gameRequestDto) {
    Game new_game = gameService.createGame(gameRequestDto);
    return ResponseEntity.ok(new_game);
  }
}
