val list = List("one", "two", "three", "four", "five")

val totalSize = list.foldLeft(0)((size, i) => size + i.size)

println("total size of list: " + totalSize)

