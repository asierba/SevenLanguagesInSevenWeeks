val list = List("one", "two", "three", "four", "five")

val totalSize = (0 /: list) {(size, i) => size + i.size}

println("total size of list: " + totalSize)

