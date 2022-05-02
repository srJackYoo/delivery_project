package delivery_project.com.vo;

import java.util.Date;

public class MenuVo {
	private int menu_num;
	private String name;
	private int price;
	private String menu_detail;
	private String menu_img;
	private String detail_img;
	private Date post_date;
	private int shop_num;
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu_detail() {
		return menu_detail;
	}
	public void setMenu_detail(String menu_detail) {
		this.menu_detail = menu_detail;
	}
	public String getMenu_img() {
		return menu_img;
	}
	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	@Override
	public String toString() {
		return "{\"menu_num\":\"" + menu_num + "\", \"name\":\"" + name + "\", \"price\":\"" + price
				+ "\", \"menu_detail\":\"" + menu_detail + "\", \"menu_img\":\"" + menu_img + "\", \"detail_img\":\""
				+ detail_img + "\", \"post_date\":\"" + post_date + "\", \"shop_num\":\"" + shop_num + "\"}";
	}
	
}
