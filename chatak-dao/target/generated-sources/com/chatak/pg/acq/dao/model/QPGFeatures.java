package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFeatures is a Querydsl query type for PGFeatures
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeatures extends EntityPathBase<PGFeatures> {

    private static final long serialVersionUID = 170140492L;

    public static final QPGFeatures pGFeatures = new QPGFeatures("pGFeatures");

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final StringPath featureName = createString("featureName");

    public final StringPath featureUrl = createString("featureUrl");

    public QPGFeatures(String variable) {
        super(PGFeatures.class, forVariable(variable));
    }

    public QPGFeatures(Path<? extends PGFeatures> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFeatures(PathMetadata<?> metadata) {
        super(PGFeatures.class, metadata);
    }

}

