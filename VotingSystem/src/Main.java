
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
       String name;
       int voterid;
       int indicate;


       forUser f1 = new forUser();
       f1.forUser();


       System.out.println("To start the voting proce3" +
               "ss press 3");
        Scanner m =  new Scanner(System.in);
        indicate=m.nextInt();

            while(indicate==3){
                Scanner obj =  new Scanner(System.in);
                int  p;
                System.out.println("To give your valuable vote press 1");
                System.out.println("To see the results press 2");
                p=obj.nextInt();
                if(p==1){
                    Scanner l =  new Scanner(System.in);
                    System.out.println("Enter your name");
                    name=l.nextLine();
                    System.out.println("Enter your voterId");
                    voterid=l.nextInt();
                    newUser u = new newUser(name,voterid);
                } else if (p==2) {
                    forUser.displayVotes();
                }
                else{
                    System.out.println("Enter either 1 or 2");
                }
            }



    }
}