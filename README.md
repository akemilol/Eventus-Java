# 🌎 Eventus – Global Solution FIAP 2025 | Java & Cloud ☁️

## ✨ Sobre o Projeto

O **Eventus** é a solução para o Global Solution FIAP 2025:  
um sistema completo de monitoramento, detecção e alerta para eventos extremos como chuvas intensas, ondas de calor e tremores.  
Eventus antecipa riscos, protege comunidades e permite respostas rápidas em situações de emergência.

---

## 🎬 Vídeos:

- [🔗 Vídeo de Demonstração](https://youtu.be/TF1KKYguWhs)
- [🔗 PITCH](https://youtu.be/OAyBGUx5pc8)

---

### 🚀 Funcionalidades
- Cadastro de usuário (ADMIN/USER), autenticação segura (JWT)
- Cadastro e consulta de alertas, relatos, abrigos
- Relacionamento entre entidades (Usuário-Relato, Usuário-Alerta, Usuário-Abrigo)
- Banco PostgreSQL (via JPA/Hibernate)
- Documentação via Swagger

### 🛠️ Arquitetura & Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- Swagger/OpenAPI
- PostgreSQL
- Docker

---
### O projeto pode ser rodado tanto localmente quanto pelo Deploy.

## 💻 Deploy:
```bash
http://4.201.184.187:8080/swagger-ui.html
```
---
# ☁️ Parte 2: Eventus (Cloud & Docker)

## 🌍 Deploy Cloud — Como Funciona:
A API Eventus está **100% operacional na Azure**, utilizando práticas de containerização Docker para garantir escalabilidade, portabilidade e alta disponibilidade.

- São **dois containers Docker** rodando na mesma VM Linux:  
  1️⃣ Um para a API Java (Spring Boot)  
  2️⃣ Outro para o banco de dados PostgreSQL  
- Ambos conectados em uma **rede Docker** que garante segurança e performance.
- O banco utiliza usuário não-root e volume Docker para persistência de dados mesmo após reinícios.
- O acesso externo à API está liberado na porta 8080 da VM.

---

## 🎬 Vídeos:

- [🔗 Vídeo de Cloud](https://youtu.be/tOTVxaakXTU)

---

## 🔎 Como acessar a API e o Swagger na nuvem
Acesse a documentação interativa da API Eventus diretamente pelo navegador:

```bash
http://4.201.184.187:8080/swagger-ui.html
```

## Pelo Swagger, você pode:
- Realizar cadastros, login e todas as operações CRUD dos módulos (usuário, alerta, relato, abrigos, vínculos)
- Autenticar e obter o token JWT para usar os endpoints protegidos
- Testar e visualizar em tempo real todos os retornos e respostas da API na cloud

---

## JSON
### POST /auth/register (Usuário ADMIN)

```bash
{
  "nomeUsuario": "Mirela Antunes",
  "emailUsuario": "Mirela.antunes@email.com",
  "senhaUsuario": "Senhamimi@2025",
  "cpfUsuario": "74335296315",
  "cepUsuario": "05055020",
  "dataNascimento": "1990-11-29",
  "role": "ADMIN"
}
```
### POST /auth/login (ADMIN)

```bash
{
  "email": "Mirela.antunes@email.com",
  "senha": "Senhamimi@2025"
}
```

### POST /alertas

```bash
{
  "tipoAlerta": "VENTANIA",
  "descricao": "Ventos fortes atingindo o bairro Jardim das Palmeiras.",
  "cepAlerta": "05055020",
  "dataHora": "2025-07-20T14:00:00Z"
}
```

### POST /relatos
```bash
{
  "usuarioIdUsuario": 3,
  "tipoRelato": "QUEDA DE ÁRVORES",
  "descricaoRelato": "Diversas árvores caídas após ventania.",
  "cepRelato": "05055020",
  "dataHoraRelato": "2025-07-20T16:00:00Z"
}
```
### POST /abrigos

```bash
{
  "usuarioIdUsuario": 3,
  "alertasId": 3,
  "dataRecebimento": "2025-07-20"
}
```
### Vínculo Usuário-Abrigo

```bash
{
  "usuarioIdUsuario": 3,
  "abrigosId": 3
}
```

### Vínculo Usuário-Alerta

```bash
{
  "usuarioIdUsuario": 3,
  "alertasId": 3,
  "dataRecebimento": "2025-07-20"
}
```

## 👩‍💻 Integrantes: 
- 💁‍♀️Valéria Conceição Dos Santos - RM: 557177
- 💁‍♀️Mirela Pinheiro Silva Rodrigues - RM: 558191
