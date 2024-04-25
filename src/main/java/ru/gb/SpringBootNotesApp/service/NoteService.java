package ru.gb.SpringBootNotesApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringBootNotesApp.model.Note;
import ru.gb.SpringBootNotesApp.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;

    private final AtomicLong count = new AtomicLong();

    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    public Note addNote(String description) {
        Note note = new Note();
        note.setId(count.incrementAndGet());
        note.setDescription(description);
        note.setDateOfCreation(LocalDateTime.now());
        return repository.save(note);
    }

    public Note getNoteById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Note updateNote(Long id, String description) {
        Note note = repository.findById(id).orElse(null);
        if (note != null) {
            note.setDescription(description);
            repository.save(note);
        }
        return note;
    }

    public void removeNote(Long id) {
        Note note = repository.findById(id).orElse(null);
        assert note != null;
        repository.delete(note);
    }
}