package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGPartnerFeeCode is a Querydsl query type for PGPartnerFeeCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGPartnerFeeCode extends EntityPathBase<PGPartnerFeeCode> {

    private static final long serialVersionUID = 528825466L;

    public static final QPGPartnerFeeCode pGPartnerFeeCode = new QPGPartnerFeeCode("pGPartnerFeeCode");

    public final NumberPath<Long> accountNumber = createNumber("accountNumber", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> feePercentageOnly = createNumber("feePercentageOnly", Long.class);

    public final NumberPath<Long> flatFee = createNumber("flatFee", Long.class);

    public final StringPath partnerEntityId = createString("partnerEntityId");

    public final StringPath partnerEntityType = createString("partnerEntityType");

    public final NumberPath<Long> partnerFeeCodeId = createNumber("partnerFeeCodeId", Long.class);

    public final StringPath partnerName = createString("partnerName");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGPartnerFeeCode(String variable) {
        super(PGPartnerFeeCode.class, forVariable(variable));
    }

    public QPGPartnerFeeCode(Path<? extends PGPartnerFeeCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGPartnerFeeCode(PathMetadata<?> metadata) {
        super(PGPartnerFeeCode.class, metadata);
    }

}

