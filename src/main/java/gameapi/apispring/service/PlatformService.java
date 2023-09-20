package gameapi.apispring.service;

import gameapi.apispring.model.Platform;
import gameapi.apispring.repository.PlatformRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatformService {

  private final PlatformRepository platformRepository;

  @Autowired
  public PlatformService(PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  public Platform store(Platform platform) {
    platformRepository.save(platform);
    return platform;
  }

  public Iterable<Platform> getAll() {
    return platformRepository.findAll();
  }


  public Optional<Platform> getById(Long id) {
    return platformRepository.findById(id);
  }

  public Optional<Platform> update(Long id, Platform new_platform_data) {
    Optional<Platform> platformOptional = platformRepository.findById(id);

    if (platformOptional.isPresent()) {
      Platform platformToUpdate = platformOptional.get();
      BeanUtils.copyProperties(new_platform_data, platformToUpdate , "id");

      Platform updated = platformRepository.save(platformToUpdate);
      return Optional.of(updated);
    }
    return Optional.empty();
  }

  public boolean delete(Long id) {
    Optional<Platform> platformOptional = platformRepository.findById(id);

    if (platformOptional.isPresent()) {
      platformRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
