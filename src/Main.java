import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Variables de menu
        boolean menu = true;
        int options;
        int options2;
        boolean alreadyPlayer1 = false;
        //Variables creacion de personajes
        String nameWarrior;
        int hpWarrior;
        int staminaWarrior;
        int strengthWarrior;
        String nameWizard;
        int hpWizard;
        int manaWizard;
        int intelligenceWizard;
        int contadorPlayers = 0;
        ArrayList<Character> players = new ArrayList<>();

        System.out.println("BIENVENIDO A IRONBATTLE");

        while (menu) {
            printMenu();
            options = scanner.nextInt();
            switch (options) {
                case 1:
                    System.out.println("SELECCIONA 1 PARA CREAR UN WARRIOR");
                    System.out.println("SELECCIONA 2 PARA CREAR UN WIZARD");
                    options2 = scanner.nextInt();
                    switch (options2) {
                        case 1:
                            if (alreadyPlayer1) {
                                // llamar método celar + createWarrior (mismo codigo en if)
                                players.clear();
                                alreadyPlayer1 = false;
                                contadorPlayers = 0;
                                System.out.println("INTRODUCE EL NOMBRE DEL WARRIOR");
                                nameWarrior = scanner.next();
                                System.out.println("INTRODUCE LA VIDA DEL WARRIOR");
                                hpWarrior = scanner.nextInt();
                                System.out.println("INTRODUCE LA STAMINA DEL WARRIOR");
                                staminaWarrior = scanner.nextInt();
                                System.out.println("INTRODUCE LA FUERZA DEL WARRIOR");
                                strengthWarrior = scanner.nextInt();
                                Warrior warrior = new Warrior(nameWarrior, hpWarrior, staminaWarrior, strengthWarrior);
                                players.add(warrior);
                                contadorPlayers++;
                                System.out.println("PERSONAJE " + contadorPlayers + ": WARRIOR CREADO");
                                System.out.println(warrior);
                                break;

                            } else if (!alreadyPlayer1) {
                                // llamar método createWarrior (mismo codigo en if)
                                System.out.println("INTRODUCE EL NOMBRE DEL WARRIOR");
                                nameWarrior = scanner.next();
                                System.out.println("INTRODUCE LA VIDA DEL WARRIOR");
                                hpWarrior = scanner.nextInt();
                                System.out.println("INTRODUCE LA STAMINA DEL WARRIOR");
                                staminaWarrior = scanner.nextInt();
                                System.out.println("INTRODUCE LA FUERZA DEL WARRIOR");
                                strengthWarrior = scanner.nextInt();
                                Warrior warrior = new Warrior(nameWarrior, hpWarrior, staminaWarrior, strengthWarrior);
                                players.add(warrior);
                                contadorPlayers++;
                                System.out.println("PERSONAJE " + contadorPlayers + ": WARRIOR CREADO");
                                System.out.println(warrior);
                                break;
                            }

                        case 2:
                            if (alreadyPlayer1) {
                                // llamar método clear createWizard (mismo codigo en if)
                                players.clear();
                                alreadyPlayer1 = false;
                                contadorPlayers = 0;
                                System.out.println("INTRODUCE EL NOMBRE DEL WIZARD");
                                nameWizard = scanner.next();
                                System.out.println("INTRODUCE LA VIDA DEL WIZARD");
                                hpWizard = scanner.nextInt();
                                System.out.println("INTRODUCE EL MANA DEL WIZARD");
                                manaWizard = scanner.nextInt();
                                System.out.println("INTRODUCE LA INTELIGENCIA DEL WIZARD");
                                intelligenceWizard = scanner.nextInt();
                                Wizard wizard = new Wizard(nameWizard, hpWizard, manaWizard, intelligenceWizard);
                                players.add(wizard);
                                contadorPlayers++;
                                System.out.println("PERSONAJE " + contadorPlayers + ": WIZARD CREADO");
                                System.out.println(wizard);
                                break;
                            } else if (!alreadyPlayer1) {
                                // llamar método createWizard (mismo codigo en if)
                                System.out.println("INTRODUCE EL NOMBRE DEL WIZARD");
                                nameWizard = scanner.next();
                                System.out.println("INTRODUCE LA VIDA DEL WIZARD");
                                hpWizard = scanner.nextInt();
                                System.out.println("INTRODUCE EL MANA DEL WIZARD");
                                manaWizard = scanner.nextInt();
                                System.out.println("INTRODUCE LA INTELIGENCIA DEL WIZARD");
                                intelligenceWizard = scanner.nextInt();
                                Wizard wizard = new Wizard(nameWizard, hpWizard, manaWizard, intelligenceWizard);
                                players.add(wizard);
                                contadorPlayers++;
                                System.out.println("PERSONAJE " + contadorPlayers + ": WIZARD CREADO");
                                System.out.println(wizard);
                            }

                        default:
                            System.out.println("SELECCIONA UNA OPCIÓN VÁLIDA");
                            break;
                    }
                    break;
                case 2:

                    if (contadorPlayers >= 2) {
                        System.out.println("-------------EMPEZANDO EL COMBATE----------------");
                        System.out.println();
                        Utilities.combat(players);
                        break;
                    } else {
                        System.out.println("CREA LOS PERSONAJES ANTES");
                        break;
                    }
                case 3:
                    //METODO PARA VER EL LOG DEL COMBATE
                    System.out.println("LOG DEL COMBATE");
                    //EL COMBATE NO GUARDA LOG, MÉTODO A MODIFICAR
                    break;
                case 4:
                    System.out.println("PERSONAJES IMPORTADOS");
                    players = Utilities.importCSV(players);
                    contadorPlayers = 2;
                    alreadyPlayer1 = true;
                    System.out.println(players);
                    break;
                case 5:
                    //METODO COMBATE AUTOMATICO
                    System.out.println("EMPIEZA COMBATE AUTOMÁTICO");
                    Utilities.automaticCombat();
                    break;
                case 6:
                    System.out.println("SALIENDO DEL JUEGO...");
                    menu = false;
                    break;
                default:
                    System.out.println("ELIGE UNA OPCIÓN VÁLIDA");
            }
        }

    }

    //private static void createWarrior(ArrayList<Character> players) {}

    public static void printMenu() {
        System.out.println("=========MENU===========");
        System.out.println("SELECIONA 1 PARA CREAR LOS PERSONAJES");
        System.out.println("SELECIONA 2 PARA ENTRAR A LA BATALLA");
        System.out.println("SELECCIONA 3 PARA VER EL LOG DEL COMBATE");
        System.out.println("SELECCIONA 4 PARA IMPORTAR PERSONAJES DE UN CSV");
        System.out.println("SELECCIONA 5 PARA COMBATE AUTOMÁTICO");
        System.out.println("SELECCIONA 6 PARA SALIR DEL JUEGO");
    }

}