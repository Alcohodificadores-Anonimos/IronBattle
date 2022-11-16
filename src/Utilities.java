import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Utilities {

    public static Character createWarrior(){

        Scanner scanner = new Scanner(System.in);
        Warrior warrior;
        String nameWarrior;
        int hpWarrior;
        int staminaWarrior;
        int strengthWarrior;

        System.out.println("INTRODUCE EL NOMBRE DEL WARRIOR");
        nameWarrior = scanner.next();
        System.out.println("INTRODUCE LA VIDA DEL WARRIOR");
        hpWarrior = scanner.nextInt();
        System.out.println("INTRODUCE LA STAMINA DEL WARRIOR");
        staminaWarrior = scanner.nextInt();
        System.out.println("INTRODUCE LA FUERZA DEL WARRIOR");
        strengthWarrior = scanner.nextInt();
        warrior = new Warrior(nameWarrior, hpWarrior, staminaWarrior, strengthWarrior);
        System.out.println("WARRIOR CREADO");
        System.out.println(warrior);

        return warrior;
    }


    public static Character createWizard(){

        Scanner scanner = new Scanner(System.in);
        Wizard wizard;
        String nameWizard;
        int hpWizard;
        int manaWizard;
        int intelligenceWizard;

        System.out.println("INTRODUCE EL NOMBRE DEL WIZARD");
        nameWizard = scanner.next();
        System.out.println("INTRODUCE LA VIDA DEL WIZARD");
        hpWizard = scanner.nextInt();
        System.out.println("INTRODUCE EL MANA DEL WIZARD");
        manaWizard = scanner.nextInt();
        System.out.println("INTRODUCE LA INTELIGENCIA DEL WIZARD");
        intelligenceWizard = scanner.nextInt();
        wizard = new Wizard(nameWizard, hpWizard, manaWizard, intelligenceWizard);
        System.out.println("WIZARD CREADO");
        System.out.println(wizard);

        return wizard;
    }

    public static void combat (ArrayList<Character> players){

        System.out.println("-------------EMPEZANDO EL COMBATE----------------");
        System.out.println();

        int turnos = 1;

        // El combate se ejecuta por cada dos players, si el array es impar, no ejecuta
        // combate para el último player
        while(players.get(0).getHp()>0 && players.get(1).getHp()>0){
            System.out.println("   TURNO " + turnos);
            turnos++;
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));
            System.out.println("ESTADISTICAS TURNO");
            System.out.println("Player 1: " + players.get(0).toString());
            System.out.println("Player 2: " + players.get(1).toString());
            System.out.println("----------------------------------------");

            if (players.get(0).getHp() <= 0 && players.get(1).getHp() <= 0){
                System.out.println( "DOBLE K.O., HA SIDO EMPATE.");
            } else if (players.get(1).getHp() <= 0){
                System.out.println(" GANADOR: Player 1: " + players.get(0).toString());
            } else if (players.get(0).getHp() <= 0){
                System.out.println(" GANADOR: Player 2: " + players.get(1).toString());
            }
        }
    }

    public static void automaticCombat(){
        System.out.println("EMPIEZA COMBATE AUTOMÁTICO");

        ArrayList<Character> players = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1 ){
                Warrior warrior = new Warrior("Player " + (i+1),new Random().nextInt(200-100) + 100);
                players.add(warrior);
            }else if(rand == 2){
                Wizard wizard = new Wizard("Player " + (i+1),new Random().nextInt(100-50) + 50 );
                players.add(wizard);
            }
        }

        combat(players);

    }

    public static ArrayList<Character> importCSV(ArrayList<Character> characters){

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
                if(campos[0].equalsIgnoreCase("warrior")){
                    Warrior warrior = new Warrior(campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3]),Integer.parseInt(campos[4]));
                    characters.add(warrior);
                }else if(campos[0].equalsIgnoreCase("wizard")){
                    Wizard wizard = new Wizard(campos[1],Integer.parseInt(campos[2]),Integer.parseInt(campos[3]),Integer.parseInt(campos[4]));
                    characters.add(wizard);
                }else{
                    System.out.println("Los tipos deben ser WARRIOR O WIZARD");
                }


                System.out.println(Arrays.toString(campos));

                // Volver a leer otra línea del fichero
                linea = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return characters;
    }

}

    //leerLog
    //leera el fichero log y lo mostrara por pantalla



