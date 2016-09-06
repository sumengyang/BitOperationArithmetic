import java.util.HashMap;
import java.util.Map;

/*
 ��Ҫ��������һЩ�������ܵ�λ����ʵ�֣�����Ϊ��
 <1> ���õĵ�ʽ��-n = ~(n-1) = ~n+1
 <2> ��ȡ����n�Ķ����������һ��1��n&(-n) ���� n&~(n-1)���磺n=010100����-n=101100��n&(-n)=000100
 <3> ȥ������n�Ķ����������һ��1��n&(n-1)���磺n=010100��n-1=010011��n&(n-1)=010000

 ����˷�����ͨ��ϵ����λ�ͼӷ���ɡ�
 ���һ��1��ͨ��b&~(b-1)��ã���ͨ��b& (b-1)ȥ����Ϊ�˸�Ч�صõ����Ƶ�λ��������ǰ����һ��map
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
