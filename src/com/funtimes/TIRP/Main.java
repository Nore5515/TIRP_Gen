package com.funtimes.TIRP;

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Main{
    public static void main(String args[]) throws Exception{

        Main m = new Main();
        Random rand = new Random();
        Scanner reader = new Scanner(System.in);

        System.out.println("What’s the issue?");
        System.out.println("1 - NPC QUICK");
        System.out.println("2 - im stuck rip fam");
        System.out.println("3 - How the hell do you even get started");
        System.out.println("4 - Where are I");
        int mainIn = reader.nextInt();

        if (mainIn == 1){
            System.out.println("I GOT YOU \n=============");
            System.out.println("Name: "+ m.GenName());
            System.out.println("Age: "+ (rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(20)));
            String gender;
            if (rand.nextInt(1) == 0){ gender = "M";}
            else{gender = "F";}
            System.out.println("Gender: " + gender);
            String interest; int interestRand = rand.nextInt(9);
            if (interestRand == 0){interest = "Knowledge (books, magic)";}
            else if (interestRand == 1){interest = "Physical Fitness (light melee, athletics)";}
            else if (interestRand == 2){interest = "Staying Alive";}
            else if (interestRand == 3){interest = "Raw Strength";}
            else if (interestRand == 4){interest = "Relaxing";}
            else if (interestRand == 5){interest = "Adventuring";}
            else if (interestRand == 6){interest = "Maintaining Order";}
            else if (interestRand == 7){interest = "Piety";}
            else if(interestRand == 8){interest = "Material Goods";}
            else{interest = "Power";}
            System.out.println("Interest: " + interest);
        }
        else if (mainIn == 2){

        }
        else if (mainIn == 3){

        }
        else if (mainIn == 4){

        }
    }

    public String GenName() throws Exception{
        String http = "http://random-name-generator.info";
        StringBuilder result = new StringBuilder();
        URL url = new URL(http);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        String soulFace = result.toString();
        soulFace = soulFace.replaceAll("\\s+","");
        System.out.println(soulFace);


        return "big loser";
    }
}




























