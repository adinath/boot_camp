
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AttendantTest {

    @Test
    public void attendeeShouldBookAvailableSlot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        parkingLotList.add(new ParkingLot(2, SlotType.GOLD));
        Attendant attendee = new Attendant(parkingLotList);

        assertTrue(attendee.bookSlot(new Object(), SlotFinderStrategy.CHEAPEST).isPresent());

    }

    @Test
    public void attendantShouldBookCheapestSlot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        parkingLotList.add(new ParkingLot(2, SlotType.GOLD));
        parkingLotList.add(new ParkingLot(3, SlotType.FREE));

        Attendant attendee = new Attendant(parkingLotList);

        Optional<Receipt> bookedSlot = attendee.bookSlot(new Object(), SlotFinderStrategy.CHEAPEST);

        assertEquals(SlotType.FREE, bookedSlot.get().getSlotType());

    }


}
