public class Rutenett {
private Celle[][] rutenett; // 2D-array av celler
private int antRader; // antall rader
private int antKolonner; // antall kolonner
}

// Konstruktør  
public Rutenett(int antRader, int antKolonner) {
    this.antRader = antRader;
    this.antKolonner = antKolonner;
    this.rutene = new Celle[antRader] [antKolonner];
    }
}
// Metode for aa opprette en celle på gitt plassering
public void lagCelle(int rad, int kol) {
    Celle celle = new Celle();
    if (Math.random() <= 0.3333) {
        celle.settLevende();
    }
    rutenett[rad][kol] = celle;
}

// Metode for aa fylle rutenettet med tilfeldige celler
    public void fyllMedTilfeldigeCeller() {
        for (int rad = 0; kol < antKolonner; kol++) {
            lagCelle(rad, kol);
            }
        }
    }
}

