import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ParkingLot {

    private Slots slots;

    private List<Notifiable> parkingAvailableNotifiables;

    private List<Notifiable> parkingFillingFastNotifiables;

    private List<Notifiable> parkingFullNotifiables;
    
    private SlotType slotType;

    public ParkingLot(int size) {
        slots = new Slots(size);
        this.slotType = SlotType.FREE;
        parkingFullNotifiables = new ArrayList<>();
        parkingAvailableNotifiables = new ArrayList<>();
        parkingFillingFastNotifiables = new ArrayList<>();
    }

    public ParkingLot(int size, SlotType slotPrice) {
        this.slotType = slotPrice;
        slots = new Slots(size);
    }

    public Optional<Integer> parkIn(Object object) {

        if (slots.getStatus() == ParkingLotStatus.FULL) {
            return Optional.empty();
        }

        Optional<Integer> parked = slots.allotSlot(object);

        ParkingLotStatus slotStatusAfterParking = slots.getStatus();

        switch (slotStatusAfterParking) {
            case FULL:
                notifyEvents(parkingFullNotifiables);
                break;
            case FILLING_FAST:
                notifyEvents(parkingFillingFastNotifiables);
                break;
        }
        return parked;
    }


    public Optional<Object> parkOut(Integer token) {
        Optional<Object> parkedObject = slots.freeSlot(token);
        if (slots.getStatus() == ParkingLotStatus.AVAILABLE) {
            notifyEvents(parkingAvailableNotifiables);
        }
        return parkedObject;
    }

    private void notifyEvents(final List<Notifiable> notifiables) {
        notifiables.forEach(new Consumer<Notifiable>() {
            @Override
            public void accept(Notifiable notifiable) {
                notifiable.notifyEvent();
            }
        });
    }

    public void registerForParkingFullEvent(Notifiable notifiable) {
        parkingFullNotifiables.add(notifiable);
    }

    public void registerForParkingAvailableEvent(Notifiable notifiable) {
        parkingAvailableNotifiables.add(notifiable);
    }

    public void registerForParkingFillingFastEvent(Notifiable notifiable) {
        parkingFillingFastNotifiables.add(notifiable);
    }

    public ParkingLotStatus getStatus() {
        return slots.getStatus();
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
        
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
