package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGActivityLog is a Querydsl query type for PGActivityLog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGActivityLog extends EntityPathBase<PGActivityLog> {

    private static final long serialVersionUID = 52845638L;

    public static final QPGActivityLog pGActivityLog = new QPGActivityLog("pGActivityLog");

    public final NumberPath<Long> adjAmount = createNumber("adjAmount", Long.class);

    public final StringPath aiCountryCode = createString("aiCountryCode");

    public final NumberPath<Integer> chipTransaction = createNumber("chipTransaction", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> expDate = createNumber("expDate", Long.class);

    public final StringPath f39 = createString("f39");

    public final StringPath f55 = createString("f55");

    public final StringPath fwdCountryCode = createString("fwdCountryCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mcc = createString("mcc");

    public final StringPath mti = createString("mti");

    public final StringPath pan = createString("pan");

    public final StringPath panCountryCode = createString("panCountryCode");

    public final StringPath panMasked = createString("panMasked");

    public final StringPath posEntryMode = createString("posEntryMode");

    public final StringPath posTxnDate = createString("posTxnDate");

    public final StringPath posTxnTime = createString("posTxnTime");

    public final StringPath processingCode = createString("processingCode");

    public final StringPath requestIP = createString("requestIP");

    public final NumberPath<Integer> requestPort = createNumber("requestPort", Integer.class);

    public final StringPath responseCode = createString("responseCode");

    public final NumberPath<Integer> responsePort = createNumber("responsePort", Integer.class);

    public final StringPath sysTraceNum = createString("sysTraceNum");

    public final NumberPath<Long> txnAmount = createNumber("txnAmount", Long.class);

    public final StringPath txnCountryCode = createString("txnCountryCode");

    public final StringPath txnCurrencyCode = createString("txnCurrencyCode");

    public QPGActivityLog(String variable) {
        super(PGActivityLog.class, forVariable(variable));
    }

    public QPGActivityLog(Path<? extends PGActivityLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGActivityLog(PathMetadata<?> metadata) {
        super(PGActivityLog.class, metadata);
    }

}

