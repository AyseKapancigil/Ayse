package testdata;

import java.util.HashMap;
import java.util.Map;

public class Fondytestdata {
    public static void main(String[] args) {

      calculateOptimalChange();
    }
   public Fondytestdata(){this.};
    public  static void calculateOptimalChange() {
        int remainingAmount = 50122;
        Map<String, Integer> pounds = new HashMap<>();
        Map<String, Integer> pence = new HashMap<>();

        int numFiftyPounds = remainingAmount / 5000;
        remainingAmount -= numFiftyPounds * 5000;
        pounds.put("50", numFiftyPounds);

        int numTwentyPounds = remainingAmount / 2000;
        remainingAmount -= numTwentyPounds * 2000;
        pounds.put("20", numTwentyPounds);

        int numTenPounds = remainingAmount / 1000;
        remainingAmount -= numTenPounds * 1000;
        pounds.put("10", numTenPounds);

        int numFivePounds = remainingAmount / 500;
        remainingAmount -= numFivePounds * 500;
        pounds.put("5", numFivePounds);

        int numTwoPounds = remainingAmount / 200;
        remainingAmount -= numTwoPounds * 200;
        pounds.put("2", numTwoPounds);

        int numOnePounds = remainingAmount / 100;
        remainingAmount -= numOnePounds * 100;
        pounds.put("1", numOnePounds);

        int numFiftyPence = remainingAmount / 50;
        remainingAmount -= numFiftyPence * 50;
        pence.put("50", numFiftyPence);

        int numTwentyPence = remainingAmount / 20;
        remainingAmount -= numTwentyPence * 20;
        pence.put("20", numTwentyPence);

        int numTenPence = remainingAmount / 10;
        remainingAmount -= numTenPence * 10;
        pence.put("10", numTenPence);

        int numFivePence = remainingAmount / 5;
        remainingAmount -= numFivePence * 5;
        pence.put("5", numFivePence);

        int numTwoPence = remainingAmount / 2;
        remainingAmount -= numTwoPence * 2;
        pence.put("2", numTwoPence);

        int numOnePence = remainingAmount;
        pence.put("1", numOnePence);


    }
}

