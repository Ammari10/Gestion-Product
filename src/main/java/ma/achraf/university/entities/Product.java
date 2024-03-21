package ma.achraf.university.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data  @NoArgsConstructor @AllArgsConstructor
// les get et set
public class Product {
    @Id @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id ; //des attributs prive
    private String name;
    private double price;
    private int quantity;

}
