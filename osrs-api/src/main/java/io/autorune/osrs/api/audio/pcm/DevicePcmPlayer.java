package io.autorune.osrs.api.audio.pcm;

import io.autorune.osrs.api.Client;

public interface DevicePcmPlayer extends PcmPlayer {
	Client getClientInstance();
}
