import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Utilities {

    public static void combat (ArrayList<Character> players){

        int turnos = 1;

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
