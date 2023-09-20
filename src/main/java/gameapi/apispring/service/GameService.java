package gameapi.apispring.service;


import gameapi.apispring.dto.GameRequestDto;
import gameapi.apispring.model.Game;
import gameapi.apispring.model.Publisher;
import gameapi.apispring.model.Studio;
import gameapi.apispring.repository.GameRepository;
import gameapi.apispring.repository.PublisherRepository;
import gameapi.apispring.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class GameService {

  private final GameRepository gameRepository;
  private final StudioRepository studioRepository;
  private final PublisherRepository publisherRepository;

  @Autowired
  public GameService(
          GameRepository gameRepository,
          StudioRepository studioRepository,
          PublisherRepository publisherRepository
  ) {
    this.gameRepository = gameRepository;
    this.studioRepository = studioRepository;
    this.publisherRepository = publisherRepository;
  }


  public Game createGame(GameRequestDto gameRequestDto) {
    Studio studio = studioRepository.findById(gameRequestDto.getStudioId())
            .orElseThrow(() -> new EntityNotFoundException("Studio not found"));

    Publisher publisher = publisherRepository.findById(gameRequestDto.getPublisherId())
            .orElseThrow(() -> new EntityNotFoundException("Publisher not found"));

    String title = gameRequestDto.getTitle();
    boolean exclusive = gameRequestDto.isExclusive();

    Game game = new Game(title, exclusive, studio, publisher);
    return gameRepository.save(game);
  }
}
