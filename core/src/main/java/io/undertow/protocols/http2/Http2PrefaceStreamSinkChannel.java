/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.undertow.protocols.http2;

import java.nio.ByteBuffer;

import io.undertow.server.protocol.framed.SendFrameHeader;
import io.undertow.util.ImmediatePooled;

/**
 * channel implementation that sends the initial HTTP2 preface
 *
 * @author Stuart Douglas
 */
class Http2PrefaceStreamSinkChannel extends Http2StreamSinkChannel {
    Http2PrefaceStreamSinkChannel(Http2Channel channel) {
        super(channel, 0);
    }

    @Override
    protected SendFrameHeader createFrameHeaderImpl() {
        return new SendFrameHeader(new ImmediatePooled<>(ByteBuffer.wrap(Http2Channel.PREFACE_BYTES)));
    }
}
