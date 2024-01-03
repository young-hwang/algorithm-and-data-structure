package hash;

public class MurmurHash3 {
    public static void main(String[] args) {
        MurmurHash3 murmurHash3 = new MurmurHash3();

        if(murmurHash3.hash("Hello") == 316307400) {
            System.out.println("right");
        };

        if(murmurHash3.hash("Hello", 5, true) == -196410714) {
            System.out.println("right");
        };
    }

    private int hash(String key) {
        return 0;
    }


    private int hash(String key, int seed, boolean signed) {
        return 0;
    }
}
