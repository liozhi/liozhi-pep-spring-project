package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    
    @Query(value = "select * from message where postedBy = ?1", nativeQuery = true)
    List<Message> getByUserId(long uid);

    // these are stupid! why does spring not let you use getById if the pkey column isn't named "id"?????
    @Query(value = "select * from message where messageId = ?1", nativeQuery = true)
    Optional<Message> getByMessageId(long id);

    @Modifying
    @Query(value = "delete from message where messageId = ?1", nativeQuery = true)
    void deleteByMessageId(long id);
}
