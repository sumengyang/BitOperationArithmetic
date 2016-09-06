
public class Substract {
	public int substract(int a, int b) {
		int result = Addition.add(a, Addition.add(~b, 1));
		return result;
	}
	public static void main(String[] args) {
		int a = -14, b = 5;
		Substract substract = new Substract();
		int result = substract.substract(a, b);
		System.out.println(result);
	}
	
}
