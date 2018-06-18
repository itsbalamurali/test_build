package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGPayPageConfig is a Querydsl query type for PGPayPageConfig
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGPayPageConfig extends EntityPathBase<PGPayPageConfig> {

    private static final long serialVersionUID = 1568675786L;

    public static final QPGPayPageConfig pGPayPageConfig = new QPGPayPageConfig("pGPayPageConfig");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath footer = createString("footer");

    public final StringPath header = createString("header");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final ArrayPath<byte[], Byte> payPageLogo = createArray("payPageLogo", byte[].class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGPayPageConfig(String variable) {
        super(PGPayPageConfig.class, forVariable(variable));
    }

    public QPGPayPageConfig(Path<? extends PGPayPageConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGPayPageConfig(PathMetadata<?> metadata) {
        super(PGPayPageConfig.class, metadata);
    }

}

