package Oblig3;

import javax.swing.*;
import java.util.Random;

public class UnikeTall {
    int[] intArray;
    String arrayAsString = "";
    int randInt;
    
    public UnikeTall(int arrayLenth) {
        intArray = new int[arrayLenth];
    }
    
    public boolean alreadyPicked() {
        boolean bool = false;
        for (int i : intArray) {
            if (i == randInt) {
                bool = true;
                //kode for feilsøking. Viser tallene som blir plukket dobbelt
                System.out.println((i+1) + "allerede plukket");
                break;
            }
        }
        return bool;
    }
    
    public void fillArray() {
        
        for (int i = 0; i < intArray.length; i++) {
            Random rand = new Random();
            randInt = rand.nextInt(100, 1000);
            
            /*Hvis tallet ikke allerede eksisterer, settes plassen i arrayet til randInt sin verdi.
            Videre legges tallet til i en string, og for hvert 8. tall printes en ny linje*/
            if (!alreadyPicked()) {
                intArray[i] = randInt;
                if ((i + 1) % 8 == 0) {
                    arrayAsString += intArray[i] + "\n";
                } else {
                    arrayAsString += intArray[i] + " ";
                }
            } else if (alreadyPicked()) {
                //tar telleren ett steg tilbake slik at vi fremdeles fyller arrayet
                i -= 1;
            }
        }
    }
    
    private int smallestNumber() {
        int smallest = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < smallest) {
                smallest = intArray[i];
            }
        }
            return smallest;
    }
    
    private int biggestNumber() {
        int biggest = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > biggest) {
                biggest = intArray[i];
            }
        }
        return biggest;
    }
    
    private double average() {
        double sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        return sum / intArray.length;
    }
    
    public void showArray() {
        JOptionPane.showMessageDialog(null, arrayAsString + "\nMinste tall er " +
                smallestNumber() + "\nStørste tall er " + biggestNumber() + "\nGjennomsnittsverdien er " + average());
    }
}
