package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTerminal is a Querydsl query type for PGTerminal
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTerminal extends EntityPathBase<PGTerminal> {

    private static final long serialVersionUID = -720449141L;

    public static final QPGTerminal pGTerminal = new QPGTerminal("pGTerminal");

    public final StringPath comments = createString("comments");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath productId = createString("productId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Long> terminalId = createNumber("terminalId", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGTerminal(String variable) {
        super(PGTerminal.class, forVariable(variable));
    }

    public QPGTerminal(Path<? extends PGTerminal> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTerminal(PathMetadata<?> metadata) {
        super(PGTerminal.class, metadata);
    }

}

