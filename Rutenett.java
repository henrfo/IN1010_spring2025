public class Rutenett {
    private Celle[][] rutenett; // 2D-array av celler
    private int antRader; // antall rader
    private int antKolonner; // antall kolonner

    // Konstruktør  
    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        this.rutenett = new Celle[antRader][antKolonner];
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
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

    // Metode for aa koble alle celler sammen
    public void kobleAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                Celle celle = rutenett[rad][kol];
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int naboRad = rad + i;
                        int naboKol = kol + j;
                        if (naboRad >= 0 && naboRad < antRader && naboKol >= 0 && naboKol < antKolonner) {
                            celle.leggTilNabo(rutenett[naboRad][naboKol]);
                        }
                    }
                }
            }
        }
    }

    // Metode for aa tegne rutenettet
    public void tegnRutenett() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                System.out.print(rutenett[rad][kol].hentStatusTegn() + " ");
            }
            System.out.println();
        }
    }

    // Metode for aa telle alle levende celler
    public int antallLevende() {
        int antallLevende = 0;
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutenett[rad][kol].erLevende()) {
                    antallLevende++;
                }
            }
        }
        return antallLevende;
    }

    // Metode for aa telle alle levende naboer
    public void tellAlleLevendeNaboer() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                rutenett[rad][kol].tellLevendeNaboer();
            }
        }
    }

    // Metode for aa oppdatere status for alle celler
    public void oppdaterAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                rutenett[rad][kol].oppdaterStatus();
            }
        }
    }
}