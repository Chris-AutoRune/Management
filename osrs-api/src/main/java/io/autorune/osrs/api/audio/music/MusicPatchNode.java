package io.autorune.osrs.api.audio.music;

import io.autorune.osrs.api.Client;
import io.autorune.osrs.api.collection.Node;

public interface MusicPatchNode extends Node {
	Client getClientInstance();
}
