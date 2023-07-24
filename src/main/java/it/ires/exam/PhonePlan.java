package it.ires.exam;

public enum PhonePlan {
    BASIC(0.5),
    SUPER(0.40),
    DELUXE(0.30);

    private final double PRICE_PER_MINUTE;

    private PhonePlan(double pricePerMinute) {
        this.PRICE_PER_MINUTE = pricePerMinute;
    }
}
