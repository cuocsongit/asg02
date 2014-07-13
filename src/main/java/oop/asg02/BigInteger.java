//Lê Thành Đạt

package oop.asg02;


public class BigInteger
{
    //cài đặt số tụ nhiên dưới dạng String
    private String bigInteger;
    
    //constructor cho phép tạo một BigInteger từ một số kiểu long.
    public BigInteger(long init) {
	bigInteger = String.valueOf(init);
    }
    
    //constructor cho phép tạo một BigInteger từ một String.
    public BigInteger(String init) {
        if(!init.isEmpty()) {
            while(init.charAt(0) == '0'  && init.length() > 1) {
                init = init.substring(1);
            }
            bigInteger = init;
        }
    }
    
    //trả về biểu diễn String của BigInteger
    public String toString() {
        return bigInteger;
    }
    
    //trả về giá trị boolean bằng true nếu hai số có giá trị bằng nhau
    //trả về false trong trường hợp ngược lại
    public boolean equals(Object other) {
        return toString().equals(other.toString());
    }
    
    //trả về biểu diễn kiểu long của BigInteger
    public long toLong() {
	return Long.valueOf(bigInteger); 
    }
    
    // trả về một đối tượng BigInteger mới là tổng của hai BigInteger đã cho
    //áp dụng qui tắc cộng thực tế
    public BigInteger add(BigInteger other) {
        //Biến nhớ, khi 2 chữ số có tổng vượt quá 10, lấy phần lẻ
        //cộng dồn 1 đơn vị lên hàng tiếp theo
        int bien_nho = 0;
        
        //Toán hạng cộng
        String add1 = bigInteger;
        String add2= other.toString();
        
        //Biến đổi 2 toán hạng có độ dài như nhau
        if(add1.length() != add2.length()) {
            //Phần độn, độn 0 vào trước toán hạng ít hơn để 2 toán hạng có độ dài như nhau
            String phan_don = "0";
            
            //Độn biến add2 có độ dài bằng add1
            if(add1.length() > add2.length()) {
                while(add1.length() != add2.length()) {
                    add2 = phan_don.concat(add2);
                }
            }
            
            //Độn biến add1 có độ dài bằng  add2
            if(add2.length() > add1.length()) {
                while(add2.length() != add1.length()) {
                    add1 = phan_don.concat(add1);
                }
            }
        }
        
        //Kết quả
        String ketqua ="";//Dạng String
        int kq = 0; //Dạng int
        
        String subAdd1, subAdd2;
        for(int i = add1.length()-1; i > 0; i--) {
            subAdd1 = String.valueOf(add1.charAt(i));
            subAdd2 = String.valueOf(add2.charAt(i));
            kq = Integer.parseInt(subAdd1)+Integer.parseInt(subAdd2)+bien_nho;
            bien_nho = kq /10;
            kq = kq%10;
            ketqua = String.valueOf(kq).concat(ketqua);
        }
        
        kq = Integer.valueOf(String.valueOf(add1.charAt(0))) +
                Integer.valueOf(String.valueOf(add2.charAt(0)))+bien_nho;
        ketqua = String.valueOf(kq).concat(ketqua);
        
        return new BigInteger(ketqua); 
    }
    
    // trả về một đối tượng BigInteger mới là hiệu của hai BigInteger đã cho.
    public BigInteger subtract(BigInteger other) {
         //Biến nhớ
        int bien_nho = 0;
        
        //Số bị trừ
        String add1 = bigInteger;
        
        //Số trừ
        String add2= other.toString();
        
        if(add1.length() != add2.length()) {
            //Phần độn
            String phan_don = "0";
            
            //Độn cho biến add2 có độ dài bằng add1
            if(add1.length() > add2.length()) {
                while(add1.length() != add2.length()) {
                    add2 = phan_don.concat(add2);
                }
            }
            
            //Độn cho biến add1 có độ dài bằng add2
            if(add2.length() > add1.length()) {
                while(add2.length() != add1.length()) {
                    add1 = phan_don.concat(add1);
                }
            }
        }
        
        String ketqua ="";
        int kq = 0;
        
        String subAdd1, subAdd2;
        
        for(int i = add1.length()-1; i >= 0; i--) {
            
            subAdd1 = String.valueOf(add1.charAt(i));
            subAdd2 = String.valueOf(add2.charAt(i));
            
            if(Integer.parseInt(subAdd1) >= Integer.parseInt(subAdd2) ) {
                kq = Integer.parseInt(subAdd1) - Integer.parseInt(subAdd2) - bien_nho;
                bien_nho = 0;
            }
            else {
                kq = Integer.parseInt(subAdd1) + 10 - Integer.parseInt(subAdd2) - bien_nho;
                bien_nho = 1;
            }
            
            ketqua = String.valueOf(kq).concat(ketqua);
        }
        
        return new BigInteger(ketqua);
    }
    
    //trả về 0 nếu 2 số bằng nhau, -1 nếu số hiện tại nhỏ hơn other, 1 nếu số hiện tại lớn hơn other
    public int compareTo(BigInteger other) {
        if(bigInteger.length() != other.toString().length()) {
            if(bigInteger.length() > other.toString().length()) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            if(bigInteger.compareTo(other.toString()) == 0) {
                return 0;
            }
            else {
 
                String add1 = bigInteger;
                String add2= other.toString();
                String subAdd1, subAdd2;
        
                for(int i = 0; i < add1.length(); i ++) {
            
                    subAdd1 = String.valueOf(add1.charAt(i));
                    subAdd2 = String.valueOf(add2.charAt(i));
                    if(Integer.valueOf(subAdd1) > Integer.valueOf(subAdd2)) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
    
    // trả về tham chiếu tới một đối tượng BigInteger mới tạo, là bản sao của đối tượng hiện hành
    public BigInteger clone() {
        return this;
    }
}
