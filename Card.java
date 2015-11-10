package javaPoker;

public class Card {
 
	private int number;
	private String suit;
	
	public Card(int num, String sut){
		setNumber(num);
		setSuit(sut);
	}
	
	public void setNumber(int num){
		number = num;
	}
	public void setSuit(String sut){
		suit = sut;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public void print(){
		if (getNumber() == 11){
			System.out.printf("J of ", getSuit());
		}
		
		else if(getNumber() == 12){
			System.out.printf("Q of ", getSuit());
		}
		
		else if(getNumber() == 13){
			System.out.printf("K of ", getSuit());
		}
		
		else if(getNumber() == 14){
			System.out.printf("A of ", getSuit());
		}
		
		else{
			System.out.println(getNumber());
			System.out.printf(" of ", getSuit());
		}
		
	}
	
}
