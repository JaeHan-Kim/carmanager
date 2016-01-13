package cms.domain;

public class Official {
  protected int offiNO;
  protected int modelNo;
  protected String modelFuel;
  protected float effi;
	
  @Override
	public String toString() {
		return "Official [offiNO=" + offiNO + ", modelNo=" + modelNo + ", modelFuel=" + modelFuel + ", effi=" + effi + "]";
	}
	
  public int getOffiNO() {
		return offiNO;
	}
	
  public void setOffiNO(int offiNO) {
		this.offiNO = offiNO;
	}

  public int getModelNo() {
		return modelNo;
	}

  public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}

  public String getModelFuel() {
		return modelFuel;
	}
	
  public void setModelFuel(String modelFuel) {
		this.modelFuel = modelFuel;
	}
	
  public float getEffi() {
		return effi;
	}

  public void setEffi(float effi) {
		this.effi = effi;
	}
  

}
