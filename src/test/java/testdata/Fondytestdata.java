package testdata;

import java.util.HashMap;
import java.util.Map;

public class Fondytestdata {
    public static void main(String[] args) {
        System.out.println(getOptimalChange(50122));
    }
    public static Map<String, Map<String, Integer>> getOptimalChange(int pence) {
        //  int pence= actualData.getPenceSubmitted();
        Map<String, Map<String, Integer>> result = new HashMap<>();
        Map<String, Integer> pounds = new HashMap<>();
        Map<String, Integer> penceMap = new HashMap<>();

        int[] poundValues = {50, 20, 10, 5, 2, 1};
        int[] penceValues = {50, 20, 10, 5, 2, 1};
        if (pence >= 0) {
            for (int value : poundValues) {
                int numCoins = pence / (value * 100);
                if (numCoins > 0) {
                    pounds.put(Integer.toString(value), numCoins);
                    pence -= numCoins * value * 100;
                } else {
                    pounds.put(Integer.toString(value), 0);
                }
            }

            for (int value : penceValues) {
                int numCoins = pence / value;
                if (numCoins > 0) {
                    penceMap.put(Integer.toString(value), numCoins);
                    pence -= numCoins * value;
                } else {
                    penceMap.put(Integer.toString(value), 0);
                }
            }

            result.put("pounds", pounds);
            result.put("pence", penceMap);

        } else {
            System.out.println("Your pence should be equals or  greater then 0");
        }
        return result;
    }


    }

/*
This code defines a method getOptimalChange that takes an integer value pence as an argument and returns a Map containing
 the optimal change in pounds and pence.

The getOptimalChange method first creates two empty Maps, pounds and penceMap, to store the optimal change in pounds and pence,
respectively. It also defines two arrays of integer values, poundValues and penceValues, which contain the available pound and pence denominations.

The method then checks if the value of pence is greater than or equal to 0. If it is, the method loops through each value
in the poundValues array and calculates the number of coins of that denomination needed to make the optimal change.
The number of coins is calculated by dividing the remaining pence by the value of the coin…
 The method then updates the pounds Map by adding an entry with the value of the coin as the key and the number of coins as the value.
 It also subtracts the value of the coins from the remaining pence. This process is repeated for each value in the poundValues array.

The method then does the same thing for the penceValues array, calculating the number of coins of each denomination
 needed to make the optimal change in pence and updating the penceMap Map accordingly.

Finally, the method puts the pounds and penceMap Maps into the result Map and returns it.
 The getOptimalChange method calculates the optimal change for this value and returns a Map containing the optimal change in pounds and pence.
  The main method then prints the returned Map to the console.

 */