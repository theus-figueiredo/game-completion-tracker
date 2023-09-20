package gameapi.apispring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity //transforma a classe numa entidade no db
@Table(name = "game") //define o nome da tabela no db
public class Game {

  @Id //define que o atributo é a chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) //para gerar o Id de forma sequencial
  private Long id;

  private String title;
  private boolean exclusive;

  @ManyToOne
  private Studio studio;
  @ManyToOne
  private Publisher publisher;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Game game = (Game) o;
    return exclusive == game.exclusive
            && Objects.equals(id, game.id)
            && Objects.equals(title, game.title)
            && Objects.equals(studio, game.studio)
            && Objects.equals(publisher, game.publisher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, exclusive, studio, publisher);
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isExclusive() {
    return exclusive;
  }

  public void setExclusive(boolean exclusive) {
    this.exclusive = exclusive;
  }

  public Studio getStudio() {
    return studio;
  }

  public void setStudio(Studio studio) {
    this.studio = studio;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
}
