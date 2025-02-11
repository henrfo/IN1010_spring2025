public class Celle {
    private boolean levende; // Status: true = levende, false = doed
    private Celle[] naboer; // Array for aa lagre opp til 8 naboer
    private int antNaboer; // antall naboer
    private int antLevendeNaboer; // antall levende naboer

    // Konstruktør: igangsetter cellen som doed
    public Celle() {
        this.levende = false; // Normalverdi: Doed
        this.naboer = new Celle[8]; // Maks 8 naboer
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
    }

    // Metode for aa sette cellen som levende
    public void settLevende() {
        this.levende = true;
    }

    // Metode for aa sette cellen som doed
    public void settDoed() {
        this.levende = false;
    }

    // Metode for aa sjekke om cellen er levende
    public boolean erLevende() {
        return this.levende;
    }

    // Hent status
    public char hentStatusTegn() {
        return this.levende ? 'O' : '.'; // Hvis levende, returner 'O', ellers '.'
    }
    
    // Legg til nabocelle
    public void leggTilNabo(Celle nabo) {
        if (antNaboer < naboer.length) {
            naboer[antNaboer] = nabo;
            antNaboer++;
        }
    }

    // Metode for aa telle levenede naboer
    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++) {
            if (naboer[i] != null && naboer[i].erLevende()) {
                antLevendeNaboer++;
            }
        }
    }
            
    // Metode for aa oppdatere celle status
    public void oppdaterStatus() {
        if (levende) {
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3) {
                settDoed();
            }
        } else { 
            // Blir levende hvis den har 3 levende naboer
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }
    }
}