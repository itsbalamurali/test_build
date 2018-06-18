package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGParams is a Querydsl query type for PGParams
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGParams extends EntityPathBase<PGParams> {

    private static final long serialVersionUID = 2075439189L;

    public static final QPGParams pGParams = new QPGParams("pGParams");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath paramName = createString("paramName");

    public final StringPath paramValue = createString("paramValue");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QPGParams(String variable) {
        super(PGParams.class, forVariable(variable));
    }

    public QPGParams(Path<? extends PGParams> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGParams(PathMetadata<?> metadata) {
        super(PGParams.class, metadata);
    }

}

