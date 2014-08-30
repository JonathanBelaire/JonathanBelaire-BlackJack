//Programmed by: Jonathan Belaire
//Date Last Modified: 08/29/14
//
//Hand class represents a group of cards that the player or dealer holds
public class Hand {
protected int score, cardNumber;
protected Deck deck;
protected Card[] hand;
protected Card tempHand;
    
    //creates a hand from the specified deck
    public Hand(Deck deck, int cards){
        
        this.cardNumber = cards;
        this.hand = new Card[]{null, null, null, null, null, null, null, null, null, null};
        this.deck = deck;
        for(int i = 0; i < this.cardNumber; i++)
        {
            this.hand[i] = this.deck.draw();
            this.score += this.hand[i].value;
        }       
        
    }
    
    //draws a card and adds its value to hand's score
    public void hit(){
        
        this.hand[this.cardNumber] = this.deck.draw();            
        this.score += this.hand[this.cardNumber].value;
        this.cardNumber += 1;
        
    }
    
    
//    public void stay()
//    {
//        
//    }
    
    //changes value of an Ace to 1 if score goes over 21
    public void checkAce()
    {
        
       if (this.score > 21)
       {
           for (int i = 0; i < this.cardNumber; i++)
           {
               if ((this.getCard(i).getIndex() == 0 || this.getCard(i).getIndex() % 13 == 0)&&this.getCard(i).getValue() == 11)
               {
                   this.getCard(i).setValue(1);
                   i = this.cardNumber;
               }
           }
       }
    
    }
    
    //returns card at index from hand object
    public Card getCard(int index)
    {
        return this.hand[index];
    }
    
    //returns the cardNumber of hand object
    public int getCardNumber()
    {
        return this.cardNumber;
    }
    
    //sets cardNumber of hand object
    public void setCardNumber(int cardNumber)
    {
        this.cardNumber = cardNumber;
    }
    
    //returns hand's score
    public int getScore()
    {
        return this.score;
    }
    
    //sets hand's score
    public void setScore(int score)
    {
        this.score = score;
    }
    
    //returns true if score is higher than 21
    public boolean checkScore(){
        return this.score > 21;
    }
    
    //returns a string telling player whether they busted or if they can hit
    public String verifyScore(){
        if (this.score > 21){
            return "BUST";
        }
        else 
            return "Type hit or stay!";
    }
    
    //compares the scores of two different hands
    public int compareTo(Hand hand){
        if (this.score < hand.score)
            return -1;
        
        else if(this.score == hand.score)
            return 0;
        
        else
            return 1;
    }
}