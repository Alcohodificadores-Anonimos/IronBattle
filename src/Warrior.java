import java.util.Random;

public class Warrior extends Character{
    private int stamina = (int) (Math.random()*50+10);
    private int strength = (int) (Math.random()*10+1);


    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
       setStamina(stamina);
       setStrength(strength);
    }
    public Warrior(String name, int hp) {
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

    @Override
    public String toString() {
        return "Warrior{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", stamina=" + getStamina() +
                ", strength=" + getStrength() +
                '}';
    }
    @Override
    public void attack(Character enemy) {
        Random random = new Random();
        int attackType;
        attackType = random.nextInt(0, 2);
        //System.out.println(attackType);

        //Controlamos que hay suficiente stamina
        if (this.stamina > 0) {
            //Si tiene stamina y el golpe es HEAVY ATTACK
            if (attackType == 1 && this.stamina >= 5) {
                enemy.setHp(enemy.getHp()-this.strength);
                this.stamina -= 5;
                System.out.println(this.getName() + " ATACA CON HEAVY ATTACK INFLINGIENDO " + this.strength + " DE DAÑO"); //Heavy Attack
                //System.out.println("Stamina actual:" + this.stamina);
                //System.out.println("La salud del enemigo actual es: " + enemy.getHp());
                //Si la stamina < 5 y se ha otorgado un HEAVY ATTACK
                //PEGARÁ WEAK ATTACK
            } else if (attackType == 1 && this.stamina < 5) { //sin suficiente stamina ejecuta un Weak Attack
                enemy.setHp(enemy.getHp()-this.strength / 2);
                this.stamina += 1;
                System.out.println(this.getName() + " ATACA CON WEAK ATTACK INFLINGIENDO " + this.strength/2 + " DE DAÑO"); //Weak Attack
                //System.out.println("Stamina actual:" + this.stamina);
                //System.out.println("La salud del enemigo actual es: " + enemy.getHp());
                // Cuando tienes stamina y se otorga WEAK ATTAK
            } else if (attackType == 0 ) { //Cuando se ejecuta el Weak Attack
                enemy.setHp(enemy.getHp()-this.strength / 2);
                this.stamina += 1;
                System.out.println(this.getName() + " ATACA CON WEAK ATTACK INFLINGIENDO " + this.strength / 2 + " DE DAÑO"); //Weak Attack
                //System.out.println("Stamina actual:" + this.stamina);
                //System.out.println("La salud del enemigo actual es: " + enemy.getHp());
            }
        } else {
            System.out.println(this.getName() + ". NO PUEDE ATACAR NO TIENE STAMINA. STAMINA +2");
            stamina += 2;
        }
    }
}
