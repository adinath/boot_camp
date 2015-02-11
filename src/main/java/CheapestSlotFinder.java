import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by adinathshirsath on 11/02/15.
 */
public class CheapestSlotFinder implements SlotFinder {

    @Override
    public Optional<ParkingLot> findAvailableSlot(List<ParkingLot> parkingLots) {

        return parkingLots.stream().sorted(new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot parkingLot1, ParkingLot parkingLot2) {
                return Math.round(parkingLot1.getSlotType().price - parkingLot2.getSlotType().price);
            }
        }).filter(new Predicate<ParkingLot>() {
            @Override
            public boolean test(ParkingLot parkingLot) {
                System.out.println(parkingLot.getSlotType());
                return parkingLot.getStatus() == ParkingLotStatus.AVAILABLE;
            }
        }).findFirst();

    }
}
