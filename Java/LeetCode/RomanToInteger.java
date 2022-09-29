package LeetCode;
// problem number 130

import java.util.Hashtable;

class romanWithInteger{
    char roman;
    int number;

    romanWithInteger(char c, int i){
        this.roman = c;
        this.number = i;
    }
}

public class RomanToInteger {
    public static Hashtable<Integer, romanWithInteger> set = new Hashtable<>();

    public static void makeSymbolSets(){
        set.put(0, new romanWithInteger('I', 1));
        set.put(1, new romanWithInteger('V', 5));
        set.put(2, new romanWithInteger('X', 10));
        set.put(3, new romanWithInteger('L', 50));
        set.put(4, new romanWithInteger('C', 100));
        set.put(5, new romanWithInteger('D', 500));
        set.put(6, new romanWithInteger('M', 1000));
    }
    public static int romanToInt(String s) {
        makeSymbolSets();

        int output = 0;
        int beforeNumber=0, presentNumber=0;

        for(int i=0; i<s.length(); i++) {
            if (i == 0) {
                for (int j = 0; j < set.size(); j++) {
                    if (set.get(j).roman == s.charAt(0)) {
                        output = set.get(j).number;
                    }
                }
            } else {
                for (int j = 0; j < set.size(); j++) {

                    if (set.get(j).roman == s.charAt(i - 1)) {
                        beforeNumber = set.get(j).number;
                    }
                    if (set.get(j).roman == s.charAt(i)) {
                        presentNumber = set.get(j).number;
                    }
                }
                if (beforeNumber < presentNumber) {
                    output -= (beforeNumber * 2);
                    output += presentNumber;
                } else if (beforeNumber >= presentNumber)
                    output += presentNumber;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
