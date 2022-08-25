package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.Reader;

import com.example.readerlibrary.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    public void addReader(Reader reader) {
        readerRepository.save(reader);
    }

    public void updateReader(Reader reader, Integer id) {
        Reader oldReader=readerRepository.getById(id);
        oldReader.setReaderName(reader.getReaderName());
        readerRepository.save(oldReader);
    }
    public void deleteReader(Integer id) {
        Reader reader=readerRepository.getById(id);
        readerRepository.delete(reader);
    }

}
