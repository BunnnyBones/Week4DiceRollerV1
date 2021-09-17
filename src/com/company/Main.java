package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    while(true){
            int total = 0;

            Scanner input = new Scanner(System.in);
            System.out.println("How many dice would you like to roll (In the XdY format please, there is no Input protection)?");
            System.out.print("Your Input: ");
            String rawInput = input.next();

            //accounting for the first change of index
            int index = -1;

            //This sucked to do, took my like 4 different designs until I found out .charAt() existed
            for(int i =0; i < rawInput.length(); i++){
                index = index +1;
                char dFinder = rawInput.charAt(i);
                if(dFinder == 'd'){
                    //stop the loop
                    break;
                }
            }

            String rawInput1 = rawInput.substring(0,index);
            String rawInput2 = rawInput.substring(index+1);


            int diceNum = Integer.parseInt(rawInput1);
            int diceSides = Integer.parseInt(rawInput2);

            int[] dice = new int[diceNum];

            for(int i = 0; i < diceNum;i++){
                Random rand = new Random();
                dice[i] = rand.nextInt(diceSides) + 1;
                System.out.println("You Rolled a "+dice[i]+"!");
                total += dice[i];
            }
            System.out.println("Your Total is: "+total);

            System.out.println("\nWould you like to go again? (y/n)?");
            System.out.print("Your Input: ");
            String continueLoop = input.next();

            while(true) {
                if (continueLoop.equalsIgnoreCase("y")) {
                    break;
                } else if (continueLoop.equalsIgnoreCase("n")) {
                    break;
                } else {
                  System.out.println("That was not a valid output, Please try Again");
                  System.out.print("Your Input: ");
                  continueLoop = input.next();
                }
            }
            //Break out of big while loop
            if (continueLoop.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println(" ");
        }

    }
}
