import java.util.List;
import java.util.Optional;

public class Attendant {

    private List<ParkingLot> parkingLots;

    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<Receipt> bookSlot(final Object object, final SlotFinderStrategy slotFinderStrategy) {
        SlotFinder slotFinder = SlotFinderFactory.getSlotFinder(slotFinderStrategy);
        Optional<ParkingLot> parkingLot = slotFinder.findAvailableSlot(parkingLots);

        return parkingLot.flatMap(
                (lot) ->
                        Optional.of(new Receipt(lot.getSlotType(),lot.parkIn(object).get()))

        );

//        if(parkingLot.isPresent()) {
//            Optional<Integer> token = parkingLot.get().parkIn(object);
//            return Optional.of(new Receipt(parkingLot.get().getSlotType(),token.get()));
//        }
//
//        return Optional.empty();
    }


}



