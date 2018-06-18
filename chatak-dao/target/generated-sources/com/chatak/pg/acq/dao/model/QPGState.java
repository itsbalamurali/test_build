package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGState is a Querydsl query type for PGState
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGState extends EntityPathBase<PGState> {

    private static final long serialVersionUID = -1592297502L;

    public static final QPGState pGState = new QPGState("pGState");

    public final NumberPath<Long> countryId = createNumber("countryId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath status = createString("status");

    public QPGState(String variable) {
        super(PGState.class, forVariable(variable));
    }

    public QPGState(Path<? extends PGState> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGState(PathMetadata<?> metadata) {
        super(PGState.class, metadata);
    }

}

