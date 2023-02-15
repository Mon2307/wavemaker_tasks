
package com.garage;
import java.util.Scanner;
public class basicServices implements BasicDetalis{
       int wheelsCheck=0;
       int nutsAndBolts=0;
       int engineOil=0;
       String vehicleType;
       int vehicleNo;
    public basicServices(){
        wheelsCheck=500;
        nutsAndBolts=500;
        engineOil=300;
    }

    public int getTotal() {
        int totalSum=wheelsCheck+nutsAndBolts+engineOil;
        return totalSum;
    }

    public void getVehicleDetails(){
        System.out.println("Enter car/bike model name");
        Scanner Obj = new Scanner(System.in);
        String vehicleType = Obj.nextLine();
        System.out.println("Enter vehicle no");
        int vehicleNo=Obj.nextInt();
    }
}
