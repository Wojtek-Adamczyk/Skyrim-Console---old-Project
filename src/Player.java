import java.io.Serializable;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Player implements Serializable
{
    Integer currentHP;
    Integer maximumHP;
    Integer damage;
    Integer armor;
    Integer money;
    Integer stealth;

    public Player(Integer currentHP, Integer maximumHP, Integer damage, Integer armor, Integer money, Integer stealth)
    {
        this.currentHP = currentHP;
        this.maximumHP = maximumHP;
        this.damage = damage;
        this.armor = armor;
        this.money = money;
        this.stealth = stealth;
    }

    public void sheet(Player player)
    {
        System.out.println("HP: " + player.currentHP + "/" + player.maximumHP);
        System.out.println("Damage: " + player.damage);
        System.out.println("Armor: " + player.armor);
        System.out.println("Stealth: " + player.stealth);
        System.out.println("Money: " + player.money + " septims");
        System.out.println();

        if (follower != null)
        {
            System.out.println(player.follower.name + ":");
            System.out.println("HP: " + follower.currentHP);
            System.out.println("Damage: " + follower.damage);
            System.out.println("Armor: " + follower.armor);
            System.out.println();
        }
    }

    public void travel() throws InterruptedException
    {
        System.out.println("1. Travel to Solitude");
        System.out.println("2. Travel to Morthal");
        System.out.println("3. Travel to Markarth");
        System.out.println("4. Travel to Falkreath");
        System.out.println("5. Travel to Whiterun");
        System.out.println("6. Travel to Dawnstar");
        System.out.println("7 .Travel to Winterhold");
        System.out.println("8. Travel to Windhelm");
        System.out.println("9. Travel to Riften");

        String travelling = "Travelling to ";
        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();
        if (playerInput == 1) {currentCity = world.cities[0]; System.out.println(travelling + "Solitude..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 2) {currentCity = world.cities[1]; System.out.println(travelling + "Morthal..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 3) {currentCity = world.cities[2]; System.out.println(travelling + "Markarth..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 4) {currentCity = world.cities[3]; System.out.println(travelling + "Falkreath..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 5) {currentCity = world.cities[4]; System.out.println(travelling + "Whiterun..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 6) {currentCity = world.cities[5]; System.out.println(travelling + "Dawnstar..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 7) {currentCity = world.cities[6]; System.out.println(travelling + "Winterhold..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 8) {currentCity = world.cities[7]; System.out.println(travelling + "Windhelm..."); System.out.println(); SECONDS.sleep(10);}
        if (playerInput == 9) {currentCity = world.cities[8]; System.out.println(travelling + "Riften..."); System.out.println(); SECONDS.sleep(10);}
    }

    public void hireFollower(Follower follower)
    {
        if (money >= 500)
        {
            money -= 500;
            System.out.println(follower.name + " joins you");
            this.follower = follower;

            if (currentCity.guildFollower == follower) {currentCity.guildFollower = null;}
            if (currentCity.follower == follower) {currentCity.guildFollower = null;}
        }
        else {System.out.println("- I'm sorry traveller. You can't afford my skills.");}
    }

    Mission mission;
    World world;
    Follower follower;
    Building building;
    City currentCity;
}