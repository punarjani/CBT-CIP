package banky.service;

import banky.model.Account;
import banky.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, Customer> customers;

    public BankService() {
        customers = new HashMap<>();
    }

    public void createCustomer(String name) {
        customers.put(name, new Customer(name));
    }

    public void createAccount(String customerName, String accountNumber) {
        Customer customer = customers.get(customerName);
        if (customer != null) {
            customer.addAccount(new Account(accountNumber));
        }
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    private Account findAccount(String accountNumber) {
        for (Customer customer : customers.values()) {
            for (Account account : customer.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }
}
