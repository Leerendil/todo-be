package org.me.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static org.me.todo.utils.CommonConstants.MEDIUM_STRING_LENGTH;
import static org.me.todo.utils.CommonConstants.SHORT_STRING_LENGTH;

@Entity
@Table(name="users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = SHORT_STRING_LENGTH)
    private String username;

    @Email
    @Column(nullable = false, unique = true, length = SHORT_STRING_LENGTH)
    private String email;

    @Column(name = "password_hash", nullable = false, length = MEDIUM_STRING_LENGTH)
    private String passwordHash;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private Set<TodoTask> tasks;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
