
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AttendantTest {

    @Test
    public void attendeeShouldBookAvailableSlot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        parkingLotList.add(new ParkingLot(2, SlotType.GOLD));

        Attendant attendee = new Attendant(parkingLotList);

        assertThat(attendee.bookSlot(new Object(), SlotFinderStrategy.CHEAPEST).isPresent(), is(true));
    }

    @Test
    public void attendantShouldBookCheapestSlot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        parkingLotList.add(new ParkingLot(2, SlotType.GOLD));
        parkingLotList.add(new ParkingLot(3, SlotType.FREE));

        Attendant attendee = new Attendant(parkingLotList);

        Optional<Receipt> bookedSlot = attendee.bookSlot(new Object(), SlotFinderStrategy.CHEAPEST);

        assertThat(bookedSlot.get().getSlotType(), is(SlotType.FREE));
    }

    @Test
    public void attendantShouldBookFirstAvailableSlot() {
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(new ParkingLot(2, SlotType.GOLD));

        Attendant attendee = new Attendant(parkingLots);

        assertThat(attendee.bookSlot(new Object(), SlotFinderStrategy.CHEAPEST).isPresent(), is(true));
    }

    @Test
    public void attendantShouldBookParkingLotWithMaximumAvailableSlots() {
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(new ParkingLot(4, SlotType.FREE));
        parkingLots.add(new ParkingLot(7, SlotType.SILVER));

        Attendant attendant = new Attendant(parkingLots);

        Optional<Receipt> receipt = attendant.bookSlot(new Object(), SlotFinderStrategy.WITH_MAXIMUM_AVAILABLE_SLOTS);

        assertThat(receipt.get().getSlotType(), is(SlotType.SILVER));
    }

}
