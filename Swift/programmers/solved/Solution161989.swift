/* 시간 초과 1
 import Foundation

 func solution(_ n:Int, _ m:Int, _ section:[Int]) -> Int {
     var result = 0
     var currentSection = section
     while !currentSection.isEmpty {
         let currentWall = currentSection.removeFirst()
         result += 1
         for width in 0..<m {
             if currentSection.contains(width + currentWall) {
                 currentSection.removeFirst()
             }
         }
     }
     return result
 }
 */

/* 시간 초과 2
 import Foundation

 func solution(_ n:Int, _ m:Int, _ section:[Int]) -> Int {
     var result = 0
     var currentSection = section
     while !currentSection.isEmpty {
         let currentWall = currentSection.removeFirst()
         result += 1
         for candidate in currentSection {
             if candidate < m + currentWall {
                 currentSection.removeFirst()
             } else { break }
         }
     }
     return result
 }
 */

/* 시간 초과는 안났지만 느린 답
 import Foundation

 func solution(_ n:Int, _ m:Int, _ section:[Int]) -> Int {
     var result = 0
     var currentSection = section
     while !currentSection.isEmpty {
         let currentWall = currentSection.removeFirst()
         result += 1
         for candidate in currentSection {
             if candidate < m + currentWall {
                 currentSection.removeFirst()
             } else { break }
         }
     }
     return result
 }
 
 테스트 1 〉    통과 (159.89ms, 18.8MB)
 테스트 2 〉    통과 (375.68ms, 20.2MB)
 테스트 3 〉    통과 (167.13ms, 18.9MB)
 테스트 4 〉    통과 (0.41ms, 16.4MB)
 테스트 5 〉    통과 (165.99ms, 18.7MB)
 테스트 6 〉    통과 (0.04ms, 16.5MB)
 테스트 7 〉    통과 (0.25ms, 16.6MB)
 테스트 8 〉    통과 (71.58ms, 17.9MB)
 테스트 9 〉    통과 (0.14ms, 16.3MB)
 테스트 10 〉    통과 (113.83ms, 18.3MB)
 테스트 11 〉    통과 (0.22ms, 16.2MB)
 테스트 12 〉    통과 (81.57ms, 17.7MB)
 테스트 13 〉    통과 (405.22ms, 20.3MB)
 테스트 14 〉    통과 (196.69ms, 18.9MB)
 테스트 15 〉    통과 (0.06ms, 16.6MB)
 테스트 16 〉    통과 (38.30ms, 17.5MB)
 테스트 17 〉    통과 (136.87ms, 18.1MB)
 테스트 18 〉    통과 (0.17ms, 16.5MB)
 테스트 19 〉    통과 (172.48ms, 18.8MB)
 테스트 20 〉    통과 (75.21ms, 17.7MB)
 테스트 21 〉    통과 (124.34ms, 18.6MB)
 테스트 22 〉    통과 (172.69ms, 19MB)
 테스트 23 〉    통과 (207.72ms, 18.6MB)
 테스트 24 〉    통과 (0.23ms, 16.4MB)
 테스트 25 〉    통과 (156.10ms, 18.9MB)
 테스트 26 〉    통과 (51.40ms, 17.5MB)
 테스트 27 〉    통과 (13.25ms, 16.9MB)
 테스트 28 〉    통과 (0.51ms, 16.4MB)
 테스트 29 〉    통과 (0.12ms, 16.5MB)
 테스트 30 〉    통과 (0.23ms, 16.4MB)
 테스트 31 〉    통과 (0.37ms, 16.3MB)
 테스트 32 〉    통과 (0.39ms, 16.4MB)
 테스트 33 〉    통과 (0.18ms, 16.4MB)
 테스트 34 〉    통과 (0.13ms, 16.4MB)
 테스트 35 〉    통과 (120.92ms, 17.9MB)
 테스트 36 〉    통과 (0.18ms, 16.3MB)
 테스트 37 〉    통과 (54.70ms, 17.7MB)
 테스트 38 〉    통과 (0.15ms, 16.6MB)
 테스트 39 〉    통과 (58.40ms, 17.7MB)
 테스트 40 〉    통과 (0.22ms, 16.3MB)
 테스트 41 〉    통과 (421.85ms, 20MB)
 테스트 42 〉    통과 (0.12ms, 16.4MB)
 테스트 43 〉    통과 (0.32ms, 16.2MB)
 테스트 44 〉    통과 (0.29ms, 16.2MB)
 테스트 45 〉    통과 (205.42ms, 18.9MB)
 테스트 46 〉    통과 (7.06ms, 16.7MB)
 테스트 47 〉    통과 (256.75ms, 19.1MB)
 테스트 48 〉    통과 (45.25ms, 17.5MB)
 테스트 49 〉    통과 (106.93ms, 18.3MB)
 테스트 50 〉    통과 (194.93ms, 19MB)
 */

/*
 removeFirst 대신 removeLast를 사용하게 해서 시간 단축
 */
import Foundation

func solution(_ n:Int, _ m:Int, _ section:[Int]) -> Int {
    var result = 0
    var currentSection: [Int] = section.reversed()
    while !currentSection.isEmpty {
        let currentWall = currentSection.removeLast()
        result += 1
        while true {
            if let last = currentSection.last {
                if last < m + currentWall {
                    currentSection.removeLast()
                } else { break }
            } else { break }
        }
    }
    return result
}
