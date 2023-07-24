package it.ires.exam;

import it.ires.exam.exception.CantCreateSimException;
import it.ires.exam.exception.CantCreateSmartphoneException;
import it.ires.exam.exception.NumberNotValidException;
import it.ires.exam.exception.RecievereAlreadyinACallException;

public class PhoneApp {

    public static void main(String[] args) {
        NetworkDistribution networkDistribution = new NetworkDistribution();
        try {
            networkDistribution.createNewSimCard("+391234567890",0.0,PhonePlan.SUPER);
            networkDistribution.createNewSmartphone("+391234567890",0.0,"Matteo",0,PhonePlan.SUPER);
        } catch (CantCreateSimException | CantCreateSmartphoneException e) {
            throw new RuntimeException(e);
        }

    }
}
