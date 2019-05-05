package com.datastructure.skiplist

import scala.util.Random

class SkipList {
  val MaxLevel: Int = 3
  var level: Int = 0
  val head: SkipListNode = new SkipListNode(MaxLevel)
  var size: Int = 0

  def randomLevel(): Int = {
    var lvl: Int = 0
    while (Random.nextFloat() < 0.8 && lvl < MaxLevel) {
      lvl += 1
    }

    lvl
  }

  def dumpAllNodes(): Unit = {
    for (i <- level to (0, -1)) {
      var tmp = head.forward(i)
      while (tmp != null) {
        print(tmp.value + "\t")
        tmp = tmp.forward(i)
      }
      println()
    }
  }

  def contains(value: Int): Boolean = {
    var node = this.head

    for (i <- head.level to (0, -1)) {
      while (node.forward(i) != null && node.forward(i).value < value)
        node = node.forward(i)

      if (node.forward(i) != null && node.forward(i).value == value)
        return true
    }

    false
  }

  def insert(value: Int): SkipListNode = {
    var curNode = head
    val update: Array[SkipListNode] = new Array[SkipListNode](MaxLevel + 1)

    for (i <- head.level to (0, -1)) {
      while (curNode.forward(i) != null && curNode.forward(i).value < value) {
        curNode = curNode.forward(i)
      }
      update(i) = curNode
    }

    val node = curNode.forward(0)
    if (node != null && node.value == value) {
      node
    } else {
      var lvl = randomLevel()
      if (lvl > level) {
        level += 1
        lvl = level
        update(lvl) = head
      }

      // Create new SkipListNode
      val newNode = new SkipListNode(value, lvl)

      for (i <- newNode.level to (0, -1)) {
        newNode.forward(i) = update(i).forward(i)
        update(i).forward(i) = newNode
      }
      size += 1
      newNode
    }
  }

  def remove(value: Int): SkipListNode = {
    val update: Array[SkipListNode] = new Array[SkipListNode](MaxLevel + 1)
    var node = head

    for (i <- level to (0, -1)) {
      while (node.forward(i) != null && node.forward(i).value < value)
        node = node.forward(i)
      update(i) = node
    }

    node = node.forward(0)
    if (node.value != value) {
      null
    } else {
      for (i <- 0 to node.level) {
        update(i).forward(i) = node.forward(i)
      }
      node
    }


  }

}
