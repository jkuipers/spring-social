/*
 * Copyright 2011 the original author or authors.
 *
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
 */
package org.springframework.social.github.connect;

import org.springframework.social.connect.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.connect.support.ConnectionRepository;
import org.springframework.social.github.GitHubApi;
import org.springframework.social.github.GitHubTemplate;
import org.springframework.social.oauth2.OAuth2Template;

public class GitHubServiceProvider extends AbstractOAuth2ServiceProvider<GitHubApi> {

	public GitHubServiceProvider(String clientId, String clientSecret, ConnectionRepository connectionRepository) {
		super("github", connectionRepository, new OAuth2Template(clientId, clientSecret,
				"https://github.com/login/oauth/authorize?client_id={client_id}&redirect_uri={redirect_uri}&scope={scope}",
				"https://github.com/login/oauth/access_token"));
	}

	protected GitHubApi getApi(String accessToken) {
		return new GitHubTemplate(accessToken);
	}

}
