
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class forUser {
    //String userName;
   // int userId;
    static Map<Integer,String> representativeNames= new HashMap<>();
    static Map<Integer,Integer> totalVotes= new HashMap<>();
    static Map<Integer,Integer> voterList=new HashMap<>();
    void forUser(){
        voterList.put(101,0);
        voterList.put(102,0);
        voterList.put(103,0);
        voterList.put(104,0);
        voterList.put(105,0);
        voterList.put(106,0);
        voterList.put(107,0);
        voterList.put(108,0);

        totalVotes.put(11,0);
        totalVotes.put(12,0);
        totalVotes.put(13,0);
        totalVotes.put(14,0);
        totalVotes.put(15,0);
        totalVotes.put(16,0);
        totalVotes.put(17,0);
        totalVotes.put(18,0);
        totalVotes.put(19,0);
        totalVotes.put(20,0);

    }



   public static boolean verifyVoter(int b){
        if(voterList.get(b)==1){
            return false;
        }
       else{
           return true;
        }
    }

    public static void myVote(){
       Scanner o = new Scanner(System.in);
        System.out.println("Enter your id once again");
        int s = o.nextInt();

        if(voterList.containsKey(s)){
            boolean k=verifyVoter(s);
            if(k){
                int m=voterList.get(s);
                voterList.put(s,m+1);
                System.out.println("Enter the ID from below table that you want to vote");
                displayRepresentatives();
                int vote= o.nextInt();
                int count=totalVotes.get(vote);
                totalVotes.put(vote,count+1);
            }
            else{
                System.out.println("You have voted Already");
            }
        }

        else{
            System.out.println("You have entered the wrong id");
        }

    }

        public static void displayVotes(){
              for(int i=11;i<21;i++){
                  System.out.println(representativeNames.get(i)+" has "+totalVotes.get(i)+" Votes");
              }

        }
    public static void displayRepresentatives(){
        representativeNames.put(11,"Rahul Gandhi");
        representativeNames.put(12,"Rajiv Gandhi");
        representativeNames.put(13,"Priyanka Gandhi");
        representativeNames.put(14,"Ankit Goyal");
        representativeNames.put(15,"Sharad Pawar");
        representativeNames.put(16,"Udhav Thakare");
        representativeNames.put(17,"Manmohan Singh");
        representativeNames.put(18,"Indira Gandhi");
        representativeNames.put(19,"Harsh Goel");
        representativeNames.put(20,"Shashi Tharoor");
        for(int i=11;i<21;i++){
            System.out.println(i+" : "+representativeNames.get(i));
        }

    }

    }
