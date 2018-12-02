import java.time.temporal.JulianFields;

public class Main {

    public static void main(String[] args) {
        //station Goes
        Station goes = new Station("Goes");
		
        //trein
        Trein trein = new Trein(goes);

        Wagon alpha = new Wagon("Alpha");
        trein.koppelWagon(alpha);

        Reiziger Lorena = new Reiziger("Lorena", 1);
        Reiziger Erik = new Reiziger("Erik", 2);
        Reiziger Bart = new Reiziger("Bart", 2);
        Reiziger Jacco = new Reiziger("Jacco", 2);
        Reiziger Gert = new Reiziger("Gert", 2);
        Reiziger Henk = new Reiziger("Henk", 2);
        Reiziger Zwartrijder = new Reiziger("Zwartrijder", 0);


        trein.instappen(Lorena);
        trein.instappen(Erik);
        trein.instappen(Bart);
        trein.instappen(Jacco);
        trein.instappen(Gert);
        trein.instappen(Henk);
        trein.instappen(Zwartrijder);

        trein.info();
        trein.rijdtWeg();

        //station arnemuiden
        Station arnemuiden = new Station("Arnemuiden");
        trein.rijdtBinnen(arnemuiden);
        Wagon beta = new Wagon("Beta");
        trein.koppelWagon(beta);

        trein.relocate();

        Reiziger Jeffrey = new Reiziger("Jeffrey", 2);
        Reiziger Mariano = new Reiziger("Mariano", 2);

        trein.instappen(Jeffrey);
        trein.instappen(Mariano);

        trein.info();
        trein.rijdtWeg();

        trein.uitstappen(Zwartrijder);

        //station middelburg
        Station middelburg = new Station("Middelburg");
        trein.rijdtBinnen(middelburg);

        Reiziger Julian = new Reiziger("Julian", 1);

        trein.instappen(Julian);

        trein.info();

        trein.rijdtWeg();

        //station vlissingen souburg
        Station vlissingensouburg = new Station("Vlissingen-Souburg");
        trein.rijdtBinnen(vlissingensouburg);

        trein.uitstappen(Jeffrey);
        trein.uitstappen(Mariano);
        trein.info();
        trein.rijdtWeg();

        //station vlissingen
        Station vlissingen = new Station("Vlissingen");
        trein.rijdtBinnen(vlissingen);

        trein.uitstappen(Lorena);
        trein.uitstappen(Erik);
        trein.uitstappen(Bart);
        trein.uitstappen(Jacco);
        trein.uitstappen(Gert);
        trein.uitstappen(Henk);
        trein.uitstappen(Julian);

        //wie zit er in de trein?
        trein.info();
		
		//station rotterdam - exception - trein is in vlissingen
		Station rotterdam = new Station("Rotterdam");
		try {
			trein.rijdtBinnen(rotterdam);
		} catch (IllegalStateException e) {
			System.out.println(e);			
		}
		
		//exception - de trein mag niet twee keer onderweg zijn
		trein.rijdtWeg();
		try {
			trein.rijdtWeg();
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
    }
}
