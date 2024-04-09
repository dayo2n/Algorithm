class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for (int index = code - 1; index < cipher.length(); index+=code) {
            answer += cipher.charAt(index);
        }
        return answer;
    }
}