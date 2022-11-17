import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Utilities {

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

    public static void combat(ArrayList<Character> players) {

        int turnos = 1;

        Character character1 = players.get(0);
        Character character2 = players.get(1);

        System.out.println("-------------EMPEZANDO EL COMBATE----------------\n");

        // El combate se ejecuta por cada dos players, si el array es impar, no ejecuta
        // combate para el último player

        while (character1.getHp() > 0 && character2.getHp() > 0) {

            System.out.println("   TURNO " + turnos);

            turnos++;

            character1.attack(character2);
            character2.attack(character1);

            System.out.println("ESTADÍSTICAS TURNO\n" +
                    "Player 1: " + character1 + "\n" +
                    "Player 2: " + character2 + "\n" +
                    "----------------------------------------\n");

            if (character1.getHp() <= 0 && character2.getHp() <= 0) {
                System.out.println("DOBLE K.O., HA SIDO EMPATE.");
            } else if (character2.getHp() <= 0) {
                System.out.println(" GANADOR: Player 1: " + character1);
            } else if (character1.getHp() <= 0) {
                System.out.println(" GANADOR: Player 2: " + character2);
            }
        }
    }

    public static void automaticCombat() {
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

}

//leerLog
//leera el fichero log y lo mostrara por pantalla



