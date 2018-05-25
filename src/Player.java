public class Player {
    private String name;
    private int maxHP;
    private int currentHP;
    private int maxEnergy;
    private int currentEnergy;
    private int Math;
    Player(String name) {
        this.Math = 0;
        this.maxHP = 20;
        this.currentHP = 20;
        this.maxEnergy = 100;
        this.currentEnergy = 100;
        this.name = name;
    }

    void getInfo(bestGUI gui) {
        gui.updateCharacter("Character name: " + this.name + "\n"
                                + "Current HP: " + this.currentHP + "/" + this.maxHP + "\n"
                                + "Current Energy: " + this.currentEnergy + "/" + this.maxEnergy + "\n"
                                + "Math level: " + this.Math);
        System.out.println("Character name: " + this.name);
        System.out.println("Current HP: " + this.currentHP + "/" + this.maxHP);
        System.out.println("Current Energy: " + this.currentEnergy + "/" + this.maxEnergy);
        System.out.println("Math level: " + this.Math);
    }

    void Heal(int amount, bestGUI gui) {
        this.currentHP += amount;
        if (this.currentHP > this.maxHP)
            this.currentHP = this.maxHP;
        gui.newAction("(+" + amount + " HP)" + "\n");
        System.out.println("(+" + amount + " HP)");
    }

    void Rest(int amount) {
        this.currentEnergy += 10 * amount;
        if (this.currentEnergy > this.maxEnergy)
            this.currentEnergy = this.maxEnergy;
        System.out.println("(+" + amount + " Energy)");
    }

    void StudyMath(Environment timer) {
        if (!((timer.getTime() > 7 && timer.getTime() < 17) || (timer.getTime() > 19))) {
            System.out.println("You're not prepared");
            return;
        }
        timer.updateTime(2);
        this.Math += 50;
        this.currentEnergy -= 10;
        this.currentHP -= 10;
        System.out.println("Ooouf (+50 Math)");
    }

    boolean isDead() {
        return this.currentHP <= 0;
    }
}
