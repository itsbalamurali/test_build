package com.chatak.pg.bean;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QResponse is a Querydsl query type for Response
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QResponse extends BeanPath<Response> {

    private static final long serialVersionUID = -359845209L;

    public static final QResponse response = new QResponse("response");

    public final NumberPath<Long> agentAccountNumber = createNumber("agentAccountNumber", Long.class);

    public final StringPath agentAni = createString("agentAni");

    public final StringPath agentClientId = createString("agentClientId");

    public final ListPath<com.chatak.pg.model.AgentDTO, SimplePath<com.chatak.pg.model.AgentDTO>> agentDTOlist = this.<com.chatak.pg.model.AgentDTO, SimplePath<com.chatak.pg.model.AgentDTO>>createList("agentDTOlist", com.chatak.pg.model.AgentDTO.class, SimplePath.class, PathInits.DIRECT2);

    public final StringPath currencyCodeAlpha = createString("currencyCodeAlpha");

    public final StringPath currencyCodeNumeric = createString("currencyCodeNumeric");

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final StringPath deviceTimeZoneOffset = createString("deviceTimeZoneOffset");

    public final StringPath deviceTimeZoneRegion = createString("deviceTimeZoneRegion");

    public final StringPath emv = createString("emv");

    public final StringPath entityType = createString("entityType");

    public final StringPath errorCode = createString("errorCode");

    public final StringPath errorMessage = createString("errorMessage");

    public final StringPath issuancePartner = createString("issuancePartner");

    public final StringPath issuanceTxnTime = createString("issuanceTxnTime");

    public final NumberPath<Long> parentMerchantId = createNumber("parentMerchantId", Long.class);

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final StringPath partnerName = createString("partnerName");

    public final StringPath programManagerName = createString("programManagerName");

    public final NumberPath<Integer> totalNoOfRows = createNumber("totalNoOfRows", Integer.class);

    public final NumberPath<Long> txnResponseTime = createNumber("txnResponseTime", Long.class);

    public final StringPath upStreamAuthCode = createString("upStreamAuthCode");

    public final StringPath upStreamMessage = createString("upStreamMessage");

    public final StringPath upStreamResponse = createString("upStreamResponse");

    public final NumberPath<Integer> upStreamStatus = createNumber("upStreamStatus", Integer.class);

    public final StringPath upStreamTxnRefNum = createString("upStreamTxnRefNum");

    public QResponse(String variable) {
        super(Response.class, forVariable(variable));
    }

    public QResponse(Path<? extends Response> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResponse(PathMetadata<?> metadata) {
        super(Response.class, metadata);
    }

}

