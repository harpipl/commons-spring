package pl.harpi.commons.spring.jpa.model2d;

import org.springframework.transaction.annotation.Transactional;
import pl.harpi.commons.jpa.model.IModelRepository;
import pl.harpi.commons.jpa.model.ObjectDto;
import pl.harpi.commons.jpa.model.ObjectInstance;
import pl.harpi.commons.jpa.model2d.*;

@Transactional
public abstract class ModelRepository2DSpring<T extends ObjectDto, O extends ObjectIdentity2D<T, O, V, I>,
        V extends ObjectVersion2D<T, O, V, I>, I extends ObjectInstance> extends ModelRepository2D<T, O, V, I>
        implements IModelRepository<OperationContext2D, ObjectSelector2D, T, O, V, I, VersionDefinition2D> {
    
    public ModelRepository2DSpring(Class<T> clazzDto, Class<O> clazzObject, Class<V> clazzVersion, Class<I> clazzInstance) {
        super(clazzDto, clazzObject, clazzVersion, clazzInstance);
    }
}
