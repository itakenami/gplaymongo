package models;

import java.util.Date;
import java.util.List;
import ognom.Finder;
import ognom.annotation.Autoload;
import ognom.annotation.Entity;
import org.bson.types.ObjectId;
import play.modules.ognomplay.Model;

@Entity(name="projetos")
public class Projeto extends Model{

    public String nome;
    public String descricao;
    public Date data_inicio; 
    public Date data_fim;
    @Autoload(model=Analista.class,fields={"nome","especialidade","cargo"})
    public List<Analista> analistas;


    @Override
    public String toString(){
        return nome;
    }
    
    public static List<Projeto> findAll() {
        return Finder.findAll(Projeto.class);
    }

    public static Projeto findById(ObjectId id) {
        return Finder.findById(Projeto.class, id);
    }
    
}
