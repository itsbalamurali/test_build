package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGBINRange is a Querydsl query type for PGBINRange
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGBINRange extends EntityPathBase<PGBINRange> {

    private static final long serialVersionUID = 2132581253L;

    public static final QPGBINRange pGBINRange = new QPGBINRange("pGBINRange");

    public final NumberPath<Long> bin = createNumber("bin", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Integer> dccSupported = createNumber("dccSupported", Integer.class);

    public final NumberPath<Integer> emvSupported = createNumber("emvSupported", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath reason = createString("reason");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Long> switchId = createNumber("switchId", Long.class);

    public QPGBINRange(String variable) {
        super(PGBINRange.class, forVariable(variable));
    }

    public QPGBINRange(Path<? extends PGBINRange> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGBINRange(PathMetadata<?> metadata) {
        super(PGBINRange.class, metadata);
    }

}

