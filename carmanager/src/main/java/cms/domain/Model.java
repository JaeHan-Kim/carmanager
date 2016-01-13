package cms.domain;

public class Model {
  protected int modelNo;
  protected int makerNo;
  protected String modelName;
  protected String fuelType;
  protected float effi;
  
  
  
  @Override
	public String toString() {
		return "Model [modelNo=" + modelNo + ", makerNo=" + makerNo + ", modelName=" + modelName + ", fuelType=" + fuelType
		    + ", effi=" + effi + "]";
	}

	public Model() {
   
  }

	public int getModelNo() {
		return modelNo;
	}

	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}

	public int getMakerNo() {
		return makerNo;
	}

	public void setMakerNo(int makerNo) {
		this.makerNo = makerNo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public float getEffi() {
		return effi;
	}

	public void setEffi(float effi) {
		this.effi = effi;
	}
  
}
