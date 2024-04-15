package me.hash;

public final class MurmurHash3_32 {
    private final int c1 = 0xcc9e2d51;
    private final int c2 = 0x1b873593;
    private final int e1 = 0x85ebca6b;
    private final int e2 = 0xc2b2ae35;

    public int hashInt(int input) {
        return this.hashInt(input, 0);
    }

    public int hashInt(int input, int seed) {
        if (input == 0) {
            return 0;
        }
        int k = this.mixK(input);
        int h = this.mixH(seed, k);
        return this.avalanche(h, Integer.SIZE / Byte.SIZE);
    }

    public int hashLong(long input) {
        return this.hashLong(input, 0);
    }

    public int hashLong(long input, int seed) {
        if (input == 0) {
            return 0;
        }
        int low = (int) input;
        int high = (int) (input >>> 32);

        int k = this.mixK(low);
        int h = this.mixH(seed, k);

        k = this.mixK(high);
        h = this.mixH(h, k);

        return this.avalanche(h, Long.SIZE / Byte.SIZE);
    }

    public int hashString(CharSequence charSequence, int seed) {
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }

        int h1 = seed;

        for (int i = 1; i < charSequence.length(); i += 2) {
            int k1 = charSequence.charAt(i - 1) | (charSequence.charAt(i) << 16);
            k1 = this.mixK(k1);
            h1 = this.mixH(h1, k1);
        }

        // deal with any remaining characters
        if ((charSequence.length() & 1) == 1) {
            int k1 = charSequence.charAt(charSequence.length() - 1);
            k1 = this.mixK(k1);
            h1 ^= k1;
        }

        return this.avalanche(h1, Character.SIZE / Byte.SIZE * charSequence.length());
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
