public class Celle {
    public  boolean levende; // Status: true = levende, false = doed
    public Celle[] naboer; // Array for aa lagre opp til 8 naboer
    public int antNaboer; // antall naboer
    public int antLevendeNaboer; // antall levende naboer

    // Konstruktoer: starter med cellen som doed og ingen naboer
    public Celle() {
        this.levende = false; // Normalverdi: Doed
        this.naboer = new Celle[8]; // Maks 8 naboer
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
    }

    // Metode for aa endre cellen til levende
    public void settLevende() {
        this.levende = true;
    }

    // Metode for aa endre cellen til doed
    public void settDoed() {
        this.levende = false;
    }

    // Metode for aa sjekke om cellen er levende
    public boolean erLevende() {
        return this.levende;
    }

    // Hent status (O = levende, . = doed)
    public char hentStatusTegn() {
        if (this.levende) {
            return 'O';
        } else {
            return '.';
        }
    }
    
    // Legg til nabocelle
    public void leggTilNabo(Celle nabo) {
        if (antNaboer < naboer.length) { //sjekk om plass til flere naboer
            naboer[antNaboer] = nabo; // legg til nabo
            antNaboer++; // oeker antaller naboer
        }
    }

    // Metode for aa telle levenede naboer
    public void tellLevendeNaboer() {
        antLevendeNaboer = 0; // starter paa null
        for (int i = 0; i < antNaboer; i++) { // loop gjennom nabo
            if (naboer[i] != null && naboer[i].erLevende()) { // sjekker om nabo lever
                antLevendeNaboer++; // oeker antall hvis nabo lever
            }
        }
    }
            
    // Metode for aa oppdatere celle status
    public void oppdaterStatus() {
        if (this.levende) {
            if (antLevendeNaboer < 2) {
                this.settDoed(); // doer naar faerre enn to
            } else if (antLevendeNaboer > 3) {
                this.settDoed();  // doer naar mer enn tre
            }
        } else {
            if (antLevendeNaboer == 3) {
                this.settLevende(); // levende naar tre naboer
            }
        }
    }
}