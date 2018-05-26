import java.util.Scanner;

public class Main {

    static Player player;
    static Environment timer;
    static bestGUI gui;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Let's create your character");
        System.out.print("Enter name: ");
        String name = cin.nextLine();
        player = new Player(name);
        System.out.println("Done!");
        gui = new bestGUI();
        player.getInfo(gui);
        if (!gameProcess(player, gui))
            System.out.println("You've lost :(");
        gui.dispose();
    }

    private static boolean gameProcess(Player player, bestGUI gui) {
        timer = new Environment();
        while(true) {
            player.getInfo(gui);
            timer.whatTime(gui);

            if (player.isDead()) {
                System.out.println("You Died.");
                return false;
            }
        }
    }
}

class Environment {
    private int time;
    private int day;
    Environment() {
        this.time = 7;
        this.day = 120;
    }

    void updateTime(int amount) {
        this.time += amount;
        this.day -= this.time/24;
        this.time %= 24;
    }

    void whatTime(bestGUI gui) {
        gui.updateTime(this.time + ":00 " + this.day + " days left");
    }

    void endDay(Player player) {
        int amount = this.time < 7 ? 7 - this.time : 24 - this.time + 7 ;
        this.updateTime(amount);
        System.out.println("Rise and shine! ");
        player.Rest(amount);
    }
    int getTime() {
        return time;
    }
}
