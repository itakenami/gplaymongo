package controllers;

import java.util.List;
import models.Cargo;
import org.bson.types.ObjectId;

public class Cargos extends DefaultController {
    
    public static void index(){
        List<Cargo> cargos = Cargo.findAll();
        render(cargos);
    }


    public static void view(ObjectId id) {
        if(id != null) {
            Cargo cargo = Cargo.findById(id);
            if(cargo!=null){
                render(cargo);
            }else{
                flash.error("Cargo não encontrado.");
                index();
            }
        }else{
            flash.error("É necessário informar um cargo.");
            index();
        }
    }


    public static void delete(ObjectId id) {
        try {
            Cargo cargo = Cargo.findById(id);
            cargo.delete();
            flash.success("Registro apagado com sucesso.");
        } catch (Exception ex) {
            flash.error("Erro ao apagar registro.");
        }
        index();
    }
    
    
   public static void form(ObjectId id) {

      if(id != null) {
          Cargo cargo = Cargo.findById(id);
          if (cargo != null) {
              render(cargo);
          } else {
              flash.error("Registro não encontrado.");
              index();
          }
      }else{
          render();
      }
  }
  
  public static void save(ObjectId id, Cargo cargoVO){

      Cargo cargo;
      if(id == null){
          cargo = cargoVO;
          cargoVO = null;
      }else{
          cargo = Cargo.findById(id);
          if(cargo != null){
	  cargo.nome = cargoVO.nome;
          }else{
              flash.error("Registro não encontrado.");
              index();
          }
      }
      
      cargo.save();
      flash.success("Registro salvo com sucesso.");
      index();
    }
    
}
