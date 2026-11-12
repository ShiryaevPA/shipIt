package parcel;

public class PerishableParcel extends Parcel {

    private int timeToLive;

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive < currentDay;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * PERISHABLE_BASE_COST;
    }

    @Override
    public String toString() {
        return "PerishableParcel{ " +
                "timeToLive=" + timeToLive +
                super.toString() + " }";
    }
}
