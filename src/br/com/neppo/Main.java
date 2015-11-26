package br.com.neppo;


public class Main {
	public static void main(String[] args) {
		int ints[] = {3, 10, 5, 7, 6, 2, 17, -15};
        int sum = 10;
		
		System.out.println(MathUtil.subsetSumChecker(ints, sum));
	}
}
