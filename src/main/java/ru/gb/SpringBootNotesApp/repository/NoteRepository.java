package ru.gb.SpringBootNotesApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.SpringBootNotesApp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {


}