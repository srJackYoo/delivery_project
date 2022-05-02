package delivery_project.com.vo;

public class ShopListVo {
	private int shop_num;
	private String seller_id;
	private String shop_name;
	private String location;
	private String shop_phone;
	private int update_month;
	private String open_time;
	private String close_time;
	private String sell_type;
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	public int getUpdate_month() {
		return update_month;
	}
	public void setUpdate_month(int update_month) {
		this.update_month = update_month;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getClose_time() {
		return close_time;
	}
	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}
	public String getSell_type() {
		return sell_type;
	}
	public void setSell_type(String sell_type) {
		this.sell_type = sell_type;
	}
	@Override
	public String toString() {
		return "{\"shop_num\":\"" + shop_num + "\",\"seller_id\":\"" + seller_id + "\",\"shop_name\":\""
				+ shop_name + "\",\"location\":\"" + location + "\",\"shop_phone\":\"" + shop_phone
				+ "\",\"update_month\":\"" + update_month + "\",\"open_time\":\"" + open_time + "\",\"close_time\":\""
				+ close_time + "\",\"sell_type\":\"" + sell_type + "\"}";
	}
	
	
}
