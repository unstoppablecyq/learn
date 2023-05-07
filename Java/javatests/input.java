import java.util.Scanner;//导入Scanner类
public class input{

	public static void main(String[] args){

		Scanner myScanner = new Scanner(System.in);

		System.out.println("请输入名字");
		String name = myScanner.next();//接受用户的收入
		System.out.println("请输入年龄");
		int age = myScanner.nextInt();
		System.out.println("请输入薪水");
		double salary = myScanner.nextDouble();
		System.out.println("人的信息如下：");
		System.out.println("name=" + name + " 年龄=" + age + " 薪水=" + salary);
	}
}