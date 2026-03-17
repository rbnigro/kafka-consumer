# kafka-Consumer
Utilizando Spring

# Subir Serviços

## 🧠 Visão mental
+ Producer → envia mensagem para um topic
+ Broker (Kafka) → armazena
+ Consumer → lê do topic
+ Consumer Group → controla paralelismo e offset

### Iniciar Zookeeper
+ cd\kafka\bin\windows
+ zookeeper-server-start.bat C:\kafka\config\zookeeper.properties

### Iniciar Kafka
+ cd\kafka\bin\windows
+ kafka-server-start.bat C:\kafka\config\server.properties

### Apagar tópicos
+ cd\kafka\bin\windows
+ kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic ecommerce.compras

### Verificações
+ cd\kafka\bin\windows
+ kafka-topics.bat --bootstrap-server localhost:9092 --describe
> ou 
+ cd\kafka\bin\windows
+ kafka-topics.bat --bootstrap-server localhost:9092 --list

### Versão
+ cd\kafka\bin\windows
+ kafka-topics.bat --version

### Criar Eventos
+ cd\kafka\bin\windows<br>
+ kafka-console-producer.bat --broker-list localhost:9092 --topic pagamento.request.topic.v1

### Ler Eventos
+ cd\kafka_2.13-3.6.1\bin\windows
+ .\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic pagamento.request.topic.v1 --from-beginning
> > > > Para pegar as mensagens desde o início. As que estão armazenadas no disco (--from-beginning)