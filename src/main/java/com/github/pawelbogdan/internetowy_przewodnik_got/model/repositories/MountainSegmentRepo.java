package com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainSegment;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainSegmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MountainSegmentRepo extends JpaRepository<MountainSegment, MountainSegmentId> {
    //public MountainSegment findByCompositeIdIs(String startingPoint, String endPoint);
}
