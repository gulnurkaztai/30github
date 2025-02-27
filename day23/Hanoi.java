package day23;

import java.io.*;

public class Hanoi {

    private static void hanoi(int n, int from, int to) {
        if (n == 0)
            return;
        int aux = (1 + 2 + 3) - from - to;
        hanoi(n - 1, from, aux);
        System.out.println(n + " " + from + " " + to);
        hanoi(n - 1, aux, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        hanoi(n, 1, 3);
    }
}
