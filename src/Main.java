import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Material_Management materialManagement = new Material_Management();

        // Thêm vật liệu
        materialManagement.addMaterial(new CrispyFlour("01", "Bột chiên giòn 1", LocalDate.now(), 100, 10));
        materialManagement.addMaterial(new Meat("02", "Thịt 1", LocalDate.now(), 200, 2.5));
        materialManagement.addMaterial(new CrispyFlour("03", "Bột chiên giòn 2", LocalDate.now(), 150, 5));
        materialManagement.addMaterial(new Meat("04", "Thịt 2", LocalDate.now(), 240, 2.0));
        materialManagement.addMaterial(new CrispyFlour("05", "Bột chiên giòn 3", LocalDate.now(), 130, 8));
        materialManagement.addMaterial(new Meat("06", "Thịt 3", LocalDate.now(), 180, 3.0));
        materialManagement.addMaterial(new CrispyFlour("07", "Bột chiên giòn 4", LocalDate.now(), 90, 12));
        materialManagement.addMaterial(new Meat("08", "Thịt 4", LocalDate.now(), 220, 1.5));
        materialManagement.addMaterial(new CrispyFlour("09", "Bột chiên giòn 5", LocalDate.now(), 160, 6));
        materialManagement.addMaterial(new Meat("10", "Thịt 5", LocalDate.now(), 210, 2.0));


        // Hiển thị danh sách vật liệu
        System.out.println("Danh sách vật liệu ban đầu:");
        materialManagement.displayMaterials();

        // Tính tổng tiền của tất cả vật liệu
        double totalCost = materialManagement.calculateTotalCost();
        System.out.println("Tổng tiền của tất cả vật liệu: " + totalCost);

        // Sắp xếp vật liệu theo giá
        materialManagement.sortMaterialsByCost();
        System.out.println("\nDanh sách vật liệu sau khi sắp xếp theo giá:");
        materialManagement.displayMaterials();

        // Tính chênh lệch giữa giá có chiết khấu và không có chiết khấu
        class ConcreteDiscount implements Discount {
            @Override
            public double getRealMoney() {
                return totalCost * 0.9;
            }
        }

        ConcreteDiscount discount = new ConcreteDiscount();
        double discountDifference = materialManagement.calculateDiscountDifference(discount);
        System.out.println("Số chênh lệch giữa chiết khấu và không chiết khấu: " + discountDifference);




        // Cập nhật vật liệu với ID "01"
        CrispyFlour updatedCrispyFlour = new CrispyFlour("01", "Bột chiên giòn 1 - Cập nhật", LocalDate.now(), 120, 15);
        materialManagement.updateMaterial("01", updatedCrispyFlour);

        // Xóa vật liệu với ID "02"
        materialManagement.removeMaterial("02");

        // Hiển thị danh sách vật liệu sau khi cập nhật và xóa
        System.out.println("\nDanh sách vật liệu sau khi cập nhật và xóa:");
        materialManagement.displayMaterials();
    }

}