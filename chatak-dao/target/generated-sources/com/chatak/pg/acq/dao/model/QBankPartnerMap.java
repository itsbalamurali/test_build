package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBankPartnerMap is a Querydsl query type for BankPartnerMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBankPartnerMap extends EntityPathBase<BankPartnerMap> {

    private static final long serialVersionUID = -522925336L;

    public static final QBankPartnerMap bankPartnerMap = new QBankPartnerMap("bankPartnerMap");

    public final NumberPath<Long> bankId = createNumber("bankId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public QBankPartnerMap(String variable) {
        super(BankPartnerMap.class, forVariable(variable));
    }

    public QBankPartnerMap(Path<? extends BankPartnerMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBankPartnerMap(PathMetadata<?> metadata) {
        super(BankPartnerMap.class, metadata);
    }

}

