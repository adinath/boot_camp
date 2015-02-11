
public class ParkingAvailableNotifier implements Notifiable {

    ParkingAvailableListener parkingAvailableListener;

    public ParkingAvailableNotifier(ParkingAvailableListener parkingAvailableListener) {
        this.parkingAvailableListener = parkingAvailableListener;
    }

    @Override
    public void notifyEvent() {
        parkingAvailableListener.parkingAvailable();
    }
}
