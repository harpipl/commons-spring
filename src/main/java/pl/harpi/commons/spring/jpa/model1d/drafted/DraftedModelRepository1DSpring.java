package pl.harpi.commons.spring.jpa.model1d.drafted;

import org.springframework.transaction.annotation.Transactional;
import pl.harpi.commons.jpa.model.IDraftedModelRepository;
import pl.harpi.commons.jpa.model.ObjectDto;
import pl.harpi.commons.jpa.model.ObjectInstance;
import pl.harpi.commons.jpa.model1d.drafted.*;

@Transactional
public abstract class DraftedModelRepository1DSpring<T extends ObjectDto, O extends DraftedObjectIdentity1D<T, O, V, I>,
        V extends DraftedObjectVersion1D<T, O, V, I>, I extends ObjectInstance> extends DraftedModelRepository1D<T, O, V, I>
        implements IDraftedModelRepository<DraftedOperationContext1D, DraftedObjectSelector1D, T, O, V, I, DraftedVersionDefinition1D> {

    public DraftedModelRepository1DSpring(Class<T> clazzDto, Class<O> clazzObject, Class<V> clazzVersion, Class<I> clazzInstance) {
        super(clazzDto, clazzObject, clazzVersion, clazzInstance);
    }
}
