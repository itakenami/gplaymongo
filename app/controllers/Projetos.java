package controllers;

import java.util.List;
import models.Projeto;
import models.Analista;
import org.bson.types.ObjectId;

public class Projetos extends DefaultController {
    
    public static void index(){
        List<Projeto> projetos = Projeto.findAll();
        render(projetos);
    }


    public static void view(ObjectId id) {
        if(id != null) {
            Projeto projeto = Projeto.findById(id);
            if(projeto!=null){
                render(projeto);
            }else{
                flash.error("Projeto não encontrado.");
                index();
            }
        }else{
            flash.error("É necessário informar um projeto.");
            index();
        }
    }


    public static void delete(ObjectId id) {
        try {
            Projeto projeto = Projeto.findById(id);
            projeto.delete();
            flash.success("Registro apagado com sucesso.");
        } catch (Exception ex) {
            flash.error("Erro ao apagar registro.");
        }
        index();
    }
    
    
   public static void form(ObjectId id) {

       List<Analista> analistas = Analista.findAll();
      if(id != null) {
          Projeto projeto = Projeto.findById(id);
          if (projeto != null) {
              render(projeto,analistas);
          } else {
              flash.error("Registro não encontrado.");
              index();
          }
      }else{
          render(analistas);
      }
  }
  
  public static void save(ObjectId id, Projeto projetoVO){
      Projeto projeto;
      if(id == null){
          projeto = projetoVO;
          projetoVO = null;
      }else{
          projeto = Projeto.findById(id);
          if(projeto != null){
	  projeto.data_fim = projetoVO.data_fim;
	  projeto.data_inicio = projetoVO.data_inicio;
	  projeto.descricao = projetoVO.descricao;
	  projeto.nome = projetoVO.nome;
	  projeto.analistas = projetoVO.analistas;
          }else{
              flash.error("Registro não encontrado.");
              index();
          }
      }
 
      projeto.save();
      flash.success("Registro salvo com sucesso.");
      index();
    }
    
}
