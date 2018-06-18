package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGEMVTransaction is a Querydsl query type for PGEMVTransaction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGEMVTransaction extends EntityPathBase<PGEMVTransaction> {

    private static final long serialVersionUID = 2062221567L;

    public static final QPGEMVTransaction pGEMVTransaction = new QPGEMVTransaction("pGEMVTransaction");

    public final StringPath aed = createString("aed");

    public final StringPath aid = createString("aid");

    public final StringPath aip = createString("aip");

    public final StringPath appCrypto = createString("appCrypto");

    public final StringPath atc = createString("atc");

    public final StringPath cryptoInfo = createString("cryptoInfo");

    public final StringPath cvrm = createString("cvrm");

    public final StringPath fci = createString("fci");

    public final StringPath fcip = createString("fcip");

    public final StringPath iad = createString("iad");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ifd = createString("ifd");

    public final StringPath iid = createString("iid");

    public final StringPath isr = createString("isr");

    public final StringPath ist = createString("ist");

    public final StringPath ist1 = createString("ist1");

    public final StringPath lanRef = createString("lanRef");

    public final StringPath pgTransactionId = createString("pgTransactionId");

    public final StringPath psn = createString("psn");

    public final StringPath tavn = createString("tavn");

    public final StringPath tcc = createString("tcc");

    public final StringPath terminalCapabilities = createString("terminalCapabilities");

    public final StringPath terminalType = createString("terminalType");

    public final StringPath tsn = createString("tsn");

    public final StringPath tvr = createString("tvr");

    public final StringPath txnStatusInfo = createString("txnStatusInfo");

    public final StringPath unPredNumber = createString("unPredNumber");

    public QPGEMVTransaction(String variable) {
        super(PGEMVTransaction.class, forVariable(variable));
    }

    public QPGEMVTransaction(Path<? extends PGEMVTransaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGEMVTransaction(PathMetadata<?> metadata) {
        super(PGEMVTransaction.class, metadata);
    }

}

