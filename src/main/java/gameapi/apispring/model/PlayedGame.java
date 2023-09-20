package gameapi.apispring.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "played_game")
public class PlayedGame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private boolean finished;
  private int completionRate;
  private double grade;
  private String toughts;

  @ManyToOne
  private Platform platformPlayed;
  @OneToOne
  private Game game;
  @Temporal(TemporalType.DATE)
  private Date completedAt;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayedGame that = (PlayedGame) o;
    return finished == that.finished
            && completionRate == that.completionRate
            && Double.compare(grade, that.grade) == 0
            && Objects.equals(id, that.id)
            && Objects.equals(platformPlayed, that.platformPlayed)
            && Objects.equals(completedAt, that.completedAt)
            && Objects.equals(game, that.game)
            && Objects.equals(toughts, that.toughts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, finished, completionRate, grade, platformPlayed, completedAt, game);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public int getCompletionRate() {
    return completionRate;
  }

  public void setCompletionRate(int completionRate) {
    this.completionRate = completionRate;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  public Platform getPlatformPlayed() {
    return platformPlayed;
  }

  public String getToughts() {
    return toughts;
  }

  public void setToughts(String toughts) {
    this.toughts = toughts;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void setPlatformPlayed(Platform platformPlayed) {
    this.platformPlayed = platformPlayed;
  }

  public Date getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(Date completedAt) {
    this.completedAt = completedAt;
  }
}
