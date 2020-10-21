package com.github.andreyelagin.spotifyplay.upstream;

import com.github.andreyelagin.spotifyplay.artists.ArtistsRepository;
import com.wrapper.spotify.model_objects.specification.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class ArtistsSpotifyApi {

  private final SpotifyClient client;
  private final ArtistsRepository artistsRepository;

  public Flux<String> getUserArtistsIds() {
    return client.followedArtists(Optional.empty())
        .expand(cursor -> {
          if (!isEmpty(cursor.getNext())) {
            var lastId = cursor.getItems()[cursor.getItems().length - 1].getId();
            return client.followedArtists(Optional.of(lastId));
          } else {
            return Flux.empty();
          }
        })
        .flatMap(artists -> Flux.fromIterable(Arrays
            .stream(artists.getItems())
            .map(Artist::getId)
            .collect(Collectors.toList())));
  }
}
