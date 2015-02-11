import java.util.List;
import java.util.Optional;

public class Attendant {

    private List<ParkingLot> parkingLots;

    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<Receipt> bookSlot(Object object, SlotFinderStrategy slotFinderStrategy) {
        SlotFinder slotFinder = SlotFinderFactory.getSlotFinder(slotFinderStrategy);
        Optional<ParkingLot> parkingLot = slotFinder.findAvailableSlot(parkingLots);

        if(parkingLot.isPresent()) {
            Optional<Integer> token = parkingLot.get().parkIn(object);
            return Optional.of(new Receipt(parkingLot.get().getSlotType(),token.get()));
        }

        return Optional.empty();
    }
}



