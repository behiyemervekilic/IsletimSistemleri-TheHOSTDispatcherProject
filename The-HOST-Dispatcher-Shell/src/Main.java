import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    DoublyLinkedList inputList = readFile(args[0]);
    DoublyLinkedList p0 = new DoublyLinkedList();
    DoublyLinkedList p1 = new DoublyLinkedList();
    DoublyLinkedList p2 = new DoublyLinkedList();
    DoublyLinkedList p3 = new DoublyLinkedList();
    int priority;
    Node current = inputList.head;
    for (int i = 0; i < inputList.size; i++) {
      if (current == null) {
        System.out.println("Node is null!");
        return;
      }
      Node node = current;
      priority = node.process.priority;
      if (priority == 0) {
        p0.addNodeToEndOfQueue(node);
      } else if (priority == 1) {
        p1.addNodeToEndOfQueue(node);
      } else if (priority == 2) {
        p2.addNodeToEndOfQueue(node);
      } else if (priority == 3) {
        p3.addNodeToEndOfQueue(node);
      }
      current = current.next;
    }
  }

  public static DoublyLinkedList readFile(String filePath) {
    Process process;
    Node node;
    DoublyLinkedList list = new DoublyLinkedList();
    try (Scanner sc = new Scanner(new File(filePath))) {
      int id = 1;
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        int[] parsedLine = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        process = new Process(id, parsedLine[0], parsedLine[1], parsedLine[2]);
        node = new Node(process);
        list.addNodeToEndOfQueue(node);
        id++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return list;
  }
}
