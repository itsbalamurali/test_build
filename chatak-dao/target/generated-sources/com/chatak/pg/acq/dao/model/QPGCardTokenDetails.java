package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGCardTokenDetails is a Querydsl query type for PGCardTokenDetails
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCardTokenDetails extends EntityPathBase<PGCardTokenDetails> {

    private static final long serialVersionUID = 1430375752L;

    public static final QPGCardTokenDetails pGCardTokenDetails = new QPGCardTokenDetails("pGCardTokenDetails");

    public final StringPath cardHolderName = createString("cardHolderName");

    public final StringPath cardLastFourDigits = createString("cardLastFourDigits");

    public final StringPath cardType = createString("cardType");

    public final StringPath cardUserEmail = createString("cardUserEmail");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath expiryDate = createString("expiryDate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath pan = createString("pan");

    public final NumberPath<Long> pgTokenCustomerId = createNumber("pgTokenCustomerId", Long.class);

    public final StringPath status = createString("status");

    public final StringPath token = createString("token");

    public final StringPath tokenExpDate = createString("tokenExpDate");

    public QPGCardTokenDetails(String variable) {
        super(PGCardTokenDetails.class, forVariable(variable));
    }

    public QPGCardTokenDetails(Path<? extends PGCardTokenDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCardTokenDetails(PathMetadata<?> metadata) {
        super(PGCardTokenDetails.class, metadata);
    }

}

