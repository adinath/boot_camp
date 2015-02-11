import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RectangleTest {
    private Rectangle rectangle;

    @Before
    public void setup() {
        rectangle = new Rectangle(2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegativeLengthInRectangle() {
        rectangle = new Rectangle(-2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowZeroLengthInRectangle() {
        rectangle = new Rectangle(0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegativeBreadthInRectangle() {
        rectangle = new Rectangle(2, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowZeroBreadthInRectangle() {
        rectangle = new Rectangle(2, 0);
    }

    @Test
    public void shouldGetAreaOfRectangle() {
        assertThat(rectangle.area(), is(6));
    }

    @Test
    public void shouldGetPerimeterOfRectangle() {
        assertThat(rectangle.perimeter(), is(10));
    }
}
