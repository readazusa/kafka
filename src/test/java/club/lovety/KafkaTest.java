package club.lovety;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Properties;

/**
 * Created by 念梓  on 2016/12/16.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class KafkaTest {

    private static final Logger log = LogManager.getLogger(KafkaTest.class);

    @Test
    public void produce() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "1551sp9557.imwork.net:5555");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("mylove", Integer.toString(i), Integer.toString(i)));
            log.debug("发送了数据： {}", i);
        }
        log.info("==================发送数据成功====================");

        producer.close();
    }

    @Test
    public void consumse() {

    }


}
