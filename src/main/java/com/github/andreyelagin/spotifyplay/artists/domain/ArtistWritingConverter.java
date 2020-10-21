package com.github.andreyelagin.spotifyplay.artists.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.SettableValue;

//@WritingConverter
public class ArtistWritingConverter implements Converter<Artist, OutboundRow> {

  @Override
  public OutboundRow convert(Artist artist) {
    var row = new OutboundRow();
    row.put("id", SettableValue.from(artist.getId()));
    row.put("name", SettableValue.from(artist.getName()));
    row.put("external_urls", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    row.put("id", SettableValue.from(artist.getId()));
    return row;
  }
}