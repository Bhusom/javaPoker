package javaPoker;

import java.util.Vector;

public class Eval {
	
	private int royalFlush;
	private int straightFlush;
	private int fourKind;
	private int fullHouse;
	private int flush;
	private int straight;
	private int threeKind;
	private int twoPair;
	private int pair;
	private int highCard;

	private int numHands;
	private int numCards;
	
	
	public int getRoyalFlush() {
		return royalFlush;
	}

	public void setRoyalFlush(int royalFlush) {
		this.royalFlush = royalFlush;
	}

	public int getStraightFlush() {
		return straightFlush;
	}

	public void setStraightFlush(int straightFlush) {
		this.straightFlush = straightFlush;
	}

	public int getFourKind() {
		return fourKind;
	}

	public void setFourKind(int fourKind) {
		this.fourKind = fourKind;
	}

	public int getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}

	public int getFlush() {
		return flush;
	}

	public void setFlush(int flush) {
		this.flush = flush;
	}

	public int getStraight() {
		return straight;
	}

	public void setStraight(int straight) {
		this.straight = straight;
	}

	public int getThreeKind() {
		return threeKind;
	}

	public void setThreeKind(int threeKind) {
		this.threeKind = threeKind;
	}

	public int getTwoPair() {
		return twoPair;
	}

	public void setTwoPair(int twoPair) {
		this.twoPair = twoPair;
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair) {
		this.pair = pair;
	}

	public int getHighCard() {
		return highCard;
	}

	public void setHighCard(int highCard) {
		this.highCard = highCard;
	}

	public Eval(int nc){
		royalFlush = 0;
		straightFlush = 0;
		fourKind = 0;
		fullHouse = 0;
		flush = 0;
		straight = 0;
		threeKind = 0;
		twoPair = 0;
		pair = 0;
		highCard = 0;

		setNumCards(nc);
		
	}

	public void setNumHands(int nh){
		numHands = nh;
	}
	public int getNumHands(){
		return numHands;
	}

	public void setNumCards(int nc){
		numCards = nc;
	}
	public int getNumCards(){
		return numCards;
	}
	
	public void swap(Card first, Card second){
		Card temp = first;
		
		first = second;
		second = temp;
	}

	public boolean RoyalFlush(Vector <Card> hand){
		boolean retVal = false;

		int heart = 0;
		int club = 0;
		int diamond = 0;
		int spade = 0;

		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit() == "Hearts")
			{
				heart++;
			}
			else if (hand.get(i).getSuit() == "Clubs")
			{
				club++;
			}
			else if (hand.get(i).getSuit() == "Diamonds")
			{
				diamond++;
			}
			else if (hand.get(i).getSuit() == "Spades")
			{
				spade++;
			}
		}

		if (heart >= 5 || club >= 5 || diamond >= 5 || spade >= 5)
		{

			boolean hitThree = false;

			int countDiff1 = 0;

			for (int i = 0; i < hand.size() - 1; i++)
			{
				int diff = hand.get(i).getNumber() - hand.get(i+1).getNumber();

				if (diff == 1)
				{
					countDiff1++;
					if (countDiff1 > 3)
					{
						hitThree = true;
					}
				}

				if (diff > 2)
				{
					countDiff1 = 0;
				}
			}

			if (countDiff1 >= 4 && hitThree == true &&
				hand.get(0).getNumber() == 15)
			{
				retVal = true;
				royalFlush++;
			}
		}
		
		return retVal;
	}
	public boolean StraightFlush(Vector <Card> hand){
		boolean retVal = false;
		
		int heart = 0;
		int club = 0;
		int diamond = 0;
		int spade = 0;

		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit() == "Hearts")
			{
				heart++;
			}
			if (hand.get(i).getSuit() == "Clubs")
			{
				club++;
			}
			if (hand.get(i).getSuit() == "Diamonds")
			{
				diamond++;
			}
			if (hand.get(i).getSuit() == "Spades")
			{
				spade++;
			}

		}

		if (heart >= 5 || club >= 5 || diamond >= 5 || spade >= 5)
		{
			boolean hitThree = false;

			int countDiff1 = 0;

			for (int i = 0; i < hand.size() - 1; i++)
			{
				int diff = hand.get(i).getNumber() - hand.get(i+1).getNumber();

				if (diff == 1)
				{
					countDiff1++;

					if (countDiff1 >= 3)
					{
						hitThree = true;
					}
				}

				if (diff > 2)
				{
					countDiff1 = 0;
				}
			}

			if (countDiff1 >= 4 && hitThree == true)
			{
				retVal = true;
				straightFlush++;
			}
		}
		
		return retVal;
	}
	public boolean FourKind(Vector <Card> hand){
		boolean retVal = false;
		
		int countDiff = 0;
		boolean hitThree = false;

		for (int i = 0; i<hand.size() - 1; i++)
		{
			for (int j = i + 1; j<hand.size(); j++)
			{
				int tempDiff = hand.get(i).getNumber() - hand.get(j).getNumber();

				if (tempDiff == 0)
				{
					countDiff++;

					if (countDiff == 3)
					{
						hitThree = true;
					}

					break;
				}

				if (tempDiff > 0)
				{
					countDiff = 0;
				}
			}
		}

		if (hitThree == true)
		{
			retVal = true;
			fourKind++;
		}
		
		return retVal;
	}
	public boolean FullHouse(Vector <Card> hand){
		boolean retVal = false;
		
		
		return retVal;
	}
	public boolean Flush(Vector <Card> hand){
		boolean retVal = false;
		
		int heart = 0;
		int club = 0;
		int diamond = 0;
		int spade = 0;

		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getSuit() == "Hearts")
			{
				heart++;
			}
			else if (hand.get(i).getSuit() == "Clubs")
			{
				club++;
			}
			else if (hand.get(i).getSuit() == "Diamonds")
			{
				diamond++;
			}
			else if (hand.get(i).getSuit() == "Spades")
			{
				spade++;
			}
		}

		if (heart == 5 || club == 5 || diamond == 5 || spade == 5)
		{
			retVal = true;
			flush++;
		}
		
		return retVal;
	}
	public boolean Straight(Vector <Card> hand){
		boolean retVal = false;
		
		boolean hitThree = false;

		int countDiff1 = 0;

		for (int i = 0; i < hand.size() - 1; i++)
		{
			int diff = hand.get(i).getNumber() - hand.get(i+1).getNumber();

			if (diff == 1)
			{
				countDiff1++;
			}

			if (diff > 2)
			{
				countDiff1 = 0;
			}

			if (countDiff1 > 3)
			{
				hitThree = true;
			}
		}

		if (countDiff1 >= 4 && hitThree == true)
		{
			retVal = true;
			straight++;
		}
		
		return retVal;
	}
	
	public boolean ThreeKind(Vector <Card> hand){
		boolean retVal = false;
		
		int countDiff = 0;
		boolean hitTwo = false;

		for (int i = 0; i<hand.size() - 1; i++)
		{
			for (int j = i + 1; j<hand.size(); j++)
			{
				int tempDiff = hand.get(i).getNumber() - hand.get(j).getNumber();

				if (tempDiff == 0)
				{
					countDiff++;

					if (countDiff == 2)
					{
						hitTwo = true;
					}

					break;
				}

				if (tempDiff > 0)
				{
					countDiff = 0;
				}
			}
		}

		if (hitTwo == true)
		{
			retVal = true;
			threeKind++;
		}
		
		return retVal;
	}
	
	public boolean TwoPair(Vector <Card> hand){
		boolean retVal = false;
		
		int countDiff = 0;

		for (int i = 0; i<hand.size() - 1; i++)
		{
			for (int j = i + 1; j<hand.size(); j++)
			{
				int tempDiff = hand.get(i).getNumber() - hand.get(j).getNumber();

				if (tempDiff == 0)
				{
					countDiff++;
					break;
				}

				if (tempDiff > 0)
				{
					break;
				}
			}
		}

		if (countDiff >= 2)
		{
			retVal = true;
			twoPair++;
		}
		
		return retVal;
	}
	public boolean Pair(Vector <Card> hand){
		boolean retVal = false;
		
		boolean isPair = false;

		for (int i = 0; i<hand.size() - 1; i++)
		{
			for (int j = i + 1; j<hand.size(); j++)
			{
				int tempDiff = hand.get(i).getNumber() - hand.get(j).getNumber();

				if (tempDiff == 0)
				{
					isPair = true;
					break;
				}

				if (tempDiff > 0)
				{
					break;
				}
			}
		}

		if (isPair == true)
		{
			retVal = true;
			pair++;
		}
		
		return retVal;
	}

	public void playDisplay(){
		
		Vector<Card> hand = new Vector<Card>();
		
		for (int i = 0; i < getNumHands(); i++)
		{


			Deck d = new Deck();
			d.shuffle();
			d.deal(getNumCards(), hand);

			sortHand(hand);

			if (RoyalFlush(hand));
			else if (StraightFlush(hand));
			else if (FourKind(hand));
			else if (FullHouse(hand));
			else if (Flush(hand));
			else if (Straight(hand));
			else if (ThreeKind(hand));
			else if (TwoPair(hand));
			else if (Pair(hand));
			else
			{
				highCard++;
			}

			hand.setSize(0);

		}
		
		System.out.println("Results: ");
		System.out.printf("	Royal Flush: ", royalFlush);
		System.out.printf("	Straight Flush: ", straightFlush);
		System.out.printf("	Four of a Kind: ", fourKind);
		System.out.printf("	Full House: ", fullHouse);
		System.out.printf("	Flush: ", flush);
		System.out.printf("	Straight: ", straight);
		System.out.printf("	Three of a Kind: ", threeKind);
		System.out.printf("	Two Pairs: ", twoPair);
		System.out.printf("	Pair: ", pair);
		System.out.printf("	High Card: ", highCard);
		
	}
	public void sortHand(Vector <Card> hand){
		
		for (int i = 0; i<hand.size() - 1; i++)
		{
			for (int j = i +1; j<hand.size(); j++)
			{
				if (hand.get(i).getNumber() < hand.get(j).getNumber())
				{
					swap(hand.get(i), hand.get(j));
				}
			}
		}
		
	}
}
