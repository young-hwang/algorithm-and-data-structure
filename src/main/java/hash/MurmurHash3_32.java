package hash;

public final class MurmurHash3_32 {
    private final int seed;
    private final int c1 = 0xcc9e2d51;
    private final int c2 = 0x1b873593;
    private final int e1 = 0x85ebca6b;
    private final int e2 = 0xc2b2ae35;

    public MurmurHash3_32(int seed) {
       this.seed = seed;
    }

    public int hashInt(int input) {
        if (input == 0) {
            return 0;
        }
        int k = this.mixK(input);
        int h = this.mixH(this.seed, k);
        return this.avalanche(h, 4);
    }

    public int mixK(int k) {
        k *= c1;
        k = Integer.rotateLeft(k, 15);
        k *= c2;
        return k;
    }

    public int mixH(int h, int k) {
        h ^= k;
        h = Integer.rotateLeft(h, 13);
        h = h * 5 + 0xe6546b64;
	    return h;
    }

    public int avalanche(int h, int length) {
        h ^= length;
        h ^= h >>> 16;
        h *= e1;
        h ^= h >>> 13;
        h *= e2;
        h ^= h >>> 16;
        return h;
    }
}
