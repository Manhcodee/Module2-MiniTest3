import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;

public class Material_Management {
    private List<Material> materials;

    public Material_Management() {
        this.materials = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void updateMaterial(String id, Material newMaterial) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.set(i, newMaterial);
                System.out.println("Cập nhật vật liệu thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy vật liệu với ID: " + id);
    }

    public void removeMaterial(String id) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.remove(i);
                System.out.println("Xóa vật liệu thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy vật liệu với ID: " + id);
    }

    public void displayMaterials() {
        if (materials.isEmpty()) {
            System.out.println("Không có vật liệu nào.");
            return;
        }
        for (Material material : materials) {
            System.out.println("ID: " + material.getId() +
                    ", Name: " + material.getName() +
                    ", Cost: " + material.getCost() +
                    ", Amount: " + material.getAmount() +
                    ", Expiry Date: " + material.getExpiryDate());
        }
    }

    // Tính tổng tiền của tất cả vật liệu
    public double calculateTotalCost() {
        int totalMaterial = 0;
        for (Material material : materials) {
            if (material.getAmount() > 0) {
                totalMaterial += material.getAmount();
            }
        }
        return totalMaterial;
    }

    // Sắp xếp vật liệu theo giá
    public void sortMaterialsByCost() {
        materials.sort(Comparator.comparingDouble(Material::getCost));
    }

    // Tính chênh lệch giữa giá có chiết khấu và không có chiết khấu
    public double calculateDiscountDifference(Discount discount) {
        double totalWithoutDiscount = calculateTotalCost();
        double totalWithDiscount = discount.getRealMoney();
        return totalWithoutDiscount - totalWithDiscount;
    }

}
