package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;
import com.example.readerlibrary.Model.Reader;
import com.example.readerlibrary.Service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public ResponseEntity getReaders(){
        return ResponseEntity.status(HttpStatus.OK).body(readerService.getReaders());
    }
    @PostMapping("/add")
    public ResponseEntity addReader(@RequestBody Reader reader){
        readerService.addReader(reader);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Reader added !",201));
    }

    @PutMapping("/edit")
    public ResponseEntity<Api> updateReader(@RequestBody Reader reader,@PathVariable Integer id){
        readerService.updateReader(reader, id);
        return ResponseEntity.status(201).body(new Api("Reader data updated !",201));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Api> deleteReader(@PathVariable Integer id){
        readerService.deleteReader(id);
        return ResponseEntity.status(201).body(new Api("Reader deleted !",201));
    }
}
