
public class ParkingFillingFastNotifier implements Notifiable {

    private double threshHoldPercentage;
    private ParkingFilingFastListener parkingFillingFastListener;

    public ParkingFillingFastNotifier(ParkingFilingFastListener parkingAvailableListener, double threshHoldPercentage) {
        this.parkingFillingFastListener = parkingAvailableListener;
        this.threshHoldPercentage = threshHoldPercentage;
    }

    @Override
    public void notifyEvent() {
        parkingFillingFastListener.parkingFillingFast();
    }
}
