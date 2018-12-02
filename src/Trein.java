import java.util.HashMap;
import java.util.Map;

public class Trein {

    private HashMap<String, Wagon> wagons = new HashMap();
	private Station huidigStation;

    public Trein(Station startStation) {
		huidigStation = startStation;
    }
	
	public Station getStation() {
		return huidigStation;
	}
	
	public void rijdtBinnen(Station nieuwStation)
	{
		if (huidigStation != null)
		{
			throw new IllegalStateException("De trein is al in station " + huidigStation.getName());
		}
		huidigStation = nieuwStation;
		huidigStation.rijdtBinnen();
	}
	
	public void rijdtWeg()
	{
		if (huidigStation == null) {
			throw new IllegalStateException("De trein is al onderweg");
		}
		huidigStation.rijdtWeg();
		huidigStation = null;
	}
	

    public void koppelWagon(Wagon wagon) {
        wagons.put(wagon.getName(), wagon);
        System.out.println("Wagon " + wagon.getName() + " is aangekoppeld.");
        System.out.println(" ");
    }

    public void instappen(Reiziger reiziger) {
        checkWagonStatus();
        if (reiziger.getTicket() == 1) {
            if (wagons.size() > 1) {
                if (wagons.get("Alpha").getFirstTotal() < 3) {
                    wagons.get("Alpha").inWagon(reiziger);
                } else {
                    wagons.get("Beta").inWagon(reiziger);
                }
            } else {
                wagons.get("Alpha").inWagon(reiziger);
            }
        } else {
            if (wagons.size() > 1) {
                if (wagons.get("Alpha").getSecondTotal() < 4) {
                    wagons.get("Alpha").inWagon(reiziger);
                } else {
                    wagons.get("Beta").inWagon(reiziger);
                }
            } else {
                wagons.get("Alpha").inWagon(reiziger);
            }
        }
        System.out.println(reiziger.getName() + " is ingestapt.");
    }

    public void uitstappen(Reiziger reiziger) {
        for (Map.Entry<String, Wagon> wagon : wagons.entrySet()) {
            Wagon value = wagon.getValue();

            if (value.getFirst().containsKey(reiziger.getName())) {
                value.uitWagon(reiziger, "first");
            } else {
                value.uitWagon(reiziger, "second");
            }
        }
        zwartrijderOpzoeken(reiziger);
    }

    public int geefAantalZwartrijders(){

        int aantalZwartrijders = 0;

        for (Map.Entry<String, Wagon> wagon : wagons.entrySet()) {
            Wagon value = wagon.getValue();

            for (Map.Entry<String, Reiziger> reiziger : value.getFirst().entrySet()) {
                Reiziger traveller = reiziger.getValue();
                if (traveller.getTicket() == 0) {
                    aantalZwartrijders++;
                }
            }

            for (Map.Entry<String, Reiziger> reiziger : value.getSecond().entrySet()) {
                Reiziger traveller = reiziger.getValue();
                if (traveller.getTicket() == 0) {
                    aantalZwartrijders++;
                }
            }
        }

        return aantalZwartrijders;
    }

    private void zwartrijderOpzoeken(Reiziger reiziger) {
        if (reiziger.getTicket() == 0) {
            System.out.println(reiziger.getName() + " is uit de trein gezet.");
            System.out.println(" ");
        } else {
            System.out.println(reiziger.getName() + " is uitgestapt.");
        }
    }

    /**
     * reiziger herplaatsen
     */
    public void relocate() {
        for (Map.Entry<String, Wagon> wagon : wagons.entrySet()) {
            Wagon value = wagon.getValue();

            for (Map.Entry<String, Reiziger> reiziger : value.getFirst().entrySet()) {
                Reiziger traveller = reiziger.getValue();
                if (traveller.getTicket() == 2) {
                    uitstappen(traveller);
                    instappen(traveller);
                }
            }
        }
    }

    public void info() {
        System.out.println(" ");
        System.out.println("Aantal wagons: " + wagons.size());
        System.out.println("Aantal passagiers: " + getTotal());
        System.out.println("Aantal passagiers wagon alpha: " + getWagonTotal("Alpha"));
        System.out.println("Aantal passagiers wagon beta: " + getWagonTotal("Beta"));
        System.out.println("Aantal passagiers eerste klas: " + (getWagonFirst("Alpha") + (getWagonFirst("Beta"))));
        System.out.println("Aantal passagiers tweede klas: " + (getWagonSecond("Alpha") + (getWagonSecond("Beta"))));
        System.out.println(" ");
    }

    public int getTotal() {
        int passagiers = 0;

        for (Map.Entry<String, Wagon> wagon : wagons.entrySet()) {
            Wagon value = wagon.getValue();

            passagiers = passagiers + value.getFirstTotal() + value.getSecondTotal();
        }

        return passagiers;
    }

    public int getWagonTotal(String name) {
        if (wagons.containsKey(name)) {
            return wagons.get(name).getTotal();
        } else {
            return 0;
        }
    }

    public int getWagonFirst(String name) {
        if (wagons.containsKey(name)) {
            return wagons.get(name).getFirstTotal();
        } else {
            return 0;
        }
    }

    public int getWagonSecond(String name) {
        if (wagons.containsKey(name)) {
            return wagons.get(name).getSecondTotal();
        } else {
            return 0;
        }
    }
	
    private void checkWagonStatus(){
        if (this.wagons.isEmpty()){
            throw new IllegalStateException("Er is nog geen wagon gekoppeld");
        }
    }
}
