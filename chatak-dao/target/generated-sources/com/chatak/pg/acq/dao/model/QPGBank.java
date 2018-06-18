package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGBank is a Querydsl query type for PGBank
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGBank extends EntityPathBase<PGBank> {

    private static final long serialVersionUID = 1887773899L;

    public static final QPGBank pGBank = new QPGBank("pGBank");

    public final StringPath acqirerId = createString("acqirerId");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath bankCode = createString("bankCode");

    public final StringPath bankName = createString("bankName");

    public final StringPath bankShortName = createString("bankShortName");

    public final StringPath city = createString("city");

    public final StringPath contactPersonCell = createString("contactPersonCell");

    public final StringPath contactPersonEmail = createString("contactPersonEmail");

    public final StringPath contactPersonFax = createString("contactPersonFax");

    public final StringPath contactPersonName = createString("contactPersonName");

    public final StringPath contactPersonPhone = createString("contactPersonPhone");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final StringPath extension = createString("extension");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> issuanceBankId = createNumber("issuanceBankId", Long.class);

    public final ListPath<PGBankCurrencyMapping, QPGBankCurrencyMapping> pgBankCurrencyMapping = this.<PGBankCurrencyMapping, QPGBankCurrencyMapping>createList("pgBankCurrencyMapping", PGBankCurrencyMapping.class, QPGBankCurrencyMapping.class, PathInits.DIRECT2);

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> revenueAccountNumber = createNumber("revenueAccountNumber", Long.class);

    public final StringPath settlAccountNumber = createString("settlAccountNumber");

    public final StringPath settlRoutingNumber = createString("settlRoutingNumber");

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zip = createString("zip");

    public QPGBank(String variable) {
        super(PGBank.class, forVariable(variable));
    }

    public QPGBank(Path<? extends PGBank> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGBank(PathMetadata<?> metadata) {
        super(PGBank.class, metadata);
    }

}

