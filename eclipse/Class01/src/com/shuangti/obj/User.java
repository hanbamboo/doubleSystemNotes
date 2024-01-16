package com.shuangti.obj;

public class User {
	private int u_id;
	private String u_name;
	private String u_pwd;
	private int dianquan;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		if (age > 100 || age < 0) {
			this.age = 18;
		}
	}

	public void setDianquan(int dianquan) {
		this.dianquan = dianquan;
	}

	public int getU_id() {
		return u_id;
	}

	public int getDianquan() {
		return dianquan;
	}

	public void QQPay(int dianquan) {
		this.dianquan = dianquan;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

}
