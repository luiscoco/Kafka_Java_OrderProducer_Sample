https://github.com/luiscoco/Kafka_Java_Producer/

## Create a new Java application with VSCode

We create a new folder to place the Java application.

We right click inside the folder and we select the option **Open with VSCode**.

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/b6e778bf-c0cf-444c-b94c-42914f54180e)

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/eddfc3ef-f7ed-42b6-aa8f-5ff29088b145)

We press the keys **Ctl+Shift+P** to create a **new Java application in VSCode**

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/c5b3aed1-3a50-40c1-8cab-51f17e74fc6c)

We select the first option **No build tools**

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/dbd6f666-a160-412b-9bbc-902249801a13)

Now we select the folder where to place the new Java application

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/3d4d2d05-ddd3-4b93-8b8f-59e9d20f739f)

We set the new Java application name **OrderProducer**. The new Java application is created:

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/7da21ea6-78e6-4b76-b2bc-931ac144c13e)

We run this command to **compile the application** and generate the **App.class** file

```
C:\Kafka with Java\OrderProducer> javac src/App.java
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/c8525741-2316-4796-addc-7dca1d266c44)

For **running the application** we type the command:

```
C:\Kafka with Java\OrderProducer> java -cp src App  
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/d4a98fb5-6da1-4398-b945-44be81cd9cfa)

## Enter the Kafka producer Java application source code and compile and run it

Now we enter the **Kafka Producer source code** in VSCode

```java
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class KafkaProducerApp {
    public static void main(String[] args) {
        // Set up producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Produce a message
        String topic = "your-topic";
        String key = "key1";
        String value = "Hello, Kafka!";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        // Send the message
        producer.send(record);

        // Close the producer
        producer.close();
    }
}
```

Then we rename the application name to **KafkaProducerApp**

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/9d9b1986-e974-4752-a3c2-822597b69e37)

Now we create a new file called **log4j.properties** in the applicaton root and we input the following code:

```
log4j.rootLogger=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/3ad0f409-7cfd-40cf-9557-4e3ed6398cd2)

Then we **donwload Kafka JAR files** from Apache Kafka web page (https://kafka.apache.org/downloads), and we place the JAR files in the Kafka producer Java application **lib** folder

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/3c5dd16e-8d37-4f45-8d28-09a16cc0bf61)

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/d0f37880-3f67-4dd9-a2bc-01eef311bc08)

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/4d6e6392-6ec9-4c0b-afe5-e63f8582a769)

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/aa7729cc-90c5-4d03-b32b-57de9898b4d2)

To **compile the application** with this command:

```
C:\Kafka with Java\OrderProducer> javac -cp "lib/*;src" src/KafkaProducerApp.java
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/38718465-2739-4b29-aa67-bc8c1ab9616a)

Finally, we **run the application** with this command:

```
C:\Kafka with Java\OrderProducer> java -cp "lib/*;src;." KafkaProducerApp
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/86cffc0e-659b-4746-a563-698b0deabc7c)

## How to run the Consumer and the Producer Java applications

### 1. First we have to run the **zookeeper-server-start** command

```
zookeeper-server-start C:\kafka_2.13-3.6.0\config\zookeeper.properties
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/adcdaea3-ba9a-4feb-87de-db5f65dc850c)

### 2. Open a command prompt window and run the command **kafka-server-start**

```
kafka-server-start C:\kafka_2.13-3.6.0\config\server.properties
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/64a7c126-3dbf-489a-876d-993a9986197b)

### 3. Then open with VSCode the **Kafka Consumer** application and run it

To **compile** the Kafka Consumer Java application

```
C:\Kafka with Java\OrderConsumer> javac -cp "lib/*;src" src/KafkaConsumerApp.java
```

To **run** the Kafka Consumer Java application

```
C:\Kafka with Java\OrderConsumer> java -cp "lib/*;src;." KafkaConsumerApp
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/0c03893c-0fd5-465c-905a-6fb88752fae1)

### 4. Then open with VSCode the **Kafka Producer** application and run it

To **compile** the Kafka Consumer Java application

```
C:\Kafka with Java\OrderProducer> javac -cp "lib/*;src" src/KafkaProducerApp.java
```

To **run** the Kafka Producer Java application

```
C:\Kafka with Java\OrderProducer> java -cp "lib/*;src;." KafkaProducerApp
```

![image](https://github.com/luiscoco/Kafka_Java_Training/assets/32194879/40403620-3a24-498e-8f76-a33ea5737ca0)

