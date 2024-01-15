public class Preke {
    private String prekesPavadinimas;
    private double netoKaina;
    private double pvm;

    public Preke(String preke, double netoKaina) {
        this.prekesPavadinimas = preke;
        this.netoKaina = netoKaina;
        pvm =0.21;
    }


    public String getPrekesPavadinimas() {
        return prekesPavadinimas;
    }

    public void setPrekesPavadinimas(String prekesPavadinimas) {
        this.prekesPavadinimas = prekesPavadinimas;
    }

    public double getNetoKaina() {
        return netoKaina;
    }

    public void setNetoKaina(double netoKaina) {
        this.netoKaina = netoKaina;
    }

    public double getKainaSuMokesciais() {
        return Math.round((netoKaina * (1+ pvm)) * 100) /100.00;
    }

    public double getKainaFrankais() {
        return Math.round((netoKaina * (1+ pvm)*0.93) * 100) /100.00;
    }
    public static double convertEurToChf(double eur){
        return Math.round(eur*0.93*100)/100.00;
    }

    public double getPvm() {
        return pvm;
    }

    public void setPvm(double mokesciaiProc) {
        this.pvm = mokesciaiProc/100;
    }
    @Override
    public String toString() {
        return prekesPavadinimas +", "+getKainaSuMokesciais()+", "+getKainaFrankais()+"\n";
    }
}
