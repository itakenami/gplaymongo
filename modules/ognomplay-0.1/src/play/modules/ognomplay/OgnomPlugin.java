/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package play.modules.ognomplay;

/**
 *
 * @author itakenami
 */
import ognom.db.Config;
import ognom.db.Connection;
import play.PlayPlugin;

public class OgnomPlugin extends PlayPlugin {

    @Override
    public void onApplicationStart() {
        
        String host = play.Play.configuration.getProperty("ognom.host");
        int port = Integer.parseInt(play.Play.configuration.getProperty("ognom.port"));
        String db = play.Play.configuration.getProperty("ognom.db");
        String login = play.Play.configuration.getProperty("ognom.login");
        String senha = play.Play.configuration.getProperty("ognom.password");
        
        if(login==null || login.equals("")){
            Connection.getInstance().newConnection(new Config(host, port, db));
        }else{
            Connection.getInstance().newConnection(new Config(host, port, db, login, senha));
        }
        
    }
}
