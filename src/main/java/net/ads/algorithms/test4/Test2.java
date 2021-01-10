package net.ads.algorithms.test4;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        EngineerFirm e = new EngineerFirm(5);
        e.assignSalaries(new int[] { 6848, 9329, 9984, 5543, 7986 });
        e.averageSalary();
        e.maxSalary();
        e.minSalary();

        AccountantFirm a = new AccountantFirm(5);
        a.assignSalaries(new int[] { 9317, 7796, 3352, 7068, 9500 });
        a.averageSalary();
        a.maxSalary();
        a.minSalary();

    }
}

class EngineerFirm implements Company {
    private static DecimalFormat df = new DecimalFormat("#.00");

    int[] income;

    EngineerFirm(int n) {
        income = new int[n];
    }

    @Override
    public void assignSalaries(int[] salaries) {
        int max = income.length;
        if (salaries.length < income.length) {
            max = salaries.length;
        }
        for (int i = 0; i < max; i++) {
            income[i] = salaries[i];
        }
        System.out.println("Incomes of engineers credited");
    }

    @Override
    public void averageSalary() {
        double result = Arrays.stream(income).average().getAsDouble();
        System.out.println("Average salary of engineers is " + df.format(result));
    }

    @Override
    public void maxSalary() {
        System.out.println("Maximum salary amongst engineers is " + Arrays.stream(income).max().getAsInt());
    }

    @Override
    public void minSalary() {
        System.out.println("Minimum salary amongst engineers is " + Arrays.stream(income).min().getAsInt());
    }
}

class AccountantFirm implements Company {
    private static DecimalFormat df = new DecimalFormat("#.00");

    int[] income;

    AccountantFirm(int n) {
        income = new int[n];
    }

    @Override
    public void assignSalaries(int[] salaries) {
        int max = income.length;
        if (salaries.length < income.length) {
            max = salaries.length;
        }
        for (int i = 0; i < max; i++) {
            income[i] = salaries[i];
        }
        System.out.println("Incomes of accountants credited");

    }

    @Override
    public void averageSalary() {
        double result = Arrays.stream(income).average().getAsDouble();
        System.out.println("Average salary of accountants is " + df.format(result));
    }

    @Override
    public void maxSalary() {
        System.out.println("Maximum salary amongst accountants is " + Arrays.stream(income).max().getAsInt());
    }

    @Override
    public void minSalary() {
        System.out.println("Minimum salary amongst accountants is " + Arrays.stream(income).min().getAsInt());
    }

}

interface Company {
    void assignSalaries(int[] salaries);

    void averageSalary();

    void maxSalary();

    void minSalary();
}
