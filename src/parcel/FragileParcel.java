package parcel;

import parcel.tracking.Trackable;

public class FragileParcel extends Parcel implements Trackable {
    @Override
    public int calculateDeliveryCost() {
        return getWeight() * FRAGILE_BASE_COST;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }
}
