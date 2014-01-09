package org.ratpoisonfactory.slotListviewmvc.model;

public class BcInfoBean {

	private String title = "";
	private String desc = "";
	private int type = 0;
	private String number = "";
	private boolean favoriteYN = false;
	private boolean hideYN = false;
	private String imgAddr = "";

	public BcInfoBean(String title, String desc, int type, String number, boolean favoriteYN, boolean hideYN, String imgAddr) {
		this.title = title;
		this.desc = desc;
		this.type = type;
		this.number = number;
		this.favoriteYN = favoriteYN;
		this.hideYN = hideYN;
		this.imgAddr = imgAddr;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public int getType() {
		return type;
	}

	public boolean isFavoriteYN() {
		return favoriteYN;
	}

	public boolean isHideYN() {
		return hideYN;
	}

	public String getNumber() {
		return number;
	}
	
	public void setFavoriteYN(boolean favoriteYN) {
		this.favoriteYN = favoriteYN;
	}

	public void setHideYN(boolean hideYN) {
		this.hideYN = hideYN;
	}

	public String getImgAddr() {
		return imgAddr;
	}
}
