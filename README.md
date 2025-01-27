<h1>Java Excel Reader - Documentação</h1>
<h2>Introdução</h2>

Java Excel Reader é uma aplicação web projetada para importar, processar e analisar dados de arquivos Excel (.xlsx). Utilizando tecnologias robustas como Java, Spring, Hibernate, Lombok, Flyway, Apache POI, e PostgreSQL, a aplicação visa proporcionar uma leitura eficiente e organizada dos dados, com foco na melhoria da gestão de tickets de suporte e desenvolvimento.

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li><strong>Java:</strong> Linguagem principal de desenvolvimento.</li>
  <li><strong>Spring:</strong> Framework para desenvolvimento da aplicação web.</li>
  <li><strong>Hibernate:</strong> Framework ORM para gerenciar as interações com o banco de dados.</li>
  <li><strong>Lombok:</strong> Biblioteca para reduzir o boilerplate de código.</li>
  <li><strong>Flyway:</strong> Ferramenta para controle de versões de banco de dados.</li>
  <li><strong>Apache POI:</strong> Biblioteca para manipulação de arquivos Excel.</li>
  <li><strong>PostgreSQL:</strong> Sistema de gerenciamento de banco de dados relacional.</li>
</ul>

<h2>Funcionalidades</h2>

<h3>Importação de Dados do Excel</h3>
<p>A principal funcionalidade do <strong>Java Excel Reader</strong> é a capacidade de importar dados de arquivos Excel para o banco de dados <strong>PostgreSQL</strong>. A estrutura de dados que será processada está organizada de forma a refletir os seguintes campos:</p>
<ul>
  <li><strong>Status do Ticket</strong></li>
  <li><strong>Ticket</strong></li>
  <li><strong>Descrição do Ticket</strong></li>
  <li><strong>Tipo de Associação</strong></li>
  <li><strong>Identificação da Associação</strong></li>
  <li><strong>Descrição da Associação</strong></li>
  <li><strong>Nome do Solicitante</strong></li>
  <li><strong>Nome do Avaliador Técnico</strong></li>
  <li><strong>Tipo de Desenvolvedor</strong></li>
  <li><strong>Nome do Desenvolvedor</strong></li>
  <li><strong>Prioridade</strong></li>
  <li><strong>Motivo da Solicitação</strong></li>
  <li><strong>Equipe de Trabalho</strong></li>
  <li><strong>Módulo</strong></li>
  <li><strong>Etapa</strong></li>
  <li><strong>Data de criação do ticket</strong></li>
  <li><strong>Data de encerramento do ticket</strong></li>
  <li><strong>Status do Documento</strong></li>
  <li><strong>Tipo de Solicitação</strong></li>
  <li><strong>Documento Reprovado</strong></li>
  <li><strong>Motivo da Reprovação</strong></li>
  <li><strong>Complexidade</strong></li>
  <li><strong>Volume de Trabalho</strong></li>
  <li><strong>Total Esforço Previsto (Hs)</strong></li>
  <li><strong>Prazo de entrega do Desenvolv.</strong></li>
  <li><strong>Total Esforço Adicional (Hs)</strong></li>
  <li><strong>Esforço Previsto + Horas Adicionais (Hs)</strong></li>
  <li><strong>Esforço Real (Hs)</strong></li>
  <li><strong>Término Real do Desenvolv.</strong></li>
  <li><strong>Status do Desenvolvimento</strong></li>
  <li><strong>Change Requests</strong></li>
  <li><strong>data_atual</strong></li>
  <li><strong>Data tratada</strong></li>
  <li><strong>Data_Convertida</strong></li>
</ul>

<h3>Exemplos de Consultas Realizadas</h3>
<p>A aplicação realiza diversas consultas. Aqui estão exemplos de respostas em <strong>JSON</strong> para algumas das operações que podem ser realizadas.</p>

<h4>Exemplo de Consulta 1: Buscar Tickets Abertos</h4>
<pre>
{
  "status": "Abertos",
  "tickets": [
    {
      "ticket": "TICKET-1234",
      "descricao": "Descrição do Ticket 1",
      "tipo_associacao": "Tipo 1",
      "solicitante": "João Silva",
      "avaliador_tecnico": "Maria Oliveira",
      "prioridade": "Alta",
      "data_criacao": "2025-01-01",
      "prazo_entrega": "2025-01-15"
    },
    {
      "ticket": "TICKET-5678",
      "descricao": "Descrição do Ticket 2",
      "tipo_associacao": "Tipo 2",
      "solicitante": "Carlos Souza",
      "avaliador_tecnico": "Ana Pereira",
      "prioridade": "Média",
      "data_criacao": "2025-01-05",
      "prazo_entrega": "2025-01-20"
    }
  ]
}
</pre>

<h4>Exemplo de Consulta 2: Buscar Tickets por Desenvolvedor</h4>
<pre>
{
  "desenvolvedor": "Lucas Martins",
  "tickets": [
    {
      "ticket": "TICKET-2468",
      "descricao": "Descrição do Ticket 3",
      "modulo": "Módulo A",
      "data_encerramento": "2025-01-10",
      "status": "Fechado"
    },
    {
      "ticket": "TICKET-1357",
      "descricao": "Descrição do Ticket 4",
      "modulo": "Módulo B",
      "data_encerramento": "2025-01-12",
      "status": "Fechado"
    }
  ]
}
</pre>

<h4>Exemplo de Consulta 3: Consultar Todos os Tickets Reprovados</h4>
<pre>
{
  "status_documento": "Reprovado",
  "tickets": [
    {
      "ticket": "TICKET-9999",
      "motivo_reprovacao": "Erro na implementação",
      "data_reprovacao": "2025-01-15"
    },
    {
      "ticket": "TICKET-8888",
      "motivo_reprovacao": "Falta de testes",
      "data_reprovacao": "2025-01-18"
    }
  ]
}
</pre>

<h2>Consultas Realizadas</h2>

<h3>1. Consulta de Tickets Ativos</h3>
<p>Essa consulta retorna os tickets que estão em andamento ou com status "Em Progresso".</p>
<h4>Exemplo de JSON:</h4>
<pre>
[
  {
    "ticket": "TKT001",
    "statusTicket": "Em Progresso",
    "descricaoTicket": "Erro na integração de API",
    "nomeSolicitante": "João Silva",
    "nomeAvaliadorTecnico": "Carlos Almeida",
    "prioridade": "Alta",
    "esforçoPrevisto": 40,
    "esforçoReal": 30,
    "dataCriacao": "2025-01-10T08:00:00",
    "dataEncerramento": null
  },
  {
    "ticket": "TKT002",
    "statusTicket": "Em Progresso",
    "descricaoTicket": "Ajuste no layout da tela de login",
    "nomeSolicitante": "Maria Oliveira",
    "nomeAvaliadorTecnico": "Luciana Mendes",
    "prioridade": "Média",
    "esforçoPrevisto": 24,
    "esforçoReal": 10,
    "dataCriacao": "2025-01-12T09:00:00",
    "dataEncerramento": null
  }
]
</pre>

<h3>2. Consulta de Tickets por Prioridade</h3>
<p>Essa consulta retorna os tickets filtrados pela prioridade (por exemplo, "Alta").</p>
<h4>Exemplo de JSON:</h4>
<pre>
[
  {
    "ticket": "TKT003",
    "statusTicket": "Em Progresso",
    "descricaoTicket": "Correção de falha no cálculo de imposto",
    "nomeSolicitante": "Pedro Rocha",
    "nomeAvaliadorTecnico": "Aline Souza",
    "prioridade": "Alta",
    "esforçoPrevisto": 50,
    "esforçoReal": 45,
    "dataCriacao": "2025-01-05T10:00:00",
    "dataEncerramento": null
  }
]
</pre>

<h3>3. Consulta de Tickets por Status de Documento</h3>
<p>Consulta os tickets com documentos reprovados.</p>
<h4>Exemplo de JSON:</h4>
<pre>
[
  {
    "ticket": "TKT004",
    "statusDocumento": "Reprovado",
    "documentoReprovado": "Sim",
    "motivoReprovacao": "Formato inválido",
    "nomeSolicitante": "Ana Costa",
    "nomeAvaliadorTecnico": "Ricardo Pereira",
    "prioridade": "Baixa",
    "dataCriacao": "2025-01-20T14:00:00",
    "dataEncerramento": null
  }
]
</pre>

<h3>4. Consulta de Esforço Real vs. Esforço Previsto</h3>
<p>Essa consulta retorna os tickets com discrepância entre o esforço previsto e o esforço real.</p>
<h4>Exemplo de JSON:</h4>
<pre>
[
  {
    "ticket": "TKT005",
    "descricaoTicket": "Desenvolvimento de nova funcionalidade de exportação",
    "esforçoPrevisto": 100,
    "esforçoReal": 120,
    "dataCriacao": "2025-01-15T11:00:00",
    "dataEncerramento": "2025-01-25T15:00:00"
  }
]
</pre>

<h3>5. Consulta de Tickets por Data de Criação</h3>
<p>Essa consulta retorna tickets criados em um período específico.</p>
<h4>Exemplo de JSON:</h4>
<pre>
[
  {
    "ticket": "TKT006",
    "statusTicket": "Fechado",
    "descricaoTicket": "Correção de bugs no módulo de pagamentos",
    "nomeSolicitante": "Lucas Martins",
    "nomeAvaliadorTecnico": "Fernanda Silva",
    "prioridade": "Alta",
    "esforçoPrevisto": 60,
    "esforçoReal": 58,
    "dataCriacao": "2025-01-10T13:00:00",
    "dataEncerramento": "2025-01-20T17:00:00"
  }
]
</pre>

<h2>Estrutura do Banco de Dados</h2>
<p>A aplicação utiliza o <strong>PostgreSQL</strong> como sistema de banco de dados, com uma estrutura de tabelas que armazena os dados dos tickets, dos desenvolvedores, das equipes e outras informações pertinentes à análise dos tickets de suporte e desenvolvimento.</p>

<h2>Processamento e Análise de Dados</h2>
<p>Após importar os dados, a aplicação permite a análise detalhada de métricas como:</p>
<ul>
  <li>Tempo estimado vs. tempo real para o desenvolvimento de tickets.</li>
  <li>Status de tickets em tempo real.</li>
  <li>Priorização de tickets com base em diferentes parâmetros.</li>
  <li>Esforço real vs. esforço previsto para cada ticket.</li>
</ul>

<h2>Controle de Versão de Banco de Dados</h2>
<p>Através do <strong>Flyway</strong>, a aplicação mantém um histórico de alterações no banco de dados, garantindo que as versões de esquema sejam controladas e que a integridade dos dados seja preservada.</p>

<h2>Geração de Relatórios</h2>
<p>A aplicação oferece a possibilidade de gerar relatórios em diversos formatos, para facilitar a visualização e o acompanhamento do progresso dos tickets. Os relatórios podem incluir detalhes como:</p>
<ul>
  <li>Status de cada ticket.</li>
  <li>Prazo de entrega.</li>
  <li>Esforço adicional registrado.</li>
  <li>Histórico de mudanças.</li>
</ul>

<h2>Estrutura do Projeto</h2>
<p>O projeto segue uma estrutura modular e organizada, dividida em camadas de responsabilidade, facilitando a manutenção e a expansão do sistema.</p>

<h3>Camada de Modelo (Entities)</h3>
<p>A camada de modelo contém as entidades do banco de dados, como Ticket, Associacao, Desenvolvedor, Equipe, entre outras. Cada uma dessas entidades representa uma tabela no banco de dados e é mapeada usando o <strong>Hibernate</strong>.</p>

<h3>Camada de Repositórios (Repositories)</h3>
<p>A camada de repositórios é responsável pela interação com o banco de dados. Utilizando o <strong>Spring Data JPA</strong>, os repositórios proporcionam uma interface para realizar operações de CRUD (Create, Read, Update, Delete) nas entidades.</p>

<h3>Camada de Serviço (Services)</h3>
<p>A camada de serviço é responsável pela lógica de negócios da aplicação. Aqui, a lógica de importação de arquivos Excel, processamento de dados e análise das informações é executada.</p>

<h3>Camada de Controladores (Controllers)</h3>
<p>Os controladores gerenciam as requisições HTTP e respondem com as informações apropriadas, utilizando os serviços definidos na camada anterior.</p>

<h2>Configuração de Banco de Dados</h2>

<h3>Banco de Dados PostgreSQL</h3>
<p>O <strong>PostgreSQL</strong> é utilizado como banco de dados relacional. Para configurar a conexão com o banco, é necessário modificar o arquivo <code>application.properties</code> com as informações de conexão, como o nome do banco, usuário e senha.</p>

<h3>Flyway</h3>
<p>O <strong>Flyway</strong> é configurado para garantir que todas as migrações de banco de dados sejam aplicadas de forma sequencial, permitindo que o esquema do banco de dados seja mantido em sincronia com o código da aplicação.</p>

<h2>Como Executar</h2>
<p>Clone o repositório:</p>
<pre>
git clone https://github.com/usuario/java-excel-reader.git
</pre>

<p>Navegue até a pasta do projeto:</p>
<pre>
cd java-excel-reader
</pre>

<p>Importe as dependências do Maven:</p>
<pre>
mvn clean install
</pre>

<p>Configure o banco de dados no arquivo <code>application.properties</code>:</p>
<pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
</pre>

<p>Execute a aplicação:</p>
<pre>
mvn spring-boot:run
</pre>

<h2>Contribuindo</h2>
<p>Se você quiser contribuir para o desenvolvimento do Java Excel Reader, sinta-se à vontade para enviar um pull request ou abrir uma issue.</p>

<h2>Licença</h2>

<p>Este projeto está licenciado sob a <a href="https://opensource.org/licenses/MIT" target="_blank">Licença MIT</a>.</p>
