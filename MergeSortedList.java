/*
Merged Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/
import java.util.Scanner;

public class MergeSortedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static ListNode createList(Scanner input, String listName) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        System.out.println("Enter elements for " + listName + " one by one.");
        System.out.println("Type 'stop' when finished:");

        while (true) {
            System.out.print("Enter value: ");
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("stop")) {
                break;
            }

            int value = Integer.parseInt(userInput);

            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ListNode list1 = createList(input, "List 1");
        ListNode list2 = createList(input, "List 2");

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedList);

        input.close();
    }
}