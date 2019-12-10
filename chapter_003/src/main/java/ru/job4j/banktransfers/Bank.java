package ru.job4j.banktransfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    Map<User, List<Account>> usersAccounts = new HashMap<>();

    private User findUserByPassport(String passport) {
        User result = null;
        for (User u : this.usersAccounts.keySet()) {
            if (u.getPassport().equals(passport)) {
                result = u;
                break;
            }
        }
        return result;
    }

    private boolean existAccount(String accRequisite) {
        boolean result = false;
        for (Map.Entry<User, List<Account>> entry : this.usersAccounts.entrySet()) {
            for (Account acc : entry.getValue()) {
                if (acc.getRequisites().equals(accRequisite)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private Account findAccountByUser(String passport, String accRequisite) {
        Account result = null;
        User user = findUserByPassport(passport);
        if (user != null) {
            for (Account acc : this.usersAccounts.get(user)) {
                if (acc.getRequisites().equals(accRequisite)) {
                    result = acc;
                    break;
                }
            }
        }
        return result;
    }

    public void addUser(User user) {
        if (findUserByPassport(user.getPassport()) == null) {
            this.usersAccounts.putIfAbsent(user, new ArrayList<Account>());
        }
    }

    public void deleteUser(User user) {
        this.usersAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (!existAccount(account.getRequisites())) {
            User user = findUserByPassport(passport);
            if (user != null) {
                this.usersAccounts.get(user).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            this.usersAccounts.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        User user = findUserByPassport(passport);
        if (user != null) {
            result = this.usersAccounts.get(user);
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAcc = findAccountByUser(srcPassport, srcRequisite);
        Account dstAcc = findAccountByUser(destPassport, dstRequisite);
        if (srcAcc != null && dstAcc != null) {
            result = srcAcc.transfer(dstAcc, amount);
        }
        return result;
    }
}
