package pucrs.alpro2.listas;

public class ListSimpleLinkedTestApp {

		public static void main(String[] args) {
			ListSimpleLinked<Integer> tst = new ListSimpleLinked<>();
//			System.out.println(tst);
//			//tst.dump();
//			tst.add(0, 10);
//			System.out.println(tst);
////			tst.dump();
//     		tst.add(1, 20);
//			System.out.println(tst);
////			tst.dump();
//			tst.add(30);
//		    System.out.println(tst);
////		    System.out.println(tst.get(0));
////		    System.out.println(tst.get(1));
////		    System.out.println(tst.get(2));
////		    System.out.println(tst.indexOf(20));
////		    System.out.println(tst.indexOf(22));
//		    tst.set(1, 55);
//		    System.out.println(tst);
			tst.add(101);
			tst.add(102);
			tst.add(103);
			tst.removeAt(2);
			System.out.println(tst);
			tst.add(104);
			System.out.println(tst);
			
			
		    
//			tst.dump();
			
//			
//			for (int i = 1; i <= 9; i++) {
//				tst.add(20 + i*10);
//				System.out.println(tst);
//			}
//			
//			for (int i = 1; i <= 10; i++) {
//				tst.removeAt(0);
//				System.out.println(tst);
//			}		
		}
	}

