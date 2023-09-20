package gameapi.apispring.controller;

import gameapi.apispring.model.Platform;
import gameapi.apispring.repository.PlatformRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/platform")
public class PlatformController {

  @Autowired
  private PlatformRepository platformRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Platform> save(@RequestBody Platform platform) {
    platformRepository.save(platform);
    return ResponseEntity.ok(platform);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Iterable<Platform>> getAll() {
    Iterable<Platform> allPlatforms = platformRepository.findAll();
    return ResponseEntity.ok(allPlatforms);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Platform getById(@PathVariable Long id) {
    return platformRepository.findById(id).orElse(new Platform());
  }


  @PutMapping("/{id}")
  public ResponseEntity<Platform> update(@PathVariable Long id, @RequestBody Platform new_platform_data) {
    Optional<Platform> platformToUpdateOptional = platformRepository.findById(id);

    if (platformToUpdateOptional.isPresent()) {
      Platform platformToUpdate = platformToUpdateOptional.get();
      BeanUtils.copyProperties(new_platform_data, platformToUpdate, "id");

      Platform updated = platformRepository.save(platformToUpdate);
      return ResponseEntity.ok(updated);
    }
    return ResponseEntity.notFound().build();
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deletePlatform(@PathVariable Long id) {
    Optional<Platform> OptionalPlatformToDelete = platformRepository.findById(id);

    if (OptionalPlatformToDelete.isPresent()) {
      platformRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }
}
