package com.example.member;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="member")
public class MemberDO implements Serializable {
    private static final long serialVersionUID = -462000190800958491L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id", nullable = false, unique = true, length=100)
    private String userId;

    @Column(name="password")
    private String password;

    @CreationTimestamp
    @Column(name="create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name="update_date")
    private Date updateDate;

    @Column(name="role_type")
    private int roleType;

    @Column(name="email")
    private String email;
}
