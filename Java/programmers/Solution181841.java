class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (int index = 0; index < str_list.length; index++) {
            if (!str_list[index].contains(ex)) {
                answer += str_list[index];
            }
        }
        return answer;
    }
}