package gameapi.apispring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Studio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Studio studio = (Studio) o;
    return Objects.equals(id, studio.id)
            && Objects.equals(name, studio.name);
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
