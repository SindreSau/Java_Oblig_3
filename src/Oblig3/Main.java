package Oblig3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    
        //Innlesing av lengde på arrayet. Det sjekkes om tallet er en integer, og at det er større enn 0
        int arrayLength = 0;
        while (true) {
            try {
                arrayLength = Integer.parseInt(JOptionPane.showInputDialog("Arrayets lengde"));
    
                if (arrayLength > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Innlest tall må være en integer større enn 0");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Innlest tall må være av typen integer");
                System.out.println("Error, prøv igjen");
            }
        }
        
        UnikeTall tall = new UnikeTall(arrayLength);
        tall.fillArray();
        tall.showArray();
        
        System.exit(0); //Avslutter programmet når message-vinduet lukkes
    }
}
