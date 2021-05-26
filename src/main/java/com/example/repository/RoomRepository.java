package com.example.repository;

import com.example.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "room", path = "room")
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomById(Long id);
    Room findRoomByNumber(int number);
}
