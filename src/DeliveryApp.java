import parcel.FragileParcel;
import parcel.Parcel;
import parcel.PerishableParcel;
import parcel.StandardParcel;
import parcel.tracking.Trackable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addParcel();
                case 2 -> sendParcels();
                case 3 -> calculateCosts();
                case 4 -> changeReportStatus();
                case 0 -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Изменить статус для отслеживаемых посылок");
        System.out.println("0 — Завершить");
    }

    private static void showParcel() {
        System.out.println("Какой тип посылки вы хотите добавить?");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
    }
    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        showParcel();
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> addParcelInfo(new StandardParcel());
            case 2 -> addParcelInfo(new FragileParcel());
            case 3 -> addParcelInfo(new PerishableParcel());
            default -> System.out.println("Такой вид посылки не поддерживается");
        }
    }

    private static void addParcelInfo(Parcel parcel) {
        System.out.println("Введите краткое описание посылки");
        String description = scanner.nextLine();
        parcel.setDescription(description);
        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();
        parcel.setDeliveryAddress(deliveryAddress);
        System.out.println("Введите вес посылки (целое число)");
        int weight = Integer.parseInt(scanner.nextLine());
        parcel.setWeight(weight);
        System.out.println("Введите день отправки 1 - 31");
        int sendDay = Integer.parseInt(scanner.nextLine());
        parcel.setSendDay(sendDay);
        if (parcel instanceof PerishableParcel perishableParcel) {
            System.out.println("Введите срок в днях, за который посылка не испортится");
            int timeToLive = Integer.parseInt(scanner.nextLine());
            perishableParcel.setTimeToLive(timeToLive);
        }
        allParcels.add(parcel);
        if(parcel instanceof Trackable) {
            trackableParcels.add((Trackable) parcel);
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            System.out.println();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int costs = 0;
        for (Parcel parcel : allParcels) {
            costs += parcel.calculateDeliveryCost();
        }
        System.out.println("Стоимость доставки всех посылок: " + costs + "\n");
    }

    private static void changeReportStatus() {
        for (Trackable trackableParcel : trackableParcels) {
            System.out.println("Введите новое нахождение посылки " + ((Parcel) trackableParcel).getDescription());
            String newLocation = scanner.nextLine();
            trackableParcel.reportStatus(newLocation);
        }
    }

}
