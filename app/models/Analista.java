package models;
import java.util.List;
import ognom.Finder;
import ognom.annotation.Autoload;
import ognom.annotation.Entity;
import org.bson.types.ObjectId;
import play.modules.ognomplay.Model;
 
@Entity(name="analistas")
public class Analista extends Model {

    public String nome;
    public String especialidade;
    
    @Autoload(model=Cargo.class)
    public Cargo cargo;
    

    @Override
    public String toString(){
        return nome;
    }
    
    public static List<Analista> findAll() {
        return Finder.findAll(Analista.class);
    }

    public static Analista findById(ObjectId id) {
        return Finder.findById(Analista.class, id);
    }

    public void loadCargo() {
        cargo = Cargo.findById(cargo.get_id());
    }
    
    
}
