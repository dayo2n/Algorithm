import Foundation

func solution(_ sizes:[[Int]]) -> Int {
    var width: Int = 0 // 무조건 크게
    var height: Int = 0 // 무조건 더 작게
    for size in sizes {
        let w: Int = max(size[0], size[1])
        let h: Int = min(size[0], size[1])
        width = max(width, w)
        height = max(height, h)
    }
    return width * height
}
