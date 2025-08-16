public class BankAccount {
    private String ownerName;
    private float balance;
    private float newBalance;


    public BankAccount(String ownerName, float balance){
        this.ownerName = ownerName;
        this.balance = balance;

    }
    public double floatAmount(float amount){
        balance= balance + amount;
        return balance;

    }
    public double withdraw(float withdraw){
        balance = balance - withdraw;
        return balance;
    }
    public void openNewBalance(String nameBalance1, int numBalance){
        this.newBalance = numBalance;
        System.out.println("You created new Balance: " + nameBalance1);
    }
    public float transferBalance(int sender, int recipient, int sum) {
        float realBalance;
        switch (sender) {
            case 1:
                realBalance = balance - sum;
                newBalance = balance - realBalance;
                System.out.println("Money in second balance: " + newBalance + "\nMoney in first balance: " + realBalance);
                break;
            case 2:
                if (newBalance != 0 && newBalance < sum) {
                    balance = balance - newBalance + sum;
                    newBalance = newBalance - sum;
                    System.out.println("Money in second balance: " + newBalance + "\nMoney in first balance: " + balance);
                    break;
                } else {
                    System.out.println("Error! There is not enough money on your card");
                }

        }
        return newBalance;
    }

    public void displayInfo(){

        System.out.println("Balance in real time: " + balance + "\nSecond balance: " + newBalance);
    }

}
