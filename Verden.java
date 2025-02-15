public class Verden {
    private Rutenett rutenett; // Instans av Rutenett
    private int genNr; // Antall generasjoner

    // Konstruktoer: Oppretter en ny verden med et rutenett av gitt stoerrelse
    public Verden(int antRader, int antKolonner) {
        this.rutenett = new Rutenett(antRader, antKolonner);
        this.genNr = 0;
        rutenett.fyllMedTilfeldigeCeller(); // fyll med celler
        rutenett.kobleAlleCeller(); // koble celler
    }

    // Metode for aa tegne rutenettet og skrive ut generasjonsnummeret og antall levende celler
    public void tegn() {
        System.out.println("Generasjon: " + genNr);
        rutenett.tegnRutenett();
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
    }

    // Metode for aa oppdatere verden til neste generasjon
    public void oppdatering() {
        rutenett.tellAlleLevendeNaboer(); // Oppdater levende naboer
        rutenett.oppdaterAlleCeller(); // Oppdater celle-status
        genNr++; // Oeker gen nr
    }
}