package brave.btc.domain.bo.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPolicePerson is a Querydsl query type for PolicePerson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPolicePerson extends EntityPathBase<PolicePerson> {

    private static final long serialVersionUID = 1109088116L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPolicePerson policePerson = new QPolicePerson("policePerson");

    public final QManagePerson _super;

    // inherited
    public final brave.btc.domain.bo.QAddress address;

    public final StringPath department = createString("department");

    //inherited
    public final EnumPath<brave.btc.constant.enums.ManageDivision> division;

    //inherited
    public final NumberPath<Integer> id;

    //inherited
<<<<<<< HEAD
    public final StringPath loginId;
=======
    public final BooleanPath isAccountNonExpired = _super.isAccountNonExpired;

    //inherited
    public final BooleanPath isAccountNonLocked = _super.isAccountNonLocked;

    //inherited
    public final BooleanPath isCredentialsNonExpired = _super.isCredentialsNonExpired;

    //inherited
    public final BooleanPath isEnabled = _super.isEnabled;

    //inherited
    public final StringPath loginId = _super.loginId;
>>>>>>> 37bc8a5 (modify : spring security userdetails 유저 상태 4가지 추가)

    //inherited
    public final StringPath name;

    public final QOfficialInstitution officialInstitution;

    //inherited
    public final StringPath password;

    //inherited
    public final StringPath phoneNumber;

    //inherited
    public final StringPath phoneNumber = _super.phoneNumber;

    public final StringPath position = createString("position");

    public QPolicePerson(String variable) {
        this(PolicePerson.class, forVariable(variable), INITS);
    }

    public QPolicePerson(Path<? extends PolicePerson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPolicePerson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPolicePerson(PathMetadata metadata, PathInits inits) {
        this(PolicePerson.class, metadata, inits);
    }

    public QPolicePerson(Class<? extends PolicePerson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QManagePerson(type, metadata, inits);
        this.address = _super.address;
        this.division = _super.division;
        this.id = _super.id;
        this.loginId = _super.loginId;
        this.name = _super.name;
        this.officialInstitution = inits.isInitialized("officialInstitution") ? new QOfficialInstitution(forProperty("officialInstitution"), inits.get("officialInstitution")) : null;
        this.password = _super.password;
        this.phoneNumber = _super.phoneNumber;
    }

}
