package org.me.todo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.me.todo.utils.CommonConstants.*;

@Entity
@Table(name = "todo-task")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = MEDIUM_STRING_LENGTH)
    private String title;

    @Column(columnDefinition = "TEXT", length = MAX_STRING_LENGTH)
    private String description;

    @Column(length = SHORT_STRING_LENGTH)
    private String status;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UUID userId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}


