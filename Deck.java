package javaPoker;

import java.util.Random;
import java.util.Vector;

public class Deck {

	private Vector<Card> allCards;  
	
	public Deck(){
		String[] suits = {"Hearts", "Diamonds", "Clubs","Spades"};
		
		for(int j = 0; j < 4; j++){
			for(int i = 2; i < 15; i++){
				Card c = new Card(i,suits[j]);
				allCards.addElement(c);
			}
		}
	}
	
	public static int RandInt(){
	    Random rand = new Random();
	    
	    int randomNum = rand.nextInt(52);

	    return randomNum;
	}
	
	public void swap(Card first, Card second){
		Card temp = first;
		
		first = second;
		second = temp;
	}
	
	public void deal(int numCards, Vector<Card> hand){
		
		for(int i = 0; i < numCards; i++){
			
			hand.addElement(allCards.get(allCards.size()));
			allCards.remove(allCards.size());
		}
	}
	
	public void shuffle(){
		for(int i = 0; i < 52; i++){
			swap(allCards.get(RandInt()) , allCards.get(RandInt()));
		}
	}
}
