package controllers;

import java.util.List;
import models.Analista;
import models.Cargo;
import org.bson.types.ObjectId;

public class Analistas extends DefaultController {
    
    public static void index(){
        List<Analista> analistas = Analista.findAll();
        render(analistas);
    }


    public static void view(ObjectId id) {
        if(id != null) {
            Analista analista = Analista.findById(id);
            if(analista!=null){
                render(analista);
            }else{
                flash.error("Analista não encontrado.");
                index();
            }
        }else{
            flash.error("É necessário informar um analista.");
            index();
        }
    }


    public static void delete(ObjectId id) {
        try {
            Analista analista = Analista.findById(id);
            analista.delete();
            flash.success("Registro apagado com sucesso.");
        } catch (Exception ex) {
            flash.error("Erro ao apagar registro.");
        }
        index();
    }
    
    
   public static void form(ObjectId id) {

      List<Cargo> cargos = Cargo.findAll();
      if(id != null) {
          Analista analista = Analista.findById(id);
          if (analista != null) {
              render(analista,cargos);
          } else {
              flash.error("Registro não encontrado.");
              index();
          }
      }else{
          render(cargos);
      }
  }
  
  public static void save(ObjectId id, Analista analistaVO){

      Analista analista;
      if(id == null){
          analista = analistaVO;
          analistaVO = null;
      }else{
          analista = Analista.findById(id);
          if(analista != null){
	  analista.especialidade = analistaVO.especialidade;
	  analista.nome = analistaVO.nome;
	  analista.cargo = analistaVO.cargo;
          }else{
              flash.error("Registro não encontrado.");
              index();
          }
      }
      
      analista.save();
      flash.success("Registro salvo com sucesso.");
      index();
    }
    
}
