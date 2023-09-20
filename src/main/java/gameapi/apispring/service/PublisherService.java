package gameapi.apispring.service;

import gameapi.apispring.model.Publisher;
import gameapi.apispring.repository.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherService {

  private final PublisherRepository publisherRepository;

  @Autowired
  public PublisherService(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }

  public Publisher store(Publisher publisher) {
    publisherRepository.save(publisher);
    return publisher;
  }

  public Iterable<Publisher> getAll() {
    return publisherRepository.findAll();
  }

  public Optional<Publisher> getById(Long id) {
    return publisherRepository.findById(id);
  }

  public Optional<Publisher> update(Long id, Publisher newPublisherData) {
    Optional<Publisher> publisherOptional = publisherRepository.findById(id);

    if (publisherOptional.isPresent()) {
      Publisher publisherToUpdate = publisherOptional.get();
      BeanUtils.copyProperties(newPublisherData, publisherToUpdate, "id");

      Publisher updated = publisherRepository.save(publisherToUpdate);
      return Optional.of(updated);
    }
    return Optional.empty();
  }

  public boolean delete(Long id) {
    Optional<Publisher> publisherOptional = publisherRepository.findById(id);

    if (publisherOptional.isPresent()) {
      publisherRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
