import java.util.Scanner;//����Scanner��
public class input{

	public static void main(String[] args){

		Scanner myScanner = new Scanner(System.in);

		System.out.println("����������");
		String name = myScanner.next();//�����û�������
		System.out.println("����������");
		int age = myScanner.nextInt();
		System.out.println("������нˮ");
		double salary = myScanner.nextDouble();
		System.out.println("�˵���Ϣ���£�");
		System.out.println("name=" + name + " ����=" + age + " нˮ=" + salary);
	}
}