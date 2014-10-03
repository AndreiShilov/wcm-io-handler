/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.handler.media.testcontext;

import io.wcm.config.api.annotations.Application;
import io.wcm.handler.media.AbstractMediaHandlerConfig;
import io.wcm.handler.media.MediaHandlerConfig;
import io.wcm.handler.media.MediaMarkupBuilder;
import io.wcm.handler.media.MediaSource;
import io.wcm.handler.media.markup.EditPlaceholderMediaMarkupBuilder;
import io.wcm.handler.media.markup.SimpleImageMediaMarkupBuilder;
import io.wcm.handler.mediasource.dam.DamMediaSource;

import java.util.List;
import java.util.Set;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Dummy media configuration
 */
@Model(adaptables = {
    SlingHttpServletRequest.class, Resource.class
}, adapters = MediaHandlerConfig.class)
@Application(AppAemContext.APPLICATION_ID)
public class DummyMediaHandlerConfig extends AbstractMediaHandlerConfig {

  private static final List<Class<? extends MediaSource>> MEDIA_SOURCES = ImmutableList.<Class<? extends MediaSource>>of(
      DamMediaSource.class
      );

  private static final List<Class<? extends MediaMarkupBuilder>> MEDIA_MARKUP_BUILDERS =
      ImmutableList.<Class<? extends MediaMarkupBuilder>>of(
          SimpleImageMediaMarkupBuilder.class,
          EditPlaceholderMediaMarkupBuilder.class
          );

  private static final Set<String> DOWNLOAD_MEDIA_FORMATS = ImmutableSet.of(
      "download"
      );

  @Override
  public List<Class<? extends MediaSource>> getMediaSources() {
    return MEDIA_SOURCES;
  }

  @Override
  public List<Class<? extends MediaMarkupBuilder>> getMediaMarkupBuilders() {
    return MEDIA_MARKUP_BUILDERS;
  }

  @Override
  public Set<String> getDownloadMediaFormats() {
    return DOWNLOAD_MEDIA_FORMATS;
  }

  @Override
  public String getMediaFormatsPath() {
    return AppAemContext.MEDIAFORMATS_PATH;
  }

}
