package StudentuRegistracija;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    ArrayList<Students> list;
    Scanner reader;
    private final String filePath = "data/register.csv";

    public FileHandler() {
        list = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(this.filePath));
            while (fileScanner.hasNextLine()) {
                String[] parametrs = fileScanner.nextLine().split(",");
                for (int i = 0; i < parametrs.length; i++) {
                    parametrs[i] = parametrs[i].trim();
                }
                Students timeStudent = new Students(
                    parametrs[0],
                    parametrs[1],
                    parametrs[2],
                    Integer.parseInt(parametrs[3]),
                    LocalDate.parse(parametrs[4]),
                    parametrs[5]
                );
                list.add(timeStudent);
            }
            fileScanner.close();
            this.reader = new Scanner(System.in);
        }
        catch (IOException e) {
            System.out.println(e + " Konstrukora kļūda");
        }
    }

    public void register(String Vards, String Uzvards, String Epasts, int PerKods, LocalDate RegDatums, String RegLaiks) {
        Students students = new Students(Vards, Uzvards, Epasts, PerKods, RegDatums, RegLaiks);
        list.add(students);
        try (FileWriter writer = new FileWriter(this.filePath)) {
            for (Students elem : list) {
                writer.write(elem.toString() + "\n");
            }
        }
        catch (IOException e) {
            System.out.printf("Kļūda %s\n", e);
        }
    }

    public void show() {
        if (list.isEmpty()) {
            System.out.println("Nav reģistrāciju.");
            return;
        }
        System.out.printf("%-10s|%-10s|%-30s|%-11s|%-10s|%-5s|\n", "Vārds", "Uzārds", "E-pasts", "PersKods", "Reģ datums", "Laiks");
        System.out.println("-".repeat(82));
        for (Students s : list) {
            String[] parts = s.toString().split(", ");
            System.out.printf("%-10s|%-10s|%-30s|%-11s|%-10s|%-5s|\n", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
        }
        System.out.println("-".repeat(82));
    }

    public void remove(int PerKods) {
        boolean removed = list.removeIf(elem -> elem.getPerKods() == PerKods);
        if (removed) {
            try (FileWriter writer = new FileWriter(this.filePath)) {
                for (Students stud : list) {
                    writer.write(stud.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.printf("Neizdevās izdzēst: %s\n", e);
            }
        }
    }

    public void edit(int PerKods) {
        for (Students elem : list) {
            if (elem.getPerKods() == PerKods) {
                System.out.println(
                    "Kurus datus jūs vēlaties rediģēt\nV - vards U - uzvards E - epasts P - Personas kods D - Registracijas dautms T - Registracijas laiks"
                );
                String user_input = reader.nextLine().trim();
                switch(user_input) {
                    case "V" -> {
                        System.out.println("Ievadiet jauno vārdu:");
                        user_input = reader.nextLine().trim();
                        elem.changeVards(user_input);
                    }
                    case "U" -> {
                        System.out.println("Ievadiet jauno uzvārdu:");
                        user_input = reader.nextLine().trim();
                        elem.changeUzvards(user_input);
                    }
                    case "E" -> {
                        System.out.println("Ievadiet jauno e-pastu:");
                        user_input = reader.nextLine().trim();
                        elem.changeEpasts(user_input);
                    }
                    case "P" -> {
                        System.out.println("Ievadiet jauno personas kodu:");
                        user_input = reader.nextLine().trim();
                        elem.changePersonaskods(Integer.parseInt(user_input));
                    }
                    case "D" -> {
                        System.out.println("Ievadiet jauno reģistrācijas datumu:");
                        user_input = reader.nextLine().trim();
                        elem.changeDatums(LocalDate.parse(user_input));
                    }
                    case "T" -> {
                        System.out.println("Ievadiet jauno reģistrācijas laiku:");
                        user_input = reader.nextLine().trim();
                        elem.changeLaiks(user_input);
                    }
                }

                try (FileWriter writer = new FileWriter(this.filePath)) {
                    if (!list.isEmpty()) {
                        for (Students stud : list) {
                            writer.write(stud.toString() + "\n");
                        }
                    }
                    writer.flush();
                } catch (IOException e) {
                    System.out.printf("Kļūda: %s\n", e);
                }
            }
        }
    }

}
