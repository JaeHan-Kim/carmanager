package cms.domain;

public class Makers {
  protected int makerNo;
  protected String makerName;
  
  public Makers() {
   
  }
  
	@Override
	public String toString() {
		return "Makers [makerNo=" + makerNo + ", makerName=" + makerName + "]";
	}

	public int getMakerNo() {
		return makerNo;
	}

	public void setMakerNo(int makerNo) {
		this.makerNo = makerNo;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	} 
  
}
