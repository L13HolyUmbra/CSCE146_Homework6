/*
 * PolySolver class
 * Dion de Jong 3/26/2014
 * Ver: 1.00
 * Description: This class creates the poly object. Users will create 2 polynomials by 
 * assigning values, and then the class adds these two polynomials together.  
 * Last modified: 3/26/14
 */

import java.util.Scanner;

public class PolySolver {

	private LList m_p;   // first poly
	private LList m_q;   // second poly
	private LList m_r;   // result

	public PolySolver()
	{
		//initialize the variables as empty linked lists
		m_p = new LList(); 
		m_q = new LList(); 
		m_r = new LList(); 
	}

	//given method that asks the user for the amount of variables and asks for the exponent and coefficient for each of those variables. 
	private void ReadPoly(LList list)
	{
		//initialze variables
		int term_num = 0;
		int coeff = 0;
		int exp = 0;
		// read from keyboard
		Data dt;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number of terms: ");
		term_num = keyboard.nextInt();

		for (int i = 0; i < term_num; i++)
		{
			System.out.print("Please enter the coeff for term " + i + ":  ");
			coeff = keyboard.nextInt();
			System.out.print("Please enter the exp for term " + i + ":  ");
			exp = keyboard.nextInt();
			dt = new Data(coeff, exp);
			list.add(dt);
		}

		list.printList();

	}

	//the addPoly method does most of the work to solve the problem
	public void AddPoly()
	{
		//call the read to have the user assign values to the two polynomials to be added. 
		ReadPoly(m_p);  
		ReadPoly(m_q); 
		
		//while both lists have values at current run this loop
		while (m_p.getCurrentNode() != null && m_q.getCurrentNode() != null)
		{
			//pull the Data object from the current node for each list
			Data dt_p = (Data)m_p.getCurrentEntry(); 
			Data dt_q = (Data)m_q.getCurrentEntry(); 
			
			//if the exponents are the same, add the coeffecients together and save the value to the result list
			if (dt_p.getM_exp() == dt_q.getM_exp())
			{
				Data dt_r = new Data(dt_p.getM_coeff() + dt_q.getM_coeff(), dt_p.getM_exp()); 
				m_r.add(dt_r);
				//must iterate both separate lists. 
				m_q.Next();
				m_p.Next();
			}

			//with these two if statements, compare the values of the exponents and save the bigger one to the result list
			//iterate through the list that had the bigger exponent. 
			if (dt_p.getM_exp() > dt_q.getM_exp())
			{
				Data dt_r = new Data(dt_p.getM_coeff(), dt_p.getM_exp());
				m_r.add(dt_r);
				m_p.Next(); 
			}
			
			if (dt_p.getM_exp() < dt_q.getM_exp())
			{
				Data dt_r = new Data(dt_q.getM_coeff(), dt_q.getM_exp());
				m_r.add(dt_r);
				m_q.Next(); 
			}
		}

		//for the next two while loops, if one of the lists is empty, save the rest of the values of the other list. 
		while (m_q.getCurrentNode() != null && m_p.getCurrentNode() == null)
		{
			Data dt_q = (Data)m_q.getCurrentEntry(); 
			m_r.add(dt_q);
			m_q.Next();
		}
		
		while (m_p.getCurrentNode() != null && m_q.getCurrentNode() == null)
		{
			Data dt_p = (Data)m_p.getCurrentEntry(); 
			m_r.add(dt_p);
			m_p.Next();
		}
		
		//print the resulting list. 
		m_r.printList(); 

	}
}