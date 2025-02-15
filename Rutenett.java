public class Rutenett {
    public Celle[][] rutene; // 2D-array av celler
    public int antRader; // Antall rader
    public int antKolonner; // Antall kolonner

    // Konstruktoer  
    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        this.rutene = new Celle[antRader][antKolonner];
    }

    // Metode for aa opprette en celle paa spesifikk plassering
    public void lagCelle(int rad, int kol) {
        Celle celle = new Celle();
        if (Math.random() <= 0.3333) {
            celle.settLevende();
        }
        rutene[rad][kol] = celle;
    }

    // Metode for aa fylle rutene med tilfeldige celler
    public void fyllMedTilfeldigeCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                lagCelle(rad, kol);
            }
        }
    }

    // Metode for aa hente en celle paa en spesifikk posisjon
    public Celle hentCelle(int rad, int kol) {
        if (rad >= 0 && rad < antRader && kol >= 0 && kol < antKolonner) {
            return rutene[rad][kol]; // Returnerer cellen hvis indeks er gyldig
        }
        return null; // Returnerer null hvis utenfor grensene
    }

    // Metode for aa koble alle celler sammen
    public void kobleAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                settNaboer(rad, kol);
            }
        }
    }

    // Metode for aa sette naboer for en spesifikk celle
    public void settNaboer(int rad, int kol) {
        Celle celle = hentCelle(rad, kol);
        if (celle != null) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // Skipper seg selv
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

    // Metode for aa tegne rutenettet
    public void tegnRutenett() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutene[rad][kol] != null) {
                    System.out.print(rutene[rad][kol].hentStatusTegn() + " ");
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
                if (rutene[rad][kol] != null && rutene[rad][kol].erLevende()) {
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
                if (rutene[rad][kol] != null) { // Sjekker at cellen finnes
                    rutene[rad][kol].tellLevendeNaboer();
                }
            }
        }
    }

    // Metode for aa oppdatere status for alle celler
    public void oppdaterAlleCeller() {
        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rutene[rad][kol] != null) { // Sjekker at cellen finnes
                    rutene[rad][kol].oppdaterStatus();
                }
            }
        }
    }
}