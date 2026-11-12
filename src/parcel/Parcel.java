package parcel;

public abstract class Parcel {

    public static final int STANDARD_BASE_COST = 2;
    public static final int PERISHABLE_BASE_COST = 3;
    public static final int FRAGILE_BASE_COST = 4;

    private String description;

    private String deliveryAddress;

    private int weight;

    private int sendDay;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Вес должен быть больше нуля");
        }
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(int sendDay) {
        if(sendDay > 0 && sendDay < 32) {
            this.sendDay = sendDay;
        } else {
            System.out.println("День отправки должен быть от 1 до 31");
        }
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();

    @Override
    public String toString() {
        return "description='" + description + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", weight=" + weight +
                ", sendDay=" + sendDay;
    }
}
