import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

    public static void combat (ArrayList<Character> players){

        int turnos = 1;

        while(players.get(0).getHp()>0 || players.get(1).getHp()>0){
            System.out.println("   TURNO " + turnos);
            turnos++;
            players.get(0).attack(players.get(1));
            players.get(1).attack(players.get(0));
            System.out.println("ESTADISTICAS TURNO");
            System.out.println("Player 1: " + players.get(0).toString());
            System.out.println("Player 2: " + players.get(1).toString());
            System.out.println("----------------------------------------");
        }
    }

}
