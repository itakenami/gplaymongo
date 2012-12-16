/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package play.modules.ognomplay;

import org.bson.types.ObjectId;

/**
 *
 * @author itakenami
 */
public abstract class Model extends ognom.Model {
    
    public String getId(){
        return _id.toString();
    }
    public void setId(String id){
        _id = new ObjectId(id);
    }

    
}
