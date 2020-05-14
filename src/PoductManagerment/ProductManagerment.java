package PoductManagerment;
import Product.Product;
import Product.Laptop;
import Product.MobilePhone;
import Product.WashingMachine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagerment implements I_ProductManager, I_FindProduct, I_EditProduct, I_EditType, I_EditColor, I_EditSize {
    private ArrayList<Product> myProduct = new ArrayList<>();;

    public void setMyProduct(ArrayList<Product> myProduct) {
        this.myProduct = myProduct;
    }

    public ArrayList<Product> getMyProduct() {
        return myProduct;
    }

    @Override
    public void add(Product element) {
        int index = myProduct.size()-1;
        if(myProduct.size() == 0){
            myProduct.add(element);
        }
        else {
            myProduct.add(index, element);
        }
    }
    @Override
    public void edit(int index) {
        System.out.println("Enter something to find: ");
        Scanner scan = new Scanner(System.in);
        String findKey = scan.nextLine();
        scan.nextLine();
        if(findByID(findKey)){
            findByID(findKey);
        }
        else if(findByName(findKey)){
            findByName(findKey);
        }
        else if(findByBrand(findKey)){
            findByBrand(findKey);
        }
        else {
            int price = Integer.parseInt(findKey);
            findByPrice(price - 1000000, price + 1000000);
        }
        int key = -1;
        while (key != 0){
            ProductType productType = null;
            System.out.println("Choose a number to use these function below: ");
            System.out.println("0. Exit");
            System.out.println("1. Edit ID's product");
            System.out.println("2. Edit name's product");
            System.out.println("3. Edit price's product");
            System.out.println("4. Edit brand's product");
            if(myProduct.get(index) instanceof Laptop){
                productType = ProductType.LAPTOP;
                System.out.println("5. Edit color's product");
                System.out.println("7. Edit size's product");
            }
            else if(myProduct.get(index) instanceof MobilePhone){
                productType = ProductType.MOBILEPHONE;
                System.out.println("5. Edit color's product");
            }
            else if(myProduct.get(index) instanceof WashingMachine){
                productType = ProductType.WASHINGMACHINE;
                System.out.println("6. Edit type's product");
            }
            int num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter product's ID to change: ");
                    String id1 = scan.nextLine();
                    System.out.println("Enter new product's ID: ");
                    String newID = scan.nextLine();
                    editID(id1, newID);
                    break;
                case 2:
                    System.out.println("Enter product's ID to change: ");
                    String id2 = scan.nextLine();
                    System.out.println("Enter new product's name: ");
                    String newName = scan.nextLine();
                    editName(id2, newName);
                    break;
                case 3:
                    System.out.println("Enter product's ID to change: ");
                    String id3 = scan.nextLine();
                    System.out.println("Enter new product's name: ");
                    int newPrice = scan.nextInt();
                    scan.nextLine();
                    editPrice(id3, newPrice);
                    break;
                case 4:
                    System.out.println("Enter product's ID to change: ");
                    String id4 = scan.nextLine();
                    System.out.println("Enter new product's name: ");
                    String newBrand = scan.nextLine();
                    editBrand(id4, newBrand);
                    break;
                case 5:
                    System.out.println("Enter product's ID to change: ");
                    String id5 = scan.nextLine();
                    System.out.println("Enter new product's color: ");
                    String newColor = scan.nextLine();
                    editColor(id5, newColor, productType);
                    break;
                case 6:
                    System.out.println("Enter product's ID to change: ");
                    String id6 = scan.nextLine();
                    System.out.println("Enter new product's type: ");
                    String newType = scan.nextLine();
                    editColor(id6, newType, productType);
                    break;
                case 7:
                    System.out.println("Enter product's ID to change: ");
                    String id7 = scan.nextLine();
                    System.out.println("Enter new product's size: ");
                    String newSize = scan.nextLine();
                    editColor(id7, newSize, productType);
                    break;
                default: System.out.println("not available");
            }
        }
    }

    @Override
    public Product remove(int index) {
        Product token = myProduct.get(index);
        myProduct.remove(index);
        return token;
    }

    @Override
    public Product get(int index) {
        return myProduct.get(index);
    }

    @Override
    public boolean findByName(String name) {
        name = name.toUpperCase();
        boolean isContains = false;
        if(getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<myProduct.size(); i++ ){
            String productName = myProduct.get(i).getName().toUpperCase();
            if(productName.contains(name)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).getName());
                isContains = true;
            }
        }
        return isContains;
    }

    @Override
    public boolean findByID(String id) {
        id = id.toUpperCase();
        boolean isContains = false;
        if(myProduct.size() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<myProduct.size(); i++ ){
            String productID = myProduct.get(i).getId().toUpperCase();
            if(productID.contains(id)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
                isContains = true;
            }
        }
        return isContains;
    }
    public boolean findByBrand(String brand){
        brand = brand.toUpperCase();
        boolean isContains = false;
        if(myProduct.size() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<myProduct.size(); i++ ){
            String productBrand = myProduct.get(i).getBrand().toUpperCase();
            if(productBrand.contains(brand)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
                isContains  = true;
            }
        }
        return isContains;
    }
    @Override
    public void findByExactlyPrice(int price) {
        if(myProduct.size() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<myProduct.size(); i++ ){
            if(myProduct.get(i).getPrice() == price){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }

    @Override
    public boolean findByPrice(int lowestPrice, int highestPrice) {
        boolean isContains = false;
        if(myProduct.size() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<myProduct.size(); i++ ){
            if(myProduct.get(i).getPrice() >= lowestPrice && myProduct.get(i).getPrice() <= highestPrice){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
                isContains = true;
            }
        }
        return isContains;
    }
    private int findProductIndexByID(String id){
        for(int i=0; i<myProduct.size(); i++ ){
            if(myProduct.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean editName(String id, String newName) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        myProduct.get(index).setName(newName);
        return true;
    }

    @Override
    public boolean editID(String id, String newID) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        myProduct.get(index).setId(newID);
        return true;
    }
    public boolean editBrand(String id, String newBrand) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        myProduct.get(index).setBrand(newBrand);
        return true;
    }

    public boolean editPrice(String id, int newPrice) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        myProduct.get(index).setPrice(index);
        return true;
    }
    @Override
    public boolean editType(String id, String newType, ProductType productType) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        switch (productType){
            case WASHINGMACHINE:
                ((WashingMachine) myProduct.get(index)).setType(newType);
                break;
            default:
                throw new NotImplementedException();
        }
        return true;
    }
    @Override
    public boolean editColor(String id, String newColor, ProductType productType) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        switch (productType){
            case MOBILEPHONE:
                ((MobilePhone) myProduct.get(index)).setColor(newColor);
                break;
            case LAPTOP:
                ((Laptop) myProduct.get(index)).setColor(newColor);
                break;
            default:
                throw new NotImplementedException();
        }
        return true;
    }

    @Override
    public boolean editSize(String id, String newSize, ProductType productType) {
        int index = findProductIndexByID(id);
        if(index < 0)
            return false;
        switch (productType){
            case LAPTOP:
                ((Laptop) myProduct.get(index)).setSize(newSize);
                break;
            default:
                throw new NotImplementedException();
        }
        return true;
    }
    public int getSize(){
        return myProduct.size();
    }
    public ProductManagerment() {
    }
}
