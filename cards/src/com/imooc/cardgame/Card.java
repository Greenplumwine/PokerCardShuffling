package com.imooc.cardgame;


public class Card {
	/**
	 * 点数
	 */
	private String POINTS;
	

	private String COLOR;

	public String getPOINTS() {
		return POINTS;
	}

	public void setPOINTS(String pOINTS) {
		POINTS = pOINTS;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	
	public Card(String points,String color) {
		setPOINTS(points);
		setCOLOR(color);
	}
	
	
	
	/**
	 * 展示牌
	 */
	public void cardShow() {
		String formatString = String.format("[%s   %s]", getCOLOR(),getPOINTS());
		System.out.print(formatString + "\t");
	}
}
