//Programmed by: Jonathan Belaire
//Date Last Modified: 08/29/14

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//represents GUI for BlackJack
public class GameBoard extends JPanel{
private ImageIcon image;    
    public GameBoard()
    {
        Deck theDeck = new Deck();
        Hand dealerHand = new Hand(theDeck, 1);
        Hand playerHand = new Hand(theDeck, 2);
        
        this.setPreferredSize(new Dimension(1000, 900));
        this.setBackground(Color.GREEN);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        JPanel dealerArea = new JPanel();
        dealerArea.setPreferredSize(new Dimension(1000,400));
        dealerArea.setBackground(Color.BLUE);
        
        JPanel playerArea = new JPanel();
        playerArea.setPreferredSize(new Dimension(1000, 400));
        playerArea.setBackground(Color.BLACK);
        
        //this.add(dealerArea);
        //this.add(playerArea);
        System.out.println(dealerHand.hand[0].toString());
        
        image = new ImageIcon("eye.jpg");
        JLabel cardimage = new JLabel(image);
        this.add(cardimage);
    }
    
//    private JLabel getCard(Deck deck)
//    {
//        
//    }
}
