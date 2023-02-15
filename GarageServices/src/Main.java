import com.garage.CarService;
import com.garage.basicServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        basicServices first = new basicServices();
        CarService second = new CarService();
        first.getVehicleDetails();

        Scanner obj = new Scanner(System.in);
        second.showServiceCode();
        int b=obj.nextInt();
        int h=second.setSum(b);
        int totalSum=second.getTotal(h);
       int totalBasicCost= first.getTotal();
       System.out.println("Your Basic Services cost: "+totalBasicCost);
        System.out.println("Your Basic Services cost plus Special Services=  "+totalSum);

    }


}