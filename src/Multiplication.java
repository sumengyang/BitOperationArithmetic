import java.util.HashMap;
import java.util.Map;

/*
 需要熟练掌握一些常见功能的位操作实现，具体为：
 <1> 常用的等式：-n = ~(n-1) = ~n+1
 <2> 获取整数n的二进制中最后一个1：n&(-n) 或者 n&~(n-1)，如：n=010100，则-n=101100，n&(-n)=000100
 <3> 去掉整数n的二进制中最后一个1：n&(n-1)，如：n=010100，n-1=010011，n&(n-1)=010000

 因而乘法可以通过系列移位和加法完成。
 最后一个1可通过b&~(b-1)求得，可通过b& (b-1)去掉，为了高效地得到左移的位数，可提前计算一个map
 */

public class Multiplication {
	public static int multiply(int a, int b) {
		boolean flag = (b < 0);
		if (flag)
			b = -b;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 32; i++)
			map.put(1 << i, i);
		while (b > 0) {
			int last_bit = map.get(b & ~(b - 1));
			sum += (a << last_bit);
			b &= b - 1;
			System.out.println(last_bit + " " + sum + " " + b);
		}

		if (flag)
			sum = -sum;
		return sum;
	}

	public static void main(String[] args) {
		int a = 6, b = 16;
		int result = multiply(a, b);
		System.out.println(result);
	}
}
