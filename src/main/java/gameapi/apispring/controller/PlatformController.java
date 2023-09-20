package gameapi.apispring.controller;

import gameapi.apispring.model.Platform;
import gameapi.apispring.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/platform")
public class PlatformController {

  private final PlatformService platformService;

  @Autowired
  public PlatformController(PlatformService platformService) {
    this.platformService = platformService;
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Platform> save(@RequestBody Platform platform) {
    Platform new_platform = platformService.store(platform);
    return ResponseEntity.ok(new_platform);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Iterable<Platform>> getAll() {
    Iterable<Platform> allPlatforms = platformService.getAll();
    return ResponseEntity.ok(allPlatforms);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Platform> getById(@PathVariable Long id) {
    Optional<Platform> platform = platformService.getById(id);
    return platform.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }


  @PutMapping("/{id}")
  public ResponseEntity<Platform> update(@PathVariable Long id, @RequestBody Platform new_platform_data) {
    Optional<Platform> updatePlatform = platformService.update(id, new_platform_data);
    return updatePlatform.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deletePlatform(@PathVariable Long id) {
    boolean deleted = platformService.delete(id);

    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
