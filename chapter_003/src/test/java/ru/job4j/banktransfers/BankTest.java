package ru.job4j.banktransfers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    String passport1 = "1234 567890";
    String passport2 = "1234 666777";
    Bank bank = new Bank();
    User user1 = new User("Serg", passport1);
    User user2 = new User("Serg", passport2);
    User user3 = new User("Ivan", passport2);
    Account acc1 = new Account("408101111111111");
    Account acc2 = new Account("408102222222222");
    Account acc3 = new Account("408103333333333");
    Account acc4 = new Account("408104444444444");

    @Test
    public void addUser() {
        bank.addUser(user1);
        assertThat(bank.usersAccounts.size(), is(1));
    }

    @Test
    public void addSameUser() {
        bank.addUser(user1);
        bank.addUser(user1);
        assertThat(bank.usersAccounts.size(), is(1));
    }

    @Test
    public void addUserWIthEqualPassport() {
        bank.addUser(user2);
        bank.addUser(user3);
        assertThat(bank.usersAccounts.size(), is(1));
    }

    @Test
    public void deleteUser() {
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.usersAccounts.size(), is(2));
        bank.deleteUser(user1);
        assertThat(bank.usersAccounts.size(), is(1));
        bank.deleteUser(user2);
        assertThat(bank.usersAccounts.size(), is(0));
    }

    @Test
    public void addAccountToUser() {
        bank.addUser(user1);
        bank.addAccountToUser(passport1, acc1);
        assertThat(bank.usersAccounts.get(user1).size(), is(1));
        assertThat(bank.usersAccounts.get(user1).indexOf(acc1), is(0));
    }

    @Test
    public void addIdenticalAccountToSameUser() {
        bank.addUser(user1);
        bank.addAccountToUser(passport1, acc1);
        bank.addAccountToUser(passport1, acc1);
        bank.addAccountToUser(passport1, acc1);
        assertThat(bank.usersAccounts.get(user1).size(), is(1));
    }

    @Test
    public void addIdenticalAccountToAnotherUser() {
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user2.getPassport(), acc1);
        assertThat(bank.usersAccounts.get(user2).size(), is(0));
        assertThat(bank.usersAccounts.get(user2).indexOf(acc1), is(-1));
    }

    @Test
    public void deleteAccountFromUser() {
        bank.addUser(user1);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user1.getPassport(), acc2);
        bank.deleteAccountFromUser(user1.getPassport(), acc1);
        bank.deleteAccountFromUser(user1.getPassport(), acc2);
        assertThat(bank.usersAccounts.get(user1).size(), is(0));
    }

    @Test
    public void getUserAccounts() {
        bank.addUser(user1);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user1.getPassport(), acc2);
        List<Account> accounts = bank.getUserAccounts(user1.getPassport());
        assertThat(accounts, is(Arrays.asList(acc1, acc2)));
    }

    @Test
    public void transferMoney() {
        bank.addUser(user1);
        bank.addUser(user2);
        acc1.setValue(10.0);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user2.getPassport(), acc2);
        bank.transferMoney(user1.getPassport(), acc1.getRequisites(),
                user2.getPassport(), acc2.getRequisites(), 5.5);
        assertThat(acc1.getValue(), is(4.5));
        assertThat(acc2.getValue(), is(5.5));
    }

    @Test
    public void transferMoneyBad() {
        bank.addUser(user1);
        bank.addUser(user2);
        acc1.setValue(2.0);
        bank.addAccountToUser(user1.getPassport(), acc1);
        bank.addAccountToUser(user2.getPassport(), acc2);
        bank.transferMoney(user1.getPassport(), acc1.getRequisites(),
                user2.getPassport(), acc2.getRequisites(), 5.5);
        assertThat(acc1.getValue(), is(2.0));
        assertThat(acc2.getValue(), is(0.0));
    }
}