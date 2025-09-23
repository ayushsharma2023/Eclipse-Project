package com.Crystophere.Bhai.journalApp.Controller;
import com.Crystophere.Bhai.journalApp.entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class   JournalEntryController {
 private Map<Long,JournalEntry> map= new HashMap<>();
   @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(map.values());

 }
 @PostMapping
 public boolean createEntry(@RequestBody JournalEntry myEntry){
  map.put(myEntry.getId(),myEntry);
  return true;
 }
 @GetMapping("id/{myId}")
    public JournalEntry findByGeneralEntries(@PathVariable Long myId){

        return map.get(myId);
    }
@DeleteMapping("id/{myId}")
public JournalEntry deleteEntity(@PathVariable long myId){

       return map.remove(myId);
}
    @PutMapping("id/{myId}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable long myId, @RequestBody JournalEntry myEntry) {
        if (!map.containsKey(myId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        JournalEntry oldEntry = map.put(myId, myEntry);
        return ResponseEntity.ok(oldEntry);
    }}
