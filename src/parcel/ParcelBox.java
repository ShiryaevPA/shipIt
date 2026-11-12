package parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    public List<T> box;

    int boxCapacity;

    public ParcelBox(int boxCapacity) {
        this.box = new ArrayList<>();
        this.boxCapacity = boxCapacity;
    }

    public void addParcel(T newParcel) {
        int currentWeight = 0;
        for (T parcel : box) {
            currentWeight += parcel.getWeight();
        }

        if (currentWeight + newParcel.getWeight() > boxCapacity) {
            System.out.println("Превышен максимальный вес коробки, добавление посылки '"
                    + newParcel.getDescription() + "' невозможно");
            return;
        }

        box.add(newParcel);
        System.out.println("Посылка '" + newParcel.getDescription() + "' добавлена в коробку.");
    }

    public List<T> getAllParcels() {
        return new ArrayList<>(box);
    }
}
