package gameapi.apispring.controller;

import gameapi.apispring.model.Studio;
import gameapi.apispring.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/studio")
public class StudioController {

  private final StudioService studioService;

  @Autowired
  public StudioController(StudioService studioService) {
    this.studioService = studioService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Studio> save(@RequestBody Studio studio) {
    Studio newStudio = studioService.store(studio);
    return ResponseEntity.ok(newStudio);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Iterable<Studio>> getAll() {
    Iterable<Studio> allStudios = studioService.getAll();
    return ResponseEntity.ok(allStudios);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Studio> getById(@PathVariable Long id) {
    Optional<Studio> studio = studioService.getById(id);
    return studio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Studio> update(@PathVariable Long id, @RequestBody Studio newStudioData) {
    Optional<Studio> updatedStudio = studioService.update(id, newStudioData);
    return updatedStudio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deleteStudio(@PathVariable Long id) {
    boolean deleted = studioService.delete(id);

    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
