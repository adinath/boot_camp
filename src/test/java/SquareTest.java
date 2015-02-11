import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {

    @Test
    public void shouldGetAreaOfSquare(){
        Square square = new Square(2);
        assertThat(square.area(),is(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateSquareWithNegativeSide(){
        Square invalidSquare = new Square(-2);
    }
}


