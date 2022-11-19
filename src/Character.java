public abstract class Character implements Attacker {

    private static int idCounter;
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = getIdCounterToString();
        setName(name);
        setHp(hp);
        this.isAlive = true;
    }

    public Character(String name) {
        this.id = getIdCounterToString();
        setName(name);
        //Random entre 100 y 200
        if (this instanceof Warrior) this.hp = (int) (Math.random() * 200 + 100);
        //Random entre 50 y 100
        else if (this instanceof Wizard) this.hp = (int) (Math.random() * 100 + 50);
        else setHp(hp);
        this.isAlive = true;
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
        this.hp = hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
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
