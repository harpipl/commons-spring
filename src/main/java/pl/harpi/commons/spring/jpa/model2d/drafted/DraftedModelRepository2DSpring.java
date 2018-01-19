package pl.harpi.commons.spring.jpa.model2d.drafted;

import org.springframework.transaction.annotation.Transactional;
import pl.harpi.commons.jpa.model.IDraftedModelRepository;
import pl.harpi.commons.jpa.model.ObjectDto;
import pl.harpi.commons.jpa.model.ObjectInstance;
import pl.harpi.commons.jpa.model2d.drafted.*;

@Transactional
public abstract class DraftedModelRepository2DSpring<T extends ObjectDto, O extends DraftedObjectIdentity2D<T, O, V, I>,
        V extends DraftedObjectVersion2D<T, O, V, I>, I extends ObjectInstance> extends DraftedModelRepository2D<T, O, V, I>
        implements IDraftedModelRepository<DraftedOperationContext2D, DraftedObjectSelector2D, T, O, V, I, DraftedVersionDefinition2D> {
    
    public DraftedModelRepository2DSpring(Class<T> clazzDto, Class<O> clazzObject, Class<V> clazzVersion, Class<I> clazzInstance) {
        super(clazzDto, clazzObject, clazzVersion, clazzInstance);
    }
}
