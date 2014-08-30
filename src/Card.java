//Programmed by: Jonathan Belaire
//Date Last Modified: 08/29/14
//
//Card class
public class Card {
    protected int index, value;
    protected String suit;
    
    //initializes value and suit and creates the card
    public Card(int card){
        
        this.index = card - 1;
        if ((card + 2)  % 13 == 0 || (card + 1) % 13 == 0 || card % 13 == 0)
            this.value = 10;
        
        else if (card > 1 && card < 11)
            this.value = card;
        
        else if(card == 1)
            this.value = 11;
        
        else if ((card - 1) % 13 == 0)
        {
            this.value = 11;
        }
        
        else if (card > 13)
        {
            
            while(card > 13)
            {
                card -= 13;
            }
            this.value = card;
            
        }
        
        
        
        if (this.index < 13)
        {
            this.suit = "Spades";
        }
        
        else if (this.index > 12 && this.index < 26)
        {
            this.suit = "Clubs";
        }
        
        else if (this.index > 25 && this.index < 39)
        {
            this.suit = "Diamonds";
        }
        
        else if (this.index > 38 && this.index < 52)
        {
            this.suit = "Hearts";
        }
                  
        
    }
    
    //returns this value
    public int getValue()
    {
        return this.value;
    }
    
    //returns this index
    public int getIndex()
    {
        return this.index;
    }
    
    //sets this value to parameter
    public void setValue(int value)
    {
        this.value = value;
    }
    
    @Override
    //returns name of card
    public String toString()
    {
        
        if((this.index + 3) % 13 == 0)
            return "Jack_of_"+this.suit;
        
        else if((this.index+2) % 13 == 0)
            return "Queen_of_"+this.suit;
        
        else if((this.index+1) % 13 == 0)
            return "King_of_"+this.suit;
        
        else if(this.value == 11 || this.value == 1)
            return "Ace_of_"+this.suit;
        
        else
            return this.value +"_of_"+ this.suit;
    }
}
