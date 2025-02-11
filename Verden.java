public class Verden {
    private Rutenett rutenett; // Instans av Rutenett
    private int genNr; // Antall generasjoner

    // Konstruktør: Oppretter en ny verden med et rutenett av gitt størrelse
    public Verden(int antRader, int antKolonner) {
        this.rutenett = new Rutenett(antRader, antKolonner);
        this.genNr = 0;
        rutenett.fyllMedTilfeldigeCeller(); // Fyller rutenettet med tilfeldige celler
        rutenett.kobleAlleCeller(); // Koble cellene sammen
    }

    // Metode for å tegne rutenettet og skrive ut generasjonsnummeret og antall levende celler
    public void tegn() {
        System.out.println("Generasjon: " + genNr);
        rutenett.tegnRutenett();
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }

    // Metode for å oppdatere verden til neste generasjon
    public void oppdatering() {
        rutenett.tellAlleLevendeNaboer(); // Oppdater antall levende naboer for alle celler
        rutenett.oppdaterAlleCeller(); // Oppdater status for alle celler
        genNr++; // Øk generasjonsnummeret
    }
}

// Metode for å oppdatere verden til neste generasjon
public void oppdatering() {
    rutenett.tellAlleLevendeNaboer(); // TELL LEVENDE NABOER FØRST
    rutenett.oppdaterAlleCeller(); // DERETTER OPPDATER STATUS FOR CELLENE
    genNr++; // Øk generasjonsnummeret
}

