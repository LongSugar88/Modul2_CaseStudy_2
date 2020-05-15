package PoductManagerment;
import MainRun.MainMenu;
import Product.Laptop;
import Product.MobilePhone;
import Product.Product;
import Product.WashingMachine;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EditProduct extends Manager implements I_Command {
    Product product;

    public EditProduct(ProductManagerment manager) {
        super(manager);
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter product's ID to change: ");
        String id = scan.nextLine();
        int key = -1;
        while (key != 0){
            FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, id);
            int index = findProductIndexByID.getIndex();
            ProductType productType = null;
            System.out.println("Choose a number to use these function below: ");
            System.out.println("0. Back");
            System.out.println("1. Edit ID's product");
            System.out.println("2. Edit name's product");
            System.out.println("3. Edit price's product");
            System.out.println("4. Edit brand's product");
            if(this.manager.get(index) instanceof Laptop){
                productType = ProductType.LAPTOP;
                System.out.println("5. Edit color's product");
                System.out.println("7. Edit size's product");
            }
            else if(this.manager.get(index) instanceof MobilePhone){
                productType = ProductType.MOBILEPHONE;
                System.out.println("5. Edit color's product");
            }
            else if(this.manager.get(index) instanceof WashingMachine){
                productType = ProductType.WASHINGMACHINE;
                System.out.println("6. Edit type's product");
            }
            int num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 0:
                    MainMenu.menu();
                case 1:
                    System.out.println("Enter new product's ID: ");
                    String newID = scan.nextLine();
                    EditID editID = new EditID(this.manager, newID, id);
                    editID.excute();
                    id = newID;
                    break;
                case 2:
                    System.out.println("Enter new product's name: ");
                    String newName = scan.nextLine();
                    EditName editName = new EditName(this.manager, newName, id);
                    editName.excute();
                    break;
                case 3:
                    System.out.println("Enter new product's price: ");
                    int newPrice = scan.nextInt();
                    EditPrice editPrice = new EditPrice(this.manager, newPrice, id);
                    editPrice.excute();
                    break;
                case 4:
                    System.out.println("Enter new product's brand: ");
                    String newBrand = scan.nextLine();
                    EditBrand editBrand = new EditBrand(this.manager, newBrand, id);
                    editBrand.excute();
                    break;
                case 5:
                    System.out.println("Enter new product's color: ");
                    String newColor = scan.nextLine();
                    EditColor editColor = new EditColor(this.manager, newColor, id, productType);
                    editColor.excute();
                    break;
                case 6:
                    System.out.println("Enter new product's type: ");
                    String newType = scan.nextLine();
                    EditType editType = new EditType(this.manager, newType, id, productType);
                    editType.excute();
                    break;
                case 7:
                    System.out.println("Enter new product's size: ");
                    String newSize = scan.nextLine();
                    EditSize editSize = new EditSize(this.manager, newSize, id, productType);
                    editSize.excute();
                    break;
                default: System.out.println("not available");
            }
        }
    }

}
