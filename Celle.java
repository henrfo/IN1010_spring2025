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


