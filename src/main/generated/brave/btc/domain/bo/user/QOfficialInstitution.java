package brave.btc.domain.bo.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOfficialInstitution is a Querydsl query type for OfficialInstitution
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOfficialInstitution extends EntityPathBase<OfficialInstitution> {

    private static final long serialVersionUID = 1818044748L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOfficialInstitution officialInstitution = new QOfficialInstitution("officialInstitution");

    public final brave.btc.domain.bo.QAddress address;

    public final EnumPath<brave.btc.constant.enums.OfficialInstitutionDivision> code = createEnum("code", brave.btc.constant.enums.OfficialInstitutionDivision.class);

    public final TimePath<java.time.LocalTime> endTime = createTime("endTime", java.time.LocalTime.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final TimePath<java.time.LocalTime> startTime = createTime("startTime", java.time.LocalTime.class);

    public QOfficialInstitution(String variable) {
        this(OfficialInstitution.class, forVariable(variable), INITS);
    }

    public QOfficialInstitution(Path<? extends OfficialInstitution> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOfficialInstitution(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOfficialInstitution(PathMetadata metadata, PathInits inits) {
        this(OfficialInstitution.class, metadata, inits);
    }

    public QOfficialInstitution(Class<? extends OfficialInstitution> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new brave.btc.domain.bo.QAddress(forProperty("address")) : null;
    }

}
