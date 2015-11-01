public class SlotFinderFactory {

    public static SlotFinder getSlotFinder(SlotFinderStrategy strategy) {
        switch (strategy) {
            case CHEAPEST:
                return new CheapestSlotFinder();
            case WITH_MAXIMUM_AVAILABLE_SLOTS:
                return new SpaciousSlotFinder();
            default:
                return null;
        }
    }
}
