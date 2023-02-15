
 package com.garage;
public class CarService extends basicServices{
    int service;
    int sum=0;
  public void showServiceCode(){
      System.out.println("1 for fullCarService");
      System.out.println("2 for Inspect drive belt");
      System.out.println("3 for Brakes and steering");
  }
    public void theServiceNeeded(int a){
        service=a;
    }

    public  int setSum(int a) {
      int p=0;
        if(a==3){

            p=2500;

        }

        else if(a==2){
             p=5000;

        } else if (a==1) {
            p=10000;

        }
        return p;
    }

    public int getTotal(int a){
        a+=wheelsCheck+nutsAndBolts+engineOil;
        return a;
    }
}
