import org.junit.Assert;

public class TreinTest {

    @org.junit.Test
    public void geefAantalZwartrijders() {
        //arrange
        Trein trein = new Trein();
        Wagon alpha = new Wagon("Alpha");
        trein.koppelWagon(alpha);
        Reiziger zwartrijder = new Reiziger("Patrick", 0);
        Reiziger Erik = new Reiziger("Erik", 1);
        Reiziger Lorena = new Reiziger("Lorena", 2);
        trein.instappen(zwartrijder);
        trein.instappen(Erik);
        trein.instappen(Lorena);

        //act
        int aantalReizigers = trein.geefAantalZwartrijders();
        //assert
        Assert.assertEquals(1,aantalReizigers);
    }

    @org.junit.Test
    public void geefAantalInstappen() {
        //arrange
        Trein trein = new Trein();
        Wagon alpha = new Wagon("Alpha");
        trein.koppelWagon(alpha);
        trein.instappen(new Reiziger("Erik", 2));
        trein.instappen(new Reiziger("Lorena", 2));

        //act
        int aantalReizigers = trein.getTotal();
        //assert
        Assert.assertEquals(2,aantalReizigers);
    }

    @org.junit.Test
    public void geefAantalEersteKlas() {
        //arrange
        Trein trein = new Trein();
        Wagon alpha = new Wagon("Alpha");
        trein.koppelWagon(alpha);
        trein.instappen(new Reiziger("Erik", 2));
        trein.instappen(new Reiziger("Lorena", 1));
        trein.instappen(new Reiziger("Tin", 1));

        //act
        int aantalReizigers = alpha.getFirstTotal();
        //assert
        Assert.assertEquals(2,aantalReizigers);
    }

    @org.junit.Test
    public void geefAantalTweedeKlas() {
        //arrange
        Trein trein = new Trein();
        Wagon alpha = new Wagon("Alpha");
        trein.koppelWagon(alpha);
        trein.instappen(new Reiziger("Erik", 2));
        trein.instappen(new Reiziger("Lorena", 1));
        trein.instappen(new Reiziger("Tin", 1));

        //act
        int aantalReizigers = alpha.getSecondTotal();
        //assert
        Assert.assertEquals(1,aantalReizigers);
    }
    @org.junit.Test
    public void treinZonderWagons() {
        //arrange
        Trein trein = new Trein();
        trein.instappen(new Reiziger("Erik", 2));
        trein.instappen(new Reiziger("Lorena", 1));


        //act
        int aantalReizigers = trein.getTotal();
        //assert
        Assert.assertEquals(0,aantalReizigers);
    }
}
