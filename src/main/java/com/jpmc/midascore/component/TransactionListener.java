package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class TransactionListener {

    private static final Logger log = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(
            topics    = "${transactions.topic.name}",
            groupId   = "${spring.kafka.consumer.group-id}"
    )
    public void handleTransaction(Transaction tx) {
        log.info(">>> got transaction: {}", tx);
        // put a breakpoint on the next line:
        System.out.println("DEBUG POINT – transaction = " + tx);
    }
}