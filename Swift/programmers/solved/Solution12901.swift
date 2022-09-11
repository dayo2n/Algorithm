import Foundation

func solution(_ a:Int, _ b:Int) -> String {
    let dateComponents = DateComponents(year: 2016, month: a, day: b)
    let date = Calendar.current.date(from: dateComponents)
    let formatter = DateFormatter()
    formatter.dateFormat = "EEE"
    return formatter.string(from: date!).uppercased()
}
