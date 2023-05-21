import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

//    public List<Product> getProductWithText(String text) {
//        String str = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//
//        for(Product p : products){
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//            if(name.contains(str) || type.contains(str) || place.contains(str))
//                prods.add(p);
//        }
//        return prods;
//
//    }

    public List<Product> getProductAtPlace(String place) {
        // Using Regular way (For Loop)
//        List<Product> prods = new ArrayList<>();
//        for(Product p : products){
//            if(p.getPlace().equals(place))
//                prods.add(p);
//        }
//        return prods;
        // Using Stream API
        return products.stream().filter(product -> product.getPlace().equalsIgnoreCase(place)).toList();
    }

    public List<Product> warrantyExp() {
        int currentYr = Year.now().getValue();

        // Using for loop
//        List<Product> prods = new ArrayList<>();
//        for(Product p : products){
//            if(p.getWarranty() < currentYr)
//                prods.add(p);
//        }
//        return prods;

        // Using Stream
        return  products.stream().filter(product -> product.getWarranty() < currentYr).toList();
    }

    // Using Stream API
    public List<Product> getProductWithText(String text) {
        String s = text.toLowerCase();

        return products.stream().filter(product ->
                (product.getName().toLowerCase().contains(s) ||
                        product.getType().toLowerCase().contains(s) ||
                        product.getPlace().toLowerCase().contains(s))).toList();

    }

}
