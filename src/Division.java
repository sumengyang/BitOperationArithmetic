
public class Division {
	public static int divide(int dividend, int divisor) {
		boolean flag = (dividend > 0) ^ (divisor > 0);
		if(dividend < 0)
			dividend = ~dividend + 1;
		if(divisor < 0)
			divisor = ~divisor + 1;
		if(dividend < divisor)
			return 0;
		int msb = 0;
		for(msb = 0; msb < 32; msb++){
			if((divisor << msb) >= dividend)
				break;
		}
		int result = 0;
		for(int i = msb; i >= 0; i--){
			if((divisor << i) > dividend)
				continue;
			result |= 1 << i;
			dividend -= divisor << i;
		}
		if(flag)
			result = - result;
		return result;
	}
	public static void main(String[] args) {
		int a = -16, b = 7;
		int result = divide(a, b);
		System.out.println(result);
	}
}
