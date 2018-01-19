package pl.harpi.commons.spring.jpa.model1d;

import org.springframework.transaction.annotation.Transactional;
import pl.harpi.commons.jpa.model.IModelRepository;
import pl.harpi.commons.jpa.model.ObjectDto;
import pl.harpi.commons.jpa.model.ObjectInstance;
import pl.harpi.commons.jpa.model1d.*;

@Transactional
public abstract class ModelRepository1DSpring<T extends ObjectDto, O extends ObjectIdentity1D<T, O, V, I>,
        V extends ObjectVersion1D<T, O, V, I>, I extends ObjectInstance> extends ModelRepository1D<T, O, V, I>
        implements IModelRepository<OperationContext1D, ObjectSelector1D, T, O, V, I, VersionDefinition1D> {

    public ModelRepository1DSpring(Class<T> clazzDto, Class<O> clazzObject, Class<V> clazzVersion, Class<I> clazzInstance) {
        super(clazzDto, clazzObject, clazzVersion, clazzInstance);
    }
}
