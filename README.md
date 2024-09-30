# Leontis
Leontis é um aplicativo em desenvolvimento que será apresentado na Expo Tech 2024. O app permite escanear obras em museus, acessar guias digitais de museus, acompanhar notícias sobre o mundo da arte, entre outros recursos.

## API do Leontis - Redis

### Descrição
Esse repositório guarda a API REDIS do aplicativo Leontis. 
A *API REST* desenvolvida com *Spring Boot* permite a comunicação entre a interface e o banco de dados **REDIS**.


### Funcionalidades
1. **Gerenciamento de usuários:**
   - Operações de incrementação, decrementação e busca de variavel que informar número de usuários ativos no app.
2. **Gerenciamento de medidas:**
   - Incrementação e busca de variavel que informar número de visualizações de uma obra
   - Incrementação e busca de variavel que informar número de comentários de uma obra
   - Incrementação e busca de variavel que informar número de notas de uma obra

## Tecnologias Utilizadas
- *Spring Boot*: Framework principal para o desenvolvimento da API.
- *REDIS*: Banco de dados NoSQL usado para o armazenamento de dados.
- *Swagger*: Ferramenta para documentação interativa da API.

### Passos do projeto:
 - [x] Criação da API para gerenciamento de usuários
 - [X]  Criação da API para gerenciamento de medidas.

### Links 
https://apiredis.onrender.com/swagger-ui/index.html

### Principais endpoints
- */api/usuario*: Gerenciamento de usuários.
- */api/estatisticas*: Gerenciamento de medidas.
 ### Commits Semânticos 
 - **Feat:** (nova funcionalidade para o usuário, não uma nova funcionalidade para o script de build) 
 - **Fix:** (correção de bug para o usuário, não uma correção para um script de build)
 - **Docs:** (mudanças na documentação)
 - **Style:** (formatação, falta de ponto e vírgula, etc.; nenhuma mudança no código de produção)
 - **Refactor:** (refatoração de código de produção, por exemplo, renomeando uma variável) 
 - **Test:** (adicionando testes que estavam faltando, refatorando testes; nenhuma mudança no código de produção)
### Equipe
❤️ Feito com carinho por:
- [Ana Romera](https://github.com/anaBeatrizRomera)
