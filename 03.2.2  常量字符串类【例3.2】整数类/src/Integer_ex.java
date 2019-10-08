//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月3日
//3.2.3   变量字符串类
//【例3.2】 Integer整数类

public class Integer_ex 
{
    public static void print(int i)
    {
        //Integer.toString(i,radix)方法，返回i整数的radix进制原码字符串，正数省略+号，负数显示-号，2≤radix≤36。
        String str10=Integer.toString(i,10);            //数字'0'～'9'，同toString()方法
        String str2=Integer.toString(i,2);              //数字'0'～'1'
        String str8=Integer.toString(i,8);              //数字'0'～'7'，
        String str16=Integer.toString(i,16);            //数字'0'～'9'，字母'a'～'f'，字母'A'～'F'
        System.out.print("原码（十、二、八、十六进制）"+str10+"，"+str2+"，"+str8+"，"+str16+"；");
        
        //Integer.toBinaryString(i)等方法，返回i的补码二、八、十六进制形式，正数省略高位0
        str2=Integer.toBinaryString(i);
        str8=Integer.toOctalString(i);
        str16="0x"+Integer.toHexString(i);
        System.out.println("补码（二、八、十六进制）"+str2+"，"+str8+"，"+str16);        
    }
    
    public static void main(String args[])
    {
        //（1）构造方法调用Integer.parseInt(s)方法，只有十进制，s包含正负号。
        //（2）toString()方法，正数省略+号
        String[] str10={"-2147483648", "-128", "-1", "0", "+127", "-32768", "2147483647"};//整数原码形式十进制
                        //,"+","-"                           //运行错，抛出异常
        for (int i=0; i<str10.length; i++)
            print(Integer.parseInt(str10[i],10));
//            print(new Integer(str10[i]));          //功能同上句
        System.out.println();        

        //（3）Integer.parseInt(s,radix)方法，s为radix进制原码，包含正负号；2≤radix≤36。
        String[] str16={"-80", "-1", "+7f", "+7fff"};      //整数原码形式十六进制
                        //,"0x7f"                          //运行错，NumberFormatException: For input string: "0x7f"
        for (int i=0; i<str16.length; i++)
            print(Integer.parseInt(str16[i],16));
        System.out.println();        

        //（3）Integer.toBinaryString(i)//整数补码二进制
/*        int[] values={Integer.MIN_VALUE,-1000,0,254,1000,Integer.MAX_VALUE,    //整数原码形式十进制
                      0177,                                //整数补码形式八进制
                      0x80000000,0x7fff,0x7fffffff};       //整数补码形式十六进制
        for (int i=0; i<values.length; i++)
            print(values[i]);                              //自动封装成Integer对象
        System.out.println();        算法正确*/
        
        int radix=36;                                      //36进制，数字'0'～'9'，字母'a'～'z'，字母'A'～'Z'
        int[] value={35, Integer.MIN_VALUE};               //整数原码形式十进制
        for (int i=0; i<value.length; i++)
        {
            String str=Integer.toString(value[i],radix);   //2≤radix≤36
            System.out.print("Integer.toString("+value[i]+","+radix+")="+(str));  //赋值运算的结果值为变量值
            System.out.println("，Integer.parseInt("+str+","+radix+")="+Integer.parseInt(str,radix));
        }
    }
}
/*
程序运行结果如下：
原码（十、二、八、十六进制）-2147483648，-10000000000000000000000000000000，-20000000000，-80000000；补码（二、八、十六进制）10000000000000000000000000000000，20000000000，0x80000000
原码（十、二、八、十六进制）-128，-10000000，-200，-80；补码（二、八、十六进制）11111111111111111111111110000000，37777777600，0xffffff80
原码（十、二、八、十六进制）-1，-1，-1，-1；补码（二、八、十六进制）11111111111111111111111111111111，37777777777，0xffffffff
原码（十、二、八、十六进制）0，0，0，0；补码（二、八、十六进制）0，0，0x0
原码（十、二、八、十六进制）127，1111111，177，7f；补码（二、八、十六进制）1111111，177，0x7f
原码（十、二、八、十六进制）-32768，-1000000000000000，-100000，-8000；补码（二、八、十六进制）11111111111111111000000000000000，37777700000，0xffff8000
原码（十、二、八、十六进制）2147483647，1111111111111111111111111111111，17777777777，7fffffff；补码（二、八、十六进制）1111111111111111111111111111111，17777777777，0x7fffffff

原码（十、二、八、十六进制）-128，-10000000，-200，-80；补码（二、八、十六进制）11111111111111111111111110000000，37777777600，0xffffff80
原码（十、二、八、十六进制）-1，-1，-1，-1；补码（二、八、十六进制）11111111111111111111111111111111，37777777777，0xffffffff
原码（十、二、八、十六进制）127，1111111，177，7f；补码（二、八、十六进制）1111111，177，0x7f
原码（十、二、八、十六进制）32767，111111111111111，77777，7fff；补码（二、八、十六进制）111111111111111，77777，0x7fff

原码（十、二、八、十六进制）-2147483648，-10000000000000000000000000000000，-20000000000，-80000000；补码（二、八、十六进制）10000000000000000000000000000000，20000000000，0x80000000
原码（十、二、八、十六进制）-1000，-1111101000，-1750，-3e8；补码（二、八、十六进制）11111111111111111111110000011000，37777776030，0xfffffc18
原码（十、二、八、十六进制）0，0，0，0；补码（二、八、十六进制）0，0，0x0
原码（十、二、八、十六进制）254，11111110，376，fe；补码（二、八、十六进制）11111110，376，0xfe
原码（十、二、八、十六进制）1000，1111101000，1750，3e8；补码（二、八、十六进制）1111101000，1750，0x3e8
原码（十、二、八、十六进制）2147483647，1111111111111111111111111111111，17777777777，7fffffff；补码（二、八、十六进制）1111111111111111111111111111111，17777777777，0x7fffffff
原码（十、二、八、十六进制）127，1111111，177，7f；补码（二、八、十六进制）1111111，177，0x7f
原码（十、二、八、十六进制）-2147483648，-10000000000000000000000000000000，-20000000000，-80000000；补码（二、八、十六进制）10000000000000000000000000000000，20000000000，0x80000000
原码（十、二、八、十六进制）32767，111111111111111，77777，7fff；补码（二、八、十六进制）111111111111111，77777，0x7fff
原码（十、二、八、十六进制）2147483647，1111111111111111111111111111111，17777777777，7fffffff；补码（二、八、十六进制）1111111111111111111111111111111，17777777777，0x7fffffff

Integer.toString(35,36)=z，Integer.parseInt(z,36)=35
Integer.toString(-2147483648,36)=-zik0zk，Integer.parseInt(-zik0zk,36)=-2147483648

*/
//@author：Yeheya。2015-2-28  

