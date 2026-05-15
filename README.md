## 📢 EAD-Notification-Hex

Microsserviço responsável pelo gerenciamento e processamento de notificações em uma plataforma EAD (Ensino a Distância), desenvolvido utilizando os princípios da Arquitetura Hexagonal (Ports and Adapters), Microsserviços, Mensageria Assíncrona e boas práticas de desenvolvimento com Spring Boot.

O serviço atua consumindo mensagens de outros microsserviços através de broker, registrando e gerenciando notificações relacionadas aos usuários matriculados em cursos da plataforma.

---

## 🧩 Visão Geral

O EAD-Notification-Hex faz parte de um ecossistema distribuído baseado em microsserviços e possui como principal responsabilidade:

Consumir eventos assíncronos via RabbitMQ
Persistir notificações de usuários
Gerenciar notificações relacionadas a cursos EAD
Disponibilizar comunicação síncrona via API REST
Participar da arquitetura distribuída através de Service Discovery

A aplicação foi estruturada utilizando Arquitetura Hexagonal, promovendo:

Baixo acoplamento
Alta testabilidade
Separação clara de responsabilidades
Independência entre domínio e infraestrutura
Facilidade de manutenção e evolução
🏗️ Arquitetura Utilizada
🔷 Arquitetura Hexagonal (Ports and Adapters)

O projeto foi desenvolvido seguindo o modelo de Arquitetura Hexagonal, separando:

Domínio da aplicação
Casos de uso
Portas de entrada e saída
Adaptadores externos
Infraestrutura

Essa abordagem permite que as regras de negócio permaneçam desacopladas de frameworks, banco de dados e mecanismos externos de comunicação.

## ⚙️ Tecnologias e Dependências

Principais tecnologias utilizadas no projeto:

Java

Spring Boot

Spring Web

Spring Security

Spring Validation

Spring Data JPA

RabbitMQ

Spring AMQP

PostgreSQL

H2 Database

Eureka Client

Spring Cloud Config

JWT Authentication

ModelMapper

Lombok

Log4j2

Spring Boot Actuator

---

## 🔄 Comunicação Entre Microsserviços
### 📬 Mensageria com RabbitMQ

O microsserviço atua como consumidor de eventos assíncronos enviados por outros serviços da plataforma.

Principais responsabilidades:
Escutar filas RabbitMQ
Consumir mensagens do tipo comando/evento
Processar notificações
Persistir informações no banco de dados
Garantir desacoplamento entre serviços
Benefícios:
Comunicação assíncrona
Alta escalabilidade
Resiliência
Menor acoplamento entre microsserviços

---

## 🌐 API REST

Além da mensageria, o serviço também disponibiliza endpoints REST para comunicação síncrona.

Funcionalidades:
Consulta de notificações
Gerenciamento de notificações
Validação de requisições
Respostas HTTP padronizadas

### ☁️ Configuração Centralizada

O EAD-Notification-Hex utiliza o Spring Cloud Config Server para gerenciamento centralizado das configurações da arquitetura.

### 🔧 Benefícios

Centralização das propriedades
Separação entre código e configuração
Configurações por ambiente
Facilidade de manutenção
Padronização entre microsserviços

### 📂 Configurações externas

RabbitMQ
Banco de dados
Eureka Server
JWT
Timeouts
Filas e exchanges
Variáveis sensíveis

### 🧭 Service Discovery

O microsserviço está integrado ao Netflix Eureka, permitindo:

Registro automático de serviços
Descoberta dinâmica de microsserviços
Balanceamento de carga
Comunicação distribuída

### 🔐 Segurança

A aplicação utiliza Spring Security com autenticação baseada em JWT (JSON Web Token).

Recursos implementados:
Autenticação via token
Proteção de endpoints
Validação de requisições autenticadas
Controle de acesso

### 🗄️ Persistência de Dados

O projeto utiliza:

PostgreSQL

Banco principal utilizado em ambiente real.

H2 Database

Banco em memória utilizado para desenvolvimento e testes locais.

---

## ⚠️ Tratamento Global de Exceções

A aplicação possui um tratamento centralizado de exceções, garantindo:

Respostas padronizadas

Melhor rastreabilidade

Facilidade de manutenção

Melhor experiência para consumidores da API

Exemplos de respostas:
404 Not Found


### 📊 Monitoramento

O projeto utiliza Spring Boot Actuator para monitoramento e observabilidade.

Recursos:

Health Check

Métricas

Informações da aplicação

Monitoramento de endpoints

### 🧪 Boas Práticas Aplicadas

Arquitetura Hexagonal

SOLID Principles

DTO Pattern

Repository Pattern

Service Layer

Clean Code

Mensageria Assíncrona

Separação de Responsabilidades

Configuração Centralizada

Microsserviços desacoplados

### 🚀 Benefícios da Solução

Alta escalabilidade

Baixo acoplamento

Facilidade de manutenção

Código desacoplado da infraestrutura

Melhor testabilidade

Comunicação assíncrona eficiente

Organização clara do domínio

### 📌 Observações

O EAD-Notification-Hex faz parte de uma arquitetura distribuída baseada em microsserviços voltada para uma plataforma EAD.

Sua responsabilidade é centralizar o processamento e gerenciamento de notificações de usuários relacionadas aos cursos da plataforma, garantindo comunicação desacoplada e processamento assíncrono eficiente.
