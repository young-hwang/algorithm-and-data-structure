import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openjdk.jol.info.ClassLayout;

import java.util.BitSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BitSetTest {
    private static final Logger LOG = LoggerFactory.getLogger(BitSetTest.class);

    @Test
    void givenBooleanArrayAndBitSet_whenCreateInstance_thenCount() {
        // given
        boolean[] bits = new boolean[1024];
        BitSet bs = new BitSet(1024);

        // when
        // then
        System.out.println(ClassLayout.parseInstance(bits).toPrintable());
        System.out.println(ClassLayout.parseInstance(bs).toPrintable());
    }

    @Test
    void givenBitSet_whenSet10_thenIsTrue() {
        // given
        BitSet bitSet = new BitSet(1024);

        // when
        bitSet.set(10);

        // then
        assertThat(bitSet.get(10)).isEqualTo(true);
    }
}
