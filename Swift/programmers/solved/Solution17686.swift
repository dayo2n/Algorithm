
// [출처:: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/17686

struct File {
    var head: String = ""
    var number: String = ""
    var tail: String = ""
    init(_ head: String, _ number: String, _ tail: String) {
        self.head = head
        self.number = number
        self.tail = tail
    }
    func getFileName() -> String {
        return head + number + tail
    }
}

func splitFileName(_ fileName: String) -> File {
    var head: String = ""
    var number: String = ""
    var tail: String = ""
    var doneNumber: Bool = true
    fileName.forEach { char in
                      if !doneNumber {
                          tail += String(char)
                      } else {
                          if char.isNumber { number += String(char)}
                          else if number.count > 0 {
                              tail += String(char)
                              doneNumber = false
                          } else { head += String(char) }
                       }
                     }
    return File(head, number, tail)
}

func solution(_ files:[String]) -> [String] {
    var sortFiles: [File] = []
    for file in files {
        sortFiles.append(splitFileName(file))
    }
    
    return sortFiles.sorted{
        if $0.head.lowercased() == $1.head.lowercased() {
            return Int($0.number)! < Int($1.number)!
        } else { return $0.head.lowercased() < $1.head.lowercased() }}.map{$0.getFileName()}
}
