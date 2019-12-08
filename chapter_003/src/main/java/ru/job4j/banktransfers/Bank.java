package ru.job4j.banktransfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    Map<User, List<Account>> usersAccounts = new HashMap<>();

    private boolean existUserByPassport(String passport) {
        boolean result = false;
        for (User u : this.usersAccounts.keySet()) {
            if (u.getPassport().equals(passport)) {
                result = true;
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

    public void addUser(User user) {
        if (!existUserByPassport(user.getPassport())) {
            this.usersAccounts.putIfAbsent(user, new ArrayList<Account>());
        }
    }

    public void deleteUser(User user) {
        this.usersAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (!existAccount(account.getRequisites())) {
            for (User user : this.usersAccounts.keySet()) {
                if (user.getPassport().equals(passport)) {
                    this.usersAccounts.get(user).add(account);
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.usersAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.usersAccounts.get(user).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User user : this.usersAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = this.usersAccounts.get(user);
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User srcUser = null, dstUser = null;
        Account srcAcc = null, dstAcc = null;
        for (Map.Entry<User, List<Account>> entry : this.usersAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport)) {
                srcUser = entry.getKey();
                for (Account acc : entry.getValue()) {
                    if (acc.getRequisites().equals(srcRequisite)) {
                        srcAcc = acc;
                    }
                }
            } else if (entry.getKey().getPassport().equals(destPassport)) {
                dstUser = entry.getKey();
                for (Account acc : entry.getValue()) {
                    if (acc.getRequisites().equals(dstRequisite)) {
                        dstAcc = acc;
                    }
                }
            }
        }

        if (srcUser != null && dstUser != null && srcAcc != null && dstAcc != null) {
            if (srcAcc.getValue() >= amount) {
                srcAcc.setValue(srcAcc.getValue() - amount);
                dstAcc.setValue(dstAcc.getValue() + amount);
                result = true;
            }
        }
        return result;
    }
}
