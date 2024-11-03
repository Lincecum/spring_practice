package com.example.delivery_api.repository

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.OffsetDateTime

@MappedSuperclass // @MappedSuperclass 어노테이션을 통해 직접 엔티티가 되지 않으며, 이를 상속받는 서브클래스들이 데이터베이스 테이블로 매핑될 때 BaseEntity의 필드들을 함께 포함하게 됩니다.
abstract class BaseEntity {
    @Column(name = "is_deleted", nullable = false)
    var isDeleted: Boolean= false

    @Temporal(TemporalType.TIMESTAMP) // @Temporal 어노테이션은 이렇게 필드를 어떤 시간 타입으로 저장할지 알려주는 데 사용됩니다. TemporalType.TIMESTAMP: 날짜와 시간 모두 저장 (년-월-일 시-분-초).
    @Column(name = "created_at", nullable = false)
    var createdAt: OffsetDateTime = OffsetDateTime.now()

    @Temporal(TemporalType.TIMESTAMP) // @Temporal 어노테이션은 이렇게 필드를 어떤 시간 타입으로 저장할지 알려주는 데 사용됩니다. TemporalType.TIMESTAMP: 날짜와 시간 모두 저장 (년-월-일 시-분-초).
    @Column(name = "updated_at", nullable = false)
    var updatedAt: OffsetDateTime = OffsetDateTime.now()

    @Column(name = "created_by", nullable = false)
    var createdBy:String? = null

    @Column(name = "updated_by", nullable = false)
    var updatedBy:String? = null

}



//Kotlin에서 abstract class는 추상 클래스로, 일부 구현은 제공하면서도 자식 클래스에서 반드시 구현해야 하는 메서드나 프로퍼티를 정의할 수 있는 클래스입니다. 이 추상 클래스 자체는 인스턴스를 생성할 수 없고, 다른 클래스들이 이를 상속받아 구체적인 구현을 제공해야 합니다.
//
//특징
//- 인스턴스화 불가: abstract class 자체는 객체로 만들 수 없고, 상속받은 클래스에서만 객체를 생성할 수 있습니다.
//- 추상 멤버 정의 가능: abstract 키워드를 사용해 메서드나 프로퍼티를 정의할 수 있는데, 이러한 추상 멤버들은 구현을 가지지 않고 서브클래스에서 반드시 구현되어야 합니다.
//- 구현을 가진 멤버 포함 가능: 추상 클래스는 반드시 모든 멤버가 추상적일 필요는 없습니다. 일부 메서드나 프로퍼티는 구현을 가질 수 있으며, 자식 클래스들이 이를 재사용할 수 있습니다.
