package delivery_project.com.vo;

public class CategoryVo {
	private int cate_num;
	private String sell_type;
	private int sub;
	public int getCate_num() {
		return cate_num;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	public String getSell_type() {
		return sell_type;
	}
	public void setSell_type(String sell_type) {
		this.sell_type = sell_type;
	}
	public int getSub() {
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "{\"cate_num\":\"" + cate_num + "\",\"sell_type\":\"" + sell_type + "\",\"sub\":\"" + sub
				+ "\"}";
	}
	
}
