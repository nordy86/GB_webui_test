package com.geekbrains.Lesson_4;

public class Functions {
    public static boolean isPrime(Integer number) {
        if (number <= 0) return false;
        if (number <= 3) return true;
        for (int i = 2; i < number; i++) {
            if (number % i ==0) return false;
        }
        return true;
    }
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length()-1)) {
            return false;
        }
        return false;
    }
}
