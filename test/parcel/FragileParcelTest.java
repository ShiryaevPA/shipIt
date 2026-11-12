package parcel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FragileParcelTest {

    private FragileParcel parcel;

    @BeforeEach
    void beforeEach() {
        parcel = new FragileParcel();
        parcel.setWeight(10);
    }

    @Test
    void shouldReturn40ForWeight10() {
        Assertions.assertEquals(40, parcel.calculateDeliveryCost());
    }
}