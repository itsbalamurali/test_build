package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGSubFeature is a Querydsl query type for PGSubFeature
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGSubFeature extends EntityPathBase<PGSubFeature> {

    private static final long serialVersionUID = -2013887515L;

    public static final QPGSubFeature pGSubFeature = new QPGSubFeature("pGSubFeature");

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final StringPath featureName = createString("featureName");

    public final StringPath featureUrl = createString("featureUrl");

    public final NumberPath<Long> subFeatureId = createNumber("subFeatureId", Long.class);

    public QPGSubFeature(String variable) {
        super(PGSubFeature.class, forVariable(variable));
    }

    public QPGSubFeature(Path<? extends PGSubFeature> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGSubFeature(PathMetadata<?> metadata) {
        super(PGSubFeature.class, metadata);
    }

}

