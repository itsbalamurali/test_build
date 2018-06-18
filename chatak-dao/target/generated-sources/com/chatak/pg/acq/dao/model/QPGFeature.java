package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFeature is a Querydsl query type for PGFeature
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeature extends EntityPathBase<PGFeature> {

    private static final long serialVersionUID = -271606265L;

    public static final QPGFeature pGFeature = new QPGFeature("pGFeature");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> featureLevel = createNumber("featureLevel", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> refFeatureId = createNumber("refFeatureId", Long.class);

    public final StringPath roleType = createString("roleType");

    public QPGFeature(String variable) {
        super(PGFeature.class, forVariable(variable));
    }

    public QPGFeature(Path<? extends PGFeature> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFeature(PathMetadata<?> metadata) {
        super(PGFeature.class, metadata);
    }

}

