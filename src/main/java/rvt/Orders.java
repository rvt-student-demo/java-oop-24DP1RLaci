package rvt;

import java.io.File;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File("data/orders.csv"))) {
            reader.nextLine();
            Double totalSum = 0.0;
            while (reader.hasNextLine()) { 
                String row = reader.nextLine();
                String[] parts = row.split(",");
                System.out.printf("Pasutijums #%s: %s pasutija %s x %s (%s EUR) -> %.2f EUR\n", parts[0], parts[1], parts[3], parts[2], parts[4], Integer.valueOf(parts[3]) * Double.valueOf(parts[4]));
                totalSum += Integer.valueOf(parts[3]) * Double.valueOf(parts[4]);
            }
            System.out.printf("Kopeja pasutijumu summa: %.2f EUR", totalSum);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}