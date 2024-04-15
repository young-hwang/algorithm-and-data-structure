package me.hash;

// Fowler-Noll-Vo(FNV)
// 해시 함수 중 하나로 간단하면서도 효과적인 비암호화 해시 함수이다.
// 데이터를 고정 크기의 해시값으로 변환한다.
public class FNVHash {

    public static void main(String[] args) {
        String data = "Hello, World!";
        int hash = fnv1a32(data);
        System.out.println("FNV-1a hash: " + hash);
    }

    private static int fnv1a32(String data) {
        final int prime = 0x01000193;   // FNV Prime constant
        int hash = 0x811c9dc5;  // FNV Offset basis

        for (int i = 0; i < data.length(); i++) {
            hash ^= data.charAt(i);
            hash *= prime;
        }

        return hash;
    }
}
