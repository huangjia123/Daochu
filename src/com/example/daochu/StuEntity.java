package com.example.daochu;

/**
 * @author Administrator
 * 
 * 
 */
//���ʵ������
public class StuEntity {
    private String stuId;
    private String stu_name;
    private String macAddress;
    private String class_name;
   
    public String getStu_id() {
		return stuId;
	}
	public void setStu_id(String stuId) {
		this.stuId = stuId;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public StuEntity() {
    }
    public StuEntity(String stu_id, String stu_name, String macAddress, String class_name) {
        this.stuId = stu_id;
        this.stu_name = stu_name;
        this.macAddress = macAddress;
        this.class_name = class_name;
    }
	@Override
	public String toString() {
		return "StuEntity [stuId=" + stuId + ", stu_name=" + stu_name
				+ ", macAddress=" + macAddress + ", class_name=" + class_name
				+ "]";
	} 
    
}
