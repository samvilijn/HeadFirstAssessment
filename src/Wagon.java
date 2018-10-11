import java.util.HashMap;

public class Wagon {
    // Eerste en tweede klasse.
    private HashMap<String, Reiziger> first = new HashMap();
    private HashMap<String, Reiziger> second = new HashMap();

    private String name;

    public Wagon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void inWagon(Reiziger reiziger) {
        if (reiziger.getTicket() == 1) {
            first.put(reiziger.getName(), reiziger);
        } else {
            if (second.size() < 4) {
                second.put(reiziger.getName(), reiziger);
            } else {
                first.put(reiziger.getName(), reiziger);
            }
        }
    }

    public void uitWagon(Reiziger reiziger, String wagon) {
        if (wagon.equals("first")) {
            first.remove(reiziger.getName(), reiziger);
        } else {
            second.remove(reiziger.getName(), reiziger);
        }
    }

    public int getFirstTotal() {

        return first.size();
    }

    public int getSecondTotal() {

        return second.size();
    }

    public int getTotal() {
        return first.size() + second.size();
    }

    public HashMap<String, Reiziger> getFirst() {
        return first;
    }

    public HashMap<String, Reiziger> getSecond() {
        return second;
    }
}
