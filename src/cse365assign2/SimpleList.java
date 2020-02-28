package cse365assign2;


/*  Ruza Rubui

 * #12138387441

 * This class has keeps track of an array and its count and allows us to 

 * modify the array by adding or removing elements, searching for a specific number, and 

 * a toString.



 */

public class SimpleList {

	int list[];

	int count;

	// constructor

	public SimpleList() {

		list = new int[10];

		count = 0;

	}

	// this methods adds a number the beginning of an array, moves the  updates the count as
	// needed. If the list was initially full, it increases the size by 50%

	void add(int num) {
		int h=0;
		//checking if the list is full 
		if (list.length == count) {
			h= count/2;  
			arrayResize(h+count); //calling resize and passing the size plus half of it 
			
		}
			// this loop goes through each element in the list and moves them doen so there is room 
			for (int i = list.length - 1; i > 0; i--) { 

					list[i] = list[i - 1]; 
					
			}
			list[0] = num;
				count++;
			
	}
	
	public void arrayResize(int newS) {
		int arr[]= new int[newS];
		int i=0;
		while(i< newS && i<count) {
			arr[i]= list[i];
			i++;
		}
		if(newS<count) {
			count = newS;
		}
		list = arr;
	}
	

	// this method searches for a specific number, remove it, shift the elements,
	// and updates the count

	public void remove(int num) {

		int searchNum = search(num), temp; // find the index of the element and store it in searchNum

		if (searchNum != -1) { // checks if the element is found

			count--;

			for (int i = searchNum; i < list.length - 1; i++) {

				list[i] = list[i + 1]; // shifting elements

			}

		}
		
		int cap= 3*list.length/4;
		if(count <cap) {
			arrayResize(count);
		}

	}

	// this method returns the number of elements in list array

	public int count() {

		return count;

	}

	// This method searches for a number in an array and retuen the index of that
	// number

	public int search(int num) {

		int ind = -1;

		for (int i = 0; i < list.length; i++) { // loop through each index

			if (list[i] == num) // checks if the number is found

				ind = i;

		}

		return ind; // returns the index

	}
	// This method returns the first element in an array 
	public int first () {
		if(count==0) //if the list is empty it returns -1
			return -1;
		return list[0];	//returns the first element otherwise 
	}
	// This method returns the last element in an array 
	public int last() {
		if(count == 0)
			return -1; //if the list is empty it returns -1
		return list[count-1];	//returns the last element otherwise 
	}

	public int size() {
		return list.length;
	}
	//This method adds a number to the end of the list, if the list is initially full, it increases the size by 50%
	public void append(int value) {
        if (count == list.length) { //Check if the list is full 
             int  h= count / 2; //calculates half of the size and 
             arrayResize(count + h);	//calls the resize method to increase the size passing the current size plus half 
        }
     
        list[count] = value; //adding the value to the last element
        count++;	//increasing the count 
    }
	public String toString() {

		String str = "";

		for (int i = 0; i < count; i++) {

			str += list[i] + " ";

		}

		return str.trim();

	}

}
