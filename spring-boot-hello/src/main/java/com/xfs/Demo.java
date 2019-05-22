package com.xfs;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 这个一个测试实体类
 * @author tieshilin
 *
 */
public class Demo {
    public int id;
	public String name;
	
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	public Date createtime;
	
	/**
	 * 不想返回remarks
	 * serialie:是否需要序列化属性
	 */
	@JSONField(serialize=false)
	public String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
