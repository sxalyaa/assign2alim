package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;
// This is an abstract class representing a bank account.
abstract class Account 
{
  public abstract float getBalance();
}
// This class represents a deposit account, a type of bank account.
class DepositeAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}
// This class represents a savings account, another type of bank account.
class SavingAccount extends Account 
{
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() 
  {
    return accountBalance;
  }
}
// This class represents a composite account that can contain multiple accounts.
class CompositeAccount extends Account
{
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() 
  {
    totalBalance = 0;
    for (Account f : accountList)
    {
      totalBalance = totalBalance + f.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) 
  {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) 
  {
    accountList.add(acc);
  }
}
// This is the main class where the program starts execution.
public class CompositePattern
{
  public static void main(String[] args) 
  {
    // Creating a composite account named component.
    CompositeAccount component = new CompositeAccount();
    // Adding deposit and savings accounts to the composite account.
    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));
    // Getting and printing the total balance of all accounts.
    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}