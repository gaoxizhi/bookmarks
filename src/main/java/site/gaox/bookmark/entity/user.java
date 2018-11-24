package site.gaox.bookmark.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class user {
	
	/** 我们不想返回name? serialize:是否需要序列化属性.*/
	@JSONField(serialize=false)
	private int id;
	//com.alibaba.fastjson.annotation.JSONField
	@JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
	private Date bDate;

	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
