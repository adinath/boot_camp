
public class Rectangle {
    private int length;
    private int breadth;

    public static Rectangle create(int length, int breadth){
        return new Rectangle(length,breadth);
    }

    public static Rectangle createSquare(int side){
        return new Square(side);
    }

    public Rectangle(int length, int breadth) {
        if (length <= 0 || breadth <= 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return length * breadth;
    }

    public int perimeter() {
            return 2 * (length + breadth);
    }
}
