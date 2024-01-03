package hash;

import java.util.BitSet;

public class BloomFilter {
    private BitSet bitSet;
    private int bitSize;
    private int expectedInsertions;
    // false positive probability(%)
    private double fpp;
    private int hashCount;

    public BloomFilter(int expectedInsertions, double fpp) {
        this.expectedInsertions = expectedInsertions;
        this.fpp = fpp;
        this.bitSize = this.calculateBitSize(this.expectedInsertions, this.fpp);
        this.hashCount = this.calculateHashCount(this.expectedInsertions, this.bitSize);
        this.bitSet = new BitSet(this.bitSize);
        this.printParameters();
    }

    @Override
    public String toString() {
        return "BloomFilter{" +
                "bitSet=" + bitSet +
                ", bitSize=" + bitSize +
                ", expectedInsertions=" + expectedInsertions +
                ", fpp=" + fpp +
                ", hashCount=" + hashCount +
                '}';
    }

    private void printParameters() {
        System.out.println(this.toString());
    }

    public int calculateHashCount(int expectedInsertions, int bitSize) {
        return (int) (bitSize * Math.log(2) / expectedInsertions);
    }

    public int calculateBitSize(int insertions, double fpp) {
        return (int) (-Math.log(fpp) * insertions / (Math.pow(Math.log(2), 2)));
    }

    public void add(String key) {
        for (int i = 0; i < this.hashCount; i++) {
            int hash = 0;
//            int hash = HashUtil.hash(key, i);
            this.bitSet.set(hash, true);
        }
    }
}
