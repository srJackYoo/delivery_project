package delivery_project.com.vo;

import java.util.Date;

public class CommentVo {
	private int comment_num;
	private String title;
	private String contents;
	private String img;
	private Date post_time;
	private byte delivery_grade;
	private byte item_grade;
	private byte seller_grade;
	private int menu_num;
	private String member_id;
	private byte state;
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
	public byte getDelivery_grade() {
		return delivery_grade;
	}
	public void setDelivery_grade(byte delivery_grade) {
		this.delivery_grade = delivery_grade;
	}
	public byte getItem_grade() {
		return item_grade;
	}
	public void setItem_grade(byte item_grade) {
		this.item_grade = item_grade;
	}
	public byte getSeller_grade() {
		return seller_grade;
	}
	public void setSeller_grade(byte seller_grade) {
		this.seller_grade = seller_grade;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "{\"comment_num\":\"" + comment_num + "\", \"title\":\"" + title + "\", \"contents\":\""
				+ contents + "\", \"img\":\"" + img + "\", \"post_time\":\"" + post_time + "\", \"delivery_grade\":\""
				+ delivery_grade + "\", \"item_grade\":\"" + item_grade + "\", \"seller_grade\":\"" + seller_grade
				+ "\", \"menu_num\":\"" + menu_num + "\", \"member_id\":\"" + member_id + "\", \"state\":\"" + state
				+ "\"}";
	}
	
}
