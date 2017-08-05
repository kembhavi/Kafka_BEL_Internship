package com.howtoprogram.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerTest {

  public static void main(String[] args) {
    Properties props = new Properties();
   
    props.put("bootstrap.servers", "localhost:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("max.block.ms", 1000);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    Producer<String, String> producer = null;
    try {
      producer = new KafkaProducer<String, String>(props);
      for (int i = 0; i < 100; i++) {
    	  String msg=null;
    	  if(i%3==0)
    	  {
           msg = "Java Message " + i;

          }
      else if(i%3==1)
	  {
         msg = "C++ Message " + i;
      }
    else
	  {
         msg = "Python Message " + i;
     }
          producer.send(new ProducerRecord<String, String>("BEL_INTERNSHIP_Kafka", msg));
          System.out.println("Sent:" + msg);
    }
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      producer.close();
  }
    }

  

}
