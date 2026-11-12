package parcel;

public class StandardParcel extends Parcel {

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * STANDARD_BASE_COST;
    }

    @Override
    public String toString() {
        return "StandardParcel{ " + super.toString() + " }";
    }
}
