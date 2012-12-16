# OGNOMPLAY

Modulo para Play 1.2.x que utiliza a biblioteca ognom para implementar um drive ORM em MongoDB

## Como instalar

Instale o Play 1.2.x e crie um novo projeto como descrito no link: http://www.playframework.org/documentation/1.2.5/install

Adicione esta configuração em conf/dependencies.yml

    # Application dependencies
    require:
        - play
        - takenami -> ognomplay 0.1

    # My custom repositories
    repositories:
        - takenami:
            type:       http
            artifact:   "https://github.com/itakenami/ognomplay/raw/master/dist/[module]-[revision].zip"
            contains:
                - takenami -> *

Dentro da pasta do projeto rode o comando:

	play dependencies
	
## Testando

Para criar um exmplo, dentro da pasta do projeto, utilize o comando:

	ognomplay:sample
	
	
Após executar o comando acima os seguintes arquivos serão criados:
* app/models/Usuario.java => Model exemplo

Para testar utilize algum controller e faça acesso ao Model Usuario