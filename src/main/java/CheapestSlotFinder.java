import java.util.List;
import java.util.Optional;

/**
 * Created by adinathshirsath on 11/02/15.
 */
public class CheapestSlotFinder implements SlotFinder {

    @Override
    public Optional<ParkingLot> findAvailableSlot(List<ParkingLot> parkingLots) {

        return parkingLots.stream().
                sorted(
                        (parkingLot1, parkingLot2) ->
                                Math.round(parkingLot1.getSlotType().price - parkingLot2.getSlotType().price)
                )
                .filter(
                        parkingLot ->
                                parkingLot.getStatus() == ParkingLotStatus.AVAILABLE)
                .findFirst();
    }
}
