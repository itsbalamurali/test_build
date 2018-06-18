package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGIPWhitelist is a Querydsl query type for PGIPWhitelist
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGIPWhitelist extends EntityPathBase<PGIPWhitelist> {

    private static final long serialVersionUID = -1217249903L;

    public static final QPGIPWhitelist pGIPWhitelist = new QPGIPWhitelist("pGIPWhitelist");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ip = createString("ip");

    public final StringPath merchantId = createString("merchantId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QPGIPWhitelist(String variable) {
        super(PGIPWhitelist.class, forVariable(variable));
    }

    public QPGIPWhitelist(Path<? extends PGIPWhitelist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGIPWhitelist(PathMetadata<?> metadata) {
        super(PGIPWhitelist.class, metadata);
    }

}

