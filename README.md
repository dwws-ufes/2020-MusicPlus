<h3 align="center">Music+</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---
O Music+ é um sistema de análise e informações do meio musical visando simplificar a experiência do usuário em suas buscas. O sistema possui dois modelos de usuários e reúne diversas funcionalidades com dois vieses: a consulta de dados e o comportamento da comunidade.

No ramo de consulta de dados, temos os usuários do tipo Administradores que controlam o cadastro das informações como artistas, álbuns e músicas. Temos também os usuários do tipo consumidores que podem procurar por essas informações de modo direto,favoritar músicas, artistas e gêneros musicais, agrupar músicas em formato de playlist e modificar essas playlists em outro momento.

No ramo de comportamento de comunidade, o usuário do tipo consumidor alimentará uma análise de conteúdo combinando suas preferências com a da comunidade. O formato com que este usuário consome essa análise é realizando uma busca de músicas e artistas com perfil aleatório ou baseado em um “ranking” de mais favoritados pela comunidade. Os resultados dessa busca procuram ser alinhados com as preferências musicais do usuário consumidor.

Além dessas funcionalidades, o sistema mantém um registro de informações dos usuários consumidores e dados sobre suas preferências musicais. O acesso a esse perfil é feito através de um cadastro e, caso o usuário encontre dificuldades, o mesmo pode recuperar sua senha de acesso via e-mail.

## 📝 Conteúdo

- [Como começar](#getting_started)
- [Aplicação](#application)
- [Ferramentas utilizadas](#built_using)
- [Infraestrutura](#infrastructure)
- [Extras](#extras)
- [Autores](#authors)
- [Considerações finais](#acknowledgement)

## 🏁 Como começar <a name = "getting_started"></a>

A inicialização da aplicação pode ser feita via Docker ou baixando as bibliotecas localmente.
O projeto pode ter integração com banco de dados local ou remoto.

### Pré-requisitos

```
Docker configurado ou banco de dados
Java 15
Maven
```

### Instalação

Baixe o repositório com o comando

```
git clone https://github.com/dwws-ufes/2020-MusicPlus.git
```

Antes de criar os containeres, é necessário configurar a rede docker que manterá os containeres conectados.

```
docker network create bubble
```

Coloque as variáveis no arquivo .env e então rode o composer para baixar as imagens base, criar a imagem da aplicação e inicializar.

```
docker-compose -f docker-compose.yml up -d --build
```

Verifique que a aplicação backend está espelhada na porta 8080.

## 🎈 Aplicação <a name = "application"></a>

### Rotas Backend

```

```

### Páginas Frontend

```

```

## ⛏️ Ferramentas utilizadas <a name = "built_using"></a>

- [Java EE 7](https://docs.oracle.com/javaee/7/index.html) - Conjunto de especificação de APIs e tecnologias, que são implementadas por programas servidores de aplicação.

- [Java 15](https://www.oracle.com/br/java/technologies/javase-jdk15-downloads.html) - Linguagem de programação orientada a objetos e independente de plataforma.

- [JSF 2.2.12](https://mvnrepository.com/artifact/com.sun.faces/jsf-api/2.2.12) - API para a construção de interfaces de usuários baseada em componentes para aplicações Web.

- [EJB 4.0.9](https://mvnrepository.com/artifact/org.jboss/jboss-ejb-client/4.0.9.Final) - API para construção de componentes transacionais gerenciados por container.

- [JPA 2.1](https://mvnrepository.com/artifact/org.hibernate.javax.persistence/hibernate-jpa-2.1-api) - API para persistência de dados por meio de mapeamento objeto/relacional.
	
- [CDI 1.1](https://docs.jboss.org/cdi/api/1.1/) - API para injeção de dependências.
	
- [Facelets 2.0](https://www.oracle.com/technical-resources/articles/java/facelets.html) - API para definição de decoradores (templates) integrada ao JSF.
	
- [PrimeFaces 6.2](https://www.primefaces.org/docs/guide/primefaces_user_guide_6_2.pdf) - Conjunto de componentes visuais JSF open source.
	
- [MySQL Database 8.0](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/) - Banco de Dados Relacional gratuito.
	
- [WildFly 22.0.1](https://www.wildfly.org/downloads/) - Servidor de Aplicações para Java EE. 

- [Docker 20.10.5](https://docs.docker.com/engine/release-notes/) - Plataforma para gerenciamento e isolamento de ambientes.

## Infraestrutura <a name = "infrastructure"></a>

## Extras <a name = "extras"></a>

Aqui estão os possíveis próximos passos para este projeto:

```

```

## ✍️ Autores <a name = "authors"></a>

- [@bih-goncalves](https://github.com/bih-goncalves)
- [@csguterres](https://github.com/csguterres)
- [@kaiorosa1](https://github.com/kaiorosa1)
- [@gsbiel](https://github.com/gsbiel)
- [](https://github.com/)
- [](https://github.com/)

## 🎉 Considerações finais <a name = "acknowledgement"></a>

- Esse projeto foi desenvolvido para a disciplina Tópicos Especiais em Engenharia de Software da UFES.

- O sistema Music+ apresenta uma arquitetura baseada na arquitetura do FrameWeb.