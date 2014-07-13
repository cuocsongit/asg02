//Lê Thành Đạt
//11020066

package oop.asg02;

/**
 *
 * @author cuocsongit
 */

public class BigIntegerDemo {

    public static void main(String[] args) {
        //contructor cho phép tạo một BigInteger từ một số kiểu long
        BigInteger demo_a = new BigInteger(1);
        
        //contructor cho phép tạo một BigInteger từ một String
        BigInteger demo_b = new BigInteger("000000000002");
        
        //Phương thức trả về biểu diễn Long của BigInteger
        System.out.println("Demo constructor từ 1 một số kiểu long : " + demo_a.toLong());
        
        //Phương thức trả về biểu diễn String của BigInteger
        System.out.println("Demo constructor từ 1 một số kiểu String : " + demo_b.toString());
        
        //So sanh hai so bang nhau
        if( demo_a.equals(10) ) {
            System.out.println("Hai số bằng nhau");
        }
        
        //Cộng 2 số
        System.out.println(demo_a.toString() + " + " + demo_b + " = " + demo_a.add(demo_b).toString());
        
        //Trừ 2 số
        System.out.println(demo_b.toString() + " - " + demo_a + " = " + demo_b.subtract(demo_a).toString());
        
        //So sánh 2 số
        System.out.println(demo_a.compareTo(demo_b));
        
    }
}
