/*
 * Data class
 * Dion de Jong 3/26/2014
 * Ver: 1.00
 * Description: This class creates a data object that Holds 2 ints 
 * representing the coefficient and exponent. 
 * Last modified: 2/26/14
 */

public class Data {
	//instance variables
	private int m_exp;
	private int m_coeff;
	
	//the constructor that assigns the values. 
	public Data (int coeff, int exp)
	{
		this.m_exp = exp;
		this.m_coeff = coeff; 
	}

	//getters
	public int getM_exp() 
	{
		return m_exp;
	}


	public int getM_coeff() 
	{
		return m_coeff;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
