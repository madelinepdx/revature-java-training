package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    MessageRepository messageRepo;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account acc) {
        // check for blank username or short password
        if (acc.getUsername() == null || acc.getUsername().isBlank() ||
            acc.getPassword() == null || acc.getPassword().length() <4) {
                return ResponseEntity.badRequest().build();
            }

        // check if username is already taken
        if (accountRepo.findByUsername(acc.getUsername()).isPresent()) {
            return ResponseEntity.status(409).build();
        }

        //save new account
        Account saved = accountRepo.save(acc);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account acc) {
        Optional<Account> found = accountRepo.findByUsername(acc.getUsername());

        if (found.isPresent() && found.get().getPassword().equals(acc.getPassword())) {
            return ResponseEntity.ok(found.get());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage (@RequestBody Message msg) {
        
        if (msg.getMessageText() == null || msg.getMessageText().isBlank()
        || msg.getMessageText().length() > 255) {
            return ResponseEntity.badRequest().build();
        }
        if (!accountRepo.existsById(msg.getPostedBy())) {
            return ResponseEntity.badRequest().build();
        }
        Message saved = messageRepo.save(msg);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int message_id) {
        return messageRepo.findById(message_id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.ok(null));
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessage (@PathVariable int message_id) {
        if (messageRepo.existsById(message_id)) {
            messageRepo.deleteById(message_id);
            return ResponseEntity.ok(1);
    }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> updateMessage(@PathVariable int message_id, @RequestBody Message updatedMsg) {
        Optional<Message> optionalMsg = messageRepo.findById(message_id);
        if (optionalMsg.isPresent()) {
            String text = updatedMsg.getMessageText();
            if (text != null && !text.isBlank() && text.length() <= 255) {
                Message msg = optionalMsg.get();
                msg.setMessageText(text);
                messageRepo.save(msg);
                return ResponseEntity.ok(1);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getMessagesByUser(@PathVariable int account_id) {
        return messageRepo.findByPostedBy(account_id);
    }
}