package com.imooc.cardgame;

import java.util.*;


public class PokerShuffleCards {

	public static void main(String[] args) {
		//准备花色
		ArrayList<String> cOLORS = new ArrayList<String>();
		
		//添加花色
		cOLORS.add("♠");
		cOLORS.add("♥");
		cOLORS.add("♣");
		cOLORS.add("◆");
		
		//创建扑克牌点数序列(A-2)
		ArrayList<String> numberStrings = new ArrayList<String>();
		
		//添加扑克牌元素
		for (int i = 1; i < 14; i++) {
			switch(i) {
			case 1:
				numberStrings.add("A");
				break;
			case 11:
				numberStrings.add("J");
				break;
			case 12:
				numberStrings.add("Q");
				break;
			case 13:
				numberStrings.add("K");
				break;
			default:
				numberStrings.add(i + "");
				break;
			}
		}
		
		//生成扑克牌
		HashMap<Integer,Card> map = new HashMap<Integer, Card>();
		int index = 0;
		for (String number : numberStrings) {
			for (String color : cOLORS) {
				map.put(index++, new Card(number, color));
			}
		}
		
		
		
		//向扑克牌中加入大小王，用于形成一副牌
		map.put(index++,new Card("","小王")); 
		map.put(index++,new Card("","大王"));

		//生成一副牌
		ArrayList <Card> cards = new ArrayList<Card>();
		Iterator iterator = map.entrySet().iterator();
		int index1 = 0;
		while (iterator.hasNext()) {
			Map.Entry<Integer,Card> entry =(Map.Entry<Integer,Card>)iterator.next();
			cards.add(entry.getValue());
		}

		//生成三名玩家和底牌
		ArrayList<Card> iPlayer1 = new ArrayList<Card>();
		ArrayList<Card> iPlayer2 = new ArrayList<Card>();
		ArrayList<Card> iPlayer3 = new ArrayList<Card>();
		ArrayList<Card> Finally = new ArrayList<Card>();
		//发牌
		//打乱顺序
		Collections.shuffle(cards);

		for (int i = cards.size() -1; i > 0 ;i--) {
			if (i > cards.size() - 4) {
				Finally.add(cards.get(i));
			}	else {
				int a = i % 3;
				if (a == 0) {
					iPlayer1.add(cards.get(i));

				}

				else if (a == 1){
					iPlayer2.add(cards.get(i));

				}
				else{
					iPlayer3.add(cards.get(i));

				}
			}


		}

		//展示手牌
		for(Card card : iPlayer1) {
			card.cardShow();
		}
		System.out.println("\n");

		for(Card card : iPlayer2) {
			card.cardShow();
		}

		System.out.println("\n");

		for(Card card : iPlayer3) {
			card.cardShow();
		}
		System.out.println("\n" + "底牌：");

		for(Card card : Finally) {
			card.cardShow();
		}

	}

}
