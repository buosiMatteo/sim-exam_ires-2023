package it.ires.exam;

import it.ires.exam.exception.NeverCallThisNumberException;
import it.ires.exam.exception.NumberNotValidException;
import it.ires.exam.exception.UserAreadyCallingException;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Smartphone extends SimCard {
    private String owner;

    private boolean isCalling = false;

    private LocalTime startCall;

    private int minuteOfCall;

    private Map<String, Integer> callRegister;

    private String lastNumberCalled;

    public Smartphone(String number, double credit, String nameOfOwner, int minuteOfCall, PhonePlan phonePlan) throws NumberNotValidException {
        super(number, credit, phonePlan);
        this.owner = nameOfOwner;
        this.minuteOfCall = minuteOfCall;
        callRegister = new HashMap<>();
    }

    public String getOwner() {
        return owner;
    }

    public boolean isCalling() {
        return isCalling;
    }

    public void setCalling(boolean calling) {
        isCalling = calling;
    }

    public int getMinuteOfCall() {
        return minuteOfCall;
    }

    public Integer getTotalMinutesOfCalling() {
        return minuteOfCall;
    }

    public String getLastNumberCalled() {
        return lastNumberCalled;
    }


    public void startCall(String numberToCall) throws UserAreadyCallingException {
        if (isCalling == false) {
            isCalling = true;
            startCall = LocalTime.now();
            lastNumberCalled = numberToCall;
            return;
        } else {
            throw new UserAreadyCallingException();
        }
    }

    public boolean endCall() {
        isCalling = false;
        int callLength = LocalTime.now().getMinute() - (startCall.getMinute());
        minuteOfCall += callLength;
        callRegister.put(lastNumberCalled, 0);
        int numberofCall = callRegister.get(lastNumberCalled);
        numberofCall++;
        callRegister.put(lastNumberCalled, numberofCall);
        return true;
    }

    public Integer numberOfCallToANumber(String numberToSearch) throws NeverCallThisNumberException {
        for (String number : callRegister.keySet()) {
            if (number.equalsIgnoreCase(numberToSearch)) {
                return callRegister.get(number);
            }
        }
        throw new NeverCallThisNumberException();
    }

    public void printSimContentAndCallRegister() {
        System.out.println("Sim Data: ");
        System.out.println(super.toString());
        System.out.println("Calls made: ");
        System.out.println(callRegister.keySet());
    }
}
