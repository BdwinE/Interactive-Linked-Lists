//Emeka Edwin Asoluka
import java.util.Scanner;

public class SingleList/*<Integer>*/ { // singly-linked, no tail reference, non-circular, Integers
		public Node head;
		private Scanner sc;
		
		public SingleList(){
			sc = new Scanner(System.in);
		}
		
		public static void main(String args[]){
			SingleList list = new SingleList();
			list.buildList(3,list.head);
			list.printList(list.head);
			list.deleteByValue(45);
			list.printList(list.head);
		}
		
		//done
		public void insertAtHead(Node node){
			node.next = head;
			head = node;
		}
		
		public Node deleteByValue(Integer value){
			Node newNode = head;
			
			if(head.data == value){
				head = head.next;
			}
		    
			while(newNode.next != null){
		        if(newNode.next.data == value){
		            newNode.next = newNode.next.next; 
		        }else{
		            newNode = newNode.next;
		        }
		    }
		 
		    return head;
			/*Node temp = head;
			if(temp != null){
				if(temp.data == value){
					temp = temp.next;
				}
				else{
					while(temp.next != null){
						if(temp.next.data == value){
							temp = temp.next.next;
						}
						temp = temp.next;
					}
				}
			}	*/
		}
		
		public void insertAtTail(Node node){
			Node temp = head;
			while(temp != null){
				temp = temp.next;
			}
			temp = node;
		}
		
		public void insertInOrder(Node node){
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
					}				
					temp = temp.next;
				}
			}
		}
		
		public void removeDuplicates(){//extra credit.
			
		}
		
		public void buildList(int size, Node head){//allow any list size) from user input, in the order the data is entered
			if(head == null){
				System.out.println("Enter value for Node(Integer): ");
				this.head = new Node(sc.nextInt());
				head = this.head;
				--size;
			}
				if(size == 0){
					return;
				}
				System.out.println("Enter value for Node: ");
				head.next = new Node(sc.nextInt());
				buildList(--size,head.next);
		}
		
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
			list += " < tail (singly-Linked, circular, tail reference)";
			System.out.println(list);
		}
		
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
		
		public void clearList(){
			head = null;
		}
		
		public class Node{
			Node next;
			Integer data;
			
			public Node(Integer data){
				this.data = data;
		}
	}
	
}
