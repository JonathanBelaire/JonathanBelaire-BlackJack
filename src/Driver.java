//Programmed by: Jonathan Belaire
//Date Last Modified: 08/29/14

import java.util.Scanner;
import javax.swing.JFrame;
public class Driver
{
    
    public static void main(String[] args)
    {
        String retry = "retry";
        Scanner scan = new Scanner(System.in);
        
        
        while (retry.equals("retry"))
        {
            //initializes objects
            Deck theDeck = new Deck();
            Hand dealerHand = new Hand(theDeck, 1);
            Hand playerHand = new Hand(theDeck, 2);
            String hit = "hit";
            
            
            System.out.println("Your score: "+playerHand.getScore() + "\n");
            System.out.println("Dealer: score: "+dealerHand.getScore()+ "\n");
            System.out.println("Your Cards: \n" + playerHand.getCard(0).toString()+"\n"
            + playerHand.getCard(1).toString());
            System.out.println("\nDealer Card: \n" + dealerHand.getCard(0).toString()+"\n");
            
            while (hit.equals("hit"))
            {
                System.out.println(playerHand.verifyScore());
                
                //checks to see if player hand went over 21
                if (playerHand.checkScore() == false && playerHand.getScore() != 21)
                {
                    hit = scan.next();
                    System.out.println("---------------------------------");
                }
                
                //checks for blackjack
                else if(playerHand.getScore() == 21 && playerHand.getCardNumber() == 2)
                {
                    hit = "";
                }
                            
                else
                    hit = "";
                
                if (hit.equals("hit"))
                {
                    playerHand.hit();
                    playerHand.checkAce();
                    System.out.println("Your score: "+playerHand.getScore() +"\n");
                    System.out.println("Your Hand: ");
                    for (int i = 0; i < playerHand.getCardNumber(); i++)
                    {
                        System.out.println(playerHand.getCard(i).toString());
                    }
                    System.out.println("");
                }
                
            }
            //dealers turn to hit
            if (playerHand.getCardNumber() != 2 || playerHand.getScore() != 21)
                while (dealerHand.getScore() < 17 && dealerHand.getScore() <= playerHand.getScore())
                {
                    dealerHand.hit();
                    dealerHand.checkAce();
                }
            
            System.out.println("Dealer Cards: ");
            for (int i = 0; i < dealerHand.getCardNumber(); i++)
                    {
                        System.out.println(dealerHand.getCard(i).toString());
                    }
            
            //checks if dealer beat player
            if ((playerHand.compareTo(dealerHand) < 0) && dealerHand.getScore() < 22)
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("You Lose! Type 'retry' to try again");
            }
            
            //checks if player beat dealer
            else if ((playerHand.compareTo(dealerHand) > 0) && (playerHand.getScore() < 22 || (playerHand.getScore() == 21 && playerHand.getCardNumber() != 2)))
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("You Win! Type 'retry' to try again");
            }
            
            //checks if dealer and player scores tie
            else if ((playerHand.compareTo(dealerHand) == 0) && playerHand.getScore() < 22)
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("PUSH! Type 'retry' to try again");
            }
            
            //checks if player busts
            else if (playerHand.getScore() > 21)
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("You Lose! Type 'retry' to try again");
            }
            
            //checks if dealer busts 
            else if (dealerHand.getScore() > 21 && (playerHand.getScore() < 22 || playerHand.getCardNumber() != 2))
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore() + " BUST");
                System.out.println("You Win! Type 'retry' to try again");
            }
            
            //checks if player gets blackjack
            else if (playerHand.getCardNumber() == 2 && playerHand.getScore() == 21)
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("BLACKJACK! Type 'retry' to try again");
            }
            
            //error message
            else 
            {
                System.out.println("\nYour Hand: " + playerHand.getScore());
                System.out.println("Dealer Hand: " + dealerHand.getScore());
                System.out.println("There has been an error");
                System.out.println("CardNumber: "+playerHand.getCardNumber());
            }
            retry = scan.next();
            System.out.println("");
//            
//            
//            
        }
//        JFrame frame = new JFrame("BlackJack");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        frame.getContentPane().add(new GameBoard());
//        frame.pack();
//        frame.setVisible(true);
    }
}
