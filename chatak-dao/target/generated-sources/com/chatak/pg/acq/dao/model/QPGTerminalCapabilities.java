package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTerminalCapabilities is a Querydsl query type for PGTerminalCapabilities
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTerminalCapabilities extends EntityPathBase<PGTerminalCapabilities> {

    private static final long serialVersionUID = -626901791L;

    public static final QPGTerminalCapabilities pGTerminalCapabilities = new QPGTerminalCapabilities("pGTerminalCapabilities");

    public final BooleanPath administrative = createBoolean("administrative");

    public final BooleanPath alphanumericSpecialCharacters = createBoolean("alphanumericSpecialCharacters");

    public final BooleanPath cardCapture = createBoolean("cardCapture");

    public final BooleanPath cash = createBoolean("cash");

    public final BooleanPath cashDeposits = createBoolean("cashDeposits");

    public final BooleanPath cda = createBoolean("cda");

    public final BooleanPath commandKeys = createBoolean("commandKeys");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final BooleanPath dda = createBoolean("dda");

    public final BooleanPath displayAttendant = createBoolean("displayAttendant");

    public final BooleanPath displayCardholder = createBoolean("displayCardholder");

    public final BooleanPath encipheredPINForOfflineVerification = createBoolean("encipheredPINForOfflineVerification");

    public final BooleanPath encipheredPINForOnlineVerification = createBoolean("encipheredPINForOnlineVerification");

    public final BooleanPath financialInstitute = createBoolean("financialInstitute");

    public final BooleanPath functionKeys = createBoolean("functionKeys");

    public final BooleanPath goods = createBoolean("goods");

    public final BooleanPath iCWithContacts = createBoolean("iCWithContacts");

    public final BooleanPath inquiry = createBoolean("inquiry");

    public final BooleanPath magneticStripes = createBoolean("magneticStripes");

    public final BooleanPath manualEntryKey = createBoolean("manualEntryKey");

    public final BooleanPath merchant = createBoolean("merchant");

    public final BooleanPath noCVMRequired = createBoolean("noCVMRequired");

    public final BooleanPath numericKeys = createBoolean("numericKeys");

    public final BooleanPath payment = createBoolean("payment");

    public final BooleanPath plainTextPINForICCVerification = createBoolean("plainTextPINForICCVerification");

    public final BooleanPath printAttendant = createBoolean("printAttendant");

    public final BooleanPath printCardholder = createBoolean("printCardholder");

    public final BooleanPath sda = createBoolean("sda");

    public final BooleanPath services = createBoolean("services");

    public final BooleanPath signature = createBoolean("signature");

    public final NumberPath<Long> terminalCapabilitiesId = createNumber("terminalCapabilitiesId", Long.class);

    public final BooleanPath transfer = createBoolean("transfer");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGTerminalCapabilities(String variable) {
        super(PGTerminalCapabilities.class, forVariable(variable));
    }

    public QPGTerminalCapabilities(Path<? extends PGTerminalCapabilities> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTerminalCapabilities(PathMetadata<?> metadata) {
        super(PGTerminalCapabilities.class, metadata);
    }

}

