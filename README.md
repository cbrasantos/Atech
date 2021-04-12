# empresa-area
API Rest para representar os voos de uma empresa aérea com seus respectivos horários.


# **Pipeline**

Para CI apesar de utilizar branch com master, poderia adotar o [gitflow](https://marketplace.atlassian.com/apps/1212520/git-flow-chart?hosting=cloud&tab=overview "gitflow"). Para CD este projeto possui  um dockerfile para utilizar com EC2 e compose para orquestração, a configuração do log esta sendo gerado no console e arquivo configurados no logback.xml.

# Swagger

Para acessar as api, podera utilizar o swagger em http://<host>:8089/empresa-aerea/swagger-ui.html


# DataSource

As configuração de banco podem-ser feita no application.yml

# Diagrama Ilustrado de uma arquitetura SaaS aplicados as seguintes clouds (AWS, Azure e GCP)

Os diagramas citados abaixo consideram as melhores praticas DevOps e os seguintes aspectos :
	-Segurança
	-Disponibilidade
	-Estabilidade
	-Escalabilidade

Nos diagramas escolhidos utilizei a plataforma de online [VisualParadigmOnline](https://online.visual-paradigm.com/pt/#)

# Arquitetura Azure

[Azure](https://online.visual-paradigm.com/app/diagrams/#diagram:proj=0&type=AzureDiagram&gallery=/repository/75644fbf-a8e2-4148-896c-6b0a0f254cf6.xml&name=Dev-Test%20PaaS-style%20System)

# Arquitetura AWS

[AWS](https://online.visual-paradigm.com/app/diagrams/#diagram:proj=0&type=AWSDiagram&gallery=/repository/b60c23ab-ddb2-4a7b-9a3a-3d509ee177c3.xml&name=Expedia%20Standard%20Deployment%20Architecture)

# Arquitetura GCP

[GCP](https://online.visual-paradigm.com/app/diagrams/#diagram:proj=0&type=GoogleCloudPlatformDiagram&gallery=/repository/ef9c864e-10e7-4081-9d86-ebdc3af4e7f6.xml&name=Jenkins%20on%20k8s)




