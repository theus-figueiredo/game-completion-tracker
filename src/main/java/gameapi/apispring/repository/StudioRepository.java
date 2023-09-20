package gameapi.apispring.repository;

import gameapi.apispring.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Long> { }
