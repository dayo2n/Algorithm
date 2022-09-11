func solution(_ n:Int) -> Int {
    var prime = Array(repeating: false, count: n + 1)
    prime[0] = true
    prime[1] = true
    
    for (idx, value) in prime.enumerated() {
        if prime[idx] { continue }
        
        // from: ~부터, through: ~까지, by: ~씩
        for index in stride(from: idx * 2, through: n, by: idx) {
            prime[index] = true
        }
        
        // prime.enumerated().filter{ (index, element) in
        //                         return index > idx && index % idx == 0 }
        //                     .map { (index, element) in
        //                           return prime[index] = true }
    }
    return prime.filter{!$0}.count
}

// 고차함수를 쓸 경우
// 테스트 1 〉    통과 (0.08ms, 16.5MB)
// 테스트 2 〉    통과 (1.39ms, 16.4MB)
// 테스트 3 〉    통과 (7.65ms, 16.6MB)
// 테스트 4 〉    통과 (31.15ms, 16.5MB)
// 테스트 5 〉    통과 (14.24ms, 16.1MB)
// 테스트 6 〉    통과 (1836.15ms, 16.6MB)
// 테스트 7 〉    통과 (179.30ms, 16.2MB)
// 테스트 8 〉    통과 (1107.68ms, 16.2MB)
// 테스트 9 〉    통과 (2285.79ms, 16.6MB)
// 테스트 10 〉    실패 (시간 초과)
// 테스트 11 〉    실패 (시간 초과)
// 테스트 12 〉    실패 (시간 초과)

// stride를 이용한 이중 for문
//테스트 1 〉    통과 (0.07ms, 16.3MB)
//테스트 2 〉    통과 (0.16ms, 16.4MB)
//테스트 3 〉    통과 (0.32ms, 16.5MB)
//테스트 4 〉    통과 (0.58ms, 16.2MB)
//테스트 5 〉    통과 (0.40ms, 16.5MB)
//테스트 6 〉    통과 (4.36ms, 16.3MB)
//테스트 7 〉    통과 (1.39ms, 16.2MB)
//테스트 8 〉    통과 (3.62ms, 16.3MB)
//테스트 9 〉    통과 (5.11ms, 16.5MB)
//테스트 10 〉    통과 (154.37ms, 16.2MB)
//테스트 11 〉    통과 (576.42ms, 16.6MB)
//테스트 12 〉    통과 (180.09ms, 16.6MB)
