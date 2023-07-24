package it.ires.exam;

import it.ires.exam.exception.*;

import java.util.ArrayList;
import java.util.List;

public class NetworkDistribution {

    private List<Smartphone> smartphoneList;

    private List<SimCard> simCardList;


    public NetworkDistribution() {
        smartphoneList = new ArrayList<>();
        simCardList = new ArrayList<>();
    }

    public void call(Smartphone smartphoneCaller, Smartphone smartphoneReceiver) throws RecievereAlreadyinACallException {
        try {
            if (smartphoneReceiver.isCalling() == false) {
                smartphoneCaller.startCall(smartphoneReceiver.getNumber());
                smartphoneCaller.endCall();
            }
        } catch (UserAreadyCallingException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeSimCardPlan(SimCard s1, PhonePlan phonePlan) {
        s1.setPhonePlan(phonePlan);
    }

    public void createSimCards() {
        try {
            SimCard s1 = new SimCard("+391234567890", 0.0, PhonePlan.BASIC);
            SimCard s2 = new SimCard("+391234567891", 0.0, PhonePlan.SUPER);
            SimCard s3 = new SimCard("+391234567892", 0.0, PhonePlan.DELUXE);
            simCardList.add(s1);
            simCardList.add(s2);
            simCardList.add(s3);
        } catch (NumberNotValidException e) {
            System.out.println(e.getMessage());
        }
    }

    public SimCard createNewSimCard(String number, double credit, PhonePlan phonePlan) throws CantCreateSimException {
        try {
            return new SimCard(number, credit, phonePlan);
        } catch (NumberNotValidException e) {
            System.out.println(e.getMessage());
        }
        throw new CantCreateSimException();
    }

    public Smartphone createNewSmartphone(String number, double credit, String nameOfOwner, int minuteOfCall, PhonePlan phonePlan) throws CantCreateSmartphoneException {
        try {
            return new Smartphone(number, credit, nameOfOwner, minuteOfCall, phonePlan);
        } catch (NumberNotValidException e) {
            System.out.println(e.getMessage());
        }
        throw new CantCreateSmartphoneException();
    }

    public void makeCall(Smartphone smartphone, String numberToCall) {
        try {
            smartphone.startCall(numberToCall);
        } catch (UserAreadyCallingException e) {
            System.out.println(e.getMessage());
        }
    }
}

