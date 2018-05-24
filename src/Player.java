public class Player {
    private String name;
    private int maxHP;
    private int currentHP;
    private int maxEnergy;
    private int currentEnergy;
    Player(String name) {
        this.maxHP = 20;
        this.currentHP = 20;
        this.maxEnergy = 100;
        this.currentEnergy = 100;
        this.name = name;
    }
    void getInfo() {
        System.out.println("Character name: " + this.name);
        System.out.println("Current HP: " + this.currentHP + "/" + this.maxHP);
        System.out.println("Current Energy: " + this.currentEnergy + "/" + this.maxEnergy);
    }

    void Heal(int amount) {
        this.currentHP += amount;
        if (this.currentHP > this.maxHP)
            this.currentHP = this.maxHP;
    }

    void Rest(int amount) {
        this.currentEnergy += 10 * amount;
        if (this.currentEnergy > this.maxEnergy)
            this.currentEnergy = this.maxEnergy;
    }
}
