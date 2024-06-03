package hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BloomFilterTest {

    @Test
    void givenInsertionsAndFPP_whenCalculateBitSize_thenEquals() {
        BloomFilter bloomFilter = new BloomFilter(100, 0.03);
        int bitSize = bloomFilter.calculateBitSize(100, 0.03);
        int bitSize1 = bloomFilter.calculateBitSize(100, 0.02);
        int bitSize2 = bloomFilter.calculateBitSize(100, 0.001);
        Assertions.assertThat(bitSize).isEqualTo(729);
        Assertions.assertThat(bitSize1).isEqualTo(814);
        Assertions.assertThat(bitSize2).isEqualTo(1437);
    }

    @Test
    void givenInsertionsAndFPP_whenCalculateHashCount_thenEquals() {
        BloomFilter bloomFilter = new BloomFilter(100, 0.03);
        int hashCount = bloomFilter.calculateHashCount(100, 729);
        int hashCount1 = bloomFilter.calculateHashCount(100, 814);
        int hashCount2 = bloomFilter.calculateHashCount(100, 1437);
        Assertions.assertThat(hashCount).isEqualTo(5);
        Assertions.assertThat(hashCount1).isEqualTo(5);
        Assertions.assertThat(hashCount2).isEqualTo(9);
    }
}
