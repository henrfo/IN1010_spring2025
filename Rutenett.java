public class Rutenett {
    private Celle[][] rutenett; // 2D-array av celler
    private int antRader; // Antall rader
    private int antKolonner; // Antall kolonner

    // Konstruktoer  
    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        this.rutenett = new Celle[antRader][antKolonner];
    }

    // Metode for å opprette en celle på spesifikk plassering
    public void lagCelle(int rad, int kol) {
        Celle celle = new Celle();
        if (Math.random() <= 0.3333) {
            celle.settLevende();
        }
        rutenett[rad][kol] = celle;
    }

    // Metode for å fylle rutene med tilfeldige celler
    public void fyllMedTilfeldigeCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

    // Metode for å hente en celle på en spesifikk posisjon
    public Celle hentCelle(int rad, int kol) {
        if (rad >= 0 && rad < antRader && kol >= 0 && kol < antKolonner) {
            return rutenett[rad][kol]; // Returnerer cellen hvis indeks er gyldig
        }
        return null; // Returnerer null hvis utenfor grensene
    }

    // Metode for å koble alle celler sammen
    public void kobleAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                Celle celle = rutenett[rad][kol];
                if (celle != null) { // Sjekker at cellen finnes
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) continue; // Teller ikke seg selv
                            int naboRad = rad + i;
                            int naboKol = kol + j;
                            Celle nabo = hentCelle(naboRad, naboKol);
                            if (nabo != null) {
                                celle.leggTilNabo(nabo);
                            }
                        }
                    }
                }
            }
        }
    }

    // Metode for å tegne rutenettet
    public void tegnRutenett() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutenett[rad][kol] != null) {
                    System.out.print(rutenett[rad][kol].hentStatusTegn() + " ");
                } else {
                    System.out.print("? "); // Feilhaandtering
                }
            }
            System.out.println(); // Ny rad
        }
    }

    // Metode for aa telle alle levende celler
    public int antallLevende() {
        int antallLevende = 0;
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutenett[rad][kol] != null && rutenett[rad][kol].erLevende()) {
                    antallLevende++; // Teller hvis cellen er levende
                }
            }
        }
        return antallLevende;
    }

    // Metode for aa telle alle levende naboer
    public void tellAlleLevendeNaboer() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutenett[rad][kol] != null) { // Sjekker at cellen finnes
                    rutenett[rad][kol].tellLevendeNaboer();
                }
            }
        }
    }

    // Metode for aa oppdatere status for alle celler
    public void oppdaterAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutenett[rad][kol] != null) { // Sjekker at cellen finnes
                    rutenett[rad][kol].oppdaterStatus();
                }
            }
        }
    }
}
