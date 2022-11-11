import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variables de menu
        boolean menu = true;
        int options;
        int options2;

        //Variables creacion de personajes
        String nameWarrior;
        int hpWarrior;
        int staminaWarrior;
        int strengthWarrior;
        String nameWizard;
        int hpWizard;
        int manaWizard;
        int intelligenceWizard;
        boolean warriorIsCrated = false;
        boolean wizardIsCreated = false;

        System.out.println("BIENVENIDO A IRONBATTLE");
        System.out.println("=========MENU===========");
        System.out.println("SELECIONA 1 PARA CREAR LOS PERSONAJES");
        System.out.println("SELECIONA 2 PARA ENTRAR A LA BATALLA");
        while (menu) {
            options = scanner.nextInt();
            switch (options) {
                case 1:
                    System.out.println("SELECCIONA 1 PARA CREAR UN WARRIOR");
                    System.out.println("SELECCIONA 2 PARA CREAR UN WIZARD");
                    System.out.println("SELECCIONA 3 PARA VER EL LOG DEL COMBATE");
                    System.out.println("SELECCIONA 4 PARA IMPORTAR PERSONAJES DE UN CSV");
                    System.out.println("SELECCIONA 5 PARA COMBATE AUTOMÁTICO");
                    System.out.println("SELECCIONA 6 PARA SALIR DEL JUEGO");

                    options2 = scanner.nextInt();
                    switch (options2) {
                        case 1:
                            System.out.println("INTRODUCE EL NOMBRE DEL WARRIOR");
                            nameWarrior = scanner.next();
                            System.out.println("INTRODUCE LA VIDA DEL WARRIOR");
                            hpWarrior = scanner.nextInt();
                            System.out.println("INTRODUCE LA STAMINA DEL WARRIOR");
                            staminaWarrior = scanner.nextInt();
                            System.out.println("INTRODUCE LA FUERZA DEL WARRIOR");
                            strengthWarrior = scanner.nextInt();
                            Warrior warrior = new Warrior(nameWarrior, hpWarrior, staminaWarrior, strengthWarrior);
                            System.out.println("WARRIOR CREADO");
                            warriorIsCrated = true;
                            System.out.println(warrior);
                            break;
                        case 2:
                            System.out.println("INTRODUCE EL NOMBRE DEL WIZARD");
                            nameWizard = scanner.next();
                            System.out.println("INTRODUCE LA VIDA DEL WIZARD");
                            hpWizard = scanner.nextInt();
                            System.out.println("INTRODUCE EL MANA DEL WIZARD");
                            manaWizard = scanner.nextInt();
                            System.out.println("INTRODUCE LA INTELIGENCIA DEL WIZARD");
                            intelligenceWizard = scanner.nextInt();
                            Wizard wizard = new Wizard(nameWizard, hpWizard, manaWizard, intelligenceWizard);
                            System.out.println("WIZARD CREADO");
                            wizardIsCreated = true;
                            System.out.println(wizard);
                            break;
                        default:
                            System.out.println("SELECCIONA UNA OPCIÓN VÁLIDA");
                            break;
                    }
                    break;
                case 2:

                    if (warriorIsCrated && wizardIsCreated){
                        System.out.println("EMPEZANDO EL COMBATE");
                        //METODOS DE COMBATE
                        break;
                    }else{
                        System.out.println("CREA LOS PERSONAJES ANTES");
                        break;
                    }
                case 3:
                    //METODO PARA VER EL LOG DEL COMBATE
                    System.out.println("LOG DEL COMBATE");
                    break;
                case 4:
                    //METODO PARA IMPORTAR JUGADORES
                    warriorIsCrated = true;
                    wizardIsCreated = true;
                    System.out.println("PERSONAJES IMPORTADOS");
                    break;
                case 5:
                    //METODO COMBATE AUTOMATICO
                    System.out.println("EMPIEZA COMBATE AUTOMÁTICO");
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
}