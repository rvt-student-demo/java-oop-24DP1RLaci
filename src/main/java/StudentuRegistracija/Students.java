package StudentuRegistracija;

import java.time.LocalDate;

public class Students {
    private String Vards;
    private String Uzvards;
    private String Epasts;
    private int PerKods;
    private LocalDate RegDatums;
    private String RegLaiks;

    public Students(String Vards, String Uzvards, String Epasts, int PerKods, LocalDate RegDatums, String RegLaiks) {
        this.Vards = Vards;
        this.Uzvards = Uzvards;
        this.Epasts = Epasts;
        this.PerKods = PerKods;
        this.RegDatums = RegDatums;
        this.RegLaiks = RegLaiks;
    }

    public void changeVards(String jaunsVards) {
        this.Vards = jaunsVards;
    }

    public void changeUzvards(String jaunsUzvards) {
        this.Uzvards = jaunsUzvards;
    }

    public void changeEpasts(String jaunsEpasts) {
        this.Epasts = jaunsEpasts;
    }

    public void changePersonaskods(int jaunsPerKods) {
        this.PerKods = jaunsPerKods;
    }

    public void changeDatums(LocalDate jaunsDatums) {
        this.RegDatums = jaunsDatums;
    }

    public void changeLaiks(String jaunsLaiks) {
        this.RegLaiks = jaunsLaiks;
    }

    public int getPerKods() {
        return this.PerKods;
    }
    

    @Override
    public String toString() {
        return Vards + ", " + Uzvards + ", " + Epasts + ", " + PerKods + ", " + RegDatums + ", " + RegLaiks;
    }
    
}
