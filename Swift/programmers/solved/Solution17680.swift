func solution(_ cacheSize:Int, _ cities:[String]) -> Int {
    
    if cacheSize == 0 { return cities.count * 5 }
    
    var cache: [String] = []
    var time: Int = 0
    
    for city in cities {
        let cityName = city.lowercased()
        
        if cache.contains(cityName) {
            time += 1
            cache.remove(at: cache.firstIndex(of: cityName)!)
            cache.append(cityName)
        }
        else {
            time += 5
            if cache.count >= cacheSize { cache.removeFirst() }
            cache.append(cityName)
        }
    }
    return time
}
