public class Main {

    public static void main(String[] args) {

        //station Goes
        Station goes = new Station();
        goes.rijdtBinnen(trein);
        Wagon alfa = new Wagon();

        Reiziger lorena = new Reiziger("lorena");
        Reiziger erik = new Reiziger("erik");
        Reiziger bart = new Reiziger("bart");
        Reiziger jacco = new Reiziger("jacco");
        Reiziger gert = new Reiziger("gert");
        Reiziger zwartrijder = new Reiziger("zwartrijder");

        trein.instappen(lorena, erik, bart, jacco, gert, zwartrijder);
        trein.info();


        //station arnemuiden
        Station arnemuiden = new Station();
        arnemuiden.rijdtBinnen(trein);
        Wagon beta = new Wagon();

        Reiziger jeffrey = new Reiziger("jeffrey");
        Reiziger mariano = new Reiziger("mariano");

        trein.instappen(jeffrey, mariano);
        trein.info();

        //station middelburg
        Station middelburg = new  Station();
        middelburg.rijdtBinnen(trein);

        Reiziger julian = new Reiziger("julian");

        trein.instappen(julian);


        trein.uitstappen(zwartrijder);
        trein.info();

        //station vlissingen souburg
        Station vlissingensouburg = new Station();
        vlissingensouburg.rijdtBinnen(trein);

        trein.uitstappen(jeffrey, mariano);
        trein.info();

        //station vlissingen
        Station vlissingen = new Station();
        vlissingen.rijdtBinnen(trein);

        trein.uitstappen(lorena, erik, bart, jacco, gert, julian);
        trein.info();


        //wie zit er in de trein?
        trein.info();
        trein.printNames();


    }
}
