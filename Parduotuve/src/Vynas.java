public class Vynas extends AlkoholinisGerimas {

private void vynoPadiniaiNustatymai(){
    setAkcizasLIkiRibos(0.28);
    setAkcizasLNuoRibos(0.72);
    setAlkTurioProcRiba(8.5);
}
    public Vynas(String preke, double netoKaina) {
        super(preke, netoKaina);
        vynoPadiniaiNustatymai();

    }

    public Vynas(String preke, double netoKaina, double alkoholioProcentas) {
        super(preke, netoKaina);
        vynoPadiniaiNustatymai();
        setAlkoholioProcentas(alkoholioProcentas);
    }

    public Vynas(String preke, double netoKaina, double alkoholioProcentas, double turis) {
        super(preke, netoKaina, alkoholioProcentas, turis);
        vynoPadiniaiNustatymai();
        setAlkoholioProcentas(alkoholioProcentas);
    }
}
