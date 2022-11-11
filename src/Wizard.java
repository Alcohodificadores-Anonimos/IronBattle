public class Wizard extends Character implements Attacker{

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", isAlive=" + getIsAlive() +
                ", stamina=" + getMana() +
                ", strength=" + getIntelligence() +
                '}';
    }

    @Override
    public void attack(Character character) {

    }
}
