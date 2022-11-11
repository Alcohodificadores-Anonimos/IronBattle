public class Warrior extends Character implements Attacker{
    private int stamina; // to check
    private int strength;

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

    @Override
    public String toString() {
        return "Warrior{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", isAlive=" + getIsAlive() +
                ", stamina=" + getStamina() +
                ", strength=" + getStrength() +
                '}';
    }

    //todo
    @Override
    public void attack(Character character) {

    }

}
