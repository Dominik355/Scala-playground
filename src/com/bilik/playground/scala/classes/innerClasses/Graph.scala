package com.bilik.playground.scala.classes.innerClasses

class Graph {

  class Node {
    var connectedNodes: List[Graph#Node] = Nil

    def connectTo(node: Graph#Node): Unit = {
      if (!connectedNodes.exists(node.equals)) { // this might also be just : ".contains(node)"
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil

  def newNode(): Node = {
    val res = new Node
    nodes = nodes.::(res)
    res
  }

}

object Test1 {
  def main(args: Array[String]): Unit = {

    val graph1: Graph = new Graph
    val node1: Graph#Node = graph1.newNode
    val node2: Graph#Node = graph1.newNode
    node1.connectTo(node2) // legal
    val graph2: Graph = new Graph
    val node3: Graph#Node = graph2.newNode
    node1.connectTo(node3) // illegal!

  } // END OF MAIN
}
