package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGBatch is a Querydsl query type for PGBatch
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGBatch extends EntityPathBase<PGBatch> {

    private static final long serialVersionUID = -1608545653L;

    public static final QPGBatch pGBatch = new QPGBatch("pGBatch");

    public final StringPath batchId = createString("batchId");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public final StringPath status = createString("status");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGBatch(String variable) {
        super(PGBatch.class, forVariable(variable));
    }

    public QPGBatch(Path<? extends PGBatch> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGBatch(PathMetadata<?> metadata) {
        super(PGBatch.class, metadata);
    }

}

