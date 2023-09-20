package gameapi.apispring.controller;

import gameapi.apispring.model.Publisher;
import gameapi.apispring.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

  private final PublisherService publisherService;

  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Publisher> save(@RequestBody Publisher publisher) {
    Publisher newPublisher = publisherService.store(publisher);
    return ResponseEntity.ok(newPublisher);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Iterable<Publisher>> getAll() {
    Iterable<Publisher> allPublishers = publisherService.getAll();
    return ResponseEntity.ok(allPublishers);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Publisher> getById(@PathVariable Long id) {
    Optional<Publisher> publisher = publisherService.getById(id);
    return publisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Publisher> update(@PathVariable Long id, @RequestBody Publisher newPublisherData) {
    Optional<Publisher> updatedPublisher = publisherService.update(id, newPublisherData);
    return updatedPublisher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
    boolean deleted = publisherService.delete(id);

    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
  }
}
