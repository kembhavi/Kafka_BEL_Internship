//This Consumer is for Retrieving the C++ Information

package com.howtoprogram.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer_3 {

  public static void main(String[] args) {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "group-1");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "100");
    props.put("auto.offset.reset", "earliest");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
    kafkaConsumer.subscribe(Arrays.asList("BEL_INTERNSHIP_Kafka"));
    while (true) {
      ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
     // System.out.println(Arrays.asList("HelloKafkaTopic"));
      for (ConsumerRecord<String, String> record : records) {
    	  String s1=record.value();
      if(s1.contains("C++")==true) {
        System.out.println("Partition: " + record.partition() + " Offset: " + record.offset()
            + " Value: " + record.value() + " ThreadID: " + Thread.currentThread().getId());
      }
    }
    }

  }

}
