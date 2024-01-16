package com.daqin.mg.entity;

public class Medicine {
	private int id;
	private String keyid;
	private String name;
	private String desp;
	private byte[] image;
	private String outdate;

	private String outdate_str;
	private String otc;
	private String otc_str;

	private String barcode;
	private int yu;
	private String elabel;
	private String muse;
	private int love;
	private String share;
	private String company;
	private int showflag;

	public String getOutdate_str() {
		return outdate_str;
	}

	public void setOutdate_str(String outdate_str) {
		this.outdate_str = outdate_str;
	}

	public String getOtc_str() {
		return otc_str;
	}

	public void setOtc_str(String otc_str) {
		this.otc_str = otc_str;
	}

	public int getShowflag() {
		return showflag;
	}

	public void setShowflag(int showflag) {
		this.showflag = showflag;
	}

	private int delflag;
	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public Medicine() {

	}

	public Medicine(int id, int uid, String keyid, String name, String desp, byte[] image, String outdate, String otc,
			String barcode, int yu, String elabel, String muse, int love, String share, String company, int delflag,
			int showflag) {
		this.id = id;
		this.uid = uid;
		this.keyid = keyid;
		this.name = name;
		this.desp = desp;
		this.image = image;
		this.outdate = outdate;
		this.otc = otc;
		this.barcode = barcode;
		this.yu = yu;
		this.elabel = elabel;
		this.muse = muse;
		this.love = love;
		this.share = share;
		this.company = company;
		this.delflag = delflag;
		this.showflag = showflag;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyid() {
		return keyid;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public String getOtc() {
		return otc;
	}

	public void setOtc(String otc) {
		this.otc = otc;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getYu() {
		return yu;
	}

	public void setYu(int yu) {
		this.yu = yu;
	}

	public String getElabel() {
		return elabel;
	}

	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	public String getMuse() {
		return muse;
	}

	public void setMuse(String muse) {
		this.muse = muse;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

}
