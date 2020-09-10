/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

import java.util.*;

/**
 *
 * @author 2ndyrGroupB
 */
public class App {

    Scanner input = new Scanner(System.in);

    int card[] = new int[52]; //
    String rank[] = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};
    String suit[] = {"S", "C", "D", "H"};
    int cardRemain = 52;
    boolean created = false;
    int counter = 0;

    public void menu() {
       
        while (true) {
            System.out.println("------------------***---------------------");
           System.out.println("|             1 - create                   |");
           System.out.println("|             2 - display                  |");
           System.out.println("|             3 - shuffle                  |");
           System.out.println("|             4 - deal                     |");
           System.out.println("|             5 - exit                     |");
            System.out.println("------------------***---------------------");
            
            System.out.print("Enter your Choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                case "create":
                    create();
                    break;
                case "2":
                case "display":
                    display();
                    break;
                case "3":
                case "shuffle":
                    shuffle();
                    break;
                case "4":
                case "deal":
                    deal();
                    break;
                case "5":
                case "exit":
                    System.exit(0);
            }

        }
    }

    public void create() {
        for (int i = 0; i < card.length; i++) {
            card[i] = i;
        }
        created = true;
        System.out.println("Success! The cards were created");

    }

    //
//    public void display() {
//
//        int count = 0;
//        if (created == true) {
//            for (int i = 0; i < suit.length; i++) {
//                for (int a = 0; a < rank.length; a++) {
//                    System.out.print(suit[i] + rank[a] + " ");
//                    count++;
//                    if (count == 13) {
//                        System.out.println("");
//                        count = 0;
//                    }
//                }
//
//            }
//        } else {
//            System.out.println("Cards were not yet created! ");
//        }
//    }
    public void display() {
        int count = 0;
        if (created == true) {
            for (int i = counter; i < 52; i++) {
                String syot = suit[card[i] / 13];
                String ranc = rank[card[i] % 13];
                System.out.print(ranc + syot + " ");
                count++;
                if (count == 13) {
                    System.out.println("");
                    count = 0;
                }
            }
        } else {
            System.out.println("The cards were not yet created.Please create first");
        }
    }

    public void shuffle() {
        if (created == true) {
            for (int i = 0; i < card.length; i++) {
                int shuffle = (int) (Math.random() * card.length);
                int temp = card[i];
                card[i] = card[shuffle];
                card[shuffle] = temp;
            }
            System.out.println("Done shuffling your cards.");
        } else {
            System.out.println("The cards were not yet created.Please create first");
        }
    }

    public void deal() {

        if (created == true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("How many cards do you want to deal?");
            int num = scan.nextInt();

            if (num > cardRemain || cardRemain == 0) {
                System.out.println("Opps! Card is not enough.");
            } else {
                int align = 0;
                int limit = num + counter;
                for (int i = counter; i < limit; i++) {
                    String suits = suit[card[i] / 13];
                    String ranks = rank[card[i] % 13];
                    System.out.print(suits + ranks + " ");
                    align++;
                    if(align == 13){
                        System.out.println("");
                        align =0;
                    }
                    counter++;
                    cardRemain--;
                }
            }
        } else {
            System.out.println("The cards were not yet created.Please create first.");
        }

    }
}
