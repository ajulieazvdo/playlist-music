package com.ajulieazvdo.playlist.music.infra;

import com.ajulieazvdo.playlist.music.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicSpringDataJpaRepository extends JpaRepository<Music, String> {
}
