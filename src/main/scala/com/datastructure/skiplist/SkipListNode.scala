package com.datastructure.skiplist

class SkipListNode {
  var level: Int = 0
  var value: Int = 0
  var forward: Array[SkipListNode] = _

  def this(value: Int, level: Int) = {
    this()

    this.value = value
    this.level = level
    this.forward = new Array[SkipListNode](level + 1)
    for (i <- 0 to level)
      this.forward(i) = null
  }

  def this(level: Int) = {
    this()
//    val node = new SkipListNode()
    this.level = level
    this.forward = new Array[SkipListNode](level + 1)
    for (i <- 0 to level)
      this.forward(i) = null

  }

  def createNewNode(level: Int): SkipListNode = {
    val node = new SkipListNode()
    node.level = level
    node.forward = new Array[SkipListNode](level + 1)

    node
  }
}
