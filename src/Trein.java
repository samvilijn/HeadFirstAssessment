import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Trein {

    private HashMap<String, Nameable> stoelen = new LinkedHashMap<String, Nameable>();


    public void instappen(reiziger reiziger){
        String key = reiziger.getName();
        Reiziger value = reiziger;
        this.stoelen.put(key, value);
        showInfo(reiziger, " is ingestapt.");
    }
    private int getCount(){
        return stoelen.size();
    }

    private void showInfo(Reiziger uitgestapte, String actie){
        System.out.println(uitgestapte.getName() + actie);
    }

    public Reiziger uitstappen(String name){
        Reiziger uitgestapte = stoelen.get(name);
        stoelen.remove(name);
        showInfo(uitgestapte, " is uitgestapt.");
        return uitgestapte;
    }

    public void info(){
        System.out.println(this);
    }

    public void printNames(){
        System.out.println("Deze mensen zitten in de trein");
        for(Map.Entry<String, Reiziger> entry : wagon.entrySet()){
            String key = entry.getkey();
            System.out.println("- "+key);
        }
    }

}
