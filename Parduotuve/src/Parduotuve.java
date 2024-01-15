import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Parduotuve {
    private ArrayList<Preke> visosPrekes = new ArrayList<>();


    public Parduotuve() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println();
                printCentered("Sveiki atvyke į Pavelo paraduotuvę!");
                printCentered("Pasirinkite ką norite atlikti:");
                printFormated("1-Sukurti prekę");
                printFormated("2-Peržiūrėti prekes");
                printFormated("3-Peržiūrėti prekės duomenis");
                printFormated("4-Pakeisti prekės duomenis");
                printFormated("0-Užbaigti");
                int num = scanner.nextInt();
                scanner.nextLine(); // consume newline
                String prekesPavadinimas;
                switch (num) {
                    case 1:
                        createPreke(scanner);
                        break;
                    case 2:
                        printKrepselis();
                        printCentered("<< Paspauskite Enter >>");
                        scanner.nextLine();
                        break;
                    case 3:
                        printFormated("");
                        printFormated("Įveskite prekės pavadinimą");
                        prekesPavadinimas = scanner.nextLine();
                        printPreke(prekesPavadinimas);
                        break;
                    case 4:
                        printFormated("");
                        printFormated("Įveskite prekės pavadinimą");
                        prekesPavadinimas = scanner.nextLine();
                        editPreke(prekesPavadinimas);
                    case 0:
                        return;
                    default:
                        printCentered("<< Neteisingas pasirinkimas, pabandykite dar kartą >>\n");
                }
            }
        } catch (InputMismatchException e) {
            printCentered("<< Netinkamas įvadas, programa užsidaro. >>");

        }
    }

    private void createPreke(Scanner scanner) {
        printFormated("Įveskite prekės tipą (alkoholis,vynas,vaistas,kita)");
        String prekesTipas = scanner.nextLine().toLowerCase();
        String prekesPavadinimas = pavadinimoIlgioPatikra("Įveskite prekės pavadinimą");
//        while (true) {
//            printFormated("Įveskite prekės pavadinimą");
//            prekesPavadinimas = scanner.nextLine();
//            if (prekesPavadinimas.length() <= 23) break;
//            printFormated("Pavadinimas per ilgas (iki 23 simbolių)");
//        }
        printFormated("Įveskite prekės kainą (EUR)");
        double prekesKaina = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        if (prekesTipas.equals("vynas")) {
            printFormated("Įveskite alkoholio procentą");
            double alkoholioProcentas = scanner.nextDouble();
            printFormated("Įveskite gėrimo tūrį (litrais)");
            double turis = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            visosPrekes.add(new Vynas(prekesPavadinimas, prekesKaina, alkoholioProcentas, turis));

        } else if (prekesTipas.equals("alkoholinis gerimas") || prekesTipas.equals("alkoholis")) {
            printFormated("Įveskite alkoholio procentą");
            double alkoholioProcentas = scanner.nextDouble();
            printFormated("Įveskite gėrimo tūrį (litrais)");
            double turis = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            visosPrekes.add(new AlkoholinisGerimas(prekesPavadinimas, prekesKaina, alkoholioProcentas, turis));

        } else if (prekesTipas.equals("vaistas")) {
            visosPrekes.add(new Vaistas(prekesPavadinimas, prekesKaina));
        } else {
            visosPrekes.add(new Preke(prekesPavadinimas, prekesKaina));
        }
        printCentered("<< Prekė sėkmingai pridėta >>");
    }

    public void printKrepselis() {
        System.out.printf("%-23s %10s %9s %9s\n", "Pavadinimas", "PVM", "Kaina EUR", "Kaina CHF");
        for (Preke preke : visosPrekes) {
            System.out.printf("%-23s %9.2f%1s %9.2f %9.2f\n", preke.getPrekesPavadinimas(), preke.getPvm() * 100, "%", preke.getKainaSuMokesciais(), preke.getKainaFrankais());
        }
    }

    public void printPreke(String prekesPavadinimas) {
        for (Preke preke : visosPrekes) {
            if (prekesPavadinimas.equals(preke.getPrekesPavadinimas())) {
                System.out.printf(preke.toString());
            }
            printCentered("<< Nėra tokios prekės >>");
        }
    }

    public void editPreke(String prekesPavadinimas) {
        Scanner scanner = new Scanner(System.in);
        for (Preke preke : visosPrekes) {
            if (prekesPavadinimas.equals(preke.getPrekesPavadinimas())) {
                while (true) {
                    printFormated("Ką norite pakeisti?(Pavadinimas,Kaina,PVM)");
                    String keiciamas = scanner.nextLine().toLowerCase();
                    if (keiciamas.equals("pavadinimas")) {
//                        printFormated("Įveskite naują pavadinimą");
                        preke.setPrekesPavadinimas(pavadinimoIlgioPatikra("Įveskite naują pavadinimą"));
                        break;
                    }
                    if (keiciamas.equals("kaina")) {
                        printFormated("Įveskite naują kainą");
                        preke.setNetoKaina(scanner.nextDouble());

                    }
                    if (keiciamas.equals("pvm")){
                        printFormated("Įveskite nauja PVM procentais");
                        preke.setPvm(scanner.nextDouble());
                    }
                }
            }
            printCentered("<< Nėra tokios prekės >>");
        }
    }

    private static void printFormated(String text) {
        System.out.printf("%-53s\n", text);
    }

    private static void printCentered(String text) {
        System.out.println(pad(text, 53, ' ', true));
    }

    private static String pavadinimoIlgioPatikra(String uzklausa) {
        Scanner scanner = new Scanner(System.in);
        String prekesPavadinimas;
        while (true) {
            printFormated(uzklausa);
            prekesPavadinimas = scanner.nextLine();
            if (prekesPavadinimas.length() <= 23) break;
            printCentered("<< Pavadinimas per ilgas (iki 23 simbolių) >>");
        }
        return prekesPavadinimas;
    }

    @Override
    public String toString() {
        return "Krepselio sudetis:\n" + visosPrekes.toString();
    }

    private static String pad(String s, int w, char c, boolean pr) {
        int pad = w - s.length();
        String p = "";

        for (int i = 0; i < pad / 2; i++)
            p = p + c;

        /* If s.length is odd */
        if (pad % 2 == 1)
            /* Pad one extra either right or left */
            if (pr) s = s + c;
            else s = c + s;
        return (p + s + p);
    }
}