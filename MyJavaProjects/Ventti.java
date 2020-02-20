package MyJavaProjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author s2000036
 */
public class Ventti {

    public static void main(String[] args) {


        ArrayList<Integer> deck = new ArrayList<>();

        for (int i = 2; i <= 14; i++) { // this forms card deck with 4 times 2-14 (13 cards, ace is 14)
            deck.add(i);
            deck.add(i);
            deck.add(i);
            deck.add(i);

        }
        Collections.shuffle(deck); // this will shuffle the deck, for this game deck only has values and not suits

        System.out.println("Let's play Ventti! It's Finnish version of Black Jack with some added rules - some of them are a bit weird, I know.. "
                + "\nHere are the rules:\n"
                + "\nYou will get 2 cards and after that you can decide if you want more."
                +"\nTry to get 21 points or as close as possible without going over."
                + "\nIf you get 21 it's Ventti and game will deal dealers cards. If you go over 21, you will lose automatically."
                + "\nIf you get ace in any point during the game, you can choose ace value to be either 1 or 14. Dealer's ace is always 1."
                + "\nWhen you decide to stay, game will start to deal dealer's cards. "
                + "\nHighest hand will win, except in few exceptions:"
                + "\nDealer will win if your hands are equal, or if dealers hand is == 20 and your hand is == 21"
                + "\nIf your hand is 21 - you get Ventti and game will automatically continue to deal dealer's cards."
                + "\nAlso, if you have 5 cards and your hand is equal or under 21 - your hand is == 21, Ventti."
                + "\n" + "\nLet´s begin!");
        System.out.println("");

        Scanner lukija = new Scanner(System.in);
        int dealerHand = 0; // makes a variable for dealer so game continues to dealers while loop (if players hand is under 22)
        int playerHand = deck.remove(0); // draws first card for player and removes it from deck
        int playerCardAmount = 1; // variable for counting players card amount
        System.out.println("Your first card is " + playerHand);

        if (playerHand == 14) { // askes user to choose value for ace if ace is first card
            System.out.println("You got a ace. Should your ace be 1 or 14?");
            int aceChoice = Integer.valueOf(lukija.nextLine());
            playerHand = aceChoice; // adds value to players hand

        }

        while (playerHand < 22) {
            int newCard = deck.remove(0); // takes new card for player
            playerCardAmount++; // adds new card to variable
            System.out.print("Your new card is " + newCard + ". ");

            if (newCard == 14) { // let's player choose value for ace
                System.out.println("You got a ace. Should your ace be 1 or 14?");
                int aceChoice = Integer.valueOf(lukija.nextLine());
                newCard = aceChoice; // adds players chosen value to be as newCard value
            }

            playerHand = playerHand + newCard; // sums up newCard to players existing hand
            System.out.println("Sum of your cards is " + playerHand + ".");
            System.out.println("");

            if (playerHand > 21) { // if player goes over 21
                System.out.println("Game over, you lose!");
                break;
            }
            if (playerCardAmount == 5 && playerHand < 22) { // if player gets 5 cards AND card value is not over 21
                playerHand = 21;
                System.out.println("Ventti - you got five cards.");
                break;
            }
            if (playerHand == 21) {
                System.out.println("Ventti!");
                break;
            }
            // this part askes user if they wan´t more cards. If user input is something else than NO
            // game starts from begining of this while loop and gives player another card
            System.out.println("Do you want more cards? Answer YES if you do and NO if you don't.");
            String answer = lukija.nextLine();
            if (answer.equals("NO")) {
                break;
            }
        }
        System.out.println("");
        // this part is for dealing dealers cards and checking how's the winner
        while (playerHand < 22) {
            int dealerCard = deck.remove(0); // deals a card to dealer, remove's dealt card from deck

            if (dealerCard == 14) { // changes card 14 value to 1
                dealerCard = 1;
            }
            dealerHand = dealerHand + dealerCard; // add's dealer's card to dealer's hand
            System.out.println("Dealer's hand is currently " + dealerHand + ".");
            System.out.println("");

            if (dealerHand > 21) { // if dealer goes over 21 -> will automatically lose and end
                System.out.println("Dealer's hand is: " + dealerHand);
                System.out.println("You win!");
                break;
            }
            if (dealerHand == playerHand) {
                System.out.println("Your cards are equal - Dealer wins!");
                break;
            }

            if (dealerHand == 20 && playerHand == 21) { // in case of player get's Ventti and dealer get's 20 -> dealer win
                System.out.println("Dealer's hand is 20 and you have Ventti - Dealer wins!");
                break;

            }

            if (dealerHand > playerHand) {
                System.out.println("Game over, you lose! Dealer's hand is: " + dealerHand + ".");
                break;
            }
        }
    }

}