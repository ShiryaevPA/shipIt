package parcel;

public class FragileParcel extends Parcel {
    @Override
    public int calculateDeliveryCost() {
        return getWeight() * FRAGILE_BASE_COST;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }
}
