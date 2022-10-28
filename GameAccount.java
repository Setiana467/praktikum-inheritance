public class GameAccount {
    protected double balance;

    public GameAccount(){}
    public GameAccount(double initBalance){
        balance = initBalance;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean deposit (double amt){
        balance += amt;
        return true;
    }

    public boolean withdraw(double amt){
        balance -= amt;
        return true;
    }
}

class SavingGameAccount extends GameAccount{
    private double interestRate;
    
    public SavingGameAccount( double balance, double interest_rate){
        super.balance = balance;
        this.interestRate = interest_rate;
    }

}

class CheckingGameAccount extends GameAccount{
    private double overdraftProtection;

    public CheckingAccount(double balance){
        super();
        this.balance = balance;
        overdraftProtection = -0.1d;

    }

    public CheckingGameAccount(double balance, double protect){;
        super.balance = balance;
        overdraftProtection = protect;
    }
    
    public boolean withdraw(double amt){
        super.withdraw(amt);
        double overdraftNeeded = amt - this.balance;
        if(balance - amt >= 0){
            this.balance -= amt;
            return true;
        }

        else {
            if(overdraftProtection == -1.0 || overdraftProtection < overdraftNeeded){
                return false;
            }

            else{
                this.balance = 0.0;
                overdraftProtection -= overdraftNeeded;
                return true;
            }
        }
    }
}
