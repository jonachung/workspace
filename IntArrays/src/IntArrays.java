
import java.util.Random;

/**
 * This class is used to construct partially filled arrays. The methods that are implemented are
 * listed as follows:
 * 
 * min, max, sum, contains, count, indexOf, lastIndexOf, print, swap, size, isEmpty, clear, get, set,
 * clone, subList, removeByIndex, remove, ensureCapacity, add, add (with index and the number), search,
 * merge, and sorting methods like sort, sorted (an immutable version of sort), bubbleSort, and isSorted,
 * which checks if a list is sorted in increasing numerical order or not.
 * 
 * This class also features permutation and isPermutation methods. The permutation method creates a 
 * permutation of numbers from a beginning value to end value. A random permutation is a random sequence 
 * that includes all numbers from starting value to end value with no duplicates. The isPermutation method 
 * checks if a user-specified array is a permutation or not. 
 *  
 * @author Jonathan
 *
 */
public class IntArrays {

	private int[] values;

	private int currentSize;
	
	public static final int DEFAULT_LENGTH = 10;

	/**
	 * Constructs IntArray object with user-specified array and user-specified size of a partially filled integer array. 
	 * If size is negative or greater than the length of the array, 
	 * the size of the partially-filled array will be the array length and an 
	 * error message will print out.
	 * If the array equals to null, then an error message will print out and a new IntArray Object with a capacity of 10 and the array is empty.
	 * 
	 * @param array
	 *            The array for the IntArray object.
	 * @param size
	 *            The size of the array for IntArray object.
	 */
	public IntArrays(int[] array, int size) // if statement for boundaries of
											// size: size can't be negative or
											// greater than values.length. set
											// currentSize to values.length.
	{
		if (array == null) {
			values = new int[DEFAULT_LENGTH];
			currentSize = 0;
			System.out.println("ERROR");
		} else if (size < 0 || size > array.length) {
			values = array;
			currentSize = array.length;
			System.out.println("ERROR");
		} else {
			values = array;
			currentSize = size;
		}
	}

	/**
	 * Constructs an empty IntArray Object with array capacity of 10 numbers.
	 */
	public IntArrays() {
		this(DEFAULT_LENGTH);
	}

	/**
	 * Constructs an empty IntArray Object with user specified capacity.
	 * If the capacity of the array is negative, then a default array will be created and 
	 * an error message will print out.
	 * 
	 * @param capacity
	 *            The length of the array in IntArray Object.
	 */
	public IntArrays(int capacity) {
		if (capacity > 0) {
			values = new int[capacity]; // capacity could not be negative. if is
										// then create default array
										// [IntArray()]. Print out error message
		} else {
			values = new int[DEFAULT_LENGTH];
			System.out.println("ERROR");
		}
		currentSize = 0;
	}

	/**
	 * Finds the minimum number of the IntArray object. Returns -1 if the object is empty.
	 * 
	 * @return The minimum number is returned unless there are no numbers inside the object (returns -1).
	 */
	public int min() {
		if (currentSize > 0) {
			int minIndex = 0;
			for (int index = 1; index < currentSize; index++) {
				if (values[index] < values[minIndex]) {
					minIndex = index;
				}
			}
			return values[minIndex];
		}
		return -1;
	}

	/**
	 * Finds the maximum number of the IntArray object. Returns -1 if the object is empty.
	 * 
	 * @return The maximum number is returned unless there are no numbers inside the object (returns -1).
	 */
	public int max() // fix like min method
	{
		if (currentSize > 0) {
			int maxIndex = 0;
			for (int index = 1; index < currentSize; index++) {
				if (values[index] > values[maxIndex]) {
					maxIndex = index;
				}
			}
			return values[maxIndex];
		}
		return -1;
	}

	/**
	 * Finds the sum of all the numbers in the IntArray Object.
	 * 
	 * @return The sum of all numbers in the IntArray object are returned.
	 */
	public int sum() {
		int total = 0;
		for (int index = 0; index < currentSize; index++) {
			total += values[index];
		}
		return total;
	}

	/**
	 * Finds the average of the numbers in the IntArray object if it is not empty. Else returns -1. 
	 * 
	 * @return The average double value of the object.
	 */
	public double average() {
		if (currentSize > 0) {
			double average;
			average = this.sum() / (double) currentSize;
			return average;
		}
		return -1;
	}

	/**
	 * Checks if the IntArray object contains the user-specified number.
	 * 
	 * @param number
	 *            The number to compare.
	 * @return True if the number is in the IntArray object, false if the number is not in the IntArray object.
	 */
	public boolean contains(int number) {
		return (this.indexOf(number) != -1);
	}

	/**
	 * Counts how many times a user-specified number is in IntArray object. 
	 * 
	 * @param number
	 *            The number that is checked in IntArray object to be counted.
	 * @return The number of times a number is in IntArray object.
	 */
	public int count(int number) {
		int numberOfTimes = 0;
		for (int index = 0; index < currentSize; index++) {
			if (values[index] == number) {
				numberOfTimes++;
			}
		}
		return numberOfTimes;
	}

	/**
	 * Finds the first index of user-specified number in the IntArrays object. Returns -1 if number is not found.
	 * 
	 * @param number
	 *            The number being compared in IntArrays object.
	 * @return The index of that number in IntArrays object.
	 */
	public int indexOf(int number) {
		for (int index = 0; index < currentSize; index++) {
			if (values[index] == number) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Finds the last index of the user-specified number in the IntArray Object. Returns -1 if number is not found. 
	 * 
	 * @param number
	 *            The number compared to in IntArray Object.
	 * @return The last index of the number in the IntArray Object.
	 */
	public int lastIndexOf(int number) {
		for (int index = currentSize - 1; index >= 0; index--) {
			if (values[index] == number) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Prints out the numbers of the IntArray Object followed by a comma at the end
	 * except for the last number.
	 * ex. 1,2,3,4,5
	 */
	public void print() {
		for (int index = 0; index < currentSize - 1; index++) {
			System.out.print(values[index] + ",");
		}
		System.out.println(values[currentSize - 1]);
	}

	/**
	 * Swaps the numbers at the specified indexes in IntArray object.
	 * Both indexes have to be within the range of the object. 
	 * @param index1
	 *            One index value that will be swapped.
	 * @param index2
	 *            Another index value that will be swapped.
	 * @return Returns true if numbers are swapped, false if numbers are not swapped.
	 */
	public boolean swap(int index1, int index2)
	{
		if (index1 < currentSize && index2 < currentSize && index1 >= 0 && index2 >= 0) 
		{
			if (index1 != index2)
			{
				int temp = values[index1]; // fix swap method
				values[index1] = values[index2];
				values[index2] = temp;
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns the size of the IntArray Object.
	 * 
	 * @return Returns size.
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Checks if IntArray Object has no numbers.
	 * 
	 * @return Returns true if IntArray object is empty, false if it isn't.
	 */
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	/**
	 * Empty the IntArray Object.
	 */
	public void clear() {
		currentSize = 0;
	}

	/**
	 * Uses the user-specified index to get the value in that index in IntArray Object 
	 * if the index is greater than or equal to zero and the index
	 * is less than the capacity of the IntArray Object.
	 * Else returns -1.
	 * 
	 * @param index
	 *            Used to get value in IntArray Object.
	 * @return Return value that has index value or -1 when the index doesn't exist.
	 */
	public int get(int index) {
		if (index >= 0 && index < currentSize) {
			return values[index];
		} 
		return -1;
	}

	/**
	 * Sets the value at the user-specified index to equal to the user-specified number in the IntArray object and returns true if 
	 * the index is greater than or equal to zero and the index
	 * is less than the capacity of the IntArray Object. 
	 * Else returns false.
	 * @param index
	 *            Finds value with that user-specified index to change to user-specified number.
	 * @param number
	 *            User-specified number that will replace the old number at user-specified index.
	 * @return true if possible to set number, false if not possible to set number.
	 */
	public boolean set(int index, int number) {
		if (index >= 0 && index < currentSize) {
			values[index] = number;
			return true;
		}
		return false;
	}

	/**
	 * Duplicates partially filled array in IntArrays object and returns it.
	 * 
	 * @return Returns duplicate integer array.
	 */
	public int[] clone() {
		int[] newValues = new int[values.length];
		for (int index = 0; index < currentSize; index++) {
			newValues[index] = values[index];
		}
		return newValues;
	}

	/**
	 * Makes a sublist from IntArray object.
	 * Both indexes have to be greater than or equal to 0 and less or equal to than the length in IntArray Object.
	 * The first index parameter has to be less than the second index parameter.
	 * 
	 * @param fromIndex
	 *            Starting Index for new partially filled array.
	 * @param toIndex
	 *            Ending Index for new partially filled array.
	 * @return Returns new partially filled array from fromIndex to toIndex, with toIndex being exclusive.
	 */
	public int[] subList(int fromIndex, int toIndex) 
	{
		if (fromIndex >= 0 && toIndex > fromIndex && toIndex <= values.length) {
			int[] newValues = new int[toIndex - fromIndex];
			for (int index = fromIndex; index < toIndex; index++) {
				newValues[index - fromIndex] = values[index];
			}
			return newValues;
		}
		System.out.println("ERROR");
		return values;
	}

	/**
	 * Removes a number from the IntArrays Object by the index if the index is within the range of the object.
	 * Returns the number that is removed.
	 * @param index
	 *            The index of the number removed
	 * @return returns the number removed or -1 if the index is less than 0 or is greater than
	 * currentSize.
	 */
	public int removeByIndex(int index) // range of index is 0 to currentSize,
										// if isnt return -1.
	{
		if (index >= 0 && index < currentSize) {
			int removedNumber = values[index];
			for (int newIndex = index + 1; newIndex < currentSize; newIndex++) {
				values[newIndex - 1] = values[newIndex];
			}
			currentSize--;
			return removedNumber;
		} 
		return -1;
	}

	/**
	 * Removes the first occurence of the user-specified number from IntArray Object if it exists.
	 * 
	 * @param number
	 *            Number removed from IntArray Object.
	 * @return Returns true if possible, false if not.
	 */
	public boolean remove(int number) {
		return (this.removeByIndex(this.indexOf(number)) != -1); 
	}

	/**
	 * Increases capacity to make sure that IntArray object fits minCapacity
	 * 
	 * @param minCapacity
	 *            How much capacity wanted in array.
	 * @return Returns true no matter what.
	 */
	public boolean ensureCapacity(int minCapacity) // check values.length not
													// currentSize
	{
		if (minCapacity > values.length) {
			int[] myArray = new int[minCapacity];
			for (int index = 0; index < currentSize; index++) {
				myArray[index] = values[index];
			}
			values = myArray;
		}
		return true;
	}

	/**
	 * Appends a user-specified number in the end of IntArrays object.
	 * @param number	User-specified number that is added.
	 * @return	Returns true if currentSize is greater than equal to length of array.
	 */
	public boolean add(int number) // check for capacity
	{
		if (currentSize >= values.length) {
			this.ensureCapacity(2 * values.length + 1);
		}
		values[currentSize] = number;
		currentSize++;
		return true;
	}

	/**
	 * Inserts user-specified number to IntArray object at user-specified index value unless it is not within the range of the IntArray object.
	 * @param index	The user-specified index of number that will be added to array.
	 * @param number	The user-specified number that will be added at user-specified index
	 * @return	Returns true if possible, false if not and index is less than 0 or greater than length of array.
	 */
	public boolean add(int index, int number) // check index and check for
												// capacity
	{
		if (index >= 0 && index <= values.length) {
			if (currentSize >= values.length) {
				this.ensureCapacity(2 * values.length + 1);
			}
			currentSize++;
			for (int newIndex = currentSize - 1; newIndex > index; newIndex--) {
				values[newIndex] = values[newIndex - 1];
			}
			values[index] = number;
			return true;
		} 
		return false;
	}

	/**
	 * Sorts the numbers in numerically increasing order.
	 * This is the mutable sort method (changes the array).
	 * @return	Returns true no matter what.
	 */
	public boolean sort() // mutable
	{
		int temp;
		for (int index = 0; index < values.length; index++) {
			for (int newIndex = index + 1; newIndex < values.length; newIndex++) {
				if (values[index] > values[newIndex]) {
					temp = values[index];
					values[index] = values[newIndex];
					values[newIndex] = temp;
				}
			}
		}
		return true;

	}

	/**
	 * This is the immutable sort method, which creates a new array and 
	 * puts the sorted values of increasing numerical order into the new array.
	 * @return Returns int[] of new sorted array.
	 */
	public int[] sorted() // immutable, returns IntArrays object
	{
		int[] newArrays = new int[values.length];
		newArrays[0] = values[0];
		for (int index = 1; index < values.length; index++) {
			if (newArrays[0] > values[index]) {
				newArrays[0] = values[index];
			}
		}
		for (int index = 1; index < values.length; index++) {
			newArrays[index] = values[0];
			for (int innerIndex = 1; innerIndex < values.length; innerIndex++) {
				if (values[innerIndex] < newArrays[index] && values[innerIndex] > newArrays[index - 1]) {
					newArrays[index] = values[innerIndex];
				}
			}
		}
		return newArrays;
	}

	/**
	 * Searches the IntArray for a user-specified number if and only if the IntArray object is sorted.
	 * Search uses less iterations than the Contains method since search cuts the values in half each time
	 * when searching for the integer instead of looping though all the values at once.
	 * @param number	Number method searches for.
	 * @return	Returns true if number found, false if not and/or the length of the IntArray Object is 0.
	 */
	public boolean search(int number) {
		if (values.length > 0) // put values.length on same line
		{
			if (number >= values[0] && number <= values[values.length - 1]) {
				int secondEndpoint = values.length - 1;
				int firstEndpoint = 0;
				while (secondEndpoint >= firstEndpoint) {
					int middleIndex = (firstEndpoint + secondEndpoint) / 2;
					if (number < values[middleIndex]) {
						secondEndpoint = middleIndex - 1;
					} else if (number > values[middleIndex]) {
						firstEndpoint = middleIndex + 1;
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * An inefficient way to sort the numbers in IntArray object in increasing
	 * numerical order.
	 * @return	Returns true if the IntArray Object length is greater than zero. False if the length of the IntArray Object is 0.
	 */
	public boolean bubbleSort() {
		int temp;
		if (values.length > 0) {
			for (int index = 0; index < values.length; index++) {
				for (int testIndex = index + 1; testIndex < values.length; testIndex++) {
					if (values[index] > values[testIndex]) {
						temp = values[index];
						values[index] = values[testIndex];
						values[testIndex] = temp;
					}
				}
			}
			return true;
		}
		return false;

	}

	/**
	 * Checks if IntArray Object is sorted or not.
	 * @return	Returns true if list is sorted, false if not.
	 */
	public boolean isSorted() {
		for (int index = 0; index < values.length - 1; index++) {
			if (values[index + 1] < values[index]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Merges the user-specified array and IntArray Object into a new integer array. The arrays have to be sorted.
	 * @param otherArray	The other array (user-specified) that 
	 * will merge with array in IntArray Object.
	 * @return	Returns new merged integer array.
	 */
	public int[] merge(int[] otherArray) {
		int[] newList = new int[values.length + otherArray.length];
		int valuesIndex = 0, otherArrayIndex = 0, newListIndex = 0;
		while (valuesIndex < values.length && otherArrayIndex < otherArray.length) {
			if (values[valuesIndex] < otherArray[otherArrayIndex]) {
				newList[newListIndex] = values[valuesIndex];
				valuesIndex++;
			} else {
				newList[newListIndex] = otherArray[otherArrayIndex];
				otherArrayIndex++;
			}
			newListIndex++;
		}

		while (valuesIndex < values.length) {
			newList[newListIndex] = values[valuesIndex];
			valuesIndex++;
			newListIndex++;
		}

		while (otherArrayIndex < otherArray.length) {
			newList[newListIndex] = otherArray[otherArrayIndex];
			otherArrayIndex++;
			newListIndex++;
		}

		return newList;
	}

	/**
	 * Makes random permutation of numbers in an integer array starting from beginning number to end number.
	 * 
	 * Better: A random permutation is a random sequence that includes all numbers from starting value to end value with no duplicates.
	 * @param beginNumber	The beginning number.
	 * @param endNumber		The ending number.
	 * @return		Returns the permutation array.
	 */
	public int[] permutation(int beginNumber, int endNumber) {
		Random number = new Random();
		int[] permutationArray = new int[(endNumber - beginNumber) + 1];
		int temp;
		for (int index = 0; index < permutationArray.length; index++) {
			permutationArray[index] = beginNumber + index;
		}
		for (int numberTest = 0; numberTest < permutationArray.length; numberTest++) {
			int numberSwapIndex = number.nextInt(permutationArray.length);
			temp = permutationArray[numberTest];
			permutationArray[numberTest] = permutationArray[numberSwapIndex];
			permutationArray[numberSwapIndex] = temp;
		}
		return permutationArray;
	}
	
	
	/**
	 * Checks if array of integers is a permutation or not. There should not be any duplicate numbers.
	 * A permutation is a randomly ordered sequence of numbers. 
	 * However, if the permutation was sorted, then the numbers would be incrementing by one each time.
	 * 
	 * Better: A random permutation is a random sequence that includes all numbers from starting value to end value with no duplicates.
	 * @param array		Array that is checked if permutation or not.
	 * @return		Returns true if is, false if not.
	 */
	public boolean isPermutation(int[] array) {
		if (array != null && array.length > 0) {
			int endNumber = array[0];
			int beginNumber = array[0];
			boolean[] groupArray = new boolean[array.length];
			for (int index = 0; index < array.length; index++) {
				if (array[index] < beginNumber) {
					beginNumber = array[index];
				}
				if (array[index] > endNumber) {
					endNumber = array[index];
				}
				groupArray[index] = false;
			}
			if (endNumber - beginNumber + 1 == groupArray.length) {
				for (int index = 0; index < array.length; index++) {
					int compareIndex = array[index] - beginNumber;
					if (groupArray[compareIndex]) {
						return false;
					}
					groupArray[compareIndex] = true;
				}
				return true;
			}
		}
		return false;

	}
}
