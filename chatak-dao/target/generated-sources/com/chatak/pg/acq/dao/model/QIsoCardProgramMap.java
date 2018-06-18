package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIsoCardProgramMap is a Querydsl query type for IsoCardProgramMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIsoCardProgramMap extends EntityPathBase<IsoCardProgramMap> {

    private static final long serialVersionUID = 784911413L;

    public static final QIsoCardProgramMap isoCardProgramMap = new QIsoCardProgramMap("isoCardProgramMap");

    public final NumberPath<Long> cardProgramId = createNumber("cardProgramId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isoId = createNumber("isoId", Long.class);

    public QIsoCardProgramMap(String variable) {
        super(IsoCardProgramMap.class, forVariable(variable));
    }

    public QIsoCardProgramMap(Path<? extends IsoCardProgramMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIsoCardProgramMap(PathMetadata<?> metadata) {
        super(IsoCardProgramMap.class, metadata);
    }

}

