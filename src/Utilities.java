import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Utilities {

    private static int contador = 1;

    public static Character createWarrior() {

        Scanner scanner = new Scanner(System.in);
        Warrior warrior;
        String nameWarrior;
        int hpWarrior;
        int staminaWarrior;
        int strengthWarrior;

        System.out.println("INTRODUCE EL NOMBRE DEL WARRIOR");
        nameWarrior = scanner.next();
        System.out.println("INTRODUCE LA VIDA DEL WARRIOR (100-200)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                hpWarrior = scanner.nextInt();

                if (hpWarrior >= 100 && hpWarrior <= 200) break;
                else System.out.println("El hp tiene que estar entre los rangos 100 y 200");

            }
        }
        System.out.println("INTRODUCE LA STAMINA DEL WARRIOR (1-50)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                staminaWarrior = scanner.nextInt();

                if (staminaWarrior > 0 && staminaWarrior <= 50) break;
                else System.out.println("La stamina tiene que estar entre los rangos 1 y 50");

            }
        }
        System.out.println("INTRODUCE LA FUERZA DEL WARRIOR (1-10)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                strengthWarrior = scanner.nextInt();

                if (strengthWarrior > 0 && strengthWarrior <= 10) break;
                else System.out.println("La strength tiene que estar entre los rangos 1 y 10");

            }
        }
        warrior = new Warrior(nameWarrior, hpWarrior, staminaWarrior, strengthWarrior);
        System.out.println("WARRIOR CREADO");
        System.out.println(warrior);

        return warrior;

    }


    public static Character createWizard() {

        Scanner scanner = new Scanner(System.in);
        Wizard wizard;
        String nameWizard;
        int hpWizard;
        int manaWizard;
        int intelligenceWizard;

        System.out.println("INTRODUCE EL NOMBRE DEL WIZARD");
        nameWizard = scanner.next();
        System.out.println("INTRODUCE LA VIDA DEL WIZARD (50-100)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                hpWizard = scanner.nextInt();

                if (hpWizard >= 50 && hpWizard <= 100) break;
                else System.out.println("El hp tiene que estar entre los rangos 50 y 100");

            }
        }
        System.out.println("INTRODUCE EL MANA DEL WIZARD (10-50)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                manaWizard = scanner.nextInt();

                if (manaWizard >= 10 && manaWizard <= 50) break;
                else System.out.println("El mana tiene que estar entre los rangos 10 y 50");

            }
        }
        System.out.println("INTRODUCE LA INTELIGENCIA DEL WIZARD (1-50)");
        while (true) {

            if (!scanner.hasNextInt()) {

                scanner.next();
                System.out.println("Introduce un número válido!");

            } else {

                intelligenceWizard = scanner.nextInt();

                if (intelligenceWizard >= 1 && intelligenceWizard <= 50) break;
                else System.out.println("La inteligencia tiene que estar entre los rangos 1 y 50");

            }
        }
        wizard = new Wizard(nameWizard, hpWizard, manaWizard, intelligenceWizard);
        System.out.println("WIZARD CREADO");
        System.out.println(wizard);

        return wizard;
    }

    public static void combat(ArrayList<Character> players) throws IOException {
        int contador2 = 0;
        int x = (contador2 -1)/2;
        if(x==0)x++;

        FileWriter combatsResults = new FileWriter(new File("resultados.txt"), true);
        Scanner reader = new Scanner(new File("resultados.txt"));
        System.out.println("-------------EMPEZANDO EL COMBATE----------------");
        System.out.println();
        if (!reader.hasNextLine() || !reader.nextLine().contains("RESULTADOS")) {
            combatsResults.write(" ----------- RESULTADOS ----------- \n");

        }
        int turnos = 1;

        // El combate se ejecuta por cada dos players, si el array es impar, no ejecuta
        // combate para el último player
        while (players.get(0).getHp() > 0 && players.get(1).getHp() > 0) {
            System.out.println("   TURNO " + turnos);
            turnos++;
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));
            System.out.println("ESTADISTICAS TURNO");
            System.out.println("Player 1: " + players.get(0).toString());
            System.out.println("Player 2: " + players.get(1).toString());
            System.out.println("----------------------------------------");

            if (players.get(0).getHp() <= 0 && players.get(1).getHp() <= 0) {
                while (reader.hasNextLine()) {
                    contador2++;
                    reader.nextLine();
                }



               // if(contador2==1) contador2++
                combatsResults.write("COMBATE "+ x + "\n");
                contador++;
                System.out.println("DOBLE K.O., HA SIDO EMPATE.");
                combatsResults.write("DOBLE K.O., HA SIDO EMPATE. \n");
            } else if (players.get(1).getHp() <= 0) {
                while (reader.hasNextLine()) {
                    contador2++;
                    reader.nextLine();
                }
                combatsResults.write("COMBATE "+ x + "\n");
                contador++;
                System.out.println(" GANADOR: Player 1: " + players.get(0).toString());
                combatsResults.write(" GANADOR: Player 1: " + players.get(0).toString() + "\n");
            } else if (players.get(0).getHp() <= 0) {
                while (reader.hasNextLine()) {
                    contador2++;
                    reader.nextLine();
                }
                combatsResults.write("COMBATE "+ x + "\n");
                contador++;
                System.out.println(" GANADOR: Player 2: " + players.get(1).toString());
                combatsResults.write(" GANADOR: Player 2: " + players.get(1).toString() + "\n");
            }
        }
        combatsResults.close();
    }

    public static void automaticCombat() throws IOException {
        System.out.println("EMPIEZA COMBATE AUTOMÁTICO");

        ArrayList<Character> players = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1) {
                Warrior warrior = new Warrior("Player " + (i + 1), new Random().nextInt(200 - 100) + 100);
                players.add(warrior);
            } else if (rand == 2) {
                Wizard wizard = new Wizard("Player " + (i + 1), new Random().nextInt(100 - 50) + 50);
                players.add(wizard);
            }
        }

        combat(players);

    }

    public static ArrayList<Character> importCSV(ArrayList<Character> characters) {

        characters.clear();

        BufferedReader bufferedReader = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferedReader = new BufferedReader(new FileReader("Players.csv"));

            // Leer una linea del archivo
            String linea = bufferedReader.readLine();

            while (linea != null) {
                // Sepapar la linea leída con el separador
                String[] campos = linea.split(";");
                if (campos[0].equalsIgnoreCase("warrior")) {
                    Warrior warrior = new Warrior(campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));
                    characters.add(warrior);
                } else if (campos[0].equalsIgnoreCase("wizard")) {
                    Wizard wizard = new Wizard(campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));
                    characters.add(wizard);
                } else {
                    System.out.println("Los tipos deben ser WARRIOR O WIZARD");
                }


                System.out.println(Arrays.toString(campos));

                // Volver a leer otra línea del fichero
                linea = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return characters;
    }

    public static void escribirResultados(){


    }

}




