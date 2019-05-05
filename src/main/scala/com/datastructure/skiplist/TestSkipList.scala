package com.datastructure.skiplist

object TestSkipList {
  def main(args: Array[String]): Unit = {
    val skipList = new SkipList

    for (i <- 0 to 8) {
      println(i)
      skipList.insert(scala.util.Random.nextInt(10))
    }

    skipList.insert(3)
    skipList.dumpAllNodes()
    skipList.remove(3)
    skipList.dumpAllNodes()

  }
}
