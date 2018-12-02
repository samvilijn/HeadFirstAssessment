public class Station {

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public void rijdtBinnen() {
        System.out.println("De trein rijdt station " + name + " binnen.");
    }

    public void rijdtWeg() {
        System.out.println("De trein verlaat station " + name + ".");
        System.out.println(" ");
    }

    public String getName() {
        return name;
    }
}
