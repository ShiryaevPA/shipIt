package parcel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardParcelTest {

    private StandardParcel parcel;

    @BeforeEach
    void beforeEach() {
        parcel = new StandardParcel();
        parcel.setWeight(10);
    }

    @Test
    void shouldReturn20ForWeight10() {
        Assertions.assertEquals(20, parcel.calculateDeliveryCost());
    }
}