//Emeka Edwin Asoluka
import java.util.Scanner;
public class Driver {
	DoubleList dL;
	SingleList sL;
	SingleCircularList sCL;
	Scanner sc;
	
	public Driver(){
		sc = new Scanner(System.in);
		dL = new DoubleList();
		sL = new SingleList();
		sCL = new SingleCircularList();
	}
	
	public static void main(String args[]){
		Driver boss = new Driver();
		boss.printMenu(0);
	}
	
	public void input1(int input){//get input, get menu choices(int) and enter list data. single list
		switch(input){
		case 1://fill the list
			System.out.println("Eneter the list size: ");
			int size = Integer.parseInt(sc.nextLine());
			sL.buildList(size, sL.head);
		break;
		case 2://clear the list			
			sL.clearList();
		break;
		case 3: //check if the list is sorted
			if(sL.isSorted())
				System.out.println("The list is sorted");
			else
				System.out.println("The list is not sorted");
		break;
		case 4: //insert at head
			System.out.print("Input value to insert(Integer)");
			sL.insertAtHead(sL.new Node(Integer.parseInt(sc.nextLine())));
		break;
		case 5: // insert in tail
			System.out.print("Input value to insert(Integer)");
			sL.insertAtTail(sL.new Node(Integer.parseInt(sc.nextLine())));
		break;
		case 6: //case print list
			output("sL");
		break;
		case 7: // case return to main menu
			printMenu(0);
		break;
		}
		printMenu(1);
	}
	
	public void input2(int input){ // double list
		switch(input){
		case 1://fill the list
			System.out.println("Eneter the list size: ");
			int size = Integer.parseInt(sc.nextLine());
			dL.buildList(size, dL.head);
		break;
		case 2://clear the list			
			dL.clearList();
		break;
		case 3: //check if the list is sorted
			if(dL.isSorted())
				System.out.println("The list is sorted");
			else
				System.out.println("The list is not sorted");
		break;
		case 4: //delete head
			dL.deleteHead();
			System.out.print("Head deleted");
		break;
		case 5: // delete tail
			dL.deleteTale();
			System.out.print("Tale deleted");
		break;
		case 6: //case print list
			output("dL");
		break;
		case 7: // case return to main menu
			printMenu(0);
		break;
		case 8: // print total and average
			dL.printTotNAvg();
		break;
		case 9://print from left to right
			dL.printInReverse(dL.head);
		break;
		case 10: // enter value to insert in ordered list
			System.out.println("Enter node to input in list.(list has to be ordered.");
			dL.insertInOrder(dL.new Node(Double.parseDouble(sc.nextLine())));
		break;
		case 11:
			int loc;
			Double value;
			System.out.println("Enter loc to insert node: ");
			loc = Integer.parseInt(sc.nextLine());
			System.out.println("Enter value of the node: ");
			value = Double.parseDouble(sc.nextLine());
			dL.insertByPosition(loc, value);
		break;
		}
		printMenu(2);
		
	}
	
	public void input3(int input){//sCL
		switch(input){
		case 1://fill the list
			System.out.println("Eneter the list size: ");
			int size = Integer.parseInt(sc.nextLine());
			sCL.buildList(size, sCL.head);
		break;
		case 2://clear the list			
			sCL.clearList();
		break;
		case 3: //check if the list is sorted
			if(sCL.isSorted())
				System.out.println("The list is sorted");
			else
				System.out.println("The list is not sorted");
		break;
		case 4: //insert At front
			System.out.print("Input value to insert(String)");
			sCL.insertAtFront(sCL.new Node(sc.nextLine()));
		break;
		case 5: // insert at tail
			System.out.print("Input value to insert(String)");
			sCL.insertAtTail(sCL.new Node(sc.nextLine()));
		break;
		case 6: //case print list
			output("sCL");
		break;
		case 7: // case return to main menu
			printMenu(0);
		break;
		case 8: // print smallest and longest string in list
			sCL.printMinNMaxString();
		break;
		case 9://print all string smaller than given length.
			System.out.println("Please enter length: ");
			sCL.printSpecString(Integer.parseInt(sc.nextLine()));
		break;		
		}		
		printMenu(3);
	}
	
	public void output(String option){ // 5.	Output will be the current list (possibly changed by an operation)
		                  //and, sometimes, messages.
		if(option == "sL")
			sL.printList(sL.head);
		else if(option == "dL")
			dL.printList(dL.head);
		else
			sCL.printList(sCL.head);
	}
	
	public void printMenu(int option){
		/*
		 * Note that the print the list operation is not on the menu,
		 * since the list is automatically printed after each operation.
		 * Print the empty list when the user first selects a list type to use.
		 */
		if(option == 0){ // print first menu
			System.out.println(
		    "1.Singly-linked, no tail reference, non-circular, Integers\n"+
			"2.Doubly-linked, tail reference, non-circular, Doubles\n"  +
			"3.Singly-linked, circular  (add tail(optional)), Strings\n"  +
			"4.Exit the program");
			Integer input = Integer.parseInt(sc.nextLine());
			printMenu(input);
		}
		else if(option == 1){ // print second menu for option 1
			System.out.println("Make a choice: ");
			System.out.println( "1.build a list\n"+
								"2.clear the list\n"+
								"3.check if the list is sorted\n"+
								"4.insert at head\n"+
								"5.insert at tail\n"+
								"6.print list\n"+								
								"7.return to main menu");
			//sc.nextLine();
			int op = Integer.parseInt(sc.nextLine());
			input1(op);
								
		}
		else if(option == 2){
			System.out.println("Make a choice: ");
			System.out.println( "1.build a list\n"+
								"2.clear the list\n"+
								"3.check if the list is sorted\n"+
								"4.delete head\n"+
								"5.delete tail\n"+
								"6.print list\n"+
								"7.return to main menu\n"+
								"8.print total and average of list\n"+
								"9.print list from left to right\n"+
								"10.enter value to insert in ordered list\n"+
								"11.Enter value to be inserted and it's location\n");
			int op = Integer.parseInt(sc.nextLine());
			input2(op);
		}
		else if(option == 3){
			System.out.println("Make a choice: ");
			System.out.println( "1.build a list\n"+
								"2.clear the list\n"+
								"3.check if the list is sorted\n"+
								"4.insert At front\n"+
								"5.insert At tail\n" +
								"6.print list\n"+
								"5.return to main menu\n"+
								"6.case print list\n"+
								"7.case return to main menu\n"+
								"8.print smallest and longest string in list\n"+
								"9.print all string smaller than given length\n");
			int op = Integer.parseInt(sc.nextLine());
			input3(op);
		}
		else if(option == 4){//quit program
			System.exit(0);
		}
		else{
			System.out.println("Wrong option");
			printMenu(0);
		}
	}
	
}
