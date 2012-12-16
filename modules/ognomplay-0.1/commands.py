# Here you can create play commands that are specific to the module, and extend existing commands

MODULE = 'ognomplay'

# Commands that are specific to your module

COMMANDS = ['ognomplay:sample']

def execute(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")

    if command == "ognomplay:sample":
        print "~ Criando o arquivo models/Usuario.java..."
        try:
            f = open("app/models/Usuario.java", "w")
            try:
                f.write('package models;\n')
                f.write('\n')
                f.write('import java.util.List;\n')
                f.write('import ognom.Finder;\n')
                f.write('import ognom.annotation.Entity;\n')
                f.write('import org.bson.types.ObjectId;\n')
                f.write('import play.modules.ognomplay.Model;\n')
                f.write('\n')
                f.write('@Entity(name="usuarios")\n')
                f.write('public class Usuario extends Model {\n')
                f.write('\n')
                f.write('    public String nome;\n')
                f.write('\n')
                f.write('    @Override\n')
                f.write('    public String toString(){\n')
                f.write('        return nome;\n')
                f.write('    }\n')
                f.write('    \n')
                f.write('    public static List<Usuario> findAll() {\n')
                f.write('        return Finder.findAll(Usuario.class);\n')
                f.write('    }\n')
                f.write('\n')
                f.write('    public static Usuario findById(ObjectId id) {\n')
                f.write('        return Finder.findById(Usuario.class, id);\n')
                f.write('    }\n')
                f.write('\n')
                f.write('}\n')
                f.write('\n')
                
                print "~ "
                print "~ Model de exemplo gerado com sucesso"
                print "~ "
                print "~ Utilize algum controller para acessar o Model Usuario"
                print ""
                
            finally:
                f.close()
        except IOError:
            pass


# This will be executed before any command (new, run...)
def before(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")


# This will be executed after any command (new, run...)
def after(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")

    if command == "new":
        pass
