package de.seuhd.campuscoffee.domain.implementation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import de.seuhd.campuscoffee.domain.model.objects.Pos;
import de.seuhd.campuscoffee.domain.ports.data.CrudDataService;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;


public class CrudServiceTest {
    @Mock
    private CrudDataService<Pos,Long> crudDataService;

    @InjectMocks
    private CrudServiceImpl<Pos,Long> crudService = new CrudServiceImpl<>(Pos.class) {
        @Override
        protected CrudDataService<Pos, Long> dataService() {
            return crudDataService;
        }
    };

    // Initializing mocks -  @BeforeEach was built with the help of  Ai, because code was not compiling due to Null errors for mocks
    //tried to iniitialize mocks otherwise but we couldn't make it work
    @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

    // testing clear method
    @Test 
    void clearFomDataServiceClear(){
        crudService.clear();
        verify(crudDataService, times(1)).clear();
    }
    
    //testing  delete method 
    @Test
    void deleteFromDataServiceDelete(){
        Pos pos = TestFixtures.getPosFixtures().getFirst();
        Assertions.assertNotNull(pos.id());
        crudService.delete(pos.id());
        verify(crudDataService, times(1)).delete(pos.id());
    }   
}
