package baitapBuoi7.bai1;

import java.util.Scanner;

public class Client {
    /**
     * Constructor for objects of class Client
     */
    private String author;
    private int day;

    public Client() {
        this.author = author;
        this.day = day;
    }



    public void doUnchecked(String value) {
        // Can phai check exception, neu khong --> bug
       try {
           int result = canThrowUncheckedException(value);
           System.out.println("result=" + result);

       }catch (Exception e){
           System.out.println("khong dung " + e.getMessage());
       }

    }

    private int canThrowUncheckedException(String value) {
        return Integer.parseInt(value);
    }

    public void doChecked() {
        try {
            // Buoc phai check exception o day! Khong cach nao khac
            canThrowCheckedException();
            System.out.println("OK");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private int canThrowCheckedException() throws Exception {
        throw new Exception("Failure");
    }

    public static void main(String[] args) {
        Client client = new Client();
        Scanner sc =  new Scanner(System.in);
        System.out.println("nhap value: ");
        String input = sc.nextLine();
        client.doUnchecked(input);

    }
}
/*
* Phân biệt giữa checked và unchecked exceptions:

Unchecked exceptions là các ngoại lệ không yêu cầu phải xử lý tại thời điểm biên dịch. Chúng thường là các lớp con của RuntimeException hoặc Error. Ví dụ: NullPointerException, ArrayIndexOutOfBoundsException.
Checked exceptions là các ngoại lệ mà trình biên dịch yêu cầu bạn phải xử lý (hoặc khai báo bằng từ khóa throws) tại thời điểm biên dịch. Chúng không phải là lớp con của RuntimeException hoặc Error. Ví dụ: IOException, SQLException.

* Sử dụng checked và unchecked exceptions:
Checked exceptions thường được sử dụng trong các tình huống mà lập trình viên có thể dự đoán và xử lý được tại thời điểm biên dịch, như đọc hoặc ghi tệp, kết nối cơ sở dữ liệu.
Unchecked exceptions thường được sử dụng trong các tình huống không thể dự đoán được tại thời điểm biên dịch, chẳng hạn như lỗi logic, truy cập vào một phần tử không tồn tại trong mảng.

* Tại sao không nên sử dụng catch (Exception ex)?:
Sử dụng catch (Exception ex) sẽ bắt tất cả các loại ngoại lệ, bao gồm cả checked và unchecked exceptions.
Việc này có thể dẫn đến việc bỏ qua các ngoại lệ mà bạn không có kế hoạch xử lý, làm cho việc debug trở nên khó khăn hơn.
Thay vào đó, nên sử dụng các khối catch cụ thể cho các loại ngoại lệ mà bạn dự định xử lý, hoặc xử lý chúng tại thời điểm nó xảy ra và để ngoại lệ khác lan truyền lên.
*
* */