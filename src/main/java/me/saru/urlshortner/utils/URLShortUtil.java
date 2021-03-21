package me.saru.urlshortner.utils;

/**
 * 원본 url을 단축시키거나 원래대로 되돌리는 유틸 클래스
 */
public final class URLShortUtil {
    // 공격적인 단어를 생성할 수 있는 문자 삭제 ('a', 'e', 'i', 'o', 'u')
    // 모호한 문자 삭제 ('l', '1')
    public static final String ALPHABET = "bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    public static final int BASE = ALPHABET.length();

    // 41진법 변환을 통해서 10진법 숫자를 문자로 변환
    public static String encode(Long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(ALPHABET.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        return sb.toString();
    }

    // 41진법 문자를 10진법 숫자로 변환
    public static Long decode(String str) {
        long num = 0;
        int power = 1;

        for (int i = 0; i < str.length(); i++) {
            num += ((long) ALPHABET.indexOf(str.charAt(i)) * power);
            power *= BASE;
        }

        return num;
    }

    private URLShortUtil() {
        // empty
    }
}
