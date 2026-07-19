package Session03;

import java.util.Scanner;
import java.util.Locale;

public class exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary;
        int count = 0;
        double totalBonus = 0;
        int totalSalary = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        while(true){
            System.out.println("""
                    ***************MENU NHẬP LƯƠNG***************
                    1.  	Nhập lương nhân viên
                    2.  	Hiển thị thống kê
                    3.  	Tính tổng số tiền thưởng cho nhân viên
                    4.  	Thoát
                    Lựa chọn của bạn:
                    """);
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    do{
                        System.out.println("Nhập lương của nhân viên (nhập -1 để dừng): ");
                        salary = Integer.parseInt(sc.nextLine());
                        if(salary == -1){
                            break;
                        }
                        if (salary <= 0 || salary > 500_000_000){
                            System.out.println("Lương không hợp lệ: từ 0 - 500 triệu");
                        } else {
                            count++;
                            totalSalary += salary;
                            if(minSalary > salary){
                                minSalary = salary;
                            }

                            if(maxSalary < salary){
                                maxSalary = salary;
                            }

                            String type;
                            double bonusRate;
                            if(salary < 5_000_000){
                                type = "Thu nhập thấp";
                                bonusRate = 0.05;
                            } else if (salary < 15_000_000){
                                type = "Thu nhập trung bình";
                                bonusRate = 0.10;
                            } else if (salary < 50_000_000){
                                type = "Thu nhập khá";
                                bonusRate = 0.15;
                            } else {
                                type = "Thu nhập cao";
                                if (salary < 100000000) {
                                    bonusRate = 0.20;
                                } else {
                                    bonusRate = 0.25;
                                }
                            }
                            count++;
                            totalSalary += salary;
                            totalBonus += salary * bonusRate;
                            System.out.printf("Tiền lương: %d - Xếp loại: %s \n", salary, type);
                        }
                    } while(true);
                    System.out.println("Bạn đã nhập lương thành công!");
                    break;
                case 2:
                    if (count > 0){
                        System.out.printf("Tổng số nhân viên đã nhập: %d\n", count);
                        System.out.printf("Tổng lương đã nhập: %d\n", totalSalary);
                        System.out.printf("Lương lớn nhất: %d\n", maxSalary);
                        System.out.printf("Lương nhỏ nhất: %d\n", minSalary);
                    }
                    break;
                case 3:
                    System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                    System.out.printf("Tổng tiền thưởng nhân viên: %s \n", totalBonus);
                    break;
                case 4:
                    System.out.println("Thoát chương trình \n");
                    sc.close();
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác \n");
            }
            if(choice == 4){
                break;
            }
        }
    }
}