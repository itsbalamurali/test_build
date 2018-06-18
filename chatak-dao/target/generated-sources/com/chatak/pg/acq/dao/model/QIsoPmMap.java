package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIsoPmMap is a Querydsl query type for IsoPmMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIsoPmMap extends EntityPathBase<IsoPmMap> {

    private static final long serialVersionUID = -267206990L;

    public static final QIsoPmMap isoPmMap = new QIsoPmMap("isoPmMap");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isoId = createNumber("isoId", Long.class);

    public final NumberPath<Long> pmId = createNumber("pmId", Long.class);

    public QIsoPmMap(String variable) {
        super(IsoPmMap.class, forVariable(variable));
    }

    public QIsoPmMap(Path<? extends IsoPmMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIsoPmMap(PathMetadata<?> metadata) {
        super(IsoPmMap.class, metadata);
    }

}

