## Sobre o projeto

pix-produtor é um projeto para fins de aprendizado relacionado ao apache kafka.

---

## Funcionalidades

- [x] Envio de solitação de um pix para o broker;
- [x] Validar Pix;
- [x] Cadastrar chaves Pix;
- [x] Validar chaves Pix;
- [x] Agora a aplicacao nao manda mais para o kafka e sim para o banco, utilizando o kafka connect
- [x] Url e porta para o confluent local http://localhost:9021/clusters


---

## Layout

O projeto desse repositório é apenas a API Backend.

---

## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Kafka 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[Confluent](https://www.confluent.io/what-is-apache-kafka/)**
- **[Apache Avro](https://avro.apache.org/)**



## Alterações

-  Integrar o Spring com o Kafka, utilizando bibliotecas específicas que facilitam a integração do Kafka com uma aplicação Spring, de acordo com seus padrões de inversão de controle e injeção de dependência.;
-  Implementar um produtor do Kafka com o Spring, que vai enviar as mensagens com informações do PIX, usando a biblioteca spring-kafka. Para a implementação do produtor usamos a classe KafkaTemplate, onde temos o método send, no qual podemos definir um tópico para enviar uma mensagem. Ainda neste método, enviamos um objeto como parâmetro que será serializado como um JSON para ser armazenado no Kafka.;
-  Implementar um consumidor do Kafka com o Spring, que vai processar as mensagens com informações dos pagamentos que foram enviadas para o Kafka. Para a implementação do consumidor usamos a anotação @KafkaListener, que define um método que será executado sempre que uma mensagem for recebida em um tópico.;
-  Confluent, uma plataforma que permite usar ferramentas dentro do Kafka, como o Schema Registry e o Kafka Connect. O Kafka, nessa plataforma, possui exatamente as mesmas funcionalidades, mas essas outras ferramentas adicionam ainda mais poderes a ele.
-  Schema Registry é uma ferramenta externa para o registro e validação do schema das mensagens em um tópico do Kafka. Quando é adicionado, o produtor envia um schema para a ferramenta Schema Registry e só depois disso a mensagem será enviada para o Kafka. Em seguida, o consumidor vai receber a mensagem com o schema, permitindo que valide se os dados estão corretos ou não.
-  Apache Avro é uma biblioteca de serialização e desserialização de dados que faz a validação com dados binários, diminuindo o tamanho das mensagens e acelerando a transmissão dos dados. Para usar essa biblioteca, foi necessário adicionar as dependências do Avro, e gerar o código do Avro usado o plugin avro-maven-plugin, com isso não precisamos nos preocupar em fazer a serialização e deserialização dos dados no formato binário, o código gerado se encarrega dessa atividade.
-  Kafka Connect é uma ferramenta que consegue se comunicar diretamente com diversas fontes de dados, sem ter que escrever nenhum código para isso. Apenas precisamos configurar a conexão com o banco de dados diretamente no console do Confluent e, depois disso, automaticamente qualquer registro que for salvo no banco de dados será enviado para o tópico do Kafka.
-  Kafka Connect, não precisamos de uma aplicação produtora, apenas tivemos que alterar a nossa aplicação para que os dados fossem salvos no banco de dados, e com o Kafka Connect, os dados são enviados automaticamente para o tópico do Kafka.
-  Configurar uma fonte de dados no Confluent Kafka para que o Kafka Connect pegue diretamente no banco de dados os dados que adicionamos e mande para o tópico da aplicação. Vimos que precisamos instalar algumas dependências no Confluent antes e, depois, diretamente na interface do Confluent conseguimos configurar uma fonte de dados, que entre as várias opções, pode ser um banco de dados do PostgreSQL.