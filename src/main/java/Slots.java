import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Slots {

    private Map<Integer, Object> lots;

    private int size;

    public Slots(int size) {
        this.size = size;
        lots = new HashMap<>();
    }

    public ParkingLotStatus getStatus() {
        if (lots.size() == size) {
            return ParkingLotStatus.FULL;
        } else if (isFillingFast()) {
            return ParkingLotStatus.FILLING_FAST;
        } else {
            return ParkingLotStatus.AVAILABLE;
        }
    }

    public Optional<Integer> allotSlot(Object object) {
        if (getStatus() == ParkingLotStatus.FULL) {
            return Optional.empty();
        }

        int token = (int) Math.abs(Math.random() * 100);
        lots.put(token, object);
        return Optional.of(token);

    }

    public Optional<Object> freeSlot(Integer token) {
        Object parkedObject = lots.remove(token);
        return Optional.ofNullable(parkedObject);
    }

    private boolean isFillingFast() {
        return ((Float.valueOf(lots.size()) / Float.valueOf(size)) * 100) >= 80;
    }

    public int getAvailableSlots() {
            return size - lots.size();
    }
}
