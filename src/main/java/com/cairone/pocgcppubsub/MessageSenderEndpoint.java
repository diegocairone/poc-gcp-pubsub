package com.cairone.pocgcppubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairone.pocgcppubsub.App.PubsubOutboundGateway;

@RestController
public class MessageSenderEndpoint {

    @Autowired private PubsubOutboundGateway messagingGateway;

    @PostMapping("/publishMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public void publishMessage(@RequestBody MessageDto message) {
        messagingGateway.sendToPubsub(message.getText());
    }
}
