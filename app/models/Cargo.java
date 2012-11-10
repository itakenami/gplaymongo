package models;

import java.util.List;
import ognom.Finder;
import ognom.annotation.Entity;
import org.bson.types.ObjectId;
import play.modules.ognomplay.Model;

@Entity(name="cargos")
public class Cargo extends Model {

    public String nome;

    @Override
    public String toString(){
        return nome;
    }
    
    public static List<Cargo> findAll() {
        return Finder.findAll(Cargo.class);
    }

    public static Cargo findById(ObjectId id) {
        return Finder.findById(Cargo.class, id);
    }

}
