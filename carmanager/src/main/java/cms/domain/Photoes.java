package cms.domain;


public class Photoes {
	protected int     photoNo;
	protected int     boardNo;
	protected String  photoPath;
	
	@Override
	public String toString() {
		return "Photoes [photoNo=" + photoNo + ", boardNo=" + boardNo + ", photoPath=" + photoPath + "]";
	}

	public int getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
}
