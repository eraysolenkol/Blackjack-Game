package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Blackjack game = new Blackjack();
        int choice = 1;
        while(choice != 2) {
            game.start();
            System.out.println("Do you wanna play again?\n1.Play\n2.Quit\n");
            choice = scan.nextInt();
        } 
        scan.close();
    }
}