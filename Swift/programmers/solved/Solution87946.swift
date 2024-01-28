import Foundation

func solution(_ k:Int, _ dungeons:[[Int]]) -> Int {
    var result = 0
    var visited = Array(repeating: false, count: dungeons.count)
    
    func dfs(_ count: Int, _ fatigue: Int) {
        if result < count {
            result = count
        }
        for index in 0..<dungeons.count {
            if !visited[index], dungeons[index][0] <= fatigue {
                visited[index] = true
                dfs(count + 1, fatigue - dungeons[index][1])
                visited[index] = false
            }
        }
    }
    
    dfs(0, k)
    return result
}
