package me.hyperloglog;

public class HyperLogLog {

    public void add(String[] dataset, int m) {
        byte[] sketch = new byte[m];

        for(String element : dataset) {
            long hash = calcHash(element);
            int bucket = calcBucket(hash);
            byte leadingZeros = calcLeadingZeros(hash);

            sketch[bucket] = (byte) Math.max(sketch[bucket], leadingZeros);
        }
    }

    public double get() {
        int m = 16;
        double alpha = 0.673;

        byte[] sketch = new byte[m];

        double z = 0;
        for (byte leadingZeros : sketch) {
            z += Math.pow(2, -leadingZeros);
        }
        return alpha * m * m / z;
    }

    public byte[] merge(byte[] sketch1, byte[] sketch2) {
        int m = sketch1.length;
        byte[] mergedSketch = new byte[m];

        for (int i = 0; i < m; i++) {
            mergedSketch[i] = (byte) Math.max(sketch1[i], sketch2[i]);
        }

        return mergedSketch;
    }

    private byte calcLeadingZeros(long hash) {
        return 0;
    }

    private int calcBucket(long hash) {
        return 0;
    }

    private long calcHash(String element) {
        return 0;
    }
}
