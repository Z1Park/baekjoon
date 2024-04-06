class Solution {
    public int romanToInt(String s) {
        String roman = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500 ,1000};
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                if (c == 'I') {
                    switch (s.charAt(i+1)) {
                        case 'V' -> {
                            result += 4;
                            i++;
                        }
                        case 'X' -> {
                            result += 9;
                            i++;
                        }
                        default -> result += 1;
                    }
                }
                else if (c == 'X') {
                    switch (s.charAt(i+1)) {
                        case 'L' -> {
                            result += 40;
                            i++;
                        }
                        case 'C' -> {
                            result += 90;
                            i++;
                        }
                        default -> result += 10;
                    }
                }
                else if (c == 'C') {
                    switch (s.charAt(i+1)) {
                        case 'D' -> {
                            result += 400;
                            i++;
                        }
                        case 'M' -> {
                            result += 900;
                            i++;
                        }
                        default -> result += 100;
                    }
                }
                else result += values[roman.indexOf(c)];
            }
            else result += values[roman.indexOf(c)];
            System.out.println(i + " : " + result);
        }
        return result;
    }
}