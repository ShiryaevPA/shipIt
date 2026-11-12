package parcel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {

    private PerishableParcel parcel;

    @BeforeEach
    void beforeEach() {
        parcel = new PerishableParcel();
        parcel.setWeight(10);
        parcel.setSendDay(1);
        parcel.setTimeToLive(5);
    }

    @Test
    void shouldReturn30ForWeight10() {
        Assertions.assertEquals(30, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldBeIsExpiredTrueCurrentDay7() {
        Assertions.assertTrue(parcel.isExpired(7));
    }

    @Test
    void shouldBeIsExpiredFalseCurrentDay6() {
        Assertions.assertFalse(parcel.isExpired(6));
    }

    @Test
    void shouldBeIsExpiredFalseCurrentDay0() {
        Assertions.assertFalse(parcel.isExpired(0));
    }
}