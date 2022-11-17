import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Variables de menu
        String options2;
        boolean alreadyPlayer1 = false;

        //Variables creacion de personajes
        int contadorPlayers = 0;
        ArrayList<Character> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO A IRONBATTLE");

        while (true) {

            printMenu();

            switch (scanner.nextLine()) {

                case "1":

                    printSubMenu();

                    switch (scanner.nextLine()) {

                        case "1":

                            if (alreadyPlayer1) {

                                // llamar método clear + createWarrior (mismo codigo en if)
                                //Limpiamos el Array por si hay personajes importados mediante el CSV
                                players.clear();

                                alreadyPlayer1 = false;
                                contadorPlayers = 0; //todo: No entiendo porque se pone 0 de nuevo
                                players.add(Utilities.createWarrior());
                                contadorPlayers++;

                                break;

                            } else {

                                players.add(Utilities.createWarrior());
                                contadorPlayers++;
                                break;

                            }

                        case "2":

                            if (alreadyPlayer1) {

                                // llamar método clear + createWizard (mismo codigo en if)
                                //Limpiamos el Array por si hay personajes importados mediante el CSV
                                players.clear();
                                alreadyPlayer1 = false;
                                contadorPlayers = 0;
                                players.add(Utilities.createWizard());
                                contadorPlayers++;

                                break;

                            } else {

                                // llamar método createWizard (mismo codigo en if)
                                players.add(Utilities.createWizard());
                                contadorPlayers++;

                            }

                        default:

                            System.out.println("¡SELECCIONA UNA OPCIÓN VÁLIDA!");

                            break;

                    }

                    break;

                case "2":

                    if (contadorPlayers >= 2) {

                        //Método que llama para empezar el combate
                        Utilities.combat(players);
                        contadorPlayers -= 2;

                        break;

                    } else {

                        System.out.println("¡CREA LOS PERSONAJES ANTES!\n");
                        break;

                    }

                case "3":

                    //METODO PARA VER EL LOG DEL COMBATE
                    System.out.println("LOG DEL COMBATE");
                    //EL COMBATE NO GUARDA LOG, MÉTODO A MODIFICAR
                    break;

                case "4":

                    System.out.println("PERSONAJES IMPORTADOS");
                    players = Utilities.importCSV(players);
                    contadorPlayers = 2;
                    alreadyPlayer1 = true;
                    System.out.println(players);

                    break;

                case "5":

                    //METODO COMBATE AUTOMATICO
                    Utilities.automaticCombat();
                    break;

                case "6":

                    System.out.println("SALIENDO DEL JUEGO...");
                    return;

                default:

                    System.out.println("ELIGE UNA OPCIÓN VÁLIDA");

            }

        }

    }

    //private static void createWarrior(ArrayList<Character> players) {}


    public static void printMenu() {

        System.out.println("=========MENU===========\n" +
                "SELECIONA 1 PARA CREAR LOS PERSONAJES\n" +
                "SELECIONA 2 PARA ENTRAR A LA BATALLA\n" +
                "SELECCIONA 3 PARA VER EL LOG DEL COMBATE\n" +
                "SELECCIONA 4 PARA IMPORTAR PERSONAJES DE UN CSV\n" +
                "SELECCIONA 5 PARA COMBATE AUTOMÁTICO\n" +
                "SELECCIONA 6 PARA SALIR DEL JUEGO\n");

    }

    public static void printSubMenu() {

        System.out.println("SELECCIONA 1 PARA CREAR UN WARRIOR\n" +
                "SELECCIONA 2 PARA CREAR UN WIZARD\n");

    }

}