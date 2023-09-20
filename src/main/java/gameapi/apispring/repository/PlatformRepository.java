package gameapi.apispring.repository;

import gameapi.apispring.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> { }
