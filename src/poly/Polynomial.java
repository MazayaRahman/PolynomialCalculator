package poly;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements evaluate, add and multiply for polynomials.
 * 
 *
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node add(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node front = null; // front for new list
		if(poly1 == null) {
			//return poly2;
			Node ptr=null;
			while(poly2 != null) {
				if(front == null) {
					front = new Node(poly2.term.coeff, poly2.term.degree,null);
					ptr = front;
					poly2 = poly2.next;
				}else {
						ptr.next = new Node(poly2.term.coeff, poly2.term.degree,null);
						ptr = ptr.next;
						poly2 = poly2.next;
				}
			}
		}else if(poly2 == null) {
			//return poly1;
			Node ptr=null;
			while(poly1 != null) {
				if(front == null) {
					front = new Node(poly1.term.coeff, poly1.term.degree,null);
					ptr = front;
					poly1 = poly1.next;
				}else {
						ptr.next = new Node(poly1.term.coeff, poly1.term.degree,null);
						ptr = ptr.next;
						poly1 = poly1.next;
				}
			}
		}
		
		
		Node ptr1 = poly1; //ptr for poly 1
		Node ptr2 = poly2; //ptr for poly2
		
		//assigns the front of the new list
				while(front == null) {
				if(ptr1 != null && ptr2 != null && ptr1.term.degree < ptr2.term.degree) {//
					front = new Node(ptr1.term.coeff, ptr1.term.degree, null);
					ptr1 = ptr1.next;
				}else if(ptr1 != null && ptr2 != null && ptr1.term.degree > ptr2.term.degree) {//
					front = new Node(ptr2.term.coeff, ptr2.term.degree, null);
					ptr2 = ptr2.next;
				}else if(ptr1 != null && ptr2 != null && ptr1.term.degree == ptr2.term.degree){
					float cff = ptr1.term.coeff+ptr2.term.coeff;
					if(cff != 0) {
						front = new Node(cff, ptr1.term.degree, null);
					}
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}
				if(ptr1 == null || ptr2 == null) {
					break;
				}
				}
				//if front is still null (one or both of the ptrs are null)
				if(front==null) {
					if(ptr1==null && ptr2 != null) {
						front = new Node(ptr2.term.coeff, ptr2.term.degree, null);
						ptr2 = ptr2.next;
					}else if(ptr2 == null && ptr1 != null){
						front = new Node(ptr1.term.coeff, ptr1.term.degree, null);
						ptr1 = ptr1.next;
					}else {
						return null;
					}
				}
		
		
		Node listPtr = front;
		
			while (ptr1 != null && ptr2 != null) {
				if(ptr1.term.degree > ptr2.term.degree) {//
					listPtr.next = new Node(ptr2.term.coeff, ptr2.term.degree, null);
					listPtr = listPtr.next;
					ptr2 = ptr2.next;
				}else if(ptr1.term.degree < ptr2.term.degree) {//
					listPtr.next = new Node(ptr1.term.coeff, ptr1.term.degree, null);
					listPtr = listPtr.next;
					ptr1 = ptr1.next;
				}else {
					float coefficient = ptr1.term.coeff+ptr2.term.coeff;
					if(coefficient != 0) {
						listPtr.next = new Node(coefficient, ptr1.term.degree, null);
						listPtr = listPtr.next;
					}		
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}
			}
		
		if(ptr1 != null) {
			while(ptr1 != null) {
				listPtr.next = new Node(ptr1.term.coeff, ptr1.term.degree,null);
				listPtr = listPtr.next;
				ptr1 = ptr1.next;
			}
		}else if(ptr2 != null) {
			while(ptr2 != null) {
				listPtr.next = new Node(ptr2.term.coeff, ptr2.term.degree,null);
				listPtr = listPtr.next;
				ptr2 = ptr2.next;
			}
		}
		return front;
	}
	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		if(poly1 == null || poly2 == null) {
			return null;
		}
		
		Node ptr1 = poly1; //ptr for poly1
		Node ptr2 = poly2; //ptr for poly2
		Node listPtr = null; //ptr for individual polys
		Node front = null; //front node for indiv polys
		Node finalFront = null; //front node for final product
		
		for(ptr1 = poly1; ptr1 != null; ptr1 = ptr1.next) {
			front = new Node(ptr1.term.coeff*ptr2.term.coeff, ptr1.term.degree+ptr2.term.degree, null);
			listPtr = front;
			for(ptr2 = poly2.next; ptr2!= null; ptr2 = ptr2.next) {
				listPtr.next = new Node(ptr1.term.coeff*ptr2.term.coeff, ptr1.term.degree+ptr2.term.degree, null);
				listPtr = listPtr.next;
			}
			finalFront = add(finalFront, front);
			ptr2 = poly2;
		}
		return finalFront;
	}
		
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		float ans = 0;
		Node ptr = poly;
		for(ptr = poly; ptr != null; ptr = ptr.next) {
			ans += ptr.term.coeff*(Math.pow(x, ptr.term.degree));
		}
		return ans;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node current = poly.next ; current != null ;
		current = current.next) {
			retval = current.term.toString() + " + " + retval;
		}
		return retval;
	}	
	
	
	
	
}
