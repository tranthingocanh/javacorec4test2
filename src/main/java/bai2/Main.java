package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        INhanVienController iNhanVienController = new NhanVienController();

        try {
            while (true){
                System.out.println("//////////////////////");
                System.out.println("\t\t\t0. Thoat chuong trinh.");
                System.out.println("\t\t\t1. Thêm một nhân viên mới.");
                System.out.println("\t\t\t2. Hiển thị một nhân viên theo mã nhân viên được nhập vào.");
                System.out.println("\t\t\t3. Xóa một nhân viên khỏi CSDL theo mã nhân viên được nhập vào.");
                System.out.println("\t\t\t4. Sửa tên một nhân viên theo mã nhân viên do người dùng nhập vào.");
                System.out.println("\t\t\t5. In ra Thong Tin Nhan Vien.");
                System.out.println("//////////////////////");
                System.out.println(">>>>>>>Nhap so tuong ung thao tac muon thuc hien:");
                int  numberOption = sc.nextInt();
                sc.nextLine();
                switch (numberOption){
                    case 0:
                        System.out.println("========Ket Thuc Chuong Trinh=========");
                        System.exit(0);
                    case 1:
                        System.out.println("========1. Thêm một nhân viên mới.=========");
                        int flag = 1;
                        while (flag == 1){
                            try {
                                System.out.println(">>>Them 1 nhan vien moi: ");
                                nhanViens.add(iNhanVienController.nhapNhanVien());
                                System.out.println("Nhan 1: tiep tuc; 0: ket thuc: ");
                                flag = sc.nextInt();
                                sc.nextLine();
                            }catch (Exception e){
                                System.out.println("ERROR!!!");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("========2. Hiển thị một nhân viên theo mã nhân viên được nhập vào.=========");
                        int flag1 = 1;
                        while (flag1 == 1){
                            try {
                                System.out.println(">>> Nhap Ma Nhan Vien: . ");
                                String maNV = sc.nextLine();
                                iNhanVienController.queryGetTenNhaVienFromMaNhanVien(maNV);
                                System.out.println("Nhan 1: tiep tuc; 0: ket thuc: ");
                                flag1 = sc.nextInt();
                                sc.nextLine();
                            }catch (Exception e){
                                System.out.println("ERROR!!!" + e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("========3. Xóa một nhân viên khỏi CSDL theo mã nhân viên được nhập vào.=========");
                        int flag2 = 1;
                        while (flag2 == 1){
                            try {
                                System.out.println(">>> Nhap Ma Nhan Vien can xoa: ");
                                String maNV = sc.nextLine();
                                iNhanVienController.queryDeteletNhaVienFromMaNhanVien(maNV);
                                System.out.println("Nhan 1: tiep tuc; 0: ket thuc: ");
                                flag2 = sc.nextInt();
                                sc.nextLine();
                            }catch (Exception e){
                                System.out.println("ERROR!!!"+ e.getMessage());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("========4. Sửa tên một nhân viên theo mã nhân viên do người dùng nhập vào.=========");
                        int flag3 = 1;
                        while (flag3 == 1){
                            try {
                                System.out.println(">>> Nhap Ma Nhan Vien muon update: ");
                                String maNV = sc.nextLine();
                                System.out.println(">>> Nhap Ten Nhan Vien moi: ");
                                String tenNV = sc.nextLine();
                                iNhanVienController.queryUpdateTenNhaVienFromMaNhanVien(maNV, tenNV);
                                System.out.println("Nhan 1: tiep tuc; 0: ket thuc: ");
                                flag3 = sc.nextInt();
                                sc.nextLine();
                            }catch (Exception e){
                                System.out.println("ERROR!!!"+ e.getMessage());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("========5. In ra Thong Tin Nhan Vien.=========");
                        iNhanVienController.inNhanViens();
                        break;
                    default:
                        System.out.println("========Ket Thuc Chuong Trinh=========");
                        System.exit(1);

                }
            }
        }catch (Exception e){
            System.out.println("Du lieu dau vao loi!!!");
        }
    }
}
