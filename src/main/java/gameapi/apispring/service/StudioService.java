package gameapi.apispring.service;

import gameapi.apispring.model.Studio;
import gameapi.apispring.repository.StudioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudioService {

  private final StudioRepository studioRepository;

  @Autowired
  public StudioService(StudioRepository studioRepository) {
    this.studioRepository = studioRepository;
  }

  public Studio store(Studio studio) {
    studioRepository.save(studio);
    return studio;
  }

  public Iterable<Studio> getAll() {
    return studioRepository.findAll();
  }

  public Optional<Studio> getById(Long id) {
    return studioRepository.findById(id);
  }

  public Optional<Studio> update(Long id, Studio newStudioData) {
    Optional<Studio> studioOptional = studioRepository.findById(id);

    if (studioOptional.isPresent()) {
      Studio studioToUpdate = studioOptional.get();
      BeanUtils.copyProperties(newStudioData, studioToUpdate, "id");

      Studio updated = studioRepository.save(studioToUpdate);
      return Optional.of(updated);
    }
    return Optional.empty();
  }

  public boolean delete(Long id) {
    Optional<Studio> studioOptional = studioRepository.findById(id);

    if (studioOptional.isPresent()) {
      studioRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
