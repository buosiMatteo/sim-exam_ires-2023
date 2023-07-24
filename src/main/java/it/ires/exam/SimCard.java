package it.ires.exam;

import it.ires.exam.exception.NumberNotValidException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SimCard {
    private PhonePlan phonePlan;
    private final String number;
    private double credit;
    private List<Integer> callInMinutes;

    public SimCard(String number1, double credit, PhonePlan phonePlan) throws NumberNotValidException {
        this.number = validateNumber(number1);
        this.credit = credit;
        this.phonePlan = phonePlan;
        callInMinutes = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void rechargeSIMCredit(Double credit) {
        this.credit += credit;
    }

    public List<Integer> getCallInMinutes() {
        return callInMinutes;
    }

    public String validateNumber(String number1) throws NumberNotValidException {
        if (number1.matches("\\+[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
            return "(" + number1.substring(0, 3) + ") " + number1.substring(3, 6) + " " + number1.substring(6, 10) + " " + number1.substring(10);
        } else {
            throw new NumberNotValidException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\t - (" + number.substring(0, 3) + ") " + number.substring(3, 6) + " " + number.substring(6, 10) + " " + number.substring(10)));
        sb.append("\n");
        sb.append(String.format("\t - Your credit is %.2f", credit));
        return sb.toString();
    }

    public void setPhonePlan(PhonePlan phonePlan) {
        this.phonePlan = phonePlan;
    }
}
