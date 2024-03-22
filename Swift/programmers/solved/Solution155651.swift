import Foundation

func solution(_ book_time:[[String]]) -> Int {
    var restBooks = book_time.sorted(by: { $0[0] < $1[0] })
    var rooms = [Booking]()
    while !restBooks.isEmpty {
        let earliest = restBooks.removeFirst()
        let earliestWithCleaning = addCleaningTime(earliest[1])
        let current = Booking(start: earliest[0], end: earliestWithCleaning)
        if rooms.isEmpty {
            rooms.append(Booking(start: current.start, end: current.end))
            continue
        }
        var assigned = false
        for (index, room) in rooms.enumerated() {
            if room.end <= current.start {
                rooms[index].end = current.end
                assigned = true
                break
            }
        }
        if !assigned {
            rooms.append(Booking(start: current.start, end: current.end))
        }
    }
    return rooms.count
}

func addCleaningTime(_ target: String) -> String {
    let splitTarget = target.split(separator: ":").map { Int($0)! }
    var (hour, min) = (splitTarget[0], splitTarget[1])
    min = min + 10
    if min > 60 {
        hour += 1
        min -= 60
    }
    if hour > 23 { return target }
    var hourString = "\(hour < 10 ? "0" : "")\(hour)"
    var minString = "\(min < 10 ? "0" : "")\(min)"
    return "\(hourString):\(minString)"
}

struct Booking {
    let start: String
    var end: String
}
