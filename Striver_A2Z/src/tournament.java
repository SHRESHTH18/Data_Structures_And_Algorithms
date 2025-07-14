
import java.util.*;
public class tournament {

    static int leastButtonPress(int n, int d, int[] digits, int pres, int dest) {
        if (pres == dest) return 0;

        // Calculate direct movement using F or B buttons
        int clock = (dest - pres + n) % n;
        int anti = (pres - dest + n) % n;
        if (clock == 0) clock = n;
        if (anti == 0) anti = n;

        int count = Math.min(clock, anti);

        // Try all possible stations we can enter with functioning digits
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize queue with single-digit stations
        for (int digit : digits) {
            if (digit > 0 && digit <= n) {
                queue.add(digit);
                visited.add(digit);
            }
        }

        int digitCount = 1;

        while (!queue.isEmpty() && digitCount < 5) {  // Max 5 digits for N < 10000
            int size = queue.size();
            digitCount++;

            for (int i = 0; i < size; i++) {
                int el = queue.poll();

                // Calculate button presses for this station
                int enter = digitCount;  // Digits + Enter button
                int forw = (dest - el + n) % n;
                int back = (el - dest + n) % n;
                if (forw == 0) forw = n;
                if (back == 0) back = n;

                int totalPresses = enter + Math.min(forw, back);
                count = Math.min(count, totalPresses);

                // Generate next level of els
                for (int digit : digits) {
                    long next = el * 10L + digit;
                    if (next <= n && !visited.contains((int)next)) {
                        queue.add((int)next);
                        visited.add((int)next);
                    }
                }
            }
        }

        return count;
    }
}
