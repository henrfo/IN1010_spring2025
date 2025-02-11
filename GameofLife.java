public class GameOfLife {
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12); // Oppretter en Verden med 8 rader og 12 kolonner
        
        verden.tegn(); // Tegner 0-te generasjon
        
        for (int i = 0; i < 3; i++) { // Kjører simuleringen i 3 generasjoner
            verden.oppdatering(); // Oppdaterer verden til neste generasjon
            verden.tegn(); // Tegner rutenettet etter oppdatering
        }
    }
}