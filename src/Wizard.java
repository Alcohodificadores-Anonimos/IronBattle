public class Wizard extends Character {

    private int mana = (int) (Math.random() * 50 + 10);
    private int intelligence = (int) (Math.random() * 50 + 1);

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    //todo: Mirar donde poner el random si en la declaración de la variable o en el constructor
    public Wizard(String name, int hp) {
        super(name, hp);
        //Random entre 10 y 50
        setMana((int) (Math.random() * 50 + 10));
        //Random entre 1 y 50
        setIntelligence((int) (Math.random() * 50 + 1));
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
                ", mana=" + getMana() +
                ", intelligence=" + getIntelligence() +
                '}';
    }

    @Override
    public void attack(Character character) {

        //Every round a wizard will try to randomly cast either a Fireball or a Staff hit

        //Este random da o 0 o 1
        int random, dmg = 0;
        random = (int) Math.round(Math.random());

        //If a wizard does not have the mana to cast a Fireball he will do a Staff hit instead.
        if (getMana() < 5) random = 1;

        //If a wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2
        if (getMana() < 2) random = 2;

        //Fireball -> random = 0, Staff hit -> random = 1, No mana -> random = 2
        switch (random) {

            case 0:

                //The damage of a Fireball is equal to his intelligence and every Fireball will decrease their mana by 5 points
                dmg = intelligence;
                setMana(getMana() - 5);
                System.out.println(this.getName() + " ATACA CON FIREBALL INFLINGIENDO " + dmg + " DE DAÑO");
                break;

            case 1:

                //The damage of a staff hit is equal to 2. Every staff hit will recover his mana by 1.
                dmg = 2;
                setMana(getMana() + 1);
                System.out.println(this.getName() + " ATACA CON STAFF HIT INFLINGIENDO " + dmg + " DE DAÑO");
                break;

            default:

                //If a wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2
                setMana(random);
                System.out.println(this.getName() + ". NO PUEDE ATACAR NO TIENE MANA. MANA +2");

        }

        //Reduce that character’s health based on the intelligence of the spell

        //Le restamos a la vida que tiene el personaje el valor de la inteligencia del hechizo
        character.setHp(character.getHp() - dmg);

        //Si al final no ha tenido mana, la variable dmg vale 0 por lo cual aunque aparezca una resta sera la hp del personaje - 0

        if (getHp() <= 0) setIsAlive(false);

    }
}
