package gameapi.apispring.repository;

import gameapi.apispring.model.WantToPlay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WantToPlayRepository extends JpaRepository<WantToPlay, Long> { }
