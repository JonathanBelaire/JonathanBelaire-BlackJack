//Programmed by: Jonathan Belaire
//Date Last Modified: 08/29/14

import java.util.Random;

//deck class represents 52 Card objects 
public class Deck 
{
protected Card[] deck = new Card[52];
protected int position = 0;
Random generator = new Random();
    //creates an array of 52 cards
    public Deck()
    {
        
        for (int i =0; i < 52; i++)
        {
            //Can't compare first card to another card
            if (i == 0){
                deck[i] = new Card(generator.nextInt(52)+1);
                
            }
            
            //compares each newly made card object to all others in array
            else 
            {
                deck[i] =  new Card(generator.nextInt(52)+1);
                for(int j = i - 1; j > -1; j--)
                {
                    if (deck[i].toString().equals(deck[j].toString()))
                    { 
                        deck[i] = new Card(generator.nextInt(52)+1);
                        j = i;
                        
                    }
                }
                
            }
        
        }
        
    }
    
    //draws card from deck moving the position every draw as to not draw duplicate cards
    public Card draw()
    {
        int cardNumber = this.position;
        this.position += 1;
        return deck[cardNumber];
    }
    
    //moves position back on place
    public void revert()
    {
        this.position -= 1;
    }
    
}
