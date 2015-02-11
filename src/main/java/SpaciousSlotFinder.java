import java.util.List;
import java.util.Optional;

public class SpaciousSlotFinder implements SlotFinder {
    @Override
    public Optional<ParkingLot> findAvailableSlot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().sorted(
                (parkingLot1, parkingLot2) ->
                        Math.round(parkingLot2.getAvailableSlots() - parkingLot1.getAvailableSlots())
        ).findFirst();
    }
}
