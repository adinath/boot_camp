
public class Receipt {
    private final SlotType slotType;

    private final Integer token;

    public Receipt(final SlotType slotType, final Integer token) {
        this.slotType = slotType;
        this.token = token;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public Integer getToken() {
        return token;
    }
}
