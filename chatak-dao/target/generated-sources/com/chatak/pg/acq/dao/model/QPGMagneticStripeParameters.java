package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMagneticStripeParameters is a Querydsl query type for PGMagneticStripeParameters
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMagneticStripeParameters extends EntityPathBase<PGMagneticStripeParameters> {

    private static final long serialVersionUID = 502479178L;

    public static final QPGMagneticStripeParameters pGMagneticStripeParameters = new QPGMagneticStripeParameters("pGMagneticStripeParameters");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> magneticStripeId = createNumber("magneticStripeId", Long.class);

    public final StringPath magneticStripeName = createString("magneticStripeName");

    public QPGMagneticStripeParameters(String variable) {
        super(PGMagneticStripeParameters.class, forVariable(variable));
    }

    public QPGMagneticStripeParameters(Path<? extends PGMagneticStripeParameters> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMagneticStripeParameters(PathMetadata<?> metadata) {
        super(PGMagneticStripeParameters.class, metadata);
    }

}

