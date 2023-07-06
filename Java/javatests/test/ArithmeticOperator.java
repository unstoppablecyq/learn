/*
演示算术运算符的使用
*/

public class ArithmeticOperator{
	public static void main(String[] args){

		System.out.println(10 / 4);//从数学看是2.5，java中2
		System.out.println(10.0 / 4);//java是2.5
		double d = 10 / 4;//java中10/4为2，2=》2.0
		System.out.println(d);

		//%，本 质看公式：a % b = a - a / b * b
		System.out.println(10 % 3);//1
		System.out.println(-10 %3);//-1
		System.out.println(10 %-3);//1	

		//++ & --
		int i = 10;
		i++;
		++i;
		x = i++; //x=i;i=i+1;
		x = ++i；//i=i+1;x=i;
		System.out.println("i=" + i);
	}
}