package parcel;

public class StandardParcel extends Parcel {

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * STANDARD_BASE_COST;
    }
}
