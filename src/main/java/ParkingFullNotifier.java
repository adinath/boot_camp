
public class ParkingFullNotifier implements Notifiable {

    ParkingFullEventListener parkingFullEventListener;

    public ParkingFullNotifier(ParkingFullEventListener parkingAvailableListener) {
        this.parkingFullEventListener = parkingAvailableListener;
    }

    @Override
    public void notifyEvent() {
        parkingFullEventListener.parkingFull();
    }
}
