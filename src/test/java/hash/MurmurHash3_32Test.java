package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MurmurHash3_32Test {

    @Test
    void hashIntTest() {
        MurmurHash3_32 murmurHash3_32 = new MurmurHash3_32();
        assertHashInt(murmurHash3_32.hashInt(0), 0);
        assertHashInt(murmurHash3_32.hashInt(1), -68075478);
        assertHashInt(murmurHash3_32.hashInt(2), 1085422463);
    }

    @Test
    void givenString_whenCalculateHash_thenEquals() {
        MurmurHash3_32 murmurHash3_32 = new MurmurHash3_32();
        assertHashInt(murmurHash3_32.hashString("test", 0), 1351191292);
        assertHashInt(murmurHash3_32.hashString("test", 1), 2123230555);
        assertHashInt(murmurHash3_32.hashString("hello", 0), -675079799);
    }
    private static void assertHashInt(int hash, int expect) {
        assertEquals(expect, hash);
    }
}