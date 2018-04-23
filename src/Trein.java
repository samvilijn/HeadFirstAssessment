import java.util.HashMap;
import java.util.LinkedHashMap;

public class Trein {

    private HashMap<String, Nameable> wagon = new LinkedHashMap<String, Nameable>();

    public void instappen(Reiziger reiziger1, Reiziger reiziger2, Reiziger reiziger3) {
        instappen(reiziger1);
        instappen(reiziger2);
        instappen(reiziger3);

    }
    public void instappen(reiziger reiziger){
        String key = reiziger.getName();
        Reiziger value = reiziger;
        this.wagon.put(key, value);
        showInfo(reiziger, " is ingestapt.");
    }

}
