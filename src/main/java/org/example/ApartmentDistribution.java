package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ApartmentDistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] applicants = new int[n];
        int[] apartments = new int[m];

        for (int i = 0; i < n; i++) {
            applicants[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            apartments[i] = scanner.nextInt();
        }

        System.out.println(maxApplicants(applicants, apartments, n, m, k));
        scanner.close();
    }

    public static int maxApplicants(int[] applicants, int[] apartments, int n, int m, int k) {
        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0, j = 0, matches = 0;

        while (i < n && j < m) {
            if (Math.abs(applicants[i]-apartments[j])<=k) {
                matches++;
                i++;
                j++;
            } else if (apartments[j] > applicants[i]) {
                i++;
            } else {
                j++;
            }
        }

        return matches;
    }
}
