package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGDynamicMDR is a Querydsl query type for PGDynamicMDR
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGDynamicMDR extends EntityPathBase<PGDynamicMDR> {

    private static final long serialVersionUID = 161489995L;

    public static final QPGDynamicMDR pGDynamicMDR = new QPGDynamicMDR("pGDynamicMDR");

    public final StringPath accountType = createString("accountType");

    public final StringPath bankName = createString("bankName");

    public final NumberPath<Long> binNumber = createNumber("binNumber", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath paymentSchemeName = createString("paymentSchemeName");

    public final StringPath productType = createString("productType");

    public final NumberPath<Double> slab = createNumber("slab", Double.class);

    public final StringPath transactionType = createString("transactionType");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGDynamicMDR(String variable) {
        super(PGDynamicMDR.class, forVariable(variable));
    }

    public QPGDynamicMDR(Path<? extends PGDynamicMDR> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGDynamicMDR(PathMetadata<?> metadata) {
        super(PGDynamicMDR.class, metadata);
    }

}

