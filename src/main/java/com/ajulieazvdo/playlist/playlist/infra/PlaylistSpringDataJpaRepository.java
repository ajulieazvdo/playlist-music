package com.ajulieazvdo.playlist.playlist.infra;

import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistSpringDataJpaRepository extends JpaRepository<Playlist, String> {
}
