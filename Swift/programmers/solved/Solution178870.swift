/*
 이분 탐색으로 해결, 시간복잡도 O(n)으로 해결 가능한 문제
 */

import Foundation

func solution(_ sequence:[Int], _ k:Int) -> [Int] {
    if let first = sequence.firstIndex(of: k) {
        return [first, first]
    }
    var count = 1
    var (left, right) = (0, 1)
    var result = (0, sequence.count - 1)
    var sum = sequence[left...right].reduce(0, +)
    while left < right {
        if sum == k {
            if result.1 - result.0 > right - left {
                result = (left, right)
            }
            sum -= sequence[left]
            left += 1
        } else if sum > k {
            sum -= sequence[left]
            left += 1
        } else {
            right += 1
            if right == sequence.count { break }
            sum += sequence[right]
        }
    }
    return [result.0, result.1]
}


/*
 슬라이딩 윈도우 + 완탐으로 풀었다가 시간초과난 코드
 */

import Foundation

func solution(_ sequence:[Int], _ k:Int) -> [Int] {
    if let first = sequence.firstIndex(of: k) {
        return [first, first]
    }
    var count = 1
    var (left, right) = (0, 1)
    var sum = sequence[left] + sequence[right]
    var initialSum = sum
    while true {
        if sum == k { break }
        left += 1
        right += 1
        if sum > k || right == sequence.count {
            count += 1
            left = 0
            right = left + count
            if right == sequence.count { break }
            sum = initialSum + sequence[right]
            initialSum = sum
        } else {
            sum = sum - sequence[left - 1] + sequence[right]
        }
    }
    return [left, right]
}

/*
테스트 1 〉     통과 (0.01ms, 16.5MB)
테스트 2 〉     통과 (0.02ms, 16.4MB)
테스트 3 〉     통과 (0.02ms, 16.2MB)
테스트 4 〉     통과 (1.58ms, 16.4MB)
테스트 5 〉     통과 (6.55ms, 17MB)
테스트 6 〉     통과 (4007.16ms, 17.4MB)
테스트 7 〉     통과 (614.24ms, 18.7MB)
테스트 8 〉     통과 (1076.09ms, 21MB)
테스트 9 〉     통과 (7288.96ms, 25.6MB)
테스트 10 〉    실패 (시간 초과)
테스트 11 〉    실패 (시간 초과)
테스트 12 〉    실패 (시간 초과)
테스트 13 〉    실패 (시간 초과)
테스트 14 〉    실패 (시간 초과)
테스트 15 〉    실패 (시간 초과)
테스트 16 〉    실패 (시간 초과)
테스트 17 〉    통과 (2524.38ms, 60.5MB)
테스트 18 〉    통과 (0.01ms, 16.5MB)
테스트 19 〉    통과 (0.02ms, 16.3MB)
테스트 20 〉    통과 (0.02ms, 16.4MB)
테스트 21 〉    통과 (0.02ms, 16.4MB)
테스트 22 〉    통과 (0.02ms, 16.4MB)
테스트 23 〉    통과 (0.02ms, 16.2MB)
테스트 24 〉    실패 (시간 초과)
테스트 25 〉    실패 (시간 초과)
테스트 26 〉    실패 (시간 초과)
테스트 27 〉    실패 (시간 초과)
테스트 28 〉    실패 (시간 초과)
테스트 29 〉    실패 (시간 초과)
테스트 30 〉    실패 (시간 초과)
테스트 31 〉    통과 (0.01ms, 16.4MB)
테스트 32 〉    통과 (0.01ms, 16.5MB)
테스트 33 〉    통과 (0.01ms, 16.4MB)
테스트 34 〉    통과 (0.02ms, 16.2MB)
채점 결과
정확성: 58.8
합계: 58.8 / 100.0
*/
