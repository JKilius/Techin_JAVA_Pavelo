public class AlkoholinisGerimas extends Preke {
    private double akcizasLIkiRibos = 0.89;
    private double akcizasLNuoRibos = 1.26;
    private double turis=1;
    private double alkTurioProcRiba = 15;
    private double alkoholioProcentas = alkTurioProcRiba;

    public AlkoholinisGerimas(String preke, double netoKaina) {
        super(preke, netoKaina);
    }

    public AlkoholinisGerimas(String preke, double netoKaina, double alkoholioProcentas) {
        super(preke, netoKaina);
        this.alkoholioProcentas = alkoholioProcentas;
    }

    public AlkoholinisGerimas(String preke, double netoKaina, double alkoholioProcentas, double turis) {
        super(preke, netoKaina);
        this.turis = turis;
        this.alkoholioProcentas = alkoholioProcentas;
    }

    public void setAkcizasLIkiRibos(double akcizasLIkiRibos) {
        this.akcizasLIkiRibos = akcizasLIkiRibos;
    }

    public void setAkcizasLNuoRibos(double akcizasLNuoRibos) {
        this.akcizasLNuoRibos = akcizasLNuoRibos;
    }

//    public void setAkcizas(double akcizas) {
//        this.akcizas = akcizas;
//    }

    public double getAkcizasLIkiRibos() {
        return akcizasLIkiRibos;
    }

    public double getAkcizasLNuoRibos() {
        return akcizasLNuoRibos;
    }

    public double getAkcizas() {
        if (alkoholioProcentas < alkTurioProcRiba) {
            return akcizasLIkiRibos;
        }
        return akcizasLNuoRibos;
    }

    public double getTuris() {
        return turis;
    }

    public void setTuris(double turis) {
        this.turis = turis;
    }

    public double getAlkoholioProcentas() {
        return alkoholioProcentas;
    }

    public void setAlkoholioProcentas(double alkoholioProcentas) {
        this.alkoholioProcentas = alkoholioProcentas;
    }

    public double getAlkTurioProcRiba() {
        return alkTurioProcRiba;
    }

    public void setAlkTurioProcRiba(double alkTurioProcRiba) {
        this.alkTurioProcRiba = alkTurioProcRiba;
    }

    @Override
    public double getKainaSuMokesciais() {
        double pradine = super.getKainaSuMokesciais();
            return Math.round((pradine + (getAkcizas() * turis)) * 100) / 100.00;
        }
//        return Math.round((pradine + (akcizas * turis)) * 100) / 100.00;
//        return Math.round(super.getKainaSuMokesciais()+(akcizas*turis)*100)/100.00;



    @Override
    public String toString() {
        return super.toString()+"\n  Alkoholio procentas:" + "Akcizas litrui: " + getAkcizas()+
                "\n  Turis: " + turis + ", Visas akcizas: "+getAkcizas()*turis;
    }
}
