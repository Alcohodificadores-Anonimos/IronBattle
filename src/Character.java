public abstract class Character implements Attacker{

    private static int idCounter;
    private String id;
    private String name;
    private int hp; // to check
    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.id = getIdCounterToString();
        this.name = name;
        this.hp = hp;
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
