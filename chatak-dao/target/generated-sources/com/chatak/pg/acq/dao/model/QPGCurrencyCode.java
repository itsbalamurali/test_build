package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGCurrencyCode is a Querydsl query type for PGCurrencyCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCurrencyCode extends EntityPathBase<PGCurrencyCode> {

    private static final long serialVersionUID = 1014415661L;

    public static final QPGCurrencyCode pGCurrencyCode = new QPGCurrencyCode("pGCurrencyCode");

    public final StringPath code = createString("code");

    public final NumberPath<Long> countryId = createNumber("countryId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCodeAlpha = createString("currencyCodeAlpha");

    public final StringPath currencyCodeNumeric = createString("currencyCodeNumeric");

    public final StringPath currencyName = createString("currencyName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPGCurrencyCode(String variable) {
        super(PGCurrencyCode.class, forVariable(variable));
    }

    public QPGCurrencyCode(Path<? extends PGCurrencyCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCurrencyCode(PathMetadata<?> metadata) {
        super(PGCurrencyCode.class, metadata);
    }

}

