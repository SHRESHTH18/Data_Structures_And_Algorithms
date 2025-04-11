package step5_strings.medium;

import java.util.Scanner;

public class p4_string_to_integer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter string");
        String s= in.nextLine();
        int ans=myAtoi(s);
        System.out.println(ans);
    }
    public static int myAtoi(String s){
        int n = s.length();
        long num = 0;
        int i = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            // Check for overflow
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * num);
    }
}
