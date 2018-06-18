package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantTerminal is a Querydsl query type for PGMerchantTerminal
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantTerminal extends EntityPathBase<PGMerchantTerminal> {

    private static final long serialVersionUID = -88328077L;

    public static final QPGMerchantTerminal pGMerchantTerminal = new QPGMerchantTerminal("pGMerchantTerminal");

    public final StringPath comments = createString("comments");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath productId = createString("productId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath terminalId = createString("terminalId");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantTerminal(String variable) {
        super(PGMerchantTerminal.class, forVariable(variable));
    }

    public QPGMerchantTerminal(Path<? extends PGMerchantTerminal> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantTerminal(PathMetadata<?> metadata) {
        super(PGMerchantTerminal.class, metadata);
    }

}

