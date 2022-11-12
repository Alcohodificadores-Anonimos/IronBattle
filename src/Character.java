public class Character {
    private String id; //todo
    /*
    Raul:
    Incrementarlo cada vez que se cree un character, creo que debe ser statica (o no) y se tiene
    que autoincrementar en el constructor
    */
    private String name;
    private int hp; // to check
    private boolean isAlive = true;

    public Character(String name, int hp) {
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

}
