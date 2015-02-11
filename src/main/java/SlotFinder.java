import java.util.List;
import java.util.Optional;

/**
 * Created by adinathshirsath on 11/02/15.
 */
public interface SlotFinder {

    Optional<ParkingLot> findAvailableSlot(List<ParkingLot> parkingLots);
}
