/*
Merged Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by
splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

import java.util.Scanner; // Allows us to get user input

public class MergeSortedList {

    // This class represents one node in a linked list
    static class ListNode {
        int val; // Stores the value/data of the node
        ListNode next; // Stores the reference/address of the next node

        // Empty constructor
        ListNode() {}

        // Constructor for creating a node with only a value
        ListNode(int val) {
            this.val = val; // Sets the node's value
        }

        // Constructor for creating a node with a value and next node
        ListNode(int val, ListNode next) {
            this.val = val; // Sets the node's value
            this.next = next; // Sets the next node
        }
    }

    // This method merges two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy is a fake starting node to make building the list easier
        ListNode dummy = new ListNode(0);

        // Current is the pointer we use to build the merged list
        ListNode current = dummy;

        // Continue while both lists still have nodes
        while (list1 != null && list2 != null) {

            // If list1's value is smaller or equal, attach list1's node
            if (list1.val <= list2.val) {
                current.next = list1; // Connect current to list1's current node
                list1 = list1.next; // Move list1 forward to its next node
            } else {
                current.next = list2; // Connect current to list2's current node
                list2 = list2.next; // Move list2 forward to its next node
            }

            // Move current forward to the node we just added
            current = current.next;
        }

        // If list1 still has remaining nodes, attach all of them
        if (list1 != null) {
            current.next = list1;
        }

        // If list2 still has remaining nodes, attach all of them
        if (list2 != null) {
            current.next = list2;
        }

        // Return the real head of the merged list
        // dummy is fake, so the real list starts at dummy.next
        return dummy.next;
    }

    // This method creates a linked list from user input
    public static ListNode createList(Scanner input, String listName) {

        // Dummy node helps us start the linked list easily
        ListNode dummy = new ListNode(0);

        // Current is used to add new nodes to the list
        ListNode current = dummy;

        // Tell the user which list they are entering values for
        System.out.println("Enter elements for " + listName + " one by one.");

        // Tell the user how to stop entering values
        System.out.println("Type 'stop' when finished:");

        // Infinite loop; it only stops when the user types "stop"
        while (true) {
            System.out.print("Enter value: ");

            // Read the user's input as a String
            String userInput = input.nextLine();

            // If the user types "stop", end the loop
            if (userInput.equalsIgnoreCase("stop")) {
                break;
            }

            // Convert the user's input from String to int
            int value = Integer.parseInt(userInput);

            // Create a new node and attach it to the list
            current.next = new ListNode(value);

            // Move current to the new node
            current = current.next;
        }

        // Return the real head of the list
        // dummy is fake, so we return dummy.next
        return dummy.next;
    }

    // This method prints the linked list
    public static void printList(ListNode head) {

        // Start from the head of the list
        ListNode current = head;

        // Keep printing while there are still nodes
        while (current != null) {

            // Print the value of the current node
            System.out.print(current.val);

            // Print arrow only if there is another node after this one
            if (current.next != null) {
                System.out.print(" -> ");
            }

            // Move to the next node
            current = current.next;
        }

        // Move to the next line after printing the whole list
        System.out.println();
    }

    public static void main(String[] args) {

        // Create Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Create the first linked list using user input
        ListNode list1 = createList(input, "List 1");

        // Create the second linked list using user input
        ListNode list2 = createList(input, "List 2");

        // Print List 1 label
        System.out.println("List 1:");

        // Print the first linked list
        printList(list1);

        // Print List 2 label
        System.out.println("List 2:");

        // Print the second linked list
        printList(list2);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print merged list label
        System.out.println("Merged List:");

        // Print the merged linked list
        printList(mergedList);

        // Close the Scanner
        input.close();
    }
}