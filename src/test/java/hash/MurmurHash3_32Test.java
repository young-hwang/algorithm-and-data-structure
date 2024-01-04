package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MurmurHash3_32Test {

    @Test
    void hashIntTest() {
        MurmurHash3_32 murmurHash3_32 = new MurmurHash3_32(0);
        assertHashInt(murmurHash3_32.hashInt(0), 0);
        assertHashInt(murmurHash3_32.hashInt(1), -68075478);
        assertHashInt(murmurHash3_32.hashInt(2), 1085422463);
    }

    private static void assertHashInt(int hash, int expect) {
        assertEquals(expect, hash);
    }
}