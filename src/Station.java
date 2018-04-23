import java.util.Stack;

public class Station {

    private Stack<Reiziger> perron = new Stack<>();

    public void rijdtBinnen(Trein trein){
        leegTrein(trein);
        vulTrein(trein);
    }

    private void leegTrein(Trein trein){
        for(String name: trein.getNames()){
            Reiziger uitgestapte = trein.uitstappen(name);
            perron.push(uitgestapte);
        }
    }

    private void vulTrein(Trein trein){
        while(!perron.isEmpty()){
            Reiziger opgestapelde = perron.pop();
            trein.instappen(opgestapelde);
        }
    }
}
