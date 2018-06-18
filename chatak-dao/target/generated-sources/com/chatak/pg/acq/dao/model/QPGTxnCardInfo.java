package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTxnCardInfo is a Querydsl query type for PGTxnCardInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTxnCardInfo extends EntityPathBase<PGTxnCardInfo> {

    private static final long serialVersionUID = -325018887L;

    public static final QPGTxnCardInfo pGTxnCardInfo = new QPGTxnCardInfo("pGTxnCardInfo");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> avsZip = createNumber("avsZip", Integer.class);

    public final StringPath cardAccType = createString("cardAccType");

    public final StringPath cardNumber = createString("cardNumber");

    public final NumberPath<Integer> cardNumLength = createNumber("cardNumLength", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath emv = createString("emv");

    public final StringPath expirationDate = createString("expirationDate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastFour = createString("lastFour");

    public final StringPath nameOnCard = createString("nameOnCard");

    public final StringPath track2 = createString("track2");

    public final NumberPath<Long> transactionId = createNumber("transactionId", Long.class);

    public QPGTxnCardInfo(String variable) {
        super(PGTxnCardInfo.class, forVariable(variable));
    }

    public QPGTxnCardInfo(Path<? extends PGTxnCardInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTxnCardInfo(PathMetadata<?> metadata) {
        super(PGTxnCardInfo.class, metadata);
    }

}

