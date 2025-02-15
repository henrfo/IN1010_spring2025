public class GameOfLife {
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12); // Oppretter Verden med 8 rader og 12 kolonner
        
        verden.tegn(); // Tegner 0-te generasjon
        
        for (int i = 0; i < 3; i++) { // Kjører simulering i 3 gen
            verden.oppdatering(); // Oppdaterer verden til neste gen
            System.out.println();
            verden.tegn(); // Tegner rutenett etter oppdatering
        }
    }
}