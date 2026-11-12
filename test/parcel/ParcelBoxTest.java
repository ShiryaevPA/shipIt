package parcel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    private ParcelBox<StandardParcel> standardBox;
    private ParcelBox<FragileParcel> fragileBox;
    private ParcelBox<PerishableParcel> perishBox;

    @BeforeEach
    void beforeAll() {
        standardBox = new ParcelBox<>(100);
        fragileBox = new ParcelBox<>(100);
        perishBox = new ParcelBox<>(100);
    }

    @Test
    void addStandardParcelCapacityFreeWeight50() {
        StandardParcel standardParcel = new StandardParcel();
        standardParcel.setDescription("Standard");
        standardParcel.setWeight(50);
        standardBox.addParcel(standardParcel);
        Assertions.assertEquals(1, standardBox.getAllParcels().size());
    }

    @Test
    void addStandardParcelCapacityFreeWeight100() {
        StandardParcel standardParcel = new StandardParcel();
        standardParcel.setDescription("Standard");
        standardParcel.setWeight(100);
        standardBox.addParcel(standardParcel);
        Assertions.assertEquals(1, standardBox.getAllParcels().size());
    }

    @Test
    void addStandardParcelCapacityFullWeight101() {
        StandardParcel standardParcel = new StandardParcel();
        standardParcel.setDescription("Standard");
        standardParcel.setWeight(101);
        standardBox.addParcel(standardParcel);
        Assertions.assertEquals(0, standardBox.getAllParcels().size());
    }

    @Test
    void addFragileParcelCapacityFreeWeight50() {
        FragileParcel fragileParcel = new FragileParcel();
        fragileParcel.setDescription("Fragile");
        fragileParcel.setWeight(50);
        fragileBox.addParcel(fragileParcel);
        Assertions.assertEquals(1, fragileBox.getAllParcels().size());
    }

    @Test
    void addFragileParcelCapacityFreeWeight100() {
        FragileParcel fragileParcel = new FragileParcel();
        fragileParcel.setDescription("Fragile");
        fragileParcel.setWeight(100);
        fragileBox.addParcel(fragileParcel);
        Assertions.assertEquals(1, fragileBox.getAllParcels().size());
    }

    @Test
    void addFragileParcelCapacityFullWeight101() {
        FragileParcel fragileParcel = new FragileParcel();
        fragileParcel.setDescription("Fragile");
        fragileParcel.setWeight(101);
        fragileBox.addParcel(fragileParcel);
        Assertions.assertEquals(0, fragileBox.getAllParcels().size());
    }

    @Test
    void addPerishableParcelCapacityFreeWeight50() {
        PerishableParcel perishableParcel = new PerishableParcel();
        perishableParcel.setDescription("Perishable");
        perishableParcel.setWeight(50);
        perishBox.addParcel(perishableParcel);
        Assertions.assertEquals(1, perishBox.getAllParcels().size());
    }

    @Test
    void addPerishableParcelCapacityFreeWeight100() {
        PerishableParcel perishableParcel = new PerishableParcel();
        perishableParcel.setDescription("Perishable");
        perishableParcel.setWeight(100);
        perishBox.addParcel(perishableParcel);
        Assertions.assertEquals(1, perishBox.getAllParcels().size());
    }

    @Test
    void addPerishableParcelCapacityFullWeight101() {
        PerishableParcel perishableParcel = new PerishableParcel();
        perishableParcel.setDescription("Perishable");
        perishableParcel.setWeight(101);
        perishBox.addParcel(perishableParcel);
        Assertions.assertEquals(0, perishBox.getAllParcels().size());
    }
}