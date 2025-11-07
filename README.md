# Nexus Tech - Tracer



## Azure Boards
- Página inicial: https://dev.azure.com/RM557987/Nexus%20Tech%20-%20Tracer

## Integrantes
| Nome | RM |
| ---- | :-: |
| Otavio Miklos Nogueira | 554513 |
| Luciayla Yumi Kawakami | 557987 |
| João Pedro Amorim Brito | 559213 |

## Vídeo de configuração e execução dos testes
- Link: [Adicionar link aqui]()

## Tecnologias principais
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Thymeleaf
- H2 Database (perfil de desenvolvimento)
- Maven Wrapper (mvnw)

## Pré-requisitos
- JDK 17 ou superior instalado e configurado
- Git instalado para clonar o repositório

## Instalação
```bash
# Clone o projeto
git clone <url-do-repositorio>

# Vá até a pasta do projeto
cd <pasta-do-repositorio>
```

## Execução da aplicação
```bash
# Execute a aplicação Spring Boot
./mvnw spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

## Execução dos testes automatizados
```bash
# Execute toda a suíte de testes
./mvnw test
```

## Fluxo de uso
1. Acesse `http://localhost:8080/web/usuarios/register` e cadastre um novo usuário com a role **ADMIN**.
2. Realize o login em `http://localhost:8080/web/usuarios/login`.
3. Após a autenticação, cadastre novas filiais e registre motos associadas.

## Rotas principais
### Usuários
| Função | Segurança | URL |
| :----- | :-------- | :-- |
| Cadastro | Livre | [http://localhost:8080/web/usuarios/register](http://localhost:8080/web/usuarios/register) |
| Login | Livre | [http://localhost:8080/web/usuarios/login](http://localhost:8080/web/usuarios/login) |
| Listagem | Autenticado | [http://localhost:8080/web/usuarios](http://localhost:8080/web/usuarios) |
| Atualizar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/usuarios/atualizar/5](http://localhost:8080/web/usuarios/atualizar/5) |
| Deletar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/usuarios/deletar/5](http://localhost:8080/web/usuarios/deletar/5) |

### Filiais
| Função | Segurança | URL |
| :----- | :-------- | :-- |
| Listagem | Autenticado | [http://localhost:8080/web/filiais](http://localhost:8080/web/filiais) |
| Criar Nova | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/filiais/new](http://localhost:8080/web/filiais/new) |
| Atualizar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/filiais/atualizar/5](http://localhost:8080/web/filiais/atualizar/5) |
| Deletar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/filiais/deletar/5](http://localhost:8080/web/filiais/deletar/5) |

### Motos
| Função | Segurança | URL |
| :----- | :-------- | :-- |
| Listagem | Autenticado | [http://localhost:8080/web/motos](http://localhost:8080/web/motos) |
| Criar Nova | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/motos/new](http://localhost:8080/web/motos/new) |
| Criar Nova a partir de uma filial | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/motos/new/filial/1](http://localhost:8080/web/motos/new/filial/1) |
| Atualizar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/motos/atualizar/5](http://localhost:8080/web/motos/atualizar/5) |
| Deletar | Autenticado & Autorizado (ADMIN) | [http://localhost:8080/web/motos/deletar/5](http://localhost:8080/web/motos/deletar/5) |

## Estrutura de pastas
```
src/
 ├─ main/
 │   ├─ java/br/com/fiap/sprint3/...    # Código-fonte da aplicação
 │   └─ resources/                      # Configurações, templates e scripts
 └─ test/
     └─ java/br/com/fiap/sprint3/...    # Testes automatizados com JUnit
```

## Contribuição
1. Crie um branch a partir da `main`.
2. Implemente sua feature ou correção.
3. Execute `./mvnw test` para garantir que os testes passam.
4. Abra um Pull Request descrevendo suas alterações.

## Licença
Este projeto é destinado a fins educacionais no contexto das sprints da FIAP.
