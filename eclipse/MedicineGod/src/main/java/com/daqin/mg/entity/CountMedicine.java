package com.daqin.mg.entity;

public class CountMedicine {
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private int ok;
	private int out;
	private int near;

	private int otcr;
	private int otcg;
	private int none;
	public int getOtcr() {
		return otcr;
	}

	public void setOtcr(int otcr) {
		this.otcr = otcr;
	}

	public int getOtcg() {
		return otcg;
	}

	public void setOtcg(int otcg) {
		this.otcg = otcg;
	}

	public int getNone() {
		return none;
	}

	public void setNone(int none) {
		this.none = none;
	}

	public int getRx() {
		return rx;
	}

	public void setRx(int rx) {
		this.rx = rx;
	}

	private int rx;

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getNear() {
		return near;
	}

	public void setNear(int near) {
		this.near = near;
	}
}
