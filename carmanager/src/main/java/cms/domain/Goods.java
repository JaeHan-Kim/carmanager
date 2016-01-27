package cms.domain;

public class Goods {

  protected int 	goodsNo;
  protected String 	goodsName;
  protected int 	lifeMile;

  public Goods() {}

  @Override
  public String toString() {
	return "Goods [goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", lifeMile=" + lifeMile + "]";
  }

  public int getGoodsNo() {
	return goodsNo;
  }
  
  public void setGoodsNo(int goodsNo) {
    this.goodsNo = goodsNo;
  }

  public String getGoodsName() {
	return goodsName;
  }

  public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
  }

  public int getLifeMile() {
	return lifeMile;
  }

  public void setLifeMile(int lifeMile) {
	this.lifeMile = lifeMile;
  }
  
}
