package com.iimtiaz.day_10.others;

import java.util.ArrayList;
import java.util.Arrays;

public class RelatedProblem {
    public static void main(String[] args) {
        String str = "ADOBECODEBANCABC", n = "ABC";
        //findAllSubstring(str);
        findAllSubstringWithContainWord(str, n);
    }

    // Find all substring
    static void findAllSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    // Find all substring with containing word exactly as ordered.
    static void findAllSubstringWithContainWord(String str, String n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                if (s.contains(n)) {
                    result.add(s);
                }
            }
        }
        System.out.println(result);
    }
}
