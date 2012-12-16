/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bind;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.bson.types.ObjectId;
import play.data.binding.Global;
import play.data.binding.TypeBinder;

/**
 *
 * @author itakenami
 */
@Global
public class ObjectIdBinder implements TypeBinder<ObjectId> {

    public Object bind(String name, Annotation[] antns, String value, Class type, Type type1) throws Exception {
        ObjectId obj = new ObjectId(value);
        return obj;
    }
    
}
