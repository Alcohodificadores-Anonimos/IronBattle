import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina; // to check random 10-50
    private int strength; // random 1-10


    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
       setStamina(stamina);
       setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @java.lang.Override
    public void attack(Character enemy) {
        Random random = new Random();
        int attackType;
        attackType = random.nextInt(0, 2);
        System.out.println(attackType);

        //Controlamos que hay suficiente stamina
        if (this.stamina > 0) {
            //Si tiene stamina y el golpe es HEAVY ATTACK
            if (attackType == 1 && this.stamina >= 5) {
                enemy.setHp(enemy.getHp()-this.strength);
                this.stamina -= 5;
                System.out.println("Tremendo putiaso"); //Heavy Attack
                System.out.println("Stamina actual:" + this.stamina);
                System.out.println("La salud del enemigo actual es: " + enemy.getHp());
                //Si la stamina < 5 y se ha otorgado un HEAVY ATTACK
                //PEGARÁ WEAK ATTACK
            } else if (attackType == 1 && this.stamina < 5) { //sin suficiente stamina ejecuta un Weak Attack
                enemy.setHp(enemy.getHp()-this.strength / 2);
                this.stamina += 1;
                System.out.println("HEAVY ATTACK (etamina <5) --> WEAK ATTACK"); //Weak Attack
                System.out.println("Stamina actual:" + this.stamina);
                System.out.println("La salud del enemigo actual es: " + enemy.getHp());
                // Cuando tienes stamina y se otorga WEAK ATTAK
            } else if (attackType == 0 ) { //Cuando se ejecuta el Weak Attack
                enemy.setHp(enemy.getHp()-this.strength / 2);
                this.stamina += 1;
                System.out.println("WEAK ATTACK (con stamina)"); //Weak Attack
                System.out.println("Stamina actual:" + this.stamina);
                System.out.println("La salud del enemigo actual es: " + enemy.getHp());
            }
        } else {
            System.out.println("No tiene estamina");
            stamina += 2;
            System.out.println("El guerrero este turno no ataca y recupera 2 de stamina");
        }
    }
}
