package com.java.util.example;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import com.java.util.utility.Employee;

/**
 * NavigableSet is a sub interface of the SortedSet interface, so it inherits
 * all SortedSet’s behaviors like range view, endpoints and comparator access.
 * In addition, the NavigableSet interface provides navigation methods and
 * descending iterator that allows the elements in the set can be traversed in
 * descending order. Let’s look at each new method defined by this interface in
 * details. lower(E): returns the greatest element which is less than the
 * specified element E, or null if there is no such element. floor(E): returns
 * the greatest element which is less than or equal to the given element E.
 * ceiling(E): returns the least element which is greater than or equal to the
 * given element E. higher(E): returns the least element which is strictly
 * greater than the specified element E. descendingSet(): returns a reverse
 * order view of the elements contained in the set. descendingIterator():
 * returns an iterator that allows traversing over elements in the set in
 * descending order. pollFirst(): retrieves and removes the first (lowest)
 * element, or returns null if the set is empty. pollLast(): retrieves and
 * removes the last (highest) element, or returns null if the set is empty.
 * 
 * Furthermore, the NavigableSet interface overloads the methods headSet(),
 * subSet() and tailSet() from the SortedSet interface, which accepts additional
 * arguments describing whether lower or upper bounds are inclusive versus
 * exclusive: headSet(E toElement, boolean inclusive) subSet(E fromElement,
 * boolean fromInclusive, E toElement, boolean toInclusive) tailSet(E
 * fromElement, boolean inclusive)
 * 
 *
 */
public class NavigableSetTest {
	public static void main(String... args) {
		// reverse order set from the original one
		NavigableSet<Integer> setNumbers1 = new TreeSet<Integer>();
		setNumbers1.addAll(Arrays.asList(4, 8, 3, 9, 1, 6, 4, 5, 3, 2, 7, 8, 0));

		NavigableSet<Integer> setNumbers2 = setNumbers1.descendingSet();

		System.out.println("Set Numbers 1: " + setNumbers1);
		System.out.println("Set Numbers 2: " + setNumbers2);

		NavigableSet<String> setFruits = new TreeSet<>();

		setFruits.add("Banana");
		setFruits.add("Apple");
		setFruits.add("Orange");
		setFruits.add("Grape");
		setFruits.add("Mango");

		System.out.println("Set Fruits: " + setFruits);

		System.out.print("Fruits by descending order: ");
		Iterator<String> descIterator = setFruits.descendingIterator();

		descIterator.forEachRemaining(System.out::println);

		NavigableSet<Employee> setEmployees = new TreeSet<>(idComparator);

		setEmployees.add(new Employee("Tom", 80000));
		setEmployees.add(new Employee("Jack", 35000));
		setEmployees.add(new Employee("Jim", 62500));
		setEmployees.add(new Employee("Peter", 58200));
		setEmployees.add(new Employee("Mary", 77000));
		setEmployees.add(new Employee("Jane", 69500));
		setEmployees.add(new Employee("David", 54000));
		setEmployees.add(new Employee("Sam", 82000));

		System.out.println("Employees: " + setEmployees);

		Employee Tom = new Employee("Tom", 80000);

		Employee emp1 = setEmployees.higher(Tom);

		if (emp1 != null) {
			System.out.println("The employee whose salary > Tom: " + emp1);

		}

		Employee emp2 = setEmployees.lower(Tom);

		if (emp2 != null) {
			System.out.println("The employee whose salary < Tom: " + emp2);
		}

		Employee emp3 = setEmployees.ceiling(new Employee(60000));

		if (emp3 != null) {
			System.out.println("The employee whose >= 60000: " + emp3);
		}

		Employee emp4 = setEmployees.floor(new Employee(40000));

		if (emp4 != null) {
			System.out.println("The employee whose <= 40000: " + emp4);
		}

		SortedSet<Employee> highPaidEmployees = setEmployees.tailSet(new Employee(70000));
		System.out.println("High paid employees: " + highPaidEmployees);

		SortedSet<Employee> lowPaidEmployees = setEmployees.headSet(new Employee(60000));
		System.out.println("Low paid employees: " + lowPaidEmployees);

		SortedSet<Employee> goodPaidEmployees = setEmployees.subSet(new Employee(60000), new Employee(70000));
		System.out.println("Good paid employees: " + goodPaidEmployees);
	}

	// Comparator anonymous class implementation
	public static Comparator<Employee> idComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee c1, Employee c2) {
			return (int) (c1.getSalary() - c2.getSalary());
		}
	};

}
