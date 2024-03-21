package ma.achraf.university;

import ma.achraf.university.entities.Product;
import ma.achraf.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired // pour demande a SPRING inject moi dans cette objet la   un objet de type ProductRepository il fait l injectio des dpndc
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args); // si je demaree cett app le premier qui demaree c est spring
        // quand spring demare  il va configurer GPA  il va scanner les class les annotation luis qui va faire l inversion du controlle
        // run c est methode qui existe au demarage de l application
    }

    private static void accept(Product p) {
        System.out.println(p.toString());
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save (new Product(null,"AirPods",300,10));
        productRepository.save (new Product(null,"IMac",3300,33));
        productRepository.save (new Product(null,"MacBook",1300,33));
        productRepository.save (new Product(null,"Iphone 15 Pro Max",1200,32));
        productRepository.save (new Product(null,"Iphone 15",9999,4));
        List<Product> products = productRepository.findAll();// retourner une liste de produits

        products.forEach(p->{
            System.out.println(p.toString());
        }); // forEach pour parcourir la liste
       Product product = productRepository.findById(Long.valueOf(1)).get();//get retourne l obj lui mem
        System.out.println( "**************");
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        System.out.println(product.getName());;
        System.out.println(product.getQuantity());
        System.out.println( "**************");


        System.out.println( "--------------------"); // afficher separateur
        // en utilise une bd de type h2
        productRepository.findByNameContains("M");// tout les produit qui contien M
        List<Product> productList = productRepository.findByNameContains("M") ; // retourne une list
     productList.forEach(p->{
         System.out.println(p);
     });
    }
}
