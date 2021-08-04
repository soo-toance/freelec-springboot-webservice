package com.toance.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // jpa entity 클래스들이 basetimeentity 상속할 경우 createdDate, modifiedDate 인식하도록 함.
@EntityListeners(AuditingEntityListener.class) // Auditing rlsmd vhgka
public class BaseTimeEntity {
    @CreatedDate // 저장할때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity 변경할때 자동 저장
    private LocalDateTime modifiedDate;
}
