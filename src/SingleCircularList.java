//Emeka Edwin Asoluka
import java.util.Scanner;


public class SingleCircularList/*<String>*/ { //can have tail reference. single linked, circular
	Node head, tail;
	Scanner sc;
	
	public SingleCircularList(){
		sc = new Scanner(System.in);
		head = null;
	}
	
	public static void main(String args[]){
		SingleCircularList list = new SingleCircularList();
		list.buildList(3, list.head);
		list.printList(list.head);
		//list.insertAtFront(list.new Node("Edwin"));
		//System.out.println(list.isSorted());
		list.clearList();
		list.printList(list.head);
	}
	
	
	//done
	public void insertAtTail(Node node){
		tail.next = node;
		node.next = head;
		tail = tail.next;
	}
	
	
	//done
	public int size(){
		Node temp = head;
		int count = 0;
		temp = temp.next;
		while(temp != head){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	
	//done
	public void printSpecString(int length){//print all Strings of size less than a user-input length
		Node temp = head;
		for(int i=0; i<size(); i++){
			if(temp.data.length()<length){
				temp.printData();
			}
			temp = temp.next;
		}
	}
	
	
	//done
	public void printMinNMaxString(){ // find and print the min and max string in length in list, also print other string
		//in the list of the same size.
		// of min and max. label them min and max.
		Node temp = head;
		String max = temp.data;
		String min = temp.data;
		for(int i=0; i<size(); i++){
			if(temp.data.length()>=max.length()){
				max = temp.data;
			}
			else if(temp.data.length() == max.length()){
				max += " " + temp.data;
			}
				
			if(temp.data.length() < min.length()){
				min = temp.data;
			}
			else if(temp.data.length() == min.length()){
				min += " " + temp.data;
			}
			temp = temp.next;
		}
		System.out.println("Max string : " + max + "\nMin string: " + min);
	}
	
	
	//done
	public void insertAtFront(Node node){//insert at the front without duplication 
		//(check the list first – if the String is already in the list, do nothing).
		//Assuming front is after head node.
		Node temp = head;
		if(head == node) return; // check if head == node. return if true.
		while(temp.next != head){// while loop checks if the node is in list return if it does.
			if(temp == node) return;
			temp = temp.next;
		}
		Node temp2 = head.next; // next 3 line of code inserts the node into the list.
		head.next = node;       //this only happens if the there is not duplicates
		node.next = temp2;
	}
	
	
	//done
	public void insert(int loc, Node node){// insert in no duplicate in the list. can be inserted at any location
		// do nothing if already in the list.
		Node temp = head;
		if(head == node) return; // check if head == node. return if true.
		while(temp.next != head){// while loop checks if the node is in list return if it does.
			if(temp == node) return;
			temp = temp.next;
		}
		temp = head;
		for(int i=0; i<loc; i++){
			temp = temp.next;
		}
		Node temp2 = temp.next;
		temp.next = node;
		node.next = temp2;
	}
	
	
	//done
	public void buildList(int size, Node head){//allow any list size) from user input, in the order the data is entered
		if(head == null){
			System.out.println("Enter value for Node(String): ");
			this.head = new Node(sc.nextLine());
			head = this.head;
			--size;
		}
			if(size == 0){
				tail = head;
				head.next = this.head;
				return;
			}
			System.out.println("Enter value for Node: ");
			head.next = new Node(sc.nextLine());
			buildList(--size,head.next);
	}
	
	
	//done
	public void printList(Node head){//print the list, showing the head (and possibly tail);
		//all will look like they are singly linked, but will be annotated with the appropriate words:
		//Ex:singly-linked, non-circular, tail:   
		//head > 17 > 23 >19 < tail   (singly-linked)	
		if(head == null){
			System.out.println("list is empty.");
			return;
		}
		System.out.print("head ");
		String list = " > " + head.data;
		head = head.next;
		while(head != this.head){
			list += " > " + head.data;
			head = head.next;
		}
		list += " < tail (singly-Linked, circular, tail reference)";
		System.out.println(list);
	}
	
	//done
	public boolean isSorted(){ // return true of false depending if list is sorted.
		Node temp = head;
		if(temp.data.compareTo(temp.next.data)>0 && temp.next != head){
			return false;
		}
		else{
			temp = temp.next;
		}
		while(temp != head){
			if(temp.data.compareTo(temp.next.data)>0 && temp.next != head){
				return false;
			}
			temp = temp.next;
		}
		return true;
	}
	
	
	//done
	public void clearList(){
		head = null;
	}
	
	class Node{
		Node next;
		String data;
		
		Node(String data){
			this.data = data;
		}
		public void printData(){
			System.out.println(data);
		}
	}
	
}
