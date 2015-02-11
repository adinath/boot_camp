
public enum SlotType {
    PLATINUM(100.0f), GOLD(50.0f), SILVER(20.0f), FREE(0.0f);
    public float price;


    SlotType(float price) {
        this.price = price;
    }
}
