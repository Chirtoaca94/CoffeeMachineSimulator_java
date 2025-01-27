package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        theCoffeeMachine coffeeMachine = new theCoffeeMachine();
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine().trim();

            if(action.equals("remaining")) {
                System.out.println(coffeeMachine.toString());
            } else if (action.equals("buy") && coffeeMachine.getCountOfCoffees() >= 10) {
                System.out.println("I need cleaning!");
            } else if(action.equals("buy") && coffeeMachine.getCountOfCoffees() < 10) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu:");
                String choice = scanner.nextLine().trim();
                if(choice.equals("back")) {
                    continue;
                } else if (Integer.parseInt(choice) == 1) {
                    coffeeMachine.buyEspresso();
                } else if (Integer.parseInt(choice) == 2) {
                    coffeeMachine.buyLatte();
                } else if (Integer.parseInt(choice) == 3) {
                    coffeeMachine.buyCappuccino();
                }
            } else if (action.equals("fill")) {
                coffeeMachine.fillMachine();
            } else if (action.equals("take")) {
                System.out.println("I gave you $" + coffeeMachine.money);
                coffeeMachine.money = 0;
            } else if (action.equals("clean")) {
                coffeeMachine.setCountOfCoffees();
                System.out.println("I have been cleaned!");
            } else if (action.equals("exit")) {
                break;
            }
        }
    }


    // The Coffee Machine Class with the necessary user functions inside
    public static class theCoffeeMachine {
        private int water;
        private int milk;
        private int beans;
        private int cups;
        private int money;
        private int countOfCoffees;

        public theCoffeeMachine() {
            this.water = 400;
            this.milk = 540;
            this.beans = 120;
            this.cups = 9;
            this.money = 550;
            this.countOfCoffees = 0;
        }

        public int getCountOfCoffees() {
            return this.countOfCoffees;
        }

        public void setCountOfCoffees() {
            this.countOfCoffees = 0;
        }

        public void buyEspresso() {
            if(this.water >= 250 && this.beans >= 16) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = this.water - 250;
                this.beans = this.beans - 16;
                this.money = this.money + 4;
                this.cups = this.cups - 1;
                this.countOfCoffees = this.countOfCoffees + 1;
            } else if (this.water < 250) {
                System.out.println("Sorry, not enough water!");
            } else {
                System.out.println("Sorry, not enough beans!");
            }
        }

        public void buyLatte() {
            if(this.water >= 350 && this.milk >= 75 && this.beans >= 20) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = this.water - 350;
                this.milk = this.milk - 75;
                this.beans = this.beans - 20;
                this.money = this.money + 7;
                this.cups = this.cups - 1;
                this.countOfCoffees = this.countOfCoffees + 1;
            } else if (this.water < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (this.milk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("Sorry, not enough beans!");
            }
        }

        public void buyCappuccino() {
            if(this.water >= 200 && this.milk >= 100 && this.beans >= 12) {
                System.out.println("I have enough resources, making you a coffee!");
                this.water = this.water - 200;
                this.milk = this.milk - 100;
                this.beans = this.beans - 12;
                this.money = this.money + 6;
                this.cups = this.cups - 1;
                this.countOfCoffees = this.countOfCoffees + 1;
            } else if (this.water < 200) {
                System.out.println("Sorry, not enough water!");
            } else if (this.milk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("Sorry, not enough beans!");
            }
         }

        public void fillMachine() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water do you want to add:");
            this.water = this.water + scanner.nextInt();
            System.out.println("Write how many ml of milk do you want to add:");
            this.milk = this.milk + scanner.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add:");
            this.beans = this.beans + scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add:");
            this.cups = this.cups + scanner.nextInt();
        }

        @Override
        public String toString() {
            return "The coffee machine has:\n" +
                    this.water + " ml of water\n" +
                    this.milk + " ml of milk\n" +
                    this.beans + " g of coffee beans\n" +
                    this.cups + " disposable cups\n" +
                    "$" + this.money + " of money";
        }


    }
}