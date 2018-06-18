package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGBankCurrencyMapping is a Querydsl query type for PGBankCurrencyMapping
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGBankCurrencyMapping extends EntityPathBase<PGBankCurrencyMapping> {

    private static final long serialVersionUID = 1405796146L;

    public static final QPGBankCurrencyMapping pGBankCurrencyMapping = new QPGBankCurrencyMapping("pGBankCurrencyMapping");

    public final NumberPath<Long> bankId = createNumber("bankId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCodeAlpha = createString("currencyCodeAlpha");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGBankCurrencyMapping(String variable) {
        super(PGBankCurrencyMapping.class, forVariable(variable));
    }

    public QPGBankCurrencyMapping(Path<? extends PGBankCurrencyMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGBankCurrencyMapping(PathMetadata<?> metadata) {
        super(PGBankCurrencyMapping.class, metadata);
    }

}

