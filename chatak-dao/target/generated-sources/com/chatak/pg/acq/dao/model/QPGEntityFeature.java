package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGEntityFeature is a Querydsl query type for PGEntityFeature
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGEntityFeature extends EntityPathBase<PGEntityFeature> {

    private static final long serialVersionUID = -1797035036L;

    public static final QPGEntityFeature pGEntityFeature = new QPGEntityFeature("pGEntityFeature");

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPGEntityFeature(String variable) {
        super(PGEntityFeature.class, forVariable(variable));
    }

    public QPGEntityFeature(Path<? extends PGEntityFeature> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGEntityFeature(PathMetadata<?> metadata) {
        super(PGEntityFeature.class, metadata);
    }

}

