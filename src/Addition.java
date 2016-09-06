public class Addition {
	public static int add(int a, int b) {
		int carry,result;
		do{
			result = a ^ b;
			carry  = (a & b) << 1;
			a = result;
			b = carry;
		}while(carry != 0);
		return result;
	}

	public static void main(String[] args) {
		Addition addition = new Addition();
		int a = 115,b = 113;
		long start = System.currentTimeMillis();
		int t = 0;
		for(int i = 0; i < 1000000; i++)
			t = addition.add(a, b);
		long end = System.currentTimeMillis();
		System.out.println(t + " bit " + (end-start));
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++)
			t = a + b;
		end = System.currentTimeMillis();
		System.out.println(t + " add " + (end-start));
	}

}
