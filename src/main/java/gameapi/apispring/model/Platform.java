package gameapi.apispring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Platform {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Platform platform = (Platform) o;
    return Objects.equals(id, platform.id)
            && Objects.equals(name, platform.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
