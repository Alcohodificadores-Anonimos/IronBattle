public class Warrior extends Character {
    private int stamina;
    private int strength;


    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name, int hp) {
        super(name, hp);
        //Random entre 10 y 50
        setStamina((int) (Math.random() * 50 + 10));
        //Random entre 1 y 10
        setStrength((int) (Math.random() * 10 + 1));
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

        //Este random da o 0 o 1
        int random, dmg = 0;
        random = (int) Math.round(Math.random());

        //If a wizard does not have the mana to cast a Fireball he will do a Staff hit instead.
        if (getStamina() < 5) random = 1;

        //If a wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2
        if (getStamina() < 2) random = 2;

        //Heavy attack -> random = 0, weak hit -> random = 1, No stamina -> random = 2
        switch (random) {

            case 0 -> {
                //The damage from a Heavy attack is equal to his intelligence and every Fireball will decrease their mana by 5 points
                dmg = getStrength();
                setStamina(getStamina() - 5);
                System.out.println(this.getName() + " ATACA CON UN GOLPE FUERTE E INFLINGE " + dmg + " DE DAÑO");
            }
            case 1 -> {
                //The damage from a staff hit is equal to 2. Every staff hit will recover his mana by 1.
                dmg = (getStrength() / 2);
                setStamina(getStamina() + 1);
                System.out.println(this.getName() + " ATACA CON UN GOLPE DÉBIL E INFLINGE " + dmg + " DE DAÑO");
            }
            default -> {
                //If a wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2
                setStamina(random);
                System.out.println(this.getName() + ". NO PUEDE ATACAR NO TIENE STAMINA. STAMINA +2");
            }
        }

        //Reduce that character’s health based on the intelligence of the spell

        //Le restamos a la vida que tiene el personaje el valor de la inteligencia del hechizo
        enemy.setHp(enemy.getHp() - dmg);

        //Si al final no ha tenido stamina, la variable dmg vale 0 por lo cual aunque aparezca una resta sera la hp del personaje - 0

        if (getHp() <= 0) setIsAlive(false);

    }

}
