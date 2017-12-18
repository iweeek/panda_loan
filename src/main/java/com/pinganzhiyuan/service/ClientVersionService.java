package com.pinganzhiyuan.service;

import com.pinganzhiyuan.model.ClientVersion;

public interface ClientVersionService {

	ClientVersion getLatestVersionInfo(byte platformId, int channelId, String packageName);

}
