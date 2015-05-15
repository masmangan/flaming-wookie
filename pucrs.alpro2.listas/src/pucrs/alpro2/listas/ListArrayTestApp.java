package pucrs.alpro2.listas;

public class ListArrayTestApp {
	public static void main(String[] args) {
		ListTAD<Integer> tst = new ListArray<>();
		System.out.println(tst);
		tst.add(20);
		System.out.println(tst);
		tst.add(0, 10);
		System.out.println(tst);
		
		for (int i = 1; i <= 9; i++) {
			tst.add(20 + i*10);
			System.out.println(tst);
		}
		
		for (int i = 1; i <= 10; i++) {
			tst.removeAt(0);
			System.out.println(tst);
		}		
	}
}
