package cms.domain;

public class Garage {
  protected int myCarNo;
  protected int modelNo;
  protected String maker;
  protected int memberNo;
  protected String nickName;
  protected String model;
  protected String deailModel;
  protected float effi;
  protected int mile;
  
  
  public Garage() {
   
  }
  
  

  @Override
	public String toString() {
		return "Garage [myCarNo=" + myCarNo + ", modelNo=" + modelNo + ", maker=" + maker + ", memberNo=" + memberNo
		    + ", nickName=" + nickName + ", model=" + model + ", deailModel=" + deailModel + ", effi=" + effi + ", mile="
		    + mile + "]";
	}



	public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }



  public void setMaker(String maker) {
    this.maker = maker;
  }



  public String getDeailModel() {
		return deailModel;
	}



	public void setDeailModel(String deailModel) {
		this.deailModel = deailModel;
	}


	public float getEffi() {
		return effi;
	}

	public void setEffi(float effi) {
		this.effi = effi;
	}

	public int getMyCarNo() {
    return myCarNo;
  }

  public void setMyCarNo(int myCarNo) {
    this.myCarNo = myCarNo;
  }

  public int getModelNo() {
    return modelNo;
  }

  public void setModelNo(int modelNo) {
    this.modelNo = modelNo;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getMile() {
    return mile;
  }

  public void setMile(int mile) {
    this.mile = mile;
  }
  
  
  
  
}
