package cms.domain;

import java.sql.Date;

public class Refuel {
  protected int refuelNo;
  protected int myCarNo;
  protected Date refuelDate;
  protected int mile;
  protected int cost;
  protected float liter;
  protected String group_date;
  protected String nickName;
  protected float effi;
  protected int literCost;
  protected String fuelName;
  
  public Refuel() {
   
  }

  public Refuel(String fuelName) {
    this.fuelName = fuelName;
  }
  

  @Override
  public String toString() {
    return "Refuel [refuelNo=" + refuelNo + ", myCarNo=" + myCarNo + ", refuelDate=" + refuelDate + ", mile=" + mile
        + ", cost=" + cost + ", liter=" + liter + ", group_date=" + group_date + ", nickName=" + nickName + ", effi="
        + effi + ", literCost=" + literCost + ", fuelName=" + fuelName + "]";
  }

  public String getFuelName() {
    return fuelName;
  }

  public void setFuelName(String fuelName) {
    this.fuelName = fuelName;
  }

  public int getLiterCost() {
    return literCost;
  }

  public void setLiterCost(int literCost) {
    this.literCost = literCost;
  }

  public String getGroup_date() {
    return group_date;
  }

  public void setGroup_date(String group_date) {
    this.group_date = group_date;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public float getEffi() {
    return effi;
  }

  public void setEffi(float effi) {
    this.effi = effi;
  }

  public int getRefuelNo() {
    return refuelNo;
  }

  public void setRefuelNo(int refuelNo) {
    this.refuelNo = refuelNo;
  }

  public int getMyCarNo() {
    return myCarNo;
  }

  public void setMyCarNo(int myCarNo) {
    this.myCarNo = myCarNo;
  }

  public Date getRefuelDate() {
    return refuelDate;
  }

  public void setRefuelDate(Date refuelDate) {
    this.refuelDate = refuelDate;
  }

  public int getMile() {
    return mile;
  }

  public void setMile(int mile) {
    this.mile = mile;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public float getLiter() {
    return liter;
  }

  public void setLiter(float liter) {
    this.liter = liter;
  }
  
}
