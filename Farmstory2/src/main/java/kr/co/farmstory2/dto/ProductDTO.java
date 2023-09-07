package kr.co.farmstory2.dto;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDTO {

	private int pNo;
	private int type;
	private String pName;
	private int price;
	private int delivery;
	private int stock;
	private int sold;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String seller;
	private String etc;
	private String rdate;
	private String path;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public ProductDTO() {
	
	}
	
	public ProductDTO(String path) {
		this.path = path;
	}
	
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = Integer.parseInt(pNo);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public String getPriceWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		
		return df.format(price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice(String price) {
		this.price =Integer.parseInt(price);
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public String getDeliveryWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		
		return df.format(delivery);
	}
	
	public void setDelivery(String delivery) {
		this.delivery = Integer.parseInt(delivery);
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setStock(String stock) {
		this.stock = Integer.parseInt(stock);
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1; // 파일 이름 변경 메서드를 여기에 사용함 
	}
	public void setThumb1ForRename(String thumb1) {
		this.thumb1 = fileRename(thumb1); // 파일 이름 변경 메서드를 여기에 사용함 
	}
	public String getThumb2() {
		return thumb2;
	}
	public void setThumb2(String thumb2) {
		this.thumb2 = thumb2;
	}
	public void setThumb2ForRename(String thumb2) {
		this.thumb2 = fileRename(thumb2);
	}
	public String getThumb3() {
		return thumb3;
	}
	public void setThumb3(String thumb3) {
		this.thumb3 = thumb3;
	}
	public void setThumb3ForRename(String thumb3) {
		this.thumb3 = fileRename(thumb3);
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRdateWithoutTime() {
		String date = getRdate();
		String a = date.substring(0, 10);
		return a;
	}
	
	
	
	public String fileRename(String thumb) {
		
		int i = thumb.lastIndexOf(".");
		String ext = thumb.substring(i);
		
		String uuid = UUID.randomUUID().toString(); 
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+thumb);
		File f2 = new File(path+"/"+sName);
		
		if (f1.canRead() && f1.canWrite()) {
		    // 파일에 대한 읽기 및 쓰기 권한이 있는 경우
			f1.renameTo(f2);
		    // renameTo() 호출
		} else {
		    // 파일에 대한 권한이 없는 경우
		    logger.error("renameTo..error");
		}
		
		
		
		return sName; // 메서드 사용하기 위해 sName(saveName)을 리턴 
	}
	
	
	
}
