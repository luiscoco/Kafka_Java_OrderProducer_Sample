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
        String value = "Hello Luis From Kafka!";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        // Send the message
        producer.send(record);

        // Close the producer
        producer.close();
    }
}
