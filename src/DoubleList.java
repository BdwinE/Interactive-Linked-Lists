//Emeka Edwin Asoluka
import java.util.Scanner;


public class DoubleList/*<Double>*/{//doubly-linked, tail reference, non-circular, Doubles
	Node head;
	Node tail;
	Scanner sc;
	
	public DoubleList(){
		sc = new Scanner(System.in);
	}
	
	public static void main(String args[]){
		DoubleList list = new DoubleList();
		list.buildList(3, list.head);
		list.printList(list.head);
		//list.insertInOrder(list.new Node(54.3));
		list.deleteHead();
		list.printList(list.head);
	}
	
	//done
	public void insertByPosition(int loc, Double value ){// assume location given is valid
		Node insertNode = new Node(value);
		Node temp = head;
		int count = 1;
		while(temp != null && count < loc){
			count++;
			temp = temp.next;
		}
		if(count == 1){
			insertNode.next = temp;
			insertNode.previous = null;
			temp.previous = insertNode;
			head = insertNode;
		}
		else{
			Node pH = temp.previous;		
			insertNode = new Node(value);
			insertNode.next = temp;
			insertNode.previous = pH;
			pH.next = insertNode;
			temp.previous = insertNode;
		}
	}
	
	//done ask class mate what this does
	public void insertInOrder(Node node){//print a message if the list is not sorted.
		if(isSorted()==false){
			System.out.println("list is not sorted.");			
		}
		else if(isSorted() == true){
		Node temp = head;
			while(temp.next != null){
				if(node.data>=temp.data){
					Node pH = temp.next;
					temp.next = node;
					node.next = pH;
					pH.previous = node;
					node.previous = temp;
				}				
				temp = temp.next;
			}
		}
	}
	
	//done
	public void deleteHead(){
		head = head.next;
	}
	
	
	//done
	public void deleteTale(){
		tail = tail.previous;
		tail.next = null;
	}
	
	//done
	public void printInReverse(Node node){ // assuming i print from tail node to head node.
		Node temp = tail;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.previous;
		}
	}	
	
	//done
	public void printTotNAvg(){//extra cred. print the total and average of the list elements.
		Node temp = head;
		double total = 0;
		double average = 0;
		while(temp != null ){
			total += temp.data;
			average++;
			temp = temp.next;
		}
		
		System.out.println("The total is: " + total + "\nThe average is: " + (total/average));
	}
	
	//done
	public void buildList(int size, Node head){//allow any list size) from user input, in the order the data is entered
		if(head == null){
			System.out.println("Enter value for Node(Double): ");
			this.head = new Node(sc.nextDouble());
			this.head.previous = null;
			head = this.head;
			--size;
		}
			if(size == 0){
				tail = head;
				return;
			}
			System.out.println("Enter value for Node: ");
			head.next = new Node(sc.nextDouble());
			head.next.previous = head;
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
		while(head != null){
			list += " > " + head.data;
			head = head.next;
		}
		list += " < tail (Doubly-Linked, tail reference)";
		System.out.println(list);
	}
	
	//done
	public boolean isSorted(){ // return true of false depending if list is sorted.
		Node temp = head;
		if(temp.data.compareTo(temp.next.data)>0 && temp.next != null){
			return false;
		}
		else{
			temp = temp.next;
		}
		while(temp != null){
			if(temp.next!=null){
				if(temp.data.compareTo(temp.next.data)>0 && temp.next != null){
					return false;
				}
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
		Node previous, next;
		Double data;
		
		Node(Double data){
			this.data = data;
		}
	}
	
}
