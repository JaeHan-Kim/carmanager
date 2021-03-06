package cms.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int          boardNo;
  protected int          memberNo;
  protected String       nickname;
  protected String       title;
  protected String       content;
  protected Timestamp    createdDate;
  protected String       category;
  protected int          likes;
  protected int          views;
  protected String			 photo;
  
  public Board() {}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", nickname=" + nickname + ", title=" + title
		    + ", content=" + content + ", createdDate=" + createdDate + ", category=" + category + ", likes=" + likes
		    + ", views=" + views + ", photo=" + photo + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
  
}