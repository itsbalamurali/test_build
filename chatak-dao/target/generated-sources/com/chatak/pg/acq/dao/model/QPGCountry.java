package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGCountry is a Querydsl query type for PGCountry
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCountry extends EntityPathBase<PGCountry> {

    private static final long serialVersionUID = 1665432231L;

    public static final QPGCountry pGCountry = new QPGCountry("pGCountry");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<PGState, QPGState> state = this.<PGState, QPGState>createList("state", PGState.class, QPGState.class, PathInits.DIRECT2);

    public QPGCountry(String variable) {
        super(PGCountry.class, forVariable(variable));
    }

    public QPGCountry(Path<? extends PGCountry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCountry(PathMetadata<?> metadata) {
        super(PGCountry.class, metadata);
    }

}

