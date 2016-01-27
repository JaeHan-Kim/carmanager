package cms.domain;

import java.sql.Date;

public class MyGoods {

  protected int  mygoodsNo;
  protected int  garageNo;
  protected int  goodsNo;
  protected int  changeMile;
  protected Date changeDate;
  
  public MyGoods() {}
  
  @Override
  public String toString() {
	return "MyGoods [mygoodsNo=" + mygoodsNo + ", garageNo=" + garageNo + ", goodsNo=" + goodsNo + ", changeMile="
			+ changeMile + ", changeDate=" + changeDate + "]";
  }

  public int getMygoodsNo() {
	return mygoodsNo;
  }

  public void setMygoodsNo(int mygoodsNo) {
	this.mygoodsNo = mygoodsNo;
  }

  public int getGarageNo() {
	return garageNo;
  }

  public void setGarageNo(int garageNo) {
	this.garageNo = garageNo;
  }

  public int getGoodsNo() {
	return goodsNo;
  }

  public void setGoodsNo(int goodsNo) {
	this.goodsNo = goodsNo;
  }

  public int getChangeMile() {
	return changeMile;
  }

  public void setChangeMile(int changeMile) {
	this.changeMile = changeMile;
  }

  public Date getChangeDate() {
	return changeDate;
  }

  public void setChangeDate(Date changeDate) {
	this.changeDate = changeDate;
  }

}