package ru.job4j.banktransfers;

import java.util.Objects;

public class Account {
    private Double value;
    private String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
        this.value = 0.0;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                + "requisites='" + requisites + '\''
                + ", value=" + value
                + '}';
    }
}
