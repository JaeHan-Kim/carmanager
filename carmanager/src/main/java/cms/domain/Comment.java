package cms.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       commentNo;
  protected int       boardNo;
  protected int       memberNo;
  protected String    content;
  protected String    nickname;
  protected Timestamp createdDate;
  
  public Comment() {}
  
  @Override
  public String toString() {
    return "Comment [commentNo=" + commentNo + ", boardNo=" + boardNo + ", memberNo=" + memberNo + ", content="
        + content + ", nickname=" + nickname + ", createdDate=" + createdDate + "]";
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getCommentNo() {
    return commentNo;
  }

  public void setCommentNo(int commentNo) {
    this.commentNo = commentNo;
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
 
}