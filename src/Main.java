import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Let's create your character");
        System.out.print("Enter name :");
        String name = cin.nextLine();
        Player player = new Player(name);
        System.out.println("Done!");
        player.getInfo();
        if (!gameProcess(cin, player))
            System.out.println("You've lost :(");
    }

    private static boolean gameProcess(Scanner cin, Player player) {
        System.out.println("Now the game begins");
        System.out.println("Since this moment you are a student of NSU, congratulations(?)");
        System.out.println("Studying here could be really fun, but there is no fun, if there is no rules");
        System.out.println("1.Everyday you wake up at 7:00, so please take your time to rest");
        System.out.println("Semester lasts for 120 days, spend them wisely");
        System.out.println("To get info about your character type -info");
        System.out.println("To eat something and restore your health type -eat");
        System.out.println("To end the day and get some rest type -sleep");
        System.out.println("To know the time type -time");
        System.out.println("To end your miserable life type -surrender");
        Environment timer = new Environment();
        String choice;
        while(true) {
            choice = cin.nextLine();
            if (choice.equals("-surrender"))
                return false;
            if (choice.equals("-info"))
                player.getInfo();
            if (choice.equals("-time"))
                timer.whatTime();
            if (choice.equals("-sleep"))
                timer.endDay(player);
            if (choice.equals("-eat")) {
                timer.updateTime(1);
                player.Heal(20);
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
    void whatTime() {
        System.out.println(this.time + ":00 " + this.day + " days left");
    }
    void endDay(Player player) {
        int amount = this.time < 7 ? 7 - this.time : 24 - this.time + 7 ;
        this.updateTime(amount);
        player.Rest(amount);
        System.out.println("Rise and shine!");
    }
}