class TestCelle {
    private static void sjekk (String hva, boolean test) {
        if (! test) {
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }
    
    private static void testCelle () {
        Celle celle = new Celle();
        sjekk("celle er død", ! celle.getLevende()); // ✅ FIXED
        sjekk("celle.antLevendeNaboer == 0", celle.getAntLevendeNaboer() == 0); // ✅ FIXED
        System.out.println("Konstruktør: Alt riktig!");
    }

    private static void testSettDoedLevende () {
        Celle celle = new Celle();
        celle.settLevende();
        sjekk("celle er levende", celle.getLevende()); // ✅ FIXED
        celle.settDoed();
        sjekk("celle er død", ! celle.getLevende()); // ✅ FIXED
        System.out.println("settDød() og settLevende(): Alt riktig!");
    }
    
    private static void testErLevende () {
        Celle celle = new Celle();
        sjekk("celle er død", ! celle.erLevende());
        celle.settLevende();
        sjekk("celle er levende", celle.erLevende());
        System.out.println("erLevende(): Alt riktig!");
    }
    
    private static void testHentStatusTegn () {
        Celle celle = new Celle();
        sjekk("celle.hentStatusTegn()=='.'", celle.hentStatusTegn() == '.');
        celle.settLevende();
        sjekk("celle.hentStatusTegn()=='O'", celle.hentStatusTegn() == 'O');
        System.out.println("hentStatusTegn(): Alt riktig!");
    }
    
    private static void testLeggTilNabo () {
        Celle celle = new Celle();
        Celle nabo1 = new Celle();
        celle.leggTilNabo(nabo1);
        sjekk("celle.antNaboer==1", celle.getAntNaboer() == 1); // ✅ FIXED
        System.out.println("leggTilNabo(): Alt riktig!");
    }

    private static void testTellLevendeNaboer () {
        Celle celle = new Celle();
        Celle nabo1 = new Celle();
        Celle nabo2 = new Celle();
        celle.leggTilNabo(nabo1);
        celle.leggTilNabo(nabo2);
        celle.tellLevendeNaboer();
        sjekk("celle.antLevendeNaboer==0", celle.getAntLevendeNaboer() == 0); // ✅ FIXED

        nabo1.settLevende();
        celle.tellLevendeNaboer();
        sjekk("celle.antLevendeNaboer==1", celle.getAntLevendeNaboer() == 1); // ✅ FIXED

        nabo2.settLevende();
        celle.tellLevendeNaboer();
        sjekk("celle.antLevendeNaboer==2", celle.getAntLevendeNaboer() == 2); // ✅ FIXED

        System.out.println("tellLevendeNaboer(): Alt riktig!");
    }
    
    private static void testOppdaterStatus () {
        Celle celle = new Celle();
        celle.oppdaterStatus();
        sjekk("celle er død (siden <2 levende naboer)", ! celle.erLevende());

        Celle nabo1 = new Celle();
        nabo1.settLevende();
        celle.leggTilNabo(nabo1);

        Celle nabo2 = new Celle();
        nabo2.settLevende();
        celle.leggTilNabo(nabo2);
        celle.tellLevendeNaboer();
        celle.oppdaterStatus();
        sjekk("celle forblir død (siden 2 levende naboer)", ! celle.erLevende());

        Celle nabo3 = new Celle();
        nabo3.settLevende();
        celle.leggTilNabo(nabo3);
        celle.tellLevendeNaboer();
        celle.oppdaterStatus();
        sjekk("celle blir levende (siden 3 levende naboer)", celle.erLevende());

        Celle nabo4 = new Celle();
        nabo4.settLevende();
        celle.leggTilNabo(nabo4);
        celle.tellLevendeNaboer();
        celle.oppdaterStatus();
        sjekk("celle doer (siden >3 levende naboer)", ! celle.erLevende());

        System.out.println("oppdaterStatus(): Alt riktig!");
    }

    public static void main (String[] arg) {
        System.out.println("** Test Celle **");

        testCelle();
        testSettDoedLevende();
        testErLevende();
        testHentStatusTegn();
        testLeggTilNabo();
        testTellLevendeNaboer();
        testOppdaterStatus();
        
        System.out.println();
    }
}

