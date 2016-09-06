# BitOperationArithmetic
位操作实现加减乘除四则运算
分类： java
1. 题目描述
如何使用位操作分别实现整数的加减乘除四种运算？

2. 解决方案
需要熟练掌握一些常见功能的位操作实现，具体为：

<1> 常用的等式：-n = ~(n-1) = ~n+1
<2> 获取整数n的二进制中最后一个1：n&(-n) 或者 n&~(n-1)，如：n=010100，则-n=101100，n&(-n)=000100
<3> 去掉整数n的二进制中最后一个1：n&(n-1)，如：n=010100，n-1=010011，n&(n-1)=010000

（1） 加法实现
可以很容易地用“异或”和“或”操作实现整数加法运算：
对应位数的“异或操作”可得到该位的数值，对应位的“与操作”可得到该位产生的高位进位，如：a=010010，b=100111，
计算步骤如下：
  第一轮：a^b=110101，(a&b)<<1=000100， 由于进位（000100）大于0，则进入下一轮计算，
  a=110101，b=000100，a^b=110001，(a&b)<<1=001000，由于进位大于0，则进入下一轮计算：
  a=110001，b=001000，a^b=111001，(a&b)<<1=0，进位为0，终止，计算结果为：111001。
（2） 减法实现
减法可很容易地转化为加法：a - b = a + (-b) = a + (~b + 1 )
（3） 乘法实现
因而乘法可以通过系列移位和加法完成。最后一个1可通过b&~(b-1)求得，可通过b& (b-1)去掉，
为了高效地得到左移的位数，可提前计算一个map.
（4） 除法实现
乘法可很容易转化为减法操作，主要思想与乘法实现类似.
