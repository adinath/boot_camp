import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class ParkingLotTest {


    @Test
    public void shouldAllowParkIfParkingIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.parkIn(new Object()).isPresent(), is(true));
    }

    @Test
    public void shouldGetStatusOfParkingIfItIsFull() {
        ParkingLot parkingLot = new ParkingLot(0);

        assertThat(parkingLot.getStatus(), is(ParkingLotStatus.FULL));
    }

    @Test
    public void shouldGetStatusOfParkingIfItIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(3);

        assertThat(parkingLot.getStatus(), is(ParkingLotStatus.AVAILABLE));
    }

    @Test
    public void shouldGetParkedCarOut() {
        ParkingLot parkingLot = new ParkingLot(1);

        Integer token = parkingLot.parkIn(new Object()).get();

        assertThat(parkingLot.parkOut(token).isPresent(), is(true));
    }


    @Test
    public void shouldAbleToRegisterForParkingFullEvent(){
        ParkingFullNotifier parkingFullEventListener = mock(ParkingFullNotifier.class);

        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.registerForParkingFullEvent(parkingFullEventListener);

        parkingLot.parkIn(new Object());

        verify(parkingFullEventListener,times(1)).notifyEvent();
    }

    @Test
    public void shouldGetNotifiedWhenParkingLotIsFillingFast() {
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingFillingFastNotifier listener = mock(ParkingFillingFastNotifier.class);

        parkingLot.registerForParkingFillingFastEvent(listener);

        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());

        verify(listener, times(1)).notifyEvent();

    }

    @Test
    public void shouldHaveCostAssociatedWithParkingLot(){
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.setSlotType(SlotType.FREE);

        assertThat(parkingLot.getSlotType(), is(SlotType.FREE));
    }

    @Test
    public void shouldGetNotifiedWhenParkingLotIsFillingFastOnThreshhold() {
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingFilingFastListener listener = mock(ParkingFilingFastListener.class);
        ParkingFillingFastNotifier notifier = new ParkingFillingFastNotifier(listener,80.0);

        parkingLot.registerForParkingFillingFastEvent(notifier);

        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object());

        verify(listener, times(1)).parkingFillingFast();

    }

    @Test
    public void shouldGetNotifiedWhenParkingLotIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingAvailableNotifier listener = mock(ParkingAvailableNotifier.class);

        parkingLot.registerForParkingAvailableEvent(listener);

        parkingLot.parkIn(new Object());
        parkingLot.parkIn(new Object()).get();
        int last = parkingLot.parkIn(new Object()).get();
        parkingLot.parkOut(last);
        verify(listener, times(1)).notifyEvent();
    }


    @Test
    public void shouldNotAllowParkIfParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkIn(new Object());
        assertThat(parkingLot.parkIn(new Object()).isPresent(), is(false));
    }

    @Test
    public void shouldGetAvailableSlots(){
        ParkingLot parkingLot = new ParkingLot(3);

        parkingLot.parkIn(new Object());

        assertThat(parkingLot.getAvailableSlots(), is(2));
    }
}
