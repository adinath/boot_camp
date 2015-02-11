public class SlotFinderFactory {

    public static SlotFinder getSlotFinder(SlotFinderStrategy strategy) {
        switch (strategy) {
            case CHEAPEST:
                return new CheapestSlotFinder();
            default:
                return null;
        }
    }
}
