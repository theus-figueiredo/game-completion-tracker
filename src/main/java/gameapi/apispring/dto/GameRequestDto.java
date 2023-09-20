package gameapi.apispring.dto;

public class GameRequestDto {
  private String title;
  private boolean exclusive;
  private Long studioId;
  private Long publisherId;

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

  public Long getStudioId() {
    return studioId;
  }

  public void setStudioId(Long studioId) {
    this.studioId = studioId;
  }

  public Long getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(Long publisherId) {
    this.publisherId = publisherId;
  }
}
