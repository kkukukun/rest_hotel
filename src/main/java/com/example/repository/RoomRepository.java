package com.example.repository;

import com.example.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "room", path = "room")
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomById(Long id);
    Room findRoomByNumber(int number);

    @Query(value = "SELECT * FROM Room WHERE room.id_reservation IN (SELECT id_reservation FROM Room GROUP BY id_reservation HAVING count(*) > 1)", nativeQuery = true)
    List<Room> findRoomByNotUnicalReservationId();
}
