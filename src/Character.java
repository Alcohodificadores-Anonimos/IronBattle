import java.util.Random;

public abstract class Character implements Attacker {

    private static int idCounter;
    private String id;
    private String name;
    private int hp; // todo. Preguntar esto a los profes porque lo quieren random si luego en los constructores el valor
                    //será sobreescrito. Mirar método setHp()
    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.id = getIdCounterToString();
        setName(name);
        setHp(hp);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {

        if (this instanceof Warrior) {

            //Random between 100-200 to warrior
            this.hp = new Random().nextInt(200 - 100) + 100;

        } else if (this instanceof Wizard) {

            //Random between 50-100 for wizards
            this.hp = new Random().nextInt(100 - 50) + 50;

        } else {

            this.hp = hp;

        }

    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }

    public String getIdCounterToString() {
        return Integer.toString(idCounter++);
    }

}
