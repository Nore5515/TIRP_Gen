import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.net.*;

//DOOT DOOT
//Lets see here...
//I want to be able to...
//1 generate a npc real quick
//  it should have a randomly assigned gender
//  name should be based on gender
//  age random
//  random family based on age
//  random spouse/child names, ages
//  random goals
//  random personality based on goals, age, family

public class Main{

    int law,order,people,money,mercy,thinking;

    public void SetResp(int traitMod,int _law,int _order,int _people, int _money, int _mercy, int _thinking){
        law = _law + traitMod;
        order = _order + traitMod;
        people = _people + traitMod;
        money = _money + traitMod;
        mercy = _mercy + traitMod;
        thinking = _thinking + traitMod;
    }

    public static void main(String args[]) throws Exception{

        Main m = new Main();
        Random rand = new Random();
        Scanner reader = new Scanner(System.in);

        System.out.println("What’s the issue?");
        System.out.println("1 - NPC QUICK");
        System.out.println("2 - im stuck rip fam");
        System.out.println("3 - How the <heck> do you even get started");
        System.out.println("4 - Where are I");
        System.out.println("5 - Average Age Check");
        int mainIn = reader.nextInt();

        if (mainIn == 1){
            System.out.println("I GOT YOU \n=============");
            String gender;
            //respect essentially, 1 is none and 5 is lots, 3 is avg

            if (rand.nextInt(1) == 0){ gender = "M";}
            else{gender = "F";}
            System.out.println("Name: "+ m.GenName(gender,2));
            int age = (rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(40));
            System.out.println("Age: "+ age);
            System.out.println("Gender: " + gender);
            String interest; int interestRand = rand.nextInt(13);
            int traitMod = rand.nextInt(3)-1;
            if (interestRand == 0){interest = "Knowledge (books, magic)";
                m.SetResp(traitMod,1,4,1,2,2,5);
            }
            else if (interestRand == 1){interest = "Physical Fitness (light melee, athletics)";
                m.SetResp(traitMod,3,3,4,2,3,1);
            }
            else if (interestRand == 2){interest = "Staying Alive (survival, stealth)";
                m.SetResp(traitMod,1,1,2,5,2,4);
            }
            else if (interestRand == 3){interest = "Raw Strength (two-handed, heavy armor)";
                m.SetResp(traitMod,2,2,2,3,2,1);
            }
            else if (interestRand == 4){interest = "Relaxing (charisma, lying)";
                m.SetResp(traitMod,2,1,5,3,3,2);
            }
            else if (interestRand == 5){interest = "Adventuring (misc objects, knowledge)";
                m.SetResp(traitMod,2,2,3,4,3,4);
            }
            else if (interestRand == 6){interest = "Maintaining Order (law, intimidation)";
                m.SetResp(traitMod,5,5,2,1,2,1);
            }
            else if (interestRand == 7){interest = "Piety (religion, magic)";
                m.SetResp(traitMod,1,5,5,1,5,3);
            }
            else if(interestRand == 8){interest = "Material Goods (wealth, barter)";
                m.SetResp(traitMod,2,2,2,5,2,4);
            }
            else if (interestRand == 9){interest = "Break Addiction (will, drugs)";
                m.SetResp(traitMod,1,4,2,4,1,1);
            }
            else if (interestRand == 10){interest = "Find Lost Sibiling (perception, persuasion)";
                m.SetResp(traitMod,4,3,2,2,3,1);
            }
            else if (interestRand == 11){interest = "Revenge (intimidation, melee)";
                m.SetResp(traitMod,1,3,1,1,1,4);
            }
            else{interest = "Power (leadership, will)";
                m.SetResp(traitMod,4,5,4,2,4,2);
            }
            System.out.println("Interest: " + interest);

            //Family Time
            //data is interest...
            //70% of people are married (if between 23 and 31)
            //if age is < 23, rate is 15%
            //if age is > 31, rate is 50%
            //2% of people are married (and gay)
            //7% of people are widowed
            //if married 43% have kids
            //if kidded then 20% of 1 kid
            //50% of 2 kid
            //20% of 3 kid
            //10% of 4+ kid

            String family = new String();
            int spouse = rand.nextInt(100)+1;
            int child = rand.nextInt(100) + 1;
            int childCount = rand.nextInt(100)+1;
            if (age <= 20){
                //low rate of marriage
                if (spouse <= 5){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Married, " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (5 < spouse && spouse <= 7){
                    family += "Married (gay), " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (7 < spouse && spouse <= 8){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Once Married, " + m.GenSpouse(gender,age) + "(DECEASED), ";
                    family += m.GenChildren(child,childCount,age);
                }
                else{
                    family += "Never Married.";
                }
            }
            else if (21 <= age && age < 32){
                //high rate of marriage
                if (spouse <= 70){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Married, " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (70 < spouse && spouse <= 72){
                    family += "Married (gay), " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (72 < spouse && spouse <= 79){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Once Married, " + m.GenSpouse(gender,age) + "(DECEASED), ";
                    family += m.GenChildren(child,childCount,age);
                }
                else{
                    family += "Never Married.";
                }
            }
            else if (31 < age){
                //ok rate of marriage
                if (spouse <= 50){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Married, " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (50 < spouse && spouse <= 52){
                    family += "Married (gay), " + m.GenSpouse(gender, age) + ", ";
                    family += m.GenChildren(child,childCount,age);
                }
                else if (52 < spouse && spouse <= 59){
                    gender = (gender.equals("M")) ? "F" : "M";
                    family += "Once Married, " + m.GenSpouse(gender,age) + "(DECEASED), ";
                    family += m.GenChildren(child,childCount,age);
                }
                else{
                    family += "Never Married.";
                }
            }
            else{
                System.out.println("ERR AGE IN FAM");
            }
            System.out.println("Family: "+ family);

            //Personality time
            //using 16 personality test, so 4 different letters to choose from
            //E v I, people vs thinking
            //S v N, order vs thinking
            //T v F, law, order, thinking v people, mercy
            //J v P, law, order, money v people, mercy, thinking
            String personality = new String();
            int EvI = rand.nextInt(100) + 1;
            EvI += 15 * (m.people - m.thinking);
            int SvN = rand.nextInt(100) + 1;
            SvN += 15 * (m.order - m.thinking);
            int TvF = rand.nextInt(100) + 1;
            TvF += 15 * ((m.order + m.law + m.thinking) - (m.people + m.mercy));
            int JvP = rand.nextInt(100) + 1;
            JvP += 15 * ((m.law + m.order + m.money) - (m.people + m.mercy + m.thinking));
            personality += (EvI <= 50)? "I" : "E";
            personality += (SvN <= 50)? "S" : "N";
            personality += (TvF <= 50)? "F" : "T";
            personality += (JvP <= 50)? "P" : "J";

            /*
            //Extro
            if (personality.substring(0,1).equals("E")){
                //Sense
                if (personality.substring(1,2).equals("S")){
                    //thinking
                    if (personality.substring(2,3).equals("T")){
                        //Judging
                        if (personality.substring(3,4).equals("J")){
                            personality += "(Executive)";
                        }
                        //Perceiving
                        else{
                            personality += "(Entrepreneur)";
                        }
                    }
                    //feeling
                    else{
                        //Judging
                        if (personality.substring(3,4).equals("J")){
                            personality += "(Consul)";
                        }
                        //Perceiving
                        else{
                            personality += "(Entertainer)";
                        }
                    }
                }
                //Intuition
                else{

                }
                //Intuition
                else{
    `
                }
            }
            //Intro
            else{

            }
            */



        }
        else if (mainIn == 2){

        }
        else if (mainIn == 3){

        }
        else if (mainIn == 4){

        }
        else if (mainIn == 5){
            int total = 0;
            int massTotal = 0;
            for (int x = 0; x < 10; x++){
                for (int y = 0; y < 10; y++){
                    total += (rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(40));
                }
                System.out.println("TOTAL: " + total / 10);
                massTotal += total;
                total = 0;
            }
            System.out.println("MASS TOTAL: "  + massTotal / 100);
        }
    }

    public String GenSpouse(String gender, int age) throws Exception{
        String toReturn = new String();
        Main m = new Main();
        Random rand = new Random();
        int ageMod = rand.nextInt(14)-4;

        if (gender.equals("M")){
            toReturn += m.GenName("M", 2) + "(" + (ageMod+age) + ")";
        }
        else if (gender.equals("F")){
            toReturn += m.GenName("F", 2) + "(" + (ageMod+age) + ")";
        }
        else{
            System.out.println("ERR");
        }
        return toReturn;
    }

    public String GenChildren(int child, int childCount, int age) throws Exception {
        String toReturn = new String();
        Main m = new Main();
        Random rand = new Random();
        if (child <= 43){
            if (childCount <= 20){
                toReturn += "1 Child, ";
                childCount = 1;
            }
            else if (20 < childCount && childCount <= 70){
                toReturn += "2 Children, ";
                childCount = 2;
            }
            else if (70 < childCount && childCount <= 90){
                toReturn += "3 Children, ";
                childCount = 3;
            }
            else if (90 < childCount && childCount <= 100){
                childCount = rand.nextInt(3) + 4;
                toReturn += childCount + " Children, ";
            }
            else{
                System.out.println("ERR IN CHILD, FAMILY");
            }
        }
        else{
            toReturn += "No Children. ";
            childCount = 0;
        }

        int gender, ageMod;
        for (int x = 0; x < childCount; x++){
            gender = rand.nextInt(2);
            ageMod = rand.nextInt(5);
            if (gender == 0){
                toReturn += "\n\t" + m.GenName("M",1) + "(" +(age - 20 + ageMod) +")";
            }
            else{
                toReturn += "\n\t" + m.GenName("F",1) + "(" + (age - 20 + ageMod) +")";
            }
        }

        return toReturn;
    }

    public String GenName(String gender, int parts) throws Exception{
        String http;
        if (gender.equals("M")){
            http = "http://random-name-generator.info/random/?n=10&g=2&st=2";
        }
        else{
            http = "http://random-name-generator.info/random/?n=10&g=3&st=2";
        }
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
        int loc = soulFace.indexOf("<olclass=");
        soulFace = soulFace.substring(loc);
        soulFace = soulFace.substring(24);
        loc = soulFace.indexOf("<li>");
        soulFace = soulFace.substring(0,loc);
        for (int x = 0; x < soulFace.length(); x++){
            if (Character.isUpperCase(soulFace.charAt(x)) && x != 0){
                loc = x;
                x = soulFace.length() + 1;
            }
        }
        String soul = soulFace.substring(0,loc);
        String face = soulFace.substring(loc,soulFace.length());
        if (parts == 1){
            soulFace = soul;
        }
        else if (parts == 2){
            soulFace = soul+ " " + face;
        }
        else{
            System.out.println("ERR");
        }
        //soulFace = soul + " " + face;
        //System.out.println(soulFace);

        return soulFace;
    }
}




























