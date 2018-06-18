package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantCategoryCode is a Querydsl query type for PGMerchantCategoryCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantCategoryCode extends EntityPathBase<PGMerchantCategoryCode> {

    private static final long serialVersionUID = 1262682754L;

    public static final QPGMerchantCategoryCode pGMerchantCategoryCode = new QPGMerchantCategoryCode("pGMerchantCategoryCode");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCategoryCode = createString("merchantCategoryCode");

    public final StringPath reason = createString("reason");

    public final StringPath selectedTcc = createString("selectedTcc");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantCategoryCode(String variable) {
        super(PGMerchantCategoryCode.class, forVariable(variable));
    }

    public QPGMerchantCategoryCode(Path<? extends PGMerchantCategoryCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantCategoryCode(PathMetadata<?> metadata) {
        super(PGMerchantCategoryCode.class, metadata);
    }

}

