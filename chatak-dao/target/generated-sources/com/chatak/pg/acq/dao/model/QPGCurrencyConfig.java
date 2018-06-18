package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGCurrencyConfig is a Querydsl query type for PGCurrencyConfig
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCurrencyConfig extends EntityPathBase<PGCurrencyConfig> {

    private static final long serialVersionUID = -103823742L;

    public static final QPGCurrencyConfig pGCurrencyConfig = new QPGCurrencyConfig("pGCurrencyConfig");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCodeAlpha = createString("currencyCodeAlpha");

    public final StringPath currencyCodeNumeric = createString("currencyCodeNumeric");

    public final NumberPath<Integer> currencyExponent = createNumber("currencyExponent", Integer.class);

    public final ComparablePath<Character> currencyMinorUnit = createComparable("currencyMinorUnit", Character.class);

    public final StringPath currencyName = createString("currencyName");

    public final NumberPath<Integer> currencySeparatorPosition = createNumber("currencySeparatorPosition", Integer.class);

    public final ComparablePath<Character> currencyThousandsUnit = createComparable("currencyThousandsUnit", Character.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> modifiedDate = createDateTime("modifiedDate", java.sql.Timestamp.class);

    public final StringPath reason = createString("reason");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QPGCurrencyConfig(String variable) {
        super(PGCurrencyConfig.class, forVariable(variable));
    }

    public QPGCurrencyConfig(Path<? extends PGCurrencyConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCurrencyConfig(PathMetadata<?> metadata) {
        super(PGCurrencyConfig.class, metadata);
    }

}

