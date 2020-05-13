package SourceProductInformation;

public class Test {
    public static void main(String[] args) {

        String [] washingMachine = {
                "https://pico.vn/may-giat-nhom-72.html", "https://pico.vn/may-giat-nhom-72.html?&pageIndex=2",
                "https://pico.vn/may-giat-nhom-72.html?&pageIndex=3"
        };
        String [] mobilePhone = {
                "https://pico.vn/dien-thoai-di-dong-nhom-75.html", "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=2",
                "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=3", "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=4"
        };
        String [] laptop = {
                "https://pico.vn/may-tinh-xach-tay-nhom-58.html", "https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=2",
                "https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=3"
        };
        for ( String element: washingMachine) {
            TakeProductInformation takeProductInformation = new TakeProductInformation(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine", "Pico00", false, true, false  );
            takeProductInformation.start();
        }
        for ( String element: mobilePhone) {
            TakeProductInformation takeProductInformation = new TakeProductInformation(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false  );
            takeProductInformation.start();
        }
        for ( String element: laptop) {
            TakeProductInformation takeProductInformation = new TakeProductInformation(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "Pico00", true, false, true  );
            takeProductInformation.start();
        }
    }
}
