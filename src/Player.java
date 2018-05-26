class Player {
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
    }

    void Heal(int amount) {
        this.currentHP += amount;
        if (this.currentHP > this.maxHP)
            this.currentHP = this.maxHP;
        Main.gui.newAction("Yummy (+" + amount + " HP)" + "\n");
    }

    void Rest(int amount) {
        this.currentEnergy += 10 * amount;
        if (this.currentEnergy > this.maxEnergy)
            this.currentEnergy = this.maxEnergy;
        Main.gui.newAction("Rise and shine! " + "(+" + amount + " Energy)");
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
        Main.gui.newAction("Ooouf (+50 Math)");
    }

    boolean isDead() {
        return this.currentHP <= 0;
    }
}
