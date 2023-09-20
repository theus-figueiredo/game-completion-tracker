package gameapi.apispring.repository;

import gameapi.apispring.model.PlayedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayedGameRepository extends JpaRepository<PlayedGame, Long> { }
