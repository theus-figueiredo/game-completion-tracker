package gameapi.apispring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "games_to_play")
public class WantToPlay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Game game;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WantToPlay that = (WantToPlay) o;
    return Objects.equals(id, that.id) && Objects.equals(game, that.game);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, game);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
