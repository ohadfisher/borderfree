package com.borderfree.library;

import com.borderfree.library.domain.BookEntity;
import com.borderfree.library.domain.CatalogEntry;
import com.borderfree.library.domain.Reader;
import com.borderfree.library.repository.BookRepository;
import com.borderfree.library.repository.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// todo comment change the @component to @Repository
// todo comment
// todo comment
// todo comment

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

/*
 * IMPORTANT!
 * Please don't remove this file. And change only if needed due to refactoring.
 */
@Component
@RequiredArgsConstructor
public class RepositoryDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${repository.reInitDataOnStart:true}")
    private boolean reInitDataOnStart;

    private final BookRepository bookRepository;
    private final ReadersRepository readersRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (reInitDataOnStart) {
            initBooks();
            initReaders();
        }
    }

    private void initBooks() {
        bookRepository.deleteAll();
        List<BookEntity> bookEntities = List.of(
                new BookEntity("978-1-60309-454-2", "Hannah Templer", "Cosmoknights (Book One)", 2,
                        new CatalogEntry("QA 200.86.S50")),
                new BookEntity("978-1-60309-454-3", "Hannah Templer", "Cosmoknights (Book Two)", 2,
                        new CatalogEntry("QA 200.86.S51")),
                new BookEntity("978-1-60309-454-4", "Duane Murray;Hannah Templer", "Zoo Story", 4,
                        new CatalogEntry("QA 320.547.X22")),
                new BookEntity("978-1-60309-495-5", "Duane Murray;Shawn Daley", "Better Place", 5,
                        new CatalogEntry("Z668 .R365 2000")),
                new BookEntity("978-1-891830-69-3", "Nicolas Mahler", "Lone Racer", 3,
                        new CatalogEntry("X3529 10.17 B158"))
        );
        bookRepository.saveAll(bookEntities);
    }

    private void initReaders() {
        readersRepository.deleteAll();
        List<Reader> readers = new ArrayList<>();
        Reader r1 = new Reader();
        r1.setFirstName("Jessica");
        r1.setLastName("Anslow");
        readers.add(r1);
        Reader r2 = new Reader();
        r2.setFirstName("David");
        r2.setLastName("Dawson");
        readers.add(r2);
        readersRepository.saveAll(readers);
    }
}
