import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Character> players;
    private static int contadorPlayers;
    private static boolean alreadyPlayer1;
    private static Scanner scanner;

    public static void main(String[] args) {

        alreadyPlayer1 = false;
        contadorPlayers = 0;
        players = new ArrayList<>();
        scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO A IRONBATTLE");

        while (true) {

            printMenu();

            switch (scanner.nextLine()) {

                case "1":

                    printSubMenu();

                    switch (scanner.nextLine()) {

                        case "1":

                            if (alreadyPlayer1) {

                                createCharacter(true);

                                break;

                            } else {

                                players.add(Utilities.createWarrior());
                                contadorPlayers++;

                            }

                        case "2":

                            if (alreadyPlayer1) {

                                createCharacter(false);

                                break;

                            } else {

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
                    //todo: EL COMBATE NO GUARDA LOG, MÉTODO A MODIFICAR

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

    private static void createCharacter(boolean isWarrior) {

        players.clear();
        alreadyPlayer1 = false;
        contadorPlayers = 0;
        contadorPlayers++;
        players.add(isWarrior ? Utilities.createWarrior() : Utilities.createWizard());

    }

    public static void printMenu() {

        System.out.println("""
                =========MENU===========
                SELECIONA 1 PARA CREAR LOS PERSONAJES
                SELECIONA 2 PARA ENTRAR A LA BATALLA
                SELECCIONA 3 PARA VER EL LOG DEL COMBATE
                SELECCIONA 4 PARA IMPORTAR PERSONAJES DE UN CSV
                SELECCIONA 5 PARA COMBATE AUTOMÁTICO
                SELECCIONA 6 PARA SALIR DEL JUEGO
                """);

    }

    public static void printSubMenu() {

        System.out.println("SELECCIONA 1 PARA CREAR UN WARRIOR\n" +
                "SELECCIONA 2 PARA CREAR UN WIZARD\n");

    }

}