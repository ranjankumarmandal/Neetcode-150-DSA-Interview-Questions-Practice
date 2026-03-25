package org.example.a_array_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(String s : strs) {
            encoded.append(s.length());
            encoded.append(':');
            encoded.append(s);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != ':') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            j++;

            String s = str.substring(i, j + len);

            result.add(s);

            i = j + len;
        }

        return result;
    }
}
