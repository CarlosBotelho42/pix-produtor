## Sobre o projeto

pix-produtor é um projeto para fins de aprendizado relacionado ao apache kafka.

---

## Funcionalidades

- [x] Envio de solitação de um pix para o broker;
- [x] Validar Pix;
- [x] Cadastrar chaves Pix;
- [x] Validar chaves Pix;


---

## Layout

O projeto desse repositório é apenas a API Backend.

---

## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Kafka 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**



## Alterações

-  Integrar o Spring com o Kafka, utilizando bibliotecas específicas que facilitam a integração do Kafka com uma aplicação Spring, de acordo com seus padrões de inversão de controle e injeção de dependência.;
-  Implementar um produtor do Kafka com o Spring, que vai enviar as mensagens com informações do PIX, usando a biblioteca spring-kafka. Para a implementação do produtor usamos a classe KafkaTemplate, onde temos o método send, no qual podemos definir um tópico para enviar uma mensagem. Ainda neste método, enviamos um objeto como parâmetro que será serializado como um JSON para ser armazenado no Kafka.;
-  Implementar um consumidor do Kafka com o Spring, que vai processar as mensagens com informações dos pagamentos que foram enviadas para o Kafka. Para a implementação do consumidor usamos a anotação @KafkaListener, que define um método que será executado sempre que uma mensagem for recebida em um tópico.;
-  Confluent, uma plataforma que permite usar ferramentas dentro do Kafka, como o Schema Registry e o Kafka Connect. O Kafka, nessa plataforma, possui exatamente as mesmas funcionalidades, mas essas outras ferramentas adicionam ainda mais poderes a ele.
-  Schema Registry é uma ferramenta externa para o registro e validação do schema das mensagens em um tópico do Kafka. Quando é adicionado, o produtor envia um schema para a ferramenta Schema Registry e só depois disso a mensagem será enviada para o Kafka. Em seguida, o consumidor vai receber a mensagem com o schema, permitindo que valide se os dados estão corretos ou não.
-  Que o Apache Avro é uma biblioteca de serialização e desserialização de dados que faz a validação com dados binários, diminuindo o tamanho das mensagens e acelerando a transmissão dos dados. Para usar essa biblioteca, foi necessário adicionar as dependências do Avro, e gerar o código do Avro usado o plugin avro-maven-plugin, com isso não precisamos nos preocupar em fazer a serialização e deserialização dos dados no formato binário, o código gerado se encarrega dessa atividade.
