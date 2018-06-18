package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBankProgramManagerMap is a Querydsl query type for BankProgramManagerMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBankProgramManagerMap extends EntityPathBase<BankProgramManagerMap> {

    private static final long serialVersionUID = 852389407L;

    public static final QBankProgramManagerMap bankProgramManagerMap = new QBankProgramManagerMap("bankProgramManagerMap");

    public final NumberPath<Long> bankId = createNumber("bankId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public QBankProgramManagerMap(String variable) {
        super(BankProgramManagerMap.class, forVariable(variable));
    }

    public QBankProgramManagerMap(Path<? extends BankProgramManagerMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBankProgramManagerMap(PathMetadata<?> metadata) {
        super(BankProgramManagerMap.class, metadata);
    }

}

