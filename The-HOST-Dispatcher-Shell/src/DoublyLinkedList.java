public class DoublyLinkedList {

  //Initially, head and last is set to null
  Node head;

  Node last;

  int size = 0;

  //add a node to the list
  public void addNodeToEndOfQueue(Node node) {

    //if list is empty, head and last points to node
    if (head == null) {
      head = last = node;
      //head's previous will be null
      head.previous = null;
      //last's next will be null
    } else {
      //add node to the end of list. last->next set to node
      last.next = node;
      //node->previous set to last
      node.previous = last;
      //node becomes new last
      last = node;
      //last's next point to null
    }
    size++;
    last.next = null;
  }

  public void addNodeWithTime(Node node, int time) {

    if (head == null) {
      head = last = node;
      head.previous = null;
    } else if (time >= size) { // add node to end since time is bigger than size
      last.next = node;
      node.previous = last;
      last = node;
    } else {
      Node current = head;
      while (current.next != null && current.process.timeArrived <= time) {
        current = current.next;
      }

      if (current.next == null) { // there is no node with bigger time, add to end of the list
        current.next = node;
        node.previous = current;
        last = node;
      } else {
        current.previous.next = node;
        node.previous = current.previous;
        node.next = current;
        current.previous = node;
      }
    }
    size++;
    last.next = null;
  }

  //print all the nodes of doubly linked list
  public void printNodes() {
    //Node current will point to head
    Node current = head;
    if (head == null) {
      System.out.println("Doubly linked list is empty");
      return;
    }
    System.out.println("Nodes of doubly linked list: ");
    while (current != null) {
      //Print each node and then go to next.
      System.out.print("process id: " + current.process.id + " time arrived: " + current.process.timeArrived + " priority: " + current.process.priority);
      current = current.next;
    }
  }
}
