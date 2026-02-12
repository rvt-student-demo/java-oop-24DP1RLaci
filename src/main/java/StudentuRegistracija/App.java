package StudentuRegistracija;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileHandler file = new FileHandler();
        Scanner scanner = new Scanner(System.in);
        CLI cli = new CLI(file, scanner);
        cli.start();
        
    }
}
