import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SlotsTest {

    @Test
    public void shouldGetCountOfAvailableFreeSlots() {
        Slots slots = new Slots(2);

        slots.allotSlot(new Object());


        assertThat(slots.getAvailableSlots(), is(1));

    }


}